package lanou.gift.guide.firstFragment;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import lanou.gift.R;
import lanou.gift.activity.GuideActivity;
import lanou.gift.textbean.SelectionBean;
import lanou.gift.volley.CommonViewHolder;

/**
 * Created by dllo on 16/10/27.
 */
public class SelectionAdapter extends BaseAdapter {

    private Context mContext;
    SelectionBean selectionBean;

    public SelectionAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setSelectionBean(SelectionBean selectionBean) {
        this.selectionBean = selectionBean;
    }

    @Override
    public int getCount() {
        return selectionBean.getData().getItems().size();
    }

    @Override
    public Object getItem(int i) {
        return selectionBean.getData().getItems().get(i);
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
                (R.id.tv_guide_fragment_item_name, selectionBean.getData().getItems().get(i).getTitle()).
                setText
                        (R.id.tv_guide_fragment_item_body, selectionBean.getData().getItems().get(i).getIntroduction()).
                setText
                        (R.id.tv_guide_fragment_item_people, String.valueOf(selectionBean.getData().getItems().get(i).getLikes_count())).
                setImage
                        (R.id.iv_guide_fragment_item_picture, selectionBean.getData().getItems().get(i).getCover_image_url()).
                setItemClick
                        (new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                Intent intent = new Intent(mContext, GuideActivity.class);
                                intent.putExtra("second",selectionBean.getData().getItems().get(i).getUrl());
                                mContext.startActivity(intent);
                            }
                        });

        return viewHolder.getItemView();

    }
}

