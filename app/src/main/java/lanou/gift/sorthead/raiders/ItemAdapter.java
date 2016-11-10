package lanou.gift.sorthead.raiders;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import lanou.gift.R;
import lanou.gift.textbean.RaidersBean;
import lanou.gift.volley.CommonViewHolder;

/**
 * Created by dllo on 16/11/10.
 */
public class ItemAdapter extends RecyclerView.Adapter<CommonViewHolder> {
    private static RaidersBean bean;

    public static void setBean(RaidersBean bean) {
        ItemAdapter.bean = bean;
    }

    @Override
    public CommonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return CommonViewHolder.getViewHolder(parent, R.layout.raiders_item_item);
    }

    @Override
    public void onBindViewHolder(CommonViewHolder holder, int position) {
        holder.setImage(R.id.iv_raiders_rc_picture, bean.getData().getChannel_groups().get(position).getChannels().
                get(position).getCover_image_url());
    }

    @Override
    public int getItemCount() {
        return bean.getData().getChannel_groups().size();
    }
}
