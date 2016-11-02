package lanou.gift.guide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import lanou.gift.guide.firstFragment.HeadFragment;
import lanou.gift.textbean.TabLayoutBean;

/**
 * Created by dllo on 16/10/21.
 */
public class GuideAdapter extends FragmentPagerAdapter {
    private static  TabLayoutBean bean;


    public GuideAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setBean(TabLayoutBean bean) {
        this.bean = bean;
    }

    @Override
    public Fragment getItem(int position) {
        //根据位置 返回不同的Fragment
        if (position == 0){
            return HeadFragment.newInstance(position);
        }else{
            Bundle args = new Bundle();
            args.putInt("position",position);
            TabLayoutFragment fragment = new TabLayoutFragment();
            fragment.setArguments(args);
            return  fragment;
        }
    }
    @Override
    public int getCount() {
        return bean == null?0:bean.getData().getCandidates().size();
    }
    //调用标题
    public CharSequence getPageTitle(int position){
        return bean.getData().getChannels().get(position).getName();
    }
    public static int getId(int position){
        int id = bean.getData().getChannels().get(position).getId();
        return id;
    }


}
