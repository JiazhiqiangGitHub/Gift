package lanou.gift.guide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import lanou.gift.R;

/**
 * Created by dllo on 16/10/25.
 */
public class TableLayoutAdapter extends BaseAdapter{
    private ArrayList<GuideBean> bean;
    private Context mContext;

    public TableLayoutAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setBean(ArrayList<GuideBean> bean) {
        this.bean = bean;
    }

    @Override
    public int getCount() {
        return bean == null ? 0 : bean.size();
    }

    @Override
    public Object getItem(int i) {
        return bean.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.guide_lv_ietm,null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.body.setText(bean.get(i).getBody());

        return convertView;
    }

    private class ViewHolder {

        private final TextView body;

        public ViewHolder(View convertView) {
            body = (TextView) convertView.findViewById(R.id.tv_guide_fragment_item);
        }
    }
}
