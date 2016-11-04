package lanou.gift.hot;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import lanou.gift.hot.together.HotFragment;
import lanou.gift.textbean.HotBean;

/**
 * Created by dllo on 16/11/4.
 */
public class HotFirstAdapter extends FragmentPagerAdapter{
    private static HotBean bean;

    public void setBean(HotBean bean) {
        this.bean = bean;
    }

    public HotFirstAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Bundle args = new Bundle();
        args.putInt("hotPosition",position);
        HotFragment fragment = new HotFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return bean == null?0:bean.getData().getRanks().size();
    }


    public CharSequence getPageTitle(int i){
        return bean.getData().getRanks().get(i).getName();
    }

    //必须是static
    public  static int getId(int i){
        int id = bean.getData().getRanks().get(i).getId();
        return id;
    }




}
