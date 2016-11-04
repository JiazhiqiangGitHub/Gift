package lanou.gift.hot;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import lanou.gift.R;
import lanou.gift.base.BaseFragment;
import lanou.gift.textbean.HotBean;
import lanou.gift.volley.GsonRequest;
import lanou.gift.volley.Values;

/**
 * Created by dllo on 16/11/4.
 */
public class HotFirstFragment extends BaseFragment {
    private TabLayout tb;
    private ViewPager viewPager;
    private HotFirstAdapter adapter;
    private String urlHead = Values.URL_HOT_TABLAYOUT;
    @Override
    protected void initDate() {
        GsonRequest<HotBean> gsonRequest = new GsonRequest<HotBean>(HotBean.class, urlHead,
                new Response.Listener<HotBean>() {
                    @Override
                    public void onResponse(HotBean response) {
                        adapter = new HotFirstAdapter(getChildFragmentManager());
                        adapter.setBean(response);
                        viewPager.setAdapter(adapter);
                        tb.setupWithViewPager(viewPager);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }

    @Override
    protected void initView() {
        viewPager = bindView(R.id.vp_hot);
        tb = bindView(R.id.tb_hot_head);
    }

    @Override
    protected int getLayout() {
        return R.layout.hot_first_fragment;
    }
}
