package lanou.gift.guide;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import lanou.gift.R;
import lanou.gift.guideHead.accessoryFragment;
import lanou.gift.guideHead.birthdayFragment;
import lanou.gift.guideHead.chooseFragment;
import lanou.gift.guideHead.christmasFragment;
import lanou.gift.guideHead.girlFriendFragment;
import lanou.gift.guideHead.growFragment;
import lanou.gift.guideHead.matchClothesFragment;

/**
 * Created by dllo on 16/10/21.
 */
public class guideFragment extends Fragment {

    private ArrayList<Fragment> fragments;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.guide_fragment, null);
        //布局中为首页创建TabLayout和ViewPager
        TabLayout tbHead = (TabLayout) v.findViewById(R.id.tb_guide_head);
        ViewPager vp = (ViewPager) v.findViewById(R.id.vp_guide);
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

        return v;
    }












}
