package lanou.gift.sorthead.secondraiders;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import lanou.gift.R;
import lanou.gift.textbean.RaidersSecondBean;
import lanou.gift.base.CommonViewHolder;

/**
 * Created by dllo on 16/11/5.
 */

//listView的Adapter
public class RaidersActivityAdapter extends BaseAdapter {
    private RaidersSecondBean bean;
    private Context context;


    public RaidersActivityAdapter(Context context) {
        this.context = context;
    }

    public void setBean(RaidersSecondBean bean) {
        this.bean = bean;
    }

    @Override
    public int getCount() {
        return bean.getData().getItems().size();
    }

    @Override
    public Object getItem(int i) {
        return bean.getData().getItems().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        CommonViewHolder viewHolder = CommonViewHolder.getViewHolder(view,viewGroup,R.layout.guide_lv_ietm);
        viewHolder.setText
                (R.id.tv_guide_fragment_item_name, bean.getData().getItems().get(i).getTitle()).
                setText
                        (R.id.tv_guide_fragment_item_body, bean.getData().getItems().get(i).getIntroduction()).
                setText
                        (R.id.tv_guide_fragment_item_people, String.valueOf(bean.getData().getItems().get(i).getLikes_count())).
                setImage
                        (R.id.iv_guide_fragment_item_picture, bean.getData().getItems().get(i).getCover_image_url());
        return viewHolder.getItemView();
    }
}
