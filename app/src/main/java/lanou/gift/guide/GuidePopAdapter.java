package lanou.gift.guide;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import lanou.gift.R;
import lanou.gift.textbean.TabLayoutBean;
import lanou.gift.volley.CommonViewHolder;

/**
 * Created by dllo on 16/11/4.
 */
public class GuidePopAdapter extends BaseAdapter{
    private static  TabLayoutBean bean;
    private Context mContext;

    public GuidePopAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setBean(TabLayoutBean bean) {
        this.bean = bean;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return bean.getData().getCandidates().size();
    }

    @Override
    public Object getItem(int i) {
        return bean.getData().getChannels().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        CommonViewHolder viewHolder =CommonViewHolder.getViewHolder(view,viewGroup,R.layout.pop_item);
        viewHolder.setText(R.id.tv_guide_pop,bean.getData().getChannels().get(i).getName());
        return viewHolder.getItemView();
    }
}







