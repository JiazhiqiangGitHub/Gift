package lanou.gift.sort;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;

import lanou.gift.R;
import lanou.gift.base.BaseFragment;
import lanou.gift.sortHead.one.OneFragment;
import lanou.gift.sortHead.raiders.RaidersFragment;

/**
 * Created by dllo on 16/10/21.
 */
public class ClassFragment extends BaseFragment {
    private ArrayList<Fragment> fragments;
    private ViewPager vp;
    private TabLayout tb;
    @Override
    protected void initDate() {
        fragments = new ArrayList<>();
        fragments.add(new OneFragment());
        fragments.add(new RaidersFragment());
        ClassAdapter adapter = new ClassAdapter(getChildFragmentManager());
        adapter.setFragments(fragments);
        vp.setAdapter(adapter);
        tb.setupWithViewPager(vp);
    }

    @Override
    protected void initView() {
        vp = bindView(R.id.vp_class);
        tb = bindView(R.id.tb_class_head);
    }

    @Override
    protected int getLayout() {
        return R.layout.class_fragment;
    }
}
