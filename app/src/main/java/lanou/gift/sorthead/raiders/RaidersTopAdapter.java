package lanou.gift.sorthead.raiders;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import lanou.gift.R;
import lanou.gift.sorthead.secondraiders.RaidersHeadActivity;
import lanou.gift.textbean.RaidersHeadBean;

/**
 * Created by dllo on 16/11/14.
 */
public class RaidersTopAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private RaidersHeadBean bean;
    private Context context;


    public RaidersTopAdapter(Context context) {
        this.context = context;
    }

    public void setBean(RaidersHeadBean bean) {
        this.bean = bean;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        switch (viewType) {
            case 11:
                View endView = LayoutInflater.from(context).inflate(R.layout.item_end, parent, false);
                holder = new EndViewHolder(endView);
                break;
            default:
                View itemView = LayoutInflater.from(context).inflate(R.layout.raiders_head_item, parent, false);
                holder = new NetViewHolder(itemView);

        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        int viewType = getItemViewType(position);
        switch (viewType) {
            case 11:
                EndViewHolder endViewHolder = (EndViewHolder) holder;
                endViewHolder.tv.setText("点击加载全部");
                break;
            default:
                NetViewHolder netViewHolder = (NetViewHolder) holder;
                Picasso.with(context).load(bean.getData().getColumns().get(position).getBanner_image_url()).into(netViewHolder.picture);
                netViewHolder.title.setText(bean.getData().getColumns().get(position).getTitle());
                netViewHolder.author.setText(bean.getData().getColumns().get(position).getAuthor());
                //点击方法
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context, "我是详情" + position, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(context, RaidersHeadActivity.class);
                        context.startActivity(intent);
                    }
                });


        }
    }

    @Override
    public int getItemCount() {
        return 12;
    }

    private class EndViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv;

        public EndViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv_end);
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "你好 我是全部", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }


    private class NetViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final TextView author;
        private final ImageView picture;

        public NetViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tv_raiders_head_title);
            author = (TextView) itemView.findViewById(R.id.tv_raiders_head_author);
            picture = (ImageView) itemView.findViewById(R.id.iv_raiders_head);


        }
    }

    //获得position 不写的话上面的type没有用
    @Override
    public int getItemViewType(int position) {
        return position;
    }

}
