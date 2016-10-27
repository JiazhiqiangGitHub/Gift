package lanou.gift.sorthead.raiders;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import lanou.gift.R;

/**
 * Created by dllo on 16/10/27.
 */
public class RaidersAdapter extends BaseAdapter{
    private Context context;
    private ArrayList<RaidersBean>arrayList;

    public RaidersAdapter(Context context) {
        this.context = context;
    }

    public void setArrayList(ArrayList<RaidersBean> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList == null?0:arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.raiders_item,null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }

            viewHolder.body.setText(arrayList.get(i).getBody());
            return view;
    }


    private class ViewHolder {


        private final TextView body;

        public ViewHolder(View view) {
            body = (TextView) view.findViewById(R.id.tv_class_raiders_item);
        }
    }
}
