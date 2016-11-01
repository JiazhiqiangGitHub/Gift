package lanou.gift.sorthead.raiders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import lanou.gift.R;
import lanou.gift.textbean.RaidersHeadBean;

/**
 * Created by dllo on 16/11/1.
 */
public class RaidersHeadAdapter extends RecyclerView.Adapter<RaidersHeadAdapter.ViewHolder>{
    private Context context;
    private RaidersHeadBean bean;

    public RaidersHeadAdapter(Context context) {
        this.context = context;
    }

    public void setBean(RaidersHeadBean bean) {
        this.bean = bean;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.raiders_head_item,parent,false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Picasso.with(context).load(bean.getData().getColumns().get(position).getBanner_image_url()).into(holder.picture);
        holder.title.setText(bean.getData().getColumns().get(position).getTitle());
        holder.author.setText(bean.getData().getColumns().get(position).getAuthor());
    }

    @Override
    public int getItemCount() {
        return bean == null?0:bean.getData().getColumns().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView picture;
        private TextView title;
        private TextView author;

        public ViewHolder(View itemView) {
            super(itemView);
            picture = (ImageView) itemView.findViewById(R.id.iv_raiders_head);
            title = (TextView) itemView.findViewById(R.id.tv_raiders_head_title);
            author = (TextView) itemView.findViewById(R.id.tv_raiders_head_author);
        }
    }
}
