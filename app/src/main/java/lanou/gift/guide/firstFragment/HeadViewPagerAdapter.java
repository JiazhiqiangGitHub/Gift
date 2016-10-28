package lanou.gift.guide.firstFragment;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by dllo on 16/10/28.
 */
public class HeadViewPagerAdapter extends PagerAdapter{


    private String[] urls;


    //把轮播图设置的数量无限
    @Override
    public int getCount() {
        return urls == null?0:Integer.MAX_VALUE;
    }
    //获得图片的数量
    public int getImgCount(){
        return urls.length;
    }

    //放url的方法
    public void setUrl(String[] urls){
        this.urls = urls;
        notifyDataSetChanged();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(container.getContext());
        //.fit让图片适应imagive的大小
        Picasso.with(container.getContext()).load(urls[position % urls.length]).fit().into(imageView);
        container.addView(imageView, ViewPager.LayoutParams.MATCH_PARENT,ViewPager.LayoutParams.MATCH_PARENT);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //滑动超过会销毁这一页
        if (container.getChildAt(position) == object){
            container.removeViewAt(position);
        }
    }
}
