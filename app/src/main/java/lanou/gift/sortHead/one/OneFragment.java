package lanou.gift.sorthead.one;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import lanou.gift.R;
import lanou.gift.base.BaseFragment;
import lanou.gift.textbean.OneBean;
import lanou.gift.volley.GsonRequest;
import lanou.gift.volley.Values;
import lanou.gift.volley.VolleySingleton;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/**
 * Created by dllo on 16/10/25.
 */
public class OneFragment extends BaseFragment {
    private ListView leftListView;
    private StickyListHeadersListView rightListView;
    private RightAdapter rightAdapter;
    private LeftAdapter leftAdapter;
    private String urlOne= Values.URL_ONE;



    @Override
    protected void initDate() {

        //相同的url 一起请求
        GsonRequest<OneBean> gsonRequest =
                new GsonRequest<OneBean>(OneBean.class,
                        urlOne, new Response.Listener<OneBean>() {
                    @Override
                    public void onResponse(OneBean response) {
                        //请求成功的方法内 绑定布局
                        leftAdapter = new LeftAdapter(getActivity());
                        leftAdapter.setBean(response);
                        leftListView.setAdapter(leftAdapter);

                        rightAdapter = new RightAdapter(getActivity());
                        rightAdapter.setBody(response);
                        rightAdapter.setHead(response);
                        rightListView.setAdapter(rightAdapter);


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        //发送网络请求
        VolleySingleton.getInstance().addRequest(gsonRequest);

        leftListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                rightListView.setSelection(i);


            }
        });

        rightListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                leftListView.smoothScrollToPositionFromTop(i,0);
            }
        });


    }


    @Override
    protected void initView() {
        leftListView = bindView(R.id.lv_class_one_left);
        rightListView = bindView(R.id.lv_class_one_right);
    }

    @Override
    protected int getLayout() {
        return R.layout.class_fragment_one_item;
    }
}
