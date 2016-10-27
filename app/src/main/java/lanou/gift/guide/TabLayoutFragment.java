package lanou.gift.guide;

import android.os.Bundle;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import lanou.gift.R;
import lanou.gift.base.BaseFragment;
import lanou.gift.guide.adapter.ChooseAdapter;
import lanou.gift.guide.adapter.OriginalityAdapter;
import lanou.gift.guide.adapter.SelectionAdapter;
import lanou.gift.guide.adapter.TableLayoutAdapter;
import lanou.gift.textbean.ChooseBean;
import lanou.gift.textbean.GuideGirlFriendBean;
import lanou.gift.textbean.OriginalityBean;
import lanou.gift.textbean.SelectionBean;
import lanou.gift.volley.GsonRequest;
import lanou.gift.volley.VolleySingleton;

/**
 * Created by dllo on 16/10/25.
 */
public class TabLayoutFragment extends BaseFragment{
    public static String TABLAYOUT_FRAGMENT = "tab_fragment";
    private int type;
    private ListView lv;
    private SelectionAdapter selectionAdapter;
    private TableLayoutAdapter girlAdapter;
    private ChooseAdapter chooseAdapter;
    private OriginalityAdapter originalityAdapter;
    private String url = "http://api.liwushuo.com/v2/channels/101/items_v2?ad=2&gender=1&generation=2&limit=20&offset=0";
    private String urlGirl = "http://api.liwushuo.com/v2/channels/10/items_v2?gender=1&limit=20&offset=0&generation=2";
    private String urlChoose = "http://api.liwushuo.com/v2/channels/129/items_v2?gender=1&limit=20&offset=0&generation=2";
    private String urlOriginality = "http://api.liwushuo.com/v2/channels/125/items_v2?gender=1&limit=20&offset=0&generation=2";
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
            case 1:
                GsonRequest<SelectionBean> gsonRequest =
                        new GsonRequest<SelectionBean>(SelectionBean.class,
                                url, new Response.Listener<SelectionBean>() {
                            @Override
                            public void onResponse(SelectionBean response) {
                                //请求成功的方法内 绑定布局
                                selectionAdapter = new SelectionAdapter(getActivity());
                                selectionAdapter.setSelectionBean(response);
                                lv.setAdapter(selectionAdapter);

                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        });
                //发送网络请求
                VolleySingleton.getInstance().addRequest(gsonRequest);

                break;
            case 2:
                GsonRequest<GuideGirlFriendBean> gsonRequest2 =
                        new GsonRequest<GuideGirlFriendBean>(GuideGirlFriendBean.class,
                                urlGirl, new Response.Listener<GuideGirlFriendBean>() {
                            @Override
                            public void onResponse(GuideGirlFriendBean response2) {
                                //请求成功的方法内 绑定布局
                                girlAdapter = new TableLayoutAdapter(getActivity());
                                girlAdapter.setBeanGirl(response2);
                                lv.setAdapter(girlAdapter);

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
                GsonRequest<ChooseBean> gsonRequest3 =
                        new GsonRequest<ChooseBean>(ChooseBean.class,
                                urlChoose, new Response.Listener<ChooseBean>() {
                            @Override
                            public void onResponse(ChooseBean response3) {
                                //请求成功的方法内 绑定布局
                                chooseAdapter = new ChooseAdapter(getActivity());
                                chooseAdapter.setBeanChoose(response3);
                                lv.setAdapter(chooseAdapter);

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
                GsonRequest<OriginalityBean> gsonRequest4 =
                        new GsonRequest<OriginalityBean>(OriginalityBean.class,
                                urlOriginality, new Response.Listener<OriginalityBean>() {
                            @Override
                            public void onResponse(OriginalityBean response4) {
                                //请求成功的方法内 绑定布局
                                originalityAdapter = new OriginalityAdapter(getActivity());
                                originalityAdapter.setOriginalityBean(response4);
                                lv.setAdapter(originalityAdapter);

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

                break;
            case 6:

                break;
            case 7:
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
