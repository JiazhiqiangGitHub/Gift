package lanou.gift.guide;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/21.
 */
public class guideAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> fragments;
    //定义 数组 名称
    String [] strings = {"圣诞节","穿搭","海淘","生日","涨姿势","送闺蜜","饰品"};

    public void setFragments(ArrayList<Fragment> fragments) {
        this.fragments = fragments;
    }

    public guideAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments == null?0:fragments.size();
    }
    //调用标题
    public CharSequence getPageTitle(int position){
        return strings[position];
    }
}
