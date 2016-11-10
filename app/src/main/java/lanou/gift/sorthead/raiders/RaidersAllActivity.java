package lanou.gift.sorthead.raiders;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import lanou.gift.R;
import lanou.gift.base.BaseActivity;
import lanou.gift.textbean.RaidersBean;
import lanou.gift.values.Values;
import lanou.gift.volley.GsonRequest;
import lanou.gift.volley.VolleySingleton;

/**
 * Created by dllo on 16/11/10.
 */
public class RaidersAllActivity extends BaseActivity{
    private RecyclerView rv;
    private ItemAdapter adapter;
    private String urlRaders = Values.URL_RAIDERS;
    private Context context;

    @Override
    protected int getLayout() {
        return R.layout.raiders_all;
    }

    @Override
    protected void initViews() {
        rv = bindView(R.id.rv_raiders_all);
    }

    @Override
    protected void initData() {
        adapter = new ItemAdapter();
        GsonRequest<RaidersBean> gsonRequest = new GsonRequest<RaidersBean>(RaidersBean.class, urlRaders,
                new Response.Listener<RaidersBean>() {
                    @Override
                    public void onResponse(RaidersBean response) {

                        adapter.setBean(response);
                        rv.setAdapter(adapter);
                        GridLayoutManager manager = new GridLayoutManager(context,2);
                        rv.setLayoutManager(manager);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        VolleySingleton.getInstance().addRequest(gsonRequest);
    }
}
