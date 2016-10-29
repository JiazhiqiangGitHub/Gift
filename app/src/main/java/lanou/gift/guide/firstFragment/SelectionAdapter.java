package lanou.gift.guide.firstFragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import lanou.gift.R;
import lanou.gift.textbean.SelectionBean;

/**
 * Created by dllo on 16/10/27.
 */
public class SelectionAdapter extends BaseAdapter {

    private Context mContext;
    SelectionBean selectionBean;

    public SelectionAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setSelectionBean(SelectionBean selectionBean) {
        this.selectionBean = selectionBean;
    }

    @Override
    public int getCount() {
        return selectionBean.getData().getItems().size();
    }

    @Override
    public Object getItem(int i) {
        return selectionBean.getData().getItems().get(i);
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
        Picasso.with(mContext).load(selectionBean.getData().getItems().get(i).getCover_image_url()).into(viewHolder.picture);
        viewHolder.name.setText(selectionBean.getData().getItems().get(i).getTitle());
        viewHolder.body.setText(selectionBean.getData().getItems().get(i).getIntroduction());
//        viewHolder.title.setText(selectionBean.getData().getItems().get(i).getColumn().getClass());
        viewHolder.people.setText(String.valueOf(selectionBean.getData().getItems().get(i).getLikes_count()));

        return convertView;
    }

    private class ViewHolder {

        private final TextView name;
        private final ImageView picture;
        private final TextView body;
        private final TextView title;
        private final TextView people;

        public ViewHolder(View convertView) {
            name = (TextView) convertView.findViewById(R.id.tv_guide_fragment_item_name);
            picture = (ImageView) convertView.findViewById(R.id.iv_guide_fragment_item_picture);
            body = (TextView) convertView.findViewById(R.id.tv_guide_fragment_item_body);
            title = (TextView) convertView.findViewById(R.id.tv_guide_fragment_item_class);
            people = (TextView) convertView.findViewById(R.id.tv_guide_fragment_item_people);
        }
    }

}