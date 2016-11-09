package lanou.gift.hot.second;

import android.content.Intent;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import lanou.gift.R;
import lanou.gift.base.BaseFragment;
import lanou.gift.textbean.CommentBean;
import lanou.gift.values.Values;
import lanou.gift.volley.GsonRequest;
import lanou.gift.volley.VolleySingleton;

/**
 * Created by dllo on 16/11/5.
 */
public class commentFragment extends BaseFragment {
    private ListView lv;
    private CommentAdapter adapter;

    @Override
    protected void initDate() {

        adapter = new CommentAdapter();
        Intent intent = getActivity().getIntent();
        String str = intent.getStringExtra("id");
        int id = Integer.parseInt(str);


        GsonRequest<CommentBean> gsonRequest = new GsonRequest<CommentBean>(CommentBean.class,
                Values.URL_COMMENT_A + id + Values.URL_COMMENT_B, new Response.Listener<CommentBean>() {
            @Override
            public void onResponse(CommentBean response) {
                adapter = new CommentAdapter();
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

    @Override
    protected void initView() {
        lv = bindView(R.id.lv_comment);

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_comment;
    }
}
