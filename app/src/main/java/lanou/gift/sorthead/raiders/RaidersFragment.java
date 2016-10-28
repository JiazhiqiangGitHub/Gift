package lanou.gift.sorthead.raiders;

import android.widget.ListView;

import java.util.ArrayList;

import lanou.gift.R;
import lanou.gift.base.BaseFragment;
import lanou.gift.textbean.RaidersBean;

/**
 * Created by dllo on 16/10/25.
 */
public class RaidersFragment extends BaseFragment {
    private ListView lv;
    private RaidersAdapter adapter;

    @Override
    protected void initDate() {
        ArrayList<RaidersBean> arrayList = new ArrayList<>();
        RaidersBean bean = new RaidersBean();
        for (int i = 0; i < 50; i++) {
            bean.setBody("0 0");
            arrayList.add(bean);
        }
        adapter = new RaidersAdapter(getActivity());
        adapter.setArrayList(arrayList);
        lv.setAdapter(adapter);
    }

    @Override
    protected void initView() {
        lv = bindView(R.id.lv_class_raiders);
    }

    @Override
    protected int getLayout() {

        return R.layout.class_fragment_raiders_item;
    }
}
