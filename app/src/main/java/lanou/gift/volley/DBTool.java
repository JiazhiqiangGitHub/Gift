package lanou.gift.volley;

import android.os.Handler;
import android.os.Looper;

import com.litesuits.orm.LiteOrm;
import com.litesuits.orm.db.assit.WhereBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import lanou.gift.base.MyApp;

/**
 * Created by dllo on 16/11/12.
 */
public class DBTool {

    //饿汉式单例
    private static DBTool sDBTool = new DBTool();
    private LiteOrm mLiteOrm;
    private Handler mHandler;//用来做线程切换的

    private Executor mThreadPool;//线程池



    //构造方法私有化
    private DBTool(){
        mLiteOrm = LiteOrm.newSingleInstance(MyApp.getContext(),"myDB.db");
        //在子线程中new就会崩溃
        //括号里的就能保证handler永远在主线程中 严谨 不写也可以
        mHandler = new Handler(Looper.getMainLooper());


        //线程池
        int coreNum = Runtime.getRuntime().availableProcessors();
        //最大线程和核心线程数是一样的 队列是无限的
        mThreadPool = Executors.newFixedThreadPool(coreNum+1);

    }


    public static DBTool getInstance(){
        return sDBTool;
    }

    //插入方法
    public void insertSearch(final Search search){
        //子线程
        mThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                mLiteOrm.insert(search);
            }
        });
    }
    //LiteOrm 删除数据库全删方法

    public void deleteAllData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                mLiteOrm.delete(Search.class);
                // mLiteOrm.deleteDatabase();  //库文件一起干掉
                // mLiteOrm.openOrCreateDatabase();  //重建一个数据库
                // 这个方法当库里只有一个表的时候可以用但是如果表多的话会全删光的
            }
        }).start();
    }
    //LiteOrm 删除数据库定向删方法
    public void deleteSpecifyData(final String search){
        mThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                mLiteOrm.delete(new WhereBuilder(Search.class).where("things = ?",search));
            }
        });
    }
//查询
public void queryAllSearch(final OnQueryListener onQueryListener) {
    mThreadPool.execute(new QueryRunnable(onQueryListener));
}

    class QueryRunnable implements Runnable {
        private OnQueryListener mOnQueryListener;

        public QueryRunnable(OnQueryListener mOnQueryListener) {
            this.mOnQueryListener = mOnQueryListener;
        }

        @Override
        public void run() {
            ArrayList<Search> query  //查询
                    = mLiteOrm.query(Search.class);
            mHandler.post(new CallBackRunnable(mOnQueryListener,query));
        }
    }

    //Handler使用的 将查询的数据返回到主线程使用的Runnable
    class CallBackRunnable implements Runnable {

        private OnQueryListener mOnQueryListener;
        private List<Search> mSearch;
        public CallBackRunnable(OnQueryListener mOnQueryListener, List<Search> mSearch) {
            this.mOnQueryListener = mOnQueryListener;
            this.mSearch = mSearch;
        }

        @Override
        public void run() {
            mOnQueryListener.onQuery(mSearch);
        }

    }


    //返回查询结果用的接口
    //handler 主要用来做线程切换
    public interface OnQueryListener {
        void onQuery(List<Search> mSearch);
    }

}
