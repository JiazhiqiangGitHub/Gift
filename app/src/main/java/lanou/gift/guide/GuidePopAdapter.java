package lanou.gift.guide;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import lanou.gift.R;
import lanou.gift.textbean.TabLayoutBean;

/**
 * Created by dllo on 16/11/4.
 */
public class GuidePopAdapter extends BaseAdapter{
    private static  TabLayoutBean bean;
    private Context mContext;
 private int PositionA;

    //set一个方法 在fragment中拿到位置
    public void setPositionA(int positionA) {
        PositionA = positionA;
    }



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
        ViewHolder viewHolder = null;
        if (view == null){
            view = LayoutInflater.from(mContext).inflate(R.layout.pop_item,viewGroup,false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.tv.setText(bean.getData().getChannels().get(i).getName());
        if (PositionA == i){
            viewHolder.tv.setTextColor(Color.RED);
        }else{
            viewHolder.tv.setTextColor(Color.BLACK);
        }

        return view;
    }

    private class ViewHolder {

        private TextView tv;

        public ViewHolder(View view) {

            tv = (TextView) view.findViewById(R.id.tv_guide_pop);

        }
    }
}







