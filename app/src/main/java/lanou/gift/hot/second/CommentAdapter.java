package lanou.gift.hot.second;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import lanou.gift.R;
import lanou.gift.textbean.CommentBean;
import lanou.gift.volley.CommonViewHolder;

/**
 * Created by dllo on 16/11/9.
 */
public class CommentAdapter extends BaseAdapter{
    private CommentBean bean;

    public void setBean(CommentBean bean) {
        this.bean = bean;
    }

    @Override
    public int getCount() {
        return bean.getData().getComments().size();
    }

    @Override
    public Object getItem(int i) {
        return bean.getData().getComments().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        CommonViewHolder holder = CommonViewHolder.getViewHolder(view,viewGroup,R.layout.item_comment);
        holder.setText(R.id.tv_comment_name,bean.getData().getComments().get(i).getUser().getNickname()).
                setText(R.id.tv_comment_time, String.valueOf(bean.getData().getComments().get(i).getCreated_at())).
                setText(R.id.tv_comment_body,bean.getData().getComments().get(i).getContent()).
                setImage(R.id.iv_comment_picture,bean.getData().getComments().get(i).getUser().getAvatar_url());
        return holder.getItemView();
    }
}
