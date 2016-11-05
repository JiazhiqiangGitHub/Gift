package lanou.gift.activity;

import android.content.Intent;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import lanou.gift.R;
import lanou.gift.base.BaseActivity;
import lanou.gift.textbean.RaidersSecondBean;
import lanou.gift.values.Values;
import lanou.gift.volley.GsonRequest;
import lanou.gift.volley.VolleySingleton;

/**
 * Created by dllo on 16/11/3.
 */
public class RaidersActivity extends BaseActivity{
    private ListView lv;
    private RaidersActivityAdapter adapter;
    private String urlA = Values.URL_RAIDERS_A;
    private String urlB = Values.URL_RAIDERS_B;
    private TextView tv;

    @Override
    protected int getLayout() {
        return R.layout.activity_raiders;


    }

    @Override
    protected void initViews() {
        lv = bindView(R.id.lv_raiders_activity);
        tv = bindView(R.id.tv_radiers_activity_head_title);
    }

    @Override
    protected void initData() {
        adapter = new RaidersActivityAdapter(this);
        Intent intent = getIntent();
        String str = intent.getStringExtra("id");
        String title = intent.getStringExtra("name");
        tv.setText(title);
        int id = Integer.parseInt(str);
    //// TODO: 16/11/5  接口有问题
            GsonRequest<RaidersSecondBean> gsonRequest = new GsonRequest<RaidersSecondBean>(RaidersSecondBean.class,
                   urlA+id+urlB, new Response.Listener<RaidersSecondBean>() {
                @Override
                public void onResponse(RaidersSecondBean response) {

                    adapter.setBean(response);
                    lv.setAdapter(adapter);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
            VolleySingleton.getInstance().addRequest(gsonRequest);

    }


}
