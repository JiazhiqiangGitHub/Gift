package lanou.gift.hot;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import lanou.gift.R;
import lanou.gift.base.BaseFragment;
import lanou.gift.search.SearchActivity;
import lanou.gift.textbean.TextHotBean;
import lanou.gift.volley.GsonRequest;
import lanou.gift.volley.VolleySingleton;

/**
 * Created by dllo on 16/10/21.
 */
public class HotFragment extends BaseFragment implements View.OnClickListener {
    private ImageButton btnSearch;
    private RecyclerView rc;
    private HotAdapter adapter;

    private String url = "http://api.liwushuo.com/v2/items?limit=20&offset=0&gender=2&generation=1";
    private ImageView ivPicture;
    @Override
    protected void initDate() {
        GsonRequest<TextHotBean> gsonRequest =
                new GsonRequest<TextHotBean>(TextHotBean.class,
                        url, new Response.Listener<TextHotBean>() {
                    @Override
                    public void onResponse(TextHotBean response) {
                    //请求成功的方法内 绑定布局
                        adapter = new HotAdapter(getActivity());
                        adapter.setBean(response);
                        rc.setAdapter(adapter);

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                //发送网络请求
                VolleySingleton.getInstance().addRequest(gsonRequest);

        //绑定RecyclerView的布局
        GridLayoutManager manager = new GridLayoutManager(getActivity(),2);
        rc.setLayoutManager(manager);

        btnSearch.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        btnSearch = bindView(R.id.btn_hot_title_search);
        rc = bindView(R.id.rc_hot);
        ivPicture = bindView(R.id.iv_hot_rv_picture);
    }

    @Override
    protected int getLayout() {
        return R.layout.hot_fragment;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getActivity(),SearchActivity.class);
        startActivity(intent);
    }



}
