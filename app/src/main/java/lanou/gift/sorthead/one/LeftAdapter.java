package lanou.gift.sorthead.one;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import lanou.gift.R;
import lanou.gift.textbean.OneBean;

/**
 * Created by dllo on 16/10/26.
 */
public class LeftAdapter extends BaseAdapter {

    private Context context;
    OneBean bean;

    public void setBean(OneBean bean) {
        this.bean = bean;
    }

    public LeftAdapter(Context context) {
        this.context = context;
    }


    @Override
    public int getCount() {
        return bean==null?0:bean.getData().getCategories().size();
    }

    @Override
    public Object getItem(int i) {
        return bean.getData().getCategories().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder = null;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.one_item_left,null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.textView.setText(bean.getData().getCategories().get(i).getName());


        return view;
    }

    private class ViewHolder {

        private  TextView textView;

        public ViewHolder(View view) {
            textView = (TextView) view.findViewById(R.id.one_text_left);
        }
    }
}
