package lanou.gift.activity;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.io.UnsupportedEncodingException;

import lanou.gift.R;
import lanou.gift.base.BaseActivity;
import lanou.gift.textbean.SearchTwoBean;
import lanou.gift.values.Values;
import lanou.gift.volley.GsonRequest;
import lanou.gift.volley.VolleySingleton;

/**
 * Created by dllo on 16/11/10.
 */
public class SearchSecondActivity extends BaseActivity {
    private RecyclerView rv;
    private RecyclerViewTwoAdapter adapter;

    @Override
    protected int getLayout() {
        return R.layout.search_activity_two;
    }

    @Override
    protected void initViews() {
        rv = bindView(R.id.rv_search_two);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String str = intent.getStringExtra("search");

        String strUF8 = null;
        try {
            strUF8 = new String(str.getBytes(),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        //// TODO: 16/11/10 三级页面没数据 UFT-8转码
        GsonRequest<SearchTwoBean> gsonRequest = new GsonRequest<SearchTwoBean>(SearchTwoBean.class,
                Values.URL_SEARCH_THREE_A + strUF8 + Values.URL_SEARCH_THREE_B, new Response.Listener<SearchTwoBean>() {
            @Override
            public void onResponse(SearchTwoBean response) {
                adapter = new RecyclerViewTwoAdapter(getApplicationContext());
                adapter.setBean(response);
                rv.setAdapter(adapter);
                GridLayoutManager manager = new GridLayoutManager(getApplicationContext(), 2);
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
