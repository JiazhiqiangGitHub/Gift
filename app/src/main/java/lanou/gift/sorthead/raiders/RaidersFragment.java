package lanou.gift.sorthead.raiders;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import lanou.gift.R;
import lanou.gift.base.BaseFragment;
import lanou.gift.textbean.RaidersBean;
import lanou.gift.textbean.RaidersHeadBean;
import lanou.gift.volley.GsonRequest;
import lanou.gift.volley.Values;
import lanou.gift.volley.VolleySingleton;

/**
 * Created by dllo on 16/10/25.
 */
public class RaidersFragment extends BaseFragment {
    private ListView lv;
    private RaidersAdapter adapter;
    private RaidersHeadAdapter headAdapter;
    private String urlRaders = Values.URL_RAIDERS;
    private RecyclerView rc;
    private View headView;
    private String urlHead = Values.URL_RAIDERS_HEAD;

    @Override
    protected void initDate() {
    //listView 获取数据
        GsonRequest<RaidersBean> gsonRequest = new GsonRequest<RaidersBean>(RaidersBean.class, urlRaders,
                new Response.Listener<RaidersBean>() {
                    @Override
                    public void onResponse(RaidersBean response) {
                        adapter = new RaidersAdapter(getActivity());
                        adapter.setBean(response);
                        lv.setAdapter(adapter);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        VolleySingleton.getInstance().addRequest(gsonRequest);


    //头标的recyclerView 横向拉动 获取数据
        GsonRequest<RaidersHeadBean> gsonRequest1 = new GsonRequest<RaidersHeadBean>(RaidersHeadBean.class,
                urlHead, new Response.Listener<RaidersHeadBean>() {
            @Override
            public void onResponse(RaidersHeadBean response) {
                headAdapter = new RaidersHeadAdapter(getActivity());
                headAdapter.setBean(response);
                rc.setAdapter(headAdapter);
                RecyclerView.LayoutManager manager = new GridLayoutManager(getActivity(),3, LinearLayoutManager.HORIZONTAL,false);
                rc.setLayoutManager(manager);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        VolleySingleton.getInstance().addRequest(gsonRequest1);

    }

    @Override
    protected void initView() {
        headView = LayoutInflater.from(getActivity()).inflate(R.layout.raiders_head, null);
        rc = bindView(headView,R.id.rc_raiders_head);
        lv = bindView(R.id.lv_class_raiders);
        lv.addHeaderView(headView);
    }

    @Override
    protected int getLayout() {

        return R.layout.class_fragment_raiders_item;
    }
}
