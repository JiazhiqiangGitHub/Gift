package lanou.gift.sort;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/25.
 */
public class ClassAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> fragments;
    String [] string = {"单品","攻略"};
    public void setFragments(ArrayList<Fragment> fragments) {
        this.fragments = fragments;
    }

    public ClassAdapter(FragmentManager fm) {

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
    public CharSequence getPageTitle(int position){return string[position];}

}
