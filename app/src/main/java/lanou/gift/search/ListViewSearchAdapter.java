package lanou.gift.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import lanou.gift.R;
import lanou.gift.volley.DBTool;

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
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.search_edit_text,viewGroup,false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.tv.setText(arrayList.get(i));
        viewHolder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            //删除
            public void onClick(View view) {
                String date = arrayList.get(i);
                DBTool.getInstance().deleteSpecifyData(date);
                arrayList.remove(i);
                notifyDataSetChanged();
            }
        });

        return view;
    }

    private class ViewHolder {

        private TextView tv;
        private Button btn;

        public ViewHolder(View view) {

            tv = (TextView) view.findViewById(R.id.tv_edit_text_search);
            btn = (Button) view.findViewById(R.id.btn_search_del);
        }
    }
}
