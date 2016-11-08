package lanou.gift.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;

import lanou.gift.R;
import lanou.gift.base.BaseActivity;
import lanou.gift.hot.second.commentFragment;
import lanou.gift.hot.second.detailsFragment;
import lanou.gift.hot.second.singleFragment;
import lanou.gift.textbean.TextHotBean;

/**
 * Created by dllo on 16/11/3.
 */
public class HotActivity extends BaseActivity{
    //// TODO: 16/11/5 完成三页数据
    private TabLayout tb;
    private ArrayList<Fragment> fragments;
    private ViewPager vp;
    @Override
    protected int getLayout() {
        return R.layout.acticity_hot;
    }

    @Override
    protected void initViews() {
        tb = bindView(R.id.tb_activity_hot);
        vp = bindView(R.id.vp_activity_hot);
    }

    @Override
    protected void initData() {
        fragments = new ArrayList<>();
        fragments.add(new singleFragment());
        fragments.add(new detailsFragment());
        fragments.add(new commentFragment());

        Intent intent = this.getIntent();
        TextHotBean.DataBean.ItemsBean itemsBean = (TextHotBean.DataBean.ItemsBean) intent.getSerializableExtra("single");
        HotSecondAdapter adapter = new HotSecondAdapter(getSupportFragmentManager());
        adapter.setFragments(fragments);
        vp.setAdapter(adapter);
        tb.setupWithViewPager(vp);







    }
}
