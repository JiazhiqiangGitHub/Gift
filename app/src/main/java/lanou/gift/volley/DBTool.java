package lanou.gift.volley;

import android.os.Handler;
import android.os.Looper;

import com.litesuits.orm.LiteOrm;

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
    //连1
    public void queryAllSearch(final OnQueryListener onQueryListener){
        mThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                final ArrayList<Search> query = mLiteOrm.query(Search.class);
                //通过接口把值传出去 先建Handler
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        onQueryListener.onQuery(query);
                    }
                });
            }
        });
    }


    //以为不知道谁要查询 弄个接口就不用考虑了
    //返回查询结果
    public interface OnQueryListener{
        void onQuery(List<Search> persons);
        //连1
    }


}
