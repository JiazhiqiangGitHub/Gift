package lanou.gift.guide.otherFragment;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import lanou.gift.R;
import lanou.gift.activity.GuideActivity;
import lanou.gift.textbean.GirlFriend;
import lanou.gift.volley.CommonViewHolder;

/**
 * Created by dllo on 16/10/25.
 */
public class TableLayoutAdapter extends BaseAdapter{
    //listView的适配器
    private Context mContext;

    private GirlFriend bean;



    public void setBean(GirlFriend bean) {
        this.bean = bean;

    }

    public TableLayoutAdapter(Context mContext) {
        this.mContext = mContext;
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
    public View getView(final int i, View convertView, ViewGroup viewGroup) {

        CommonViewHolder viewHolder = CommonViewHolder.getViewHolder(convertView, viewGroup,
                R.layout.guide_lv_ietm);
        viewHolder.setText
                (R.id.tv_guide_fragment_item_name, bean.getData().getItems().get(i).getTitle()).
                setText
                        (R.id.tv_guide_fragment_item_body, bean.getData().getItems().get(i).getIntroduction()).
                setText
                        (R.id.tv_guide_fragment_item_people, String.valueOf(bean.getData().getItems().get(i).getLikes_count())).
                setImage
                        (R.id.iv_guide_fragment_item_picture, bean.getData().getItems().get(i).getCover_image_url()).
//                setText(R.id.tv_guide_fragment_item_class,bean.getData().getItems().get(i).getColumn().getTitle()).
                setItemClick
                        (new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(mContext,GuideActivity.class);
                                intent.putExtra("second",bean.getData().getItems().get(i).getUrl());
                                mContext.startActivity(intent);
                            }
                        });

        return viewHolder.getItemView();


    }


}