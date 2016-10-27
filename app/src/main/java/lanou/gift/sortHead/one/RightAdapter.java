package lanou.gift.sorthead.one;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import lanou.gift.R;
import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

/**
 * Created by dllo on 16/10/26.
 */
public class RightAdapter extends BaseAdapter implements StickyListHeadersAdapter{
    private Context context;
    private ArrayList<String> headlist,bodylist;

    public RightAdapter(Context context) {
        this.context = context;
    }

    public void setHeadlist(ArrayList<String> headlist) {
        this.headlist = headlist;
    }

    public void setBodylist(ArrayList<String> bodylist) {
        this.bodylist = bodylist;
    }

    @Override
    public int getCount() {
        return headlist == null?0:headlist.size();
    }

    @Override
    public Object getItem(int i) {
        return bodylist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        BodyViewHolder bodyViewHolder = null;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.one_item_body,null);
            bodyViewHolder = new BodyViewHolder(view);
            view.setTag(bodyViewHolder);
        }else{
            bodyViewHolder = (BodyViewHolder) view.getTag();
        }
        bodyViewHolder.tvbody.setText(bodylist.get(i));


        return view;
    }
    @Override
    public View getHeaderView(int position, View convertView, ViewGroup parent) {
        HeadViewHolder headViewHolder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.one_item_head,null);
            headViewHolder = new HeadViewHolder(convertView);
            convertView.setTag(headViewHolder);
        }else{
            headViewHolder = (HeadViewHolder) convertView.getTag();
        }
        headViewHolder.tvhead.setText(bodylist.get(position));
        return convertView;
    }

    public long getHeaderId(int position){
        return position;
    }

    private class BodyViewHolder {


        private final TextView tvbody;

        public BodyViewHolder(View view) {

            tvbody = (TextView) view.findViewById(R.id.tv_body_one);
        }
    }

    private class HeadViewHolder {

        private final TextView tvhead;

        public HeadViewHolder(View view1) {
            tvhead = (TextView) view1.findViewById(R.id.tv_head_one);

        }
    }
}
