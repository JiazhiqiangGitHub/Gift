package lanou.gift.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import lanou.gift.R;

/**
 * Created by dllo on 16/11/12.
 */
public class ListViewSearchAdapter extends BaseAdapter{
    private Context context;
    private ArrayList<String> arrayList;

    public ListViewSearchAdapter(Context context) {
        this.context = context;
    }

    public void setArrayList(ArrayList<String> arrayList) {
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
            view = LayoutInflater.from(context).inflate(R.layout.search_edit_text,viewGroup,false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.tv.setText(arrayList.get(i));

        return view;
    }

    private class ViewHolder {

        private TextView tv;

        public ViewHolder(View view) {

            tv = (TextView) view.findViewById(R.id.tv_edit_text_search);
        }
    }
}
