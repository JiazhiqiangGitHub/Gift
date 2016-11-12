package lanou.gift.sorthead.secondone;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import lanou.gift.R;
import lanou.gift.base.BaseActivity;
import lanou.gift.textbean.SingleActivityBean;
import lanou.gift.values.Values;
import lanou.gift.volley.GsonRequest;
import lanou.gift.volley.VolleySingleton;

/**
 * Created by dllo on 16/11/3.
 */
public class OneActivity extends BaseActivity{
    private RecyclerView rc;
    private TextView tv;
    private OneSecondAdapter adapter;
    private Context context;

    @Override
    protected int getLayout() {
        return R.layout.activity_one;
    }

    @Override
    protected void initViews() {
        tv = bindView(R.id.tv_one_activity_main_title);
        rc = bindView(R.id.rc_activity_one);
    }

    @Override
    protected void initData() {
        //获取传的值 和ID

        Intent intent = getIntent();
        String strId = intent.getStringExtra("id");
        String str = intent.getStringExtra("strTitle");
        tv.setText(str);
        int id = Integer.parseInt(strId);
        GsonRequest<SingleActivityBean> gsonRequest = new GsonRequest<SingleActivityBean>(SingleActivityBean.class,
                Values.URL_ONE_ONE_A + id + Values.URL_ONE_ONE_B, new Response.Listener<SingleActivityBean>() {
            @Override
            public void onResponse(SingleActivityBean response) {
                adapter = new OneSecondAdapter(context);
                adapter.setBean(response);
                rc.setAdapter(adapter);

                GridLayoutManager manager = new GridLayoutManager(context,2);
                rc.setLayoutManager(manager);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        VolleySingleton.getInstance().addRequest(gsonRequest);

    }
}
