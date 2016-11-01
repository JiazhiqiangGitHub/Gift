package lanou.gift.sorthead.raiders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import lanou.gift.R;
import lanou.gift.textbean.RaidersBean;

/**
 * Created by dllo on 16/11/1.
 */
public class RaidersItemAdapter extends RecyclerView.Adapter<RaidersItemAdapter.ViewHolder> {
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
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.raiders_item_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Picasso.with(context).load(bean.getData().getChannel_groups().get(i).getChannels().
                get(position).getCover_image_url()).into(holder.picture);
    }

    @Override
    public int getItemCount() {
        return bean.getData().getChannel_groups().get(i).getChannels().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView picture;


        public ViewHolder(View itemView) {
            super(itemView);
            picture = (ImageView) itemView.findViewById(R.id.iv_raiders_rc_picture);
        }
    }
}
