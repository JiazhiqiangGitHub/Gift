package lanou.gift.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import lanou.gift.R;
import lanou.gift.base.BaseActivity;
import lanou.gift.hot.second.commentFragment;
import lanou.gift.hot.second.detailsFragment;
import lanou.gift.hot.second.singleFragment;

/**
 * Created by dllo on 16/11/3.
 */
public class HotActivity extends BaseActivity{
    private TabLayout tb;
    private ArrayList<Fragment> fragments;
    private ViewPager vp;
    private Button btn;
    @Override
    protected int getLayout() {
        return R.layout.acticity_hot;
    }

    @Override
    protected void initViews() {
        btn = bindView(R.id.btn_hot_activity);
        tb = bindView(R.id.tb_activity_hot);
        vp = bindView(R.id.vp_activity_hot);
    }

    @Override
    protected void initData() {

        fragments = new ArrayList<>();
        fragments.add(new singleFragment());
        fragments.add(new detailsFragment());
        fragments.add(new commentFragment());


        HotSecondAdapter adapter = new HotSecondAdapter(getSupportFragmentManager());
        adapter.setFragments(fragments);
        vp.setAdapter(adapter);
        tb.setupWithViewPager(vp);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });





    }
}
