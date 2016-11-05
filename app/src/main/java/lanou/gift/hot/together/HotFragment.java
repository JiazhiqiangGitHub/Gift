package lanou.gift.hot.together;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bartoszlipinski.recyclerviewheader.RecyclerViewHeader;
import com.squareup.picasso.Picasso;

import lanou.gift.R;
import lanou.gift.base.BaseFragment;
import lanou.gift.hot.HotFirstAdapter;
import lanou.gift.textbean.TextHotBean;
import lanou.gift.volley.GsonRequest;
import lanou.gift.values.Values;
import lanou.gift.volley.VolleySingleton;

/**
 * Created by dllo on 16/10/21.
 */
public class HotFragment extends BaseFragment {
    private RecyclerView rc;
    private HotAdapter adapter;
    private RecyclerViewHeader rcHead;
    private String urlHotA = Values.URL_HOT_A;
    private String urlHotB = Values.URL_HOT_B;
    private ImageView ivPicture;
    private GridLayoutManager manager;
    private int type;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //获取tablayout的数量赋给type
            type = (int) getArguments().getSerializable("hotPosition");
        }
    }
    @Override
    protected void initDate() {
        switch (type){
            case 0:
                gsonHot();
                break;
            case 1:
                gsonHot();
                break;
            case 2:
                gsonHot();
                break;
            case 3:
                gsonHot();
                break;
        }

    }

    private void gsonHot() {

        GsonRequest<TextHotBean> gsonRequest =
                new GsonRequest<TextHotBean>(TextHotBean.class,
                        urlHotA+ HotFirstAdapter.getId(getHotPosition())+urlHotB, new Response.Listener<TextHotBean>() {

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


    }

    @Override
    protected void initView() {
        rc = bindView(R.id.rc_hot);
        ivPicture = bindView(R.id.iv_hot_head);
        rcHead = bindView(R.id.rc_hot_head);
    }

    @Override
    protected int getLayout() {
        return R.layout.hot_fragment;
    }

    private  int getHotPosition(){
        int position;
        Bundle args = getArguments();
        //获得传入Bunndle的位置信息 并取出
        if (args != null) {
            position = args.getInt("hotPosition");
            return position;
        }else return 0;
    }


}
