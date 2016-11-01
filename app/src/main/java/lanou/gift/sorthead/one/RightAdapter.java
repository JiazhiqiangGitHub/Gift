package lanou.gift.sorthead.one;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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
    private RightItemAdapter adapter;

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
        //给RecyclerView创建适配器 然后把数据传给body
        adapter = new RightItemAdapter(context,i);
        bodyViewHolder.recycleView.setAdapter(adapter);
        adapter.setBean(body);
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


        private RecyclerView recycleView;

        public BodyViewHolder(View view) {

            //右面布局是个RecyclerView 给他设置网格布局 以及竖向排列
            recycleView = (RecyclerView) view.findViewById(R.id.rc_sort_one_body);
            RecyclerView.LayoutManager manager = new GridLayoutManager(context,3, LinearLayoutManager.VERTICAL,false);
            recycleView.setLayoutManager(manager);
        }
    }

    private class HeadViewHolder {

        private  TextView tvhead;

        public HeadViewHolder(View view1) {
            tvhead = (TextView) view1.findViewById(R.id.tv_head_one);

        }
    }
}
