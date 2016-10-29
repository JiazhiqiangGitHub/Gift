package lanou.gift.guide;

import android.os.Bundle;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import lanou.gift.R;
import lanou.gift.base.BaseFragment;
import lanou.gift.textbean.GuideGirlFriendBean;
import lanou.gift.volley.GsonRequest;
import lanou.gift.volley.VolleySingleton;

/**
 * Created by dllo on 16/10/25.
 */
public class TabLayoutFragment extends BaseFragment{
    public static String TABLAYOUT_FRAGMENT = "tab_fragment";
    //其余6页公用一个adapter bean fragment
    private int type;
    private ListView lv;
    private TableLayoutAdapter adapter;
    private String urlGirl = "http://api.liwushuo.com/v2/channels/10/items_v2?gender=1&limit=20&offset=0&generation=2";
    private String urlChoose = "http://api.liwushuo.com/v2/channels/129/items_v2?gender=1&limit=20&offset=0&generation=2";
    private String urlOriginality = "http://api.liwushuo.com/v2/channels/125/items_v2?gender=1&limit=20&offset=0&generation=2";
    private String urlFriend ="http://api.liwushuo.com/v2/channels/26/items_v2?gender=1&limit=20&offset=0&generation=2";
    private String urlParent ="http://api.liwushuo.com/v2/channels/6/items_v2?gender=1&limit=20&offset=0&generation=2";
    private String urlWorker ="http://api.liwushuo.com/v2/channels/17/items_v2?gender=1&limit=20&offset=0&generation=2";
    public static TabLayoutFragment newInstance(int type) {

        TabLayoutFragment fragment = new TabLayoutFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(TABLAYOUT_FRAGMENT, type);
        fragment.setArguments(bundle);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            type = (int) getArguments().getSerializable(TABLAYOUT_FRAGMENT);
        }
    }
    @Override
    protected void initDate() {
        switch (type) {
            case 2:
                GsonRequest<GuideGirlFriendBean> gsonRequest2 =
                        new GsonRequest<GuideGirlFriendBean>(GuideGirlFriendBean.class,
                                urlGirl, new Response.Listener<GuideGirlFriendBean>() {
                            @Override
                            public void onResponse(GuideGirlFriendBean response) {
                                //请求成功的方法内 绑定布局
                                adapter = new TableLayoutAdapter(getActivity());
                                adapter.setBean(response);
                                lv.setAdapter(adapter);

                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        });
                //发送网络请求
                VolleySingleton.getInstance().addRequest(gsonRequest2);

            break;
            case 3:
                GsonRequest<GuideGirlFriendBean> gsonRequest3 =
                        new GsonRequest<GuideGirlFriendBean>(GuideGirlFriendBean.class,
                                urlChoose, new Response.Listener<GuideGirlFriendBean>() {
                            @Override
                            public void onResponse(GuideGirlFriendBean response) {
                                //请求成功的方法内 绑定布局
                                adapter = new TableLayoutAdapter(getActivity());
                                adapter.setBean(response);
                                lv.setAdapter(adapter);

                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        });
                //发送网络请求
                VolleySingleton.getInstance().addRequest(gsonRequest3);
                break;
            case 4:
                GsonRequest<GuideGirlFriendBean> gsonRequest4 =
                        new GsonRequest<GuideGirlFriendBean>(GuideGirlFriendBean.class,
                                urlOriginality, new Response.Listener<GuideGirlFriendBean>() {
                            @Override
                            public void onResponse(GuideGirlFriendBean response) {
                                //请求成功的方法内 绑定布局
                                adapter = new TableLayoutAdapter(getActivity());
                                adapter.setBean(response);
                                lv.setAdapter(adapter);
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                            }
                        });
                //发送网络请求
                VolleySingleton.getInstance().addRequest(gsonRequest4);
                break;
            case 5:
                GsonRequest<GuideGirlFriendBean> gsonRequest5 =
                        new GsonRequest<GuideGirlFriendBean>(GuideGirlFriendBean.class,
                                urlFriend, new Response.Listener<GuideGirlFriendBean>() {
                            @Override
                            public void onResponse(GuideGirlFriendBean response) {
                                //请求成功的方法内 绑定布局
                                adapter = new TableLayoutAdapter(getActivity());
                                adapter.setBean(response);
                                lv.setAdapter(adapter);

                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        });
                //发送网络请求
                VolleySingleton.getInstance().addRequest(gsonRequest5);

                break;
            case 6:
                GsonRequest<GuideGirlFriendBean> gsonRequest6 =
                        new GsonRequest<GuideGirlFriendBean>(GuideGirlFriendBean.class,
                                urlParent, new Response.Listener<GuideGirlFriendBean>() {
                            @Override
                            public void onResponse(GuideGirlFriendBean response) {
                                //请求成功的方法内 绑定布局
                                adapter = new TableLayoutAdapter(getActivity());
                                adapter.setBean(response);
                                lv.setAdapter(adapter);

                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        });
                //发送网络请求
                VolleySingleton.getInstance().addRequest(gsonRequest6);

                break;
            case 7:
                GsonRequest<GuideGirlFriendBean> gsonRequest7 =
                        new GsonRequest<GuideGirlFriendBean>(GuideGirlFriendBean.class,
                                urlWorker, new Response.Listener<GuideGirlFriendBean>() {
                            @Override
                            public void onResponse(GuideGirlFriendBean response) {
                                //请求成功的方法内 绑定布局
                                adapter = new TableLayoutAdapter(getActivity());
                                adapter.setBean(response);
                                lv.setAdapter(adapter);

                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        });
                //发送网络请求
                VolleySingleton.getInstance().addRequest(gsonRequest7);
                break;
        }
    }
    @Override
    protected void initView() {
        lv = bindView(R.id.lv_fragment);
    }

    @Override
    protected int getLayout() {
        return R.layout.guide_fragment_item;
    }
}
