package lanou.gift.guide;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import lanou.gift.R;
import lanou.gift.activity.SearchActivity;
import lanou.gift.base.BaseFragment;
import lanou.gift.textbean.TabLayoutBean;
import lanou.gift.volley.GsonRequest;
import lanou.gift.volley.Values;
import lanou.gift.volley.VolleySingleton;

/**
 * Created by dllo on 16/10/21.
 */
public class GuideFragment extends BaseFragment implements View.OnClickListener {
    private TabLayout tbHead;
    private ViewPager vp;
    private ImageButton btnSearch;
    private String urlHead = Values.URL_TABLAYOUT;
    private Button btnD;
    private PopupWindow popupWindow;
    private RecyclerView rc;
    private View v;


    @Override
    protected void initDate() {

        GsonRequest<TabLayoutBean> gsonRequest =
                new GsonRequest<TabLayoutBean>(TabLayoutBean.class,
                        urlHead, new Response.Listener<TabLayoutBean>() {
                    @Override
                    public void onResponse(TabLayoutBean response) {
                        //请求成功的方法内 绑定布局
                        //创建适配器.把ViewPager和适配器 以及TabLayout绑定
                        GuideAdapter adapter = new
                                GuideAdapter(getChildFragmentManager());
                        adapter.setBean(response);
                        vp.setAdapter(adapter);
                        tbHead.setupWithViewPager(vp);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                });
        //发送网络请求
        VolleySingleton.getInstance().addRequest(gsonRequest);



        //添加点击事件
        btnSearch.setOnClickListener(this);
        //控制TabLayout滑动
        tbHead.setTabMode(TabLayout.MODE_SCROLLABLE);
        btnD.setOnClickListener(this);

    }
    @Override
    protected void initView() {
        btnD = bindView(R.id.btn_guide_dialog);
        //布局中为首页创建TabLayout和ViewPager
        tbHead = bindView(R.id.tb_guide_head);
        vp = bindView(R.id.vp_guide);
        btnSearch = bindView(R.id.btn_guide_title_search);


    }
    @Override
    protected int getLayout() {
        //布局
        return R.layout.guide_fragment;
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_guide_title_search:
            Intent intent = new Intent(getActivity(), SearchActivity.class);
            startActivity(intent);
                break;
            //对话框
            case R.id.btn_guide_dialog:
                if (popupWindow == null || ! popupWindow.isShowing()){
                    popup();
                    popupWindow.showAsDropDown(btnD);
                }else{
                    popupWindow.dismiss();
                }
                break;
        }
    }
    //TODO pop
    private void popup() {
        popupWindow = new PopupWindow(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        v = LayoutInflater.from(getActivity()).inflate(R.layout.guide_pop,null);
        popupWindow.setContentView(v);
        //pop的recyclerView
        rc = (RecyclerView) v.findViewById(R.id.rc_guide_pop);

        GsonRequest<TabLayoutBean> gsonRequest1 =
                new GsonRequest<TabLayoutBean>(TabLayoutBean.class,
                        urlHead, new Response.Listener<TabLayoutBean>() {
                    @Override
                    public void onResponse(TabLayoutBean response) {
                        //解析pop内recyclerView的内容
                        GuidePopAdapter adapter1 = new
                                GuidePopAdapter(getActivity());
                        adapter1.setBean(response);
                        rc.setAdapter(adapter1);

                        GridLayoutManager manager = new GridLayoutManager(getActivity(),4);
                        rc.setLayoutManager(manager);

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                });
        //发送网络请求
        VolleySingleton.getInstance().addRequest(gsonRequest1);

    }
}
