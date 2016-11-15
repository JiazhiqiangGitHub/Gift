package lanou.gift.sort;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import lanou.gift.R;
import lanou.gift.base.BaseFragment;
import lanou.gift.search.SearchActivity;
import lanou.gift.sorthead.one.OneFragment;
import lanou.gift.sorthead.raiders.RaidersFragment;

/**
 * Created by dllo on 16/10/21.
 */
public class ClassFragment extends BaseFragment {
    private ArrayList<Fragment> fragments;
    private ViewPager vp;
    private TabLayout tb;
    private Button btn;

    @Override
    protected void initDate() {
        fragments = new ArrayList<>();
        fragments.add(new OneFragment());
        fragments.add(new RaidersFragment());
        ClassAdapter adapter = new ClassAdapter(getChildFragmentManager());
        adapter.setFragments(fragments);
        vp.setAdapter(adapter);
        tb.setupWithViewPager(vp);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initView() {
        vp = bindView(R.id.vp_class);
        tb = bindView(R.id.tb_class_head);
        btn = bindView(R.id.btn_sort_search);
    }

    @Override
    protected int getLayout() {
        return R.layout.class_fragment;
    }
}
