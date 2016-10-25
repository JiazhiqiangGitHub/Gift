package lanou.gift.guide;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import lanou.gift.R;
import lanou.gift.base.BaseFragment;

/**
 * Created by dllo on 16/10/25.
 */
public class TabLayoutFragment extends BaseFragment{
    public static String TABLAYOUT_FRAGMENT = "tab_fragment";
    private TextView tv;
    private int type;
    private ListView lv;
    private ArrayList<GuideBean> arrayList;
    private TableLayoutAdapter adapter;
    private GuideBean bean;


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
                tv.setText("这是精选Fragment");
                break;
            case 2:
                tv.setText("这是关注Fragment");
                break;
            case 3:
                tv.setText("这是送女票Fragment");
                break;
            case 4:
                tv.setText("这是海掏Fragment");
                break;
            case 5:
                tv.setText("这是科技范Fragment");
                break;
            case 6:
                tv.setText("这是美食Fragment");
                break;
            case 7:
                tv.setText("这是送基友Fragment");
                break;
            case 8:
                tv.setText("这是送爸妈Fragment");
                break;
            case 9:
                tv.setText("这是送同事Fragment");
                break;
            case 10:
                tv.setText("这是送宝贝Fragment");
                break;
        }
        arrayList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            bean = new GuideBean();
            bean.setBody("嘿嘿嘿");
            arrayList.add(bean);
        }
        adapter = new TableLayoutAdapter(getActivity());
        adapter.setBean(arrayList);
        lv.setAdapter(adapter);


    }

    @Override
    protected void initView() {
        tv = bindView(R.id.tv_guide_fragment);
        lv = bindView(R.id.lv_fragment);
    }

    @Override
    protected int getLayout() {
        return R.layout.guide_fragment_item;
    }
}
