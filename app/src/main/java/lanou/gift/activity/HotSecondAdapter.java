package lanou.gift.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import lanou.gift.textbean.TextHotBean;

/**
 * Created by dllo on 16/11/5.
 */
public class HotSecondAdapter extends FragmentPagerAdapter{
    ArrayList<Fragment> fragments;
    private  TextHotBean.DataBean.ItemsBean itemsBean;
    String [] strings = {"单品","详情","评论"};

    private static int position;

    public HotSecondAdapter(FragmentManager supportFragmentManager) {
        super(supportFragmentManager);
    }

    public static int getPosition() {
        return position;
    }

    public static void setPosition(int position) {
        HotSecondAdapter.position = position;
    }


    public void setFragments(ArrayList<Fragment> fragments) {
        this.fragments = fragments;
    }

    public HotSecondAdapter(FragmentManager fm, TextHotBean.DataBean.ItemsBean itemsBean) {
        super(fm);
        this.itemsBean= itemsBean;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments == null?0:fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return strings[position];
    }
}
