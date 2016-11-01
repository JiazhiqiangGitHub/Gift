package lanou.gift.hot;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bartoszlipinski.recyclerviewheader.RecyclerViewHeader;
import com.squareup.picasso.Picasso;

import lanou.gift.R;
import lanou.gift.base.BaseFragment;
import lanou.gift.volley.Values;
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
    private RecyclerViewHeader rcHead;
    private String urlHot = Values.URL_HOT;
    private ImageView ivPicture;
    private GridLayoutManager manager;
    @Override
    protected void initDate() {

        GsonRequest<TextHotBean> gsonRequest =
                new GsonRequest<TextHotBean>(TextHotBean.class,
                        urlHot, new Response.Listener<TextHotBean>() {



                    @Override
                    public void onResponse(final TextHotBean response) {
                        Picasso.with(getActivity()).load(response.getData().getCover_image()).into(ivPicture);
                    //请求成功的方法内 绑定布局
                        adapter = new HotAdapter(getActivity());
                        adapter.setBean(response);
                        rc.setAdapter(adapter);
                        //绑定RecyclerView的布局
                        manager = new GridLayoutManager(getActivity(),2);
                        rc.setLayoutManager(manager);
                        //添加头布局 别忘记写true
                        rcHead.attachTo(rc,true);

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                //发送网络请求
                VolleySingleton.getInstance().addRequest(gsonRequest);


        btnSearch.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        btnSearch = bindView(R.id.btn_hot_title_search);
        rc = bindView(R.id.rc_hot);
        ivPicture = bindView(R.id.iv_hot_head);
        rcHead = bindView(R.id.rc_hot_head);
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
