package lanou.gift.guide.firstFragment;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.ArrayList;
import java.util.List;

import lanou.gift.R;
import lanou.gift.base.BaseFragment;
import lanou.gift.textbean.SelectionBean;
import lanou.gift.volley.GsonRequest;
import lanou.gift.volley.VolleySingleton;

/**
 * Created by dllo on 16/10/27.
 */
public class HeadFragment extends BaseFragment {
    private String[] pics = {"http://img02.liwushuo.com/image/161025/4j8uoe9zy.jpg-w720",
            "http://img03.liwushuo.com/image/161027/jlw86rxck.jpg-w720",
            "http://img01.liwushuo.com/image/161027/t21sqabnw.jpg-w720",
            "http://img01.liwushuo.com/image/161026/dxhiii89e.jpg-w720",
            "http://img02.liwushuo.com/image/160929/68bib1c1a.jpg-w720",
            "http://img02.liwushuo.com/image/161028/v577ul0un.jpg-w720",
    };
    private SelectionAdapter selectionAdapter;
    private String url = "http://api.liwushuo.com/v2/channels/101/items_v2?ad=2&gender=1&generation=2&limit=20&offset=0";
    private ListView lv;
    private ViewPager vp;
    private View headView;
    private Handler mHandler;
    private HeadViewPagerAdapter headAdapter;
    private List<Point1> points;
    private LinearLayout pointLayout;
    @Override
    protected void initDate() {

        headAdapter = new HeadViewPagerAdapter();
        headAdapter.setUrl(pics);
        Log.d("zzz", "pics:" + pics);
        vp.setAdapter(headAdapter);

        //调用
        initPoints();
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
        //让点跟着一起动
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            //当前选中的是哪一个
            @Override
            public void onPageSelected(int position) {
                //当前显示的是第几页也就是第几张图
                int currentPage = position % headAdapter.getImgCount();

                for (Point1 point : points) {
                    point.setSelected(false);//所有点弄成不选中
                }
                points.get(currentPage).setSelected(true);//再把当前页的选中
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });




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
    //把点加进去
    private void initPoints() {
        //调用adapter里的获得数量的方法
        //最好不要写Point的类跟系统的重名自己改
        points = new ArrayList<>();
        for (int i = 0; i < headAdapter.getImgCount(); i++) {
            Point1 point =  new Point1(getContext());
            points.add(point);//加到集合里
            //选线性布局里的那个
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    0, ViewGroup.LayoutParams.MATCH_PARENT,1
            );//宽,高,权重
            pointLayout.addView(point,layoutParams);
        }


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
        //点的ID 是个线性布局
        pointLayout = bindView(headView,R.id.guide_point);
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
