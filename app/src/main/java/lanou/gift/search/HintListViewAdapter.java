package lanou.gift.search;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import lanou.gift.R;
import lanou.gift.base.CommonViewHolder;
import lanou.gift.textbean.SearchBean;

/**
 * Created by dllo on 16/11/17.
 */
public class HintListViewAdapter extends BaseAdapter {
    private List<SearchBean.DataBean.WordsBean> arrayList;
    private Context context;

    public HintListViewAdapter(Context context) {
        this.context = context;
    }

//    public void setArrayList(ArrayList<SearchBean.DataBean.WordsBean> arrayList) {
//        this.arrayList = arrayList;
//    }


    public void setArrayList(List<SearchBean.DataBean.WordsBean> arrayList) {
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
        CommonViewHolder viewHolder = CommonViewHolder.getViewHolder(view,viewGroup, R.layout.hint_item);
        viewHolder.setText(R.id.tv_hint_search,arrayList.get(i).getWord());




        return viewHolder.getItemView();
    }

}
