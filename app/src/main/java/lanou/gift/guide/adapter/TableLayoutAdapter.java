package lanou.gift.guide.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import lanou.gift.R;
import lanou.gift.textbean.GuideGirlFriendBean;

/**
 * Created by dllo on 16/10/25.
 */
public class TableLayoutAdapter extends BaseAdapter{
    //listView的适配器
    private Context mContext;
    GuideGirlFriendBean beanGirl;
    public void setBeanGirl(GuideGirlFriendBean beanGirl) {
        this.beanGirl = beanGirl;
    }


    public TableLayoutAdapter(Context mContext) {
        this.mContext = mContext;
    }


    @Override
    public int getCount() {
        return beanGirl.getData().getItems().size();
    }

    @Override
    public Object getItem(int i) {
        return beanGirl.getData().getItems().get(i);
    }


    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.guide_lv_ietm,null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Picasso.with(mContext).load(beanGirl.getData().getItems().get(i).getCover_image_url()).into(viewHolder.picture);
        viewHolder.name.setText(beanGirl.getData().getItems().get(i).getTitle());
        viewHolder.body.setText(beanGirl.getData().getItems().get(i).getIntroduction());
        viewHolder.title.setText(beanGirl.getData().getItems().get(i).getColumn().getTitle());
        viewHolder.people.setText(String.valueOf(beanGirl.getData().getItems().get(i).getLikes_count()));

        return convertView;
    }

    private class ViewHolder {

        private TextView name;
        private ImageView picture;
        private TextView body;
        private TextView title;
        private TextView people;

        public ViewHolder(View convertView) {
            name = (TextView) convertView.findViewById(R.id.tv_guide_fragment_item_name);
            picture = (ImageView) convertView.findViewById(R.id.iv_guide_fragment_item_picture);
            body = (TextView) convertView.findViewById(R.id.tv_guide_fragment_item_body);
            title = (TextView) convertView.findViewById(R.id.tv_guide_fragment_item_class);
            people = (TextView) convertView.findViewById(R.id.tv_guide_fragment_item_people);
       }
    }
}
