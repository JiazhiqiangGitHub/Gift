package lanou.gift.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import lanou.gift.R;
import lanou.gift.base.BaseActivity;
import lanou.gift.textbean.SearchTextBean;
import lanou.gift.values.Values;
import lanou.gift.volley.GsonRequest;
import lanou.gift.volley.VolleySingleton;

/**
 * Created by dllo on 16/10/24.
 */
public class SearchActivity extends BaseActivity implements View.OnClickListener {
    private ImageButton btnBack;
    private ListView lv;
    private RecyclerView rv;
    private RecyclerViewSearchAdapter adapter;



    @Override
    protected int getLayout() {
        return R.layout.activity_search;
    }

    @Override
    protected void initViews() {
        btnBack = bindView(R.id.btn_search_title_back);
        lv = bindView(R.id.lv_search);
        rv = bindView(R.id.rv_search);

    }

    @Override
    protected void initData() {
        adapter = new RecyclerViewSearchAdapter(this);
        btnBack.setOnClickListener(this);
        GridLayoutManager manager = new GridLayoutManager(this,5);
        rv.setLayoutManager(manager);

        GsonRequest<SearchTextBean> gsonRequest = new GsonRequest<SearchTextBean>(SearchTextBean.class,
                Values.URL_SEARCH_RV, new Response.Listener<SearchTextBean>() {
            @Override
            public void onResponse(SearchTextBean response) {

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
    public void onClick(View view) {
        finish();
    }
}
