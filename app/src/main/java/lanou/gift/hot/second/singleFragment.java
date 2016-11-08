package lanou.gift.hot.second;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import lanou.gift.R;
import lanou.gift.base.BaseFragment;
import lanou.gift.textbean.HotSecondOneBean;
import lanou.gift.values.Values;
import lanou.gift.volley.GsonRequest;
import lanou.gift.volley.VolleySingleton;

/**
 * Created by dllo on 16/11/5.
 */
public class singleFragment extends BaseFragment{
    private HotThirdOneAdapter adapter;
    private RecyclerView rv;
    private HotSecondOneBean.DataBean.RecommendItemsBean bean;

    //// TODO: 16/11/8 字符串拼接 
    @Override
    protected void initDate() {
        bean = new HotSecondOneBean.DataBean.RecommendItemsBean();
        GsonRequest<HotSecondOneBean> gsonRequest = new GsonRequest<HotSecondOneBean>(HotSecondOneBean.class,
                Values.URL_HOT_ONE_A + bean.getId() + Values.URL_HOT_ONE_B,
                new Response.Listener<HotSecondOneBean>() {
                    @Override
                    public void onResponse(HotSecondOneBean response) {

                        adapter = new HotThirdOneAdapter(getActivity());
                        adapter.setBean(response);
                        rv.setAdapter(adapter);

                        GridLayoutManager m = new GridLayoutManager(getActivity(),2);
                        rv.setLayoutManager(m);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        VolleySingleton.getInstance().addRequest(gsonRequest);

    }

    @Override
    protected void initView() {
        rv = bindView(R.id.rv_hot_second);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_single;
    }


}
