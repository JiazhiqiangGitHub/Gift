package lanou.gift.hot;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import lanou.gift.R;
import lanou.gift.textbean.TextHotBean;

/**
 * Created by dllo on 16/10/25.
 */
public class HotAdapter extends RecyclerView.Adapter<HotAdapter.ViewHolder> {
    TextHotBean bean;
    private Context mContext;

    public HotAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setBean(TextHotBean bean) {
        this.bean = bean;
    }

    @Override
    public HotAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.hot_item,parent,false);
        ViewHolder myViewHolder = new ViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(HotAdapter.ViewHolder holder, int position) {
        //一顿点找到解析出的相对的东西
        Picasso.with(mContext).load(bean.getData().getItems().get(position).getCover_image_url()).into(holder.picture);
        holder.name.setText(bean.getData().getItems().get(position).getShort_description());
        holder.price.setText(bean.getData().getItems().get(position).getPrice());
        holder.body.setText(bean.getData().getItems().get(position).getName());
        holder.love.setImageResource(R.mipmap.ic_action_compact_favourite_normal);
        holder.people.setText(String.valueOf(bean.getData().getItems().get(position).getFavorites_count()));
        Picasso.with(mContext).load(bean.getData().getCover_image()).into(holder.head);
    }

    @Override
    public int getItemCount() {
        return bean.getData().getItems().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private  TextView people;
        private  TextView name;
        private  TextView price;
        private  ImageView picture;
        private  ImageView love;
        private  TextView body;
        private  ImageView head;

        public ViewHolder(View itemView) {
            super(itemView);
            people = (TextView) itemView.findViewById(R.id.tv_hot_rv_people);
            name = (TextView) itemView.findViewById(R.id.tv_hot_rv_name);
            price = (TextView) itemView.findViewById(R.id.tv_hot_rv_price);
            picture = (ImageView) itemView.findViewById(R.id.iv_hot_rv_picture);
            love = (ImageView) itemView.findViewById(R.id.iv_hot_rv_love);
            body = (TextView) itemView.findViewById(R.id.tv_hot_rv_body);
            View v = LayoutInflater.from(mContext).inflate(R.layout.hot_fragment,null);
            head = (ImageView) v.findViewById(R.id.iv_hot_head);

        }
    }
}
