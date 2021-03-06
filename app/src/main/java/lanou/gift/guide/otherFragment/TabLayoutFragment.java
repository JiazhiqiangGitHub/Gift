package lanou.gift.guide.otherFragment;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;

import lanou.gift.R;
import lanou.gift.base.BaseFragment;
import lanou.gift.guide.GuideAdapter;
import lanou.gift.textbean.GirlFriend;
import lanou.gift.values.Values;
import lanou.gift.volley.GsonRequest;
import lanou.gift.volley.VolleySingleton;


/**
 * Created by dllo on 16/10/25.
 */
public class TabLayoutFragment extends BaseFragment {
    public static String POSITION = "position";
    //其余14页公用一个adapter bean fragment
    private int type;
    private PullToRefreshListView lv;
    private TableLayoutAdapter adapter;
    private String urlA = Values.URL_TABLAYOUT_A;
    private String urlB = Values.URL_TABLAYOUT_B;
    private String urlBB = Values.URL_TABLAYOUT_BB;
    private int j;
    private ArrayList<String> urlList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //获取tablayout的数量赋给type
            type = (int) getArguments().getSerializable(POSITION);
        }
    }

    @Override
    protected void initDate() {
        //刷新
        lv.setMode(PullToRefreshBase.Mode.BOTH);
        lv.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {

                CountDownTimer countDownTimer = new CountDownTimer(1000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                    }

                    @Override
                    public void onFinish() {
                        lv.onRefreshComplete();
                    }
                };
                countDownTimer.start();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
                //不需要判断 直接下拉到底下的时候加20页
                j = j + 20;

                String url = urlA + GuideAdapter.getId(getPosition()) + urlBB + j;
                GsonRequest<GirlFriend> request = new GsonRequest<GirlFriend>(GirlFriend.class,
                        url, new Response.Listener<GirlFriend>() {
                    @Override
                    public void onResponse(GirlFriend response) {
                        adapter.setBean(response, false);
                        //不要在这刷新
                        adapter.notifyDataSetChanged();
                        lv.onRefreshComplete();

                        for (int i = 0; i < response.getData().getItems().size(); i++) {
                            String url = response.getData().getItems().get(i).getUrl();
                            urlList.add(url);
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                });
                VolleySingleton.getInstance().addRequest(request);

            }

        });

        //复用
        switch (type) {
            case 1:
                //把listView的解析封装成一个方法
                Gson();
                break;
            case 2:
                Gson();
                break;
            case 3:
                Gson();
                break;
            case 4:
                Gson();
                break;
            case 5:
                Gson();
                break;
            case 6:
                Gson();
                break;
            case 7:
                Gson();
                break;
            case 8:
                Gson();
                break;
            case 9:
                Gson();
                break;
            case 10:
                Gson();
                break;
            case 11:
                Gson();
                break;
            case 12:
                Gson();
                break;
            case 13:
                Gson();
                break;
            case 14:
                Gson();
                break;
            case 15:
                Gson();
                break;
            case 16:
                Gson();
                break;

        }


    }

    //封装的listView解析方法
    private void Gson() {
        GsonRequest<GirlFriend> gsonRequest2 =
                new GsonRequest<GirlFriend>(GirlFriend.class,
                        urlA + GuideAdapter.getId(getPosition()) + urlB, new Response.Listener<GirlFriend>() {
                    @Override
                    public void onResponse(GirlFriend response) {
                        //请求成功的方法内 绑定布局
                        adapter = new TableLayoutAdapter(getActivity());
                        adapter.setBean(response);
                        lv.setAdapter(adapter);

//


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        //发送网络请求
        VolleySingleton.getInstance().addRequest(gsonRequest2);

    }

    @Override
    protected void initView() {
        lv = bindView(R.id.lv_fragment);
    }

    @Override
    protected int getLayout() {
        return R.layout.guide_fragment_item;
    }

    //获取tablayout的对应位置信息
    private int getPosition() {
        int position;
        Bundle args = getArguments();
        //获得传入Bunndle的位置信息 并取出
        if (args != null) {
            position = args.getInt("position");
            return position;
        } else return 0;

    }


}
