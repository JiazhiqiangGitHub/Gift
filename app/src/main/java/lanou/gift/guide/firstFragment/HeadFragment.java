package lanou.gift.guide.firstFragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
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
import lanou.gift.guide.otherFragment.TableLayoutAdapter;
import lanou.gift.textbean.GirlFriend;
import lanou.gift.textbean.GuideBean;
import lanou.gift.volley.GsonRequest;
import lanou.gift.values.Point1;
import lanou.gift.values.Values;
import lanou.gift.volley.VolleySingleton;

/**
 * Created by dllo on 16/10/27.
 */
public class HeadFragment extends BaseFragment {
    private String urlHead = Values.URL_RCHEAD;
    private TableLayoutAdapter adapter;
    private String url = Values.URL_HEAD;
    private ListView lv;
    private ViewPager vp;
    private View headView;
    private Handler mHandler;
    private HeadViewPagerAdapter headAdapter;
    private List<Point1> points;
    private LinearLayout pointLayout;

    @Override
    protected void initDate() {
        //解析轮播图的网址
        initGson();
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
        GsonRequest<GirlFriend> gsonRequest =
                new GsonRequest<GirlFriend>(GirlFriend.class,
                        url, new Response.Listener<GirlFriend>() {
                    @Override
                    public void onResponse(GirlFriend response) {
                        //请求成功的方法内 绑定布局
                        adapter = new TableLayoutAdapter(getActivity());
                        adapter.setBean(response);
                        lv.setAdapter(adapter);

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        //发送网络请求
        VolleySingleton.getInstance().addRequest(gsonRequest);
    }

    private void initGson() {

        GsonRequest<GuideBean> guideBeanGsonRequest = new GsonRequest<GuideBean>(GuideBean.class, urlHead,
                new Response.Listener<GuideBean>() {

                    @Override
                    public void onResponse(GuideBean response) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        int urlSize = response.getData().getBanners().size();
                        for (int i = 0; i < urlSize; i++) {
                            String urlimg = response.getData().getBanners().get(i).getImage_url();
                            arrayList.add(urlimg);
                        }

                        headAdapter = new HeadViewPagerAdapter();
                        headAdapter.setUrls(arrayList);
                        vp.setAdapter(headAdapter);

                        //把点加进去
                        points = new ArrayList<>();
                        for (int i = 0; i < urlSize; i++) {
                            Point1 point =  new Point1(getContext());
                            points.add(point);//加到集合里
                            //选线性布局里的那个
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                                    0, ViewGroup.LayoutParams.MATCH_PARENT,1
                            );//宽,高,权重
                            pointLayout.addView(point,layoutParams);
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {



            }
        });
        VolleySingleton.getInstance().addRequest(guideBeanGsonRequest);


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
    //实现Fragment的复用
    public static HeadFragment newInstance(int position){
        Bundle args = new Bundle();
        args.putInt("position",position);
        HeadFragment fragment = new HeadFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
