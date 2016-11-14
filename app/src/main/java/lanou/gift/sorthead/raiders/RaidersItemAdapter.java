package lanou.gift.sorthead.raiders;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import lanou.gift.R;
import lanou.gift.sorthead.secondraiders.RaidersActivity;
import lanou.gift.textbean.RaidersBean;
import lanou.gift.volley.CommonViewHolder;

/**
 * Created by dllo on 16/11/1.
 */
public class RaidersItemAdapter extends RecyclerView.Adapter<CommonViewHolder> {
    private Context context;
    private int i;
    private RaidersBean bean;

    //一个item内还有多个时再找一层
    public RaidersItemAdapter(Context context, int i) {
        this.context = context;
        this.i = i;
    }

    public void setBean(RaidersBean bean) {
        this.bean = bean;
    }
    //创建布局
    @Override
    public CommonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return CommonViewHolder.getViewHolder(parent,R.layout.raiders_item_item);
    }

    @Override
    public void onBindViewHolder(CommonViewHolder holder, final int position) {
        holder.setImage(R.id.iv_raiders_rc_picture,bean.getData().getChannel_groups().get(i).getChannels().
                get(position).getCover_image_url())
                .setItemClick(new View.OnClickListener() {



            @Override
            //传值 传ID
            public void onClick(View view) {
                int id = bean.getData().getChannel_groups().get(position).getId();
                String strId = Integer.toString(id);
                String title = bean.getData().getChannel_groups().get(position).getName();
                Intent intent = new Intent(context,RaidersActivity.class);
                intent.putExtra("id",strId);
                intent.putExtra("name",title);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return bean.getData().getChannel_groups().get(i).getChannels().size();
    }

}
