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
import lanou.gift.guideHead.accessory.AccessoryFragment;
import lanou.gift.guideHead.birthday.BirthdayFragment;
import lanou.gift.guideHead.choose.ChooseFragment;
import lanou.gift.guideHead.christmas.ChristmasFragment;
import lanou.gift.guideHead.girlFriend.GirlFriendFragment;
import lanou.gift.guideHead.grow.GrowFragment;
import lanou.gift.guideHead.matchClothes.MatchClothesFragment;
import lanou.gift.search.SearchActivity;

/**
 * Created by dllo on 16/10/21.
 */
public class GuideFragment extends BaseFragment implements View.OnClickListener {

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
        fragments.add(new ChristmasFragment());
        fragments.add(new MatchClothesFragment());
        fragments.add(new ChooseFragment());
        fragments.add(new BirthdayFragment());
        fragments.add(new GrowFragment());
        fragments.add(new GirlFriendFragment());
        fragments.add(new AccessoryFragment());
        //创建适配器.把ViewPager和适配器 以及TabLayout绑定
        GuideAdapter adapter = new GuideAdapter(getChildFragmentManager());
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
        intent = new Intent(getActivity(),SearchActivity.class);
        startActivity(intent);
    }
}
