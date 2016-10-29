package lanou.gift.sorthead.one;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import lanou.gift.R;
import lanou.gift.textbean.OneBean;
import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

/**
 * Created by dllo on 16/10/26.
 */
public class RightAdapter extends BaseAdapter implements StickyListHeadersAdapter{
    private Context context;
    OneBean head,body;


    public void setHead(OneBean head) {
        this.head = head;
    }

    public void setBody(OneBean body) {
        this.body = body;
    }

    public RightAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return head == null?0:head.getData().getCategories().size();
    }

    @Override
    public Object getItem(int i) {
        return body.getData().getCategories().get(i);
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

//        数组越界
//        Picasso.with(context).load(body.getData().getCategories().get(i).
//                getSubcategories().get(i).getIcon_url()).into(bodyViewHolder.ivbody);
//        bodyViewHolder.tvbody.setText(body.getData().getCategories().get(i).getSubcategories().
//                get(i).getName());


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
        headViewHolder.tvhead.setText(head.getData().getCategories().get(position).getName());
        return convertView;
    }

    public long getHeaderId(int position){
        return position;
    }

    private class BodyViewHolder {


        private TextView tvbody;
        private ImageView ivbody;

        public BodyViewHolder(View view) {

            tvbody = (TextView) view.findViewById(R.id.tv_body_one);
            ivbody = (ImageView) view.findViewById(R.id.iv_body_one);
        }
    }

    private class HeadViewHolder {

        private  TextView tvhead;

        public HeadViewHolder(View view1) {
            tvhead = (TextView) view1.findViewById(R.id.tv_head_one);

        }
    }
}
