package lanou.gift.sorthead.raiders;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import lanou.gift.R;
import lanou.gift.sorthead.secondraiders.RaidersHeadActivity;
import lanou.gift.textbean.RaidersHeadBean;
import lanou.gift.volley.CommonViewHolder;

/**
 * Created by dllo on 16/11/1.
 */
public class RaidersHeadAdapter extends RecyclerView.Adapter<CommonViewHolder> {
    private Context context;
    private RaidersHeadBean bean;

    public RaidersHeadAdapter(Context context) {
        this.context = context;
    }

    public void setBean(RaidersHeadBean bean) {
        this.bean = bean;
        notifyDataSetChanged();
    }

    @Override
    public CommonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                return CommonViewHolder.getViewHolder(parent, R.layout.raiders_head_item);


    }

    @Override
    public void onBindViewHolder(CommonViewHolder holder, final int position) {
        holder.setText(R.id.tv_raiders_head_title,bean.getData().getColumns().get(position).getTitle()).
                setText(R.id.tv_raiders_head_author,bean.getData().getColumns().get(position).getAuthor()).setImage(
                R.id.iv_raiders_head,bean.getData().getColumns().get(position).getBanner_image_url()
        ).setItemClick(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,RaidersHeadActivity.class);
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return bean.getData().getColumns().size();
    }


}
