package lanou.gift.guide.firstFragment;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import lanou.gift.R;
import lanou.gift.base.BaseFragment;
import lanou.gift.guide.adapter.SelectionAdapter;
import lanou.gift.textbean.SelectionBean;
import lanou.gift.volley.GsonRequest;
import lanou.gift.volley.VolleySingleton;

/**
 * Created by dllo on 16/10/27.
 */
public class HeadFragment extends BaseFragment {
    private String[] pics = {"http://img.boqiicdn.com/Data/BK/A/1411/26/img77931416972193.jpg",
            "http://h.hiphotos.baidu.com/zhidao/pic/item/6d81800a19d8bc3ed69473cb848ba61ea8d34516.jpg",
            "http://f.hiphotos.baidu.com/zhidao/pic/item/d50735fae6cd7b89535b1a450d2442a7d8330ec4.jpg",
            "http://pic29.nipic.com/20130506/3822951_102005116000_2.jpg",
            "http://pic36.nipic.com/20131125/8821914_090743677000_2.jpg"};
    private SelectionAdapter selectionAdapter;
    private String url = "http://api.liwushuo.com/v2/channels/101/items_v2?ad=2&gender=1&generation=2&limit=20&offset=0";
    private ListView lv;
    private ViewPager vp;
    private View headView;
    private Handler mHandler;
    private HeadViewPagerAdapter headAdapter;
    @Override
    protected void initDate() {

        headAdapter = new HeadViewPagerAdapter();
        headAdapter.setUrl(pics);
        Log.d("zzz", "pics:" + pics);
        vp.setAdapter(headAdapter);
        //自动的方法
        mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                //执行回调的地方
                if (vp != null&& msg.what==1){
                    vp.setCurrentItem(vp.getCurrentItem()+1);
                }
                //再走两秒回调
                mHandler.sendEmptyMessageDelayed(1,2000);
            }
        };



        GsonRequest<SelectionBean> gsonRequest =
                new GsonRequest<SelectionBean>(SelectionBean.class,
                        url, new Response.Listener<SelectionBean>() {
                    @Override
                    public void onResponse(SelectionBean response) {
                        //请求成功的方法内 绑定布局
                        selectionAdapter = new SelectionAdapter(getActivity());
                        selectionAdapter.setSelectionBean(response);
                        lv.setAdapter(selectionAdapter);

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        //发送网络请求
        VolleySingleton.getInstance().addRequest(gsonRequest);

    }

    @Override
    protected void initView() {
        //吧放图片的那个作为一个布局
        headView = LayoutInflater.from(getActivity()).inflate(R.layout.guide_head_img_fragment, null);

        lv = bindView(R.id.lv_guide_head);
        //这里是要从fragment中找ID 但是viewpager所在的布局不在fragment中 所以要把相应的布局传到下面
        vp = bindView(headView,R.id.vp_guide_head);
        //吧布局设置成头布局
        lv.addHeaderView(headView);
    }

    @Override
    protected int getLayout() {
        return R.layout.guide_head_fragment;
    }
    @Override
    public void onStop() {
        super.onStop();
        //取消轮播
        mHandler.removeMessages(1);
    }

    @Override
    public void onStart() {
        super.onStart();
        //开始轮播 延时发送一个空的消息 只执行一次回到回调的下面
        mHandler.sendEmptyMessageDelayed(1,2000);
    }
}
