package lanou.gift.sorthead.one;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import lanou.gift.R;
import lanou.gift.textbean.OneBean;

/**
 * Created by dllo on 16/10/26.
 */
public class LeftAdapter extends BaseAdapter {
    //左面的listView
    private Context context;
    OneBean bean;
    private int ChangeColor = 0;
    //刷新颜色
    public void setChangeColor(int changeColor) {
        ChangeColor = changeColor;
        notifyDataSetChanged();

    }

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

        //判断是否在相同地方 设置字体颜色以及背景色
        if (ChangeColor == i){

            viewHolder.textView.setTextColor(Color.RED);
            viewHolder.ll.setBackgroundColor(Color.WHITE);
        }else{
            viewHolder.textView.setTextColor(Color.BLACK);
            viewHolder.ll.setBackgroundColor(Color.GRAY);

        }
        viewHolder.textView.setText(bean.getData().getCategories().get(i).getName());

        return view;
    }

    private class ViewHolder {

        private  TextView textView;
        private LinearLayout ll;

        public ViewHolder(View view) {
            textView = (TextView) view.findViewById(R.id.one_text_left);
            ll = (LinearLayout) view.findViewById(R.id.ll_left_one);
        }
    }
}
