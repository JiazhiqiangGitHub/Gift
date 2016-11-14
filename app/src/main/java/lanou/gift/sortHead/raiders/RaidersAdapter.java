package lanou.gift.sorthead.raiders;

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
import lanou.gift.textbean.RaidersBean;

/**
 * Created by dllo on 16/10/27.
 */
public class RaidersAdapter extends BaseAdapter {
    private Context context;
    private RaidersBean bean;
    private RaidersItemAdapter adapter;

    public RaidersAdapter(Context context) {
        this.context = context;
    }

    public void setBean(RaidersBean bean) {
        this.bean = bean;
    }

    @Override
    public int getCount() {
        return bean == null ? 0 : bean.getData().getChannel_groups().size();
    }

    @Override
    public Object getItem(int i) {
        return bean.getData().getChannel_groups().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {


        ViewHolder viewHolder = null;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.raiders_item, viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }


        //recyclerView创建适配器
        viewHolder.title.setText(bean.getData().getChannel_groups().get(i).getName());
        adapter = new RaidersItemAdapter(context, i);
        viewHolder.rc.setAdapter(adapter);
        adapter.setBean(bean);

        return view;

    }
    private class ViewHolder {
        private RecyclerView rc;
        private TextView title;
        public ViewHolder(View view) {

            title = (TextView) view.findViewById(R.id.tv_raiders_title);
            rc = (RecyclerView) view.findViewById(R.id.rc_raiders);

            //攻略listView的item 是recyclerView的网格布局
            //布局竖向拉 2行
            RecyclerView.LayoutManager manager = new GridLayoutManager(context, 2, LinearLayoutManager.VERTICAL, false);
            rc.setLayoutManager(manager);
        }
    }
}
