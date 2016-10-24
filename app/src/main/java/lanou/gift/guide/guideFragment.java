package lanou.gift.guide;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

import lanou.gift.R;
import lanou.gift.base.BaseFragment;
import lanou.gift.guideHead.accessory.accessoryFragment;
import lanou.gift.guideHead.birthday.birthdayFragment;
import lanou.gift.guideHead.choose.chooseFragment;
import lanou.gift.guideHead.christmas.christmasFragment;
import lanou.gift.guideHead.girlFriend.girlFriendFragment;
import lanou.gift.guideHead.grow.growFragment;
import lanou.gift.guideHead.matchClothes.matchClothesFragment;
import lanou.gift.search.searchActivity;

/**
 * Created by dllo on 16/10/21.
 */
public class guideFragment extends BaseFragment implements View.OnClickListener {

    private ArrayList<Fragment> fragments;
    private TabLayout tbHead;
    private ViewPager vp;
    private ImageButton btnSearch;
    Intent intent = null;
    @Override
    protected void initDate() {
//        //添加点击事件
        btnSearch.setOnClickListener(this);
        //创建ViewPager需要滑动的fragment
        fragments = new ArrayList<>();
        fragments.add(new christmasFragment());
        fragments.add(new matchClothesFragment());
        fragments.add(new chooseFragment());
        fragments.add(new birthdayFragment());
        fragments.add(new growFragment());
        fragments.add(new girlFriendFragment());
        fragments.add(new accessoryFragment());
        //创建适配器.把ViewPager和适配器 以及TabLayout绑定
        guideAdapter adapter = new guideAdapter(getFragmentManager());
        adapter.setFragments(fragments);
        vp.setAdapter(adapter);
        tbHead.setupWithViewPager(vp);

    }
    @Override
    protected void initView() {
        //布局中为首页创建TabLayout和ViewPager
        tbHead = bindView(R.id.tb_guide_head);
        vp = bindView(R.id.vp_guide);
        btnSearch = bindView(R.id.btn_guide_title_search);
    }

    @Override
    protected int getLayout() {
        //布局
        return R.layout.guide_fragment;
    }


    @Override
    public void onClick(View view) {
        intent = new Intent(getActivity(),searchActivity.class);
        startActivity(intent);
    }
}
