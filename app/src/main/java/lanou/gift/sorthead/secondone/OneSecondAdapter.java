package lanou.gift.sorthead.secondone;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import lanou.gift.R;
import lanou.gift.textbean.SingleActivityBean;
import lanou.gift.base.CommonViewHolder;

/**
 * Created by dllo on 16/11/8.
 */
public class OneSecondAdapter extends RecyclerView.Adapter<CommonViewHolder>{
    private SingleActivityBean bean;
    private Context context;

    public OneSecondAdapter(Context context) {
        this.context = context;
    }

    public void setBean(SingleActivityBean bean) {
        this.bean = bean;
        notifyDataSetChanged();
    }

    @Override
    public CommonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return CommonViewHolder.getViewHolder(parent, R.layout.one_activity_item);
    }

    @Override
    public void onBindViewHolder(CommonViewHolder holder, int position) {
        holder.setText(R.id.price_one,bean.getData().getItems().get(position).getPrice()).setText(
                R.id.text_one,bean.getData().getItems().get(position).getName()).setImage(
                R.id.picture_one,bean.getData().getItems().get(position).getCover_image_url()
        );
    }

    @Override
    public int getItemCount() {
        return bean.getData().getItems().size();
    }
}
