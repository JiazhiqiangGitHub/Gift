package lanou.gift.hot.second;

import android.content.Intent;
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


    @Override
    protected void initDate() {
        adapter = new HotThirdOneAdapter();
        Intent intent = getActivity().getIntent();
        String str = intent.getStringExtra("id");
        int id = Integer.parseInt(str);

        GsonRequest<HotSecondOneBean> gsonRequest = new GsonRequest<HotSecondOneBean>(HotSecondOneBean.class,
                Values.URL_HOT_ONE_A + id + Values.URL_HOT_ONE_B,
                new Response.Listener<HotSecondOneBean>() {
                    @Override
                    public void onResponse(HotSecondOneBean response) {

                        adapter = new HotThirdOneAdapter();
                        adapter.setBean(response);
                        rv.setAdapter(adapter);


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
        GridLayoutManager m = new GridLayoutManager(getActivity(),2);
        rv.setLayoutManager(m);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_single;
    }


}
