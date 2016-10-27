package lanou.gift.guide;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by dllo on 16/10/21.
 */
public class GuideAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;

    public GuideAdapter(FragmentManager fm,List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
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
        return GuideFragment.tabTitle[position];
    }
}
