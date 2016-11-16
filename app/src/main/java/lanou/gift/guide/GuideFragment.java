package lanou.gift.guide;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import lanou.gift.R;
import lanou.gift.base.BaseFragment;
import lanou.gift.search.SearchActivity;
import lanou.gift.textbean.TabLayoutBean;
import lanou.gift.values.Values;
import lanou.gift.volley.GsonRequest;
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
    private View v;
    private GridView gv;
    private GuideAdapter adapter;
    private GuidePopAdapter popAdapter;
    private TextView tvPop;
    private LinearLayout ll;
    int count = 0;

    @Override
    protected void initDate() {

        GsonRequest<TabLayoutBean> gsonRequest =
                new GsonRequest<TabLayoutBean>(TabLayoutBean.class,
                        urlHead, new Response.Listener<TabLayoutBean>() {

                    @Override
                    public void onResponse(final TabLayoutBean response) {
                        //请求成功的方法内 绑定布局
                        //创建适配器.把ViewPager和适配器 以及TabLayout绑定
                        adapter = new
                                GuideAdapter(getChildFragmentManager());
                        adapter.setBean(response);
                        vp.setAdapter(adapter);
                        tbHead.setupWithViewPager(vp);

                        popAdapter = new GuidePopAdapter(getActivity());
                        popAdapter.setBean(response);
                        gv.setAdapter(popAdapter);



                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                });
        //发送网络请求
        VolleySingleton.getInstance().addRequest(gsonRequest);

        popupWindow = createPop();
        getCridViewOnClick();

        //添加点击事件
        btnSearch.setOnClickListener(this);
        //控制TabLayout滑动
        tbHead.setTabMode(TabLayout.MODE_SCROLLABLE);
        btnD.setOnClickListener(this);

    }
    //pop中gridView的点击事件 页面跳转 文字隐藏 pop消失
    private void getCridViewOnClick() {
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            private TextView name;
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                vp.setCurrentItem(i,false);
                tbHead.setVisibility(View.VISIBLE);
                tvPop.setVisibility(View.INVISIBLE);
                popupWindow.dismiss();
            }
        });


    }



    //创建pop 宽高适应屏幕
    private PopupWindow createPop() {
        //这里必须是getContext 要不没法点按钮切换别的页面
         popupWindow = new PopupWindow(getContext());
        v = LayoutInflater.from(getContext()).inflate(R.layout.guide_pop,null);
        //pop自带的监听 在这里让他们隐藏
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                tvPop.setVisibility(View.INVISIBLE);
                tbHead.setVisibility(View.VISIBLE);
            }
        });
        gv = (GridView) v.findViewById(R.id.guide_pop_grid);
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setContentView(v);
        popupWindow.setFocusable(true);
        return popupWindow;
    }

    @Override
    protected void initView() {
        btnD = bindView(R.id.btn_guide_dialog);
        //布局中为首页创建TabLayout和ViewPager
        tbHead = bindView(R.id.tb_guide_head);
        vp = bindView(R.id.vp_guide);
        btnSearch = bindView(R.id.btn_guide_title_search);
        tvPop = bindView(R.id.tv_pop);

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
            case R.id.btn_guide_dialog:
            //点击按钮的时候判断点击的次数 奇数就显示pop 隐藏tablayout 显示文字 反之相反
                count++;
                if(count%2 == 0){
                    tvPop.setVisibility(View.VISIBLE);
                    tbHead.setVisibility(View.INVISIBLE);
                    popupWindow.showAsDropDown(btnD,0,0);

                    popAdapter.setPositionA(vp.getCurrentItem());

                }else{
                    popupWindow.dismiss();
                }
                break;
        }


    }


}
