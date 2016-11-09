package lanou.gift.hot.second;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import lanou.gift.R;
import lanou.gift.textbean.HotSecondOneBean;
import lanou.gift.volley.CommonViewHolder;

/**
 * Created by dllo on 16/11/7.
 */
public class HotThirdOneAdapter extends RecyclerView.Adapter<CommonViewHolder> {
    private static HotSecondOneBean bean;


    public static void setBean(HotSecondOneBean bean) {
        HotThirdOneAdapter.bean = bean;
    }

    @Override
    public CommonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return CommonViewHolder.getViewHolder(parent, R.layout.item_rv_hot_second_one);
    }

    @Override
    public void onBindViewHolder(CommonViewHolder holder, int position) {
        holder.setText(R.id.tv_hot_rv_second_name,bean.getData().getRecommend_items().get(position).getName()).
                setText(R.id.tv_hot_rv_second_price,bean.getData().getRecommend_items().get(position).getPrice()).
                setImage(R.id.iv_hot_rv_second_picture,bean.getData().getRecommend_items().get(position).getCover_image_url());


    }


    @Override
    public int getItemCount() {
        return bean.getData().getRecommend_items().size();
    }
}
