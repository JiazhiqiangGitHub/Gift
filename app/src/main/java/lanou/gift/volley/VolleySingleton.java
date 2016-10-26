package lanou.gift.volley;

import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

import lanou.gift.R;

/**
 * Created by dllo on 16/10/24.
 */
public class VolleySingleton {
    //单例 A
private static VolleySingleton volleySingleton;
   //B
    private RequestQueue mRequestQueue;

private ImageLoader mImageLoader;
  //A
private VolleySingleton(){
   //B  -C创建一个APP
    mRequestQueue = Volley.newRequestQueue(MyApp.getContext());
    //初始化ImageLoader
    mImageLoader = new ImageLoader(mRequestQueue,new MemoryCache());


}
//A
public static VolleySingleton getInstance(){
    if (volleySingleton == null){
        synchronized (VolleySingleton.class){
            if (volleySingleton == null){
                volleySingleton = new VolleySingleton();
            }
        }
    }
    return volleySingleton;
}
    //请求图片  为了以后美工告诉你改不需要整个项目一个个改
   public void getImage(String url, ImageView imageView){
       mImageLoader.get(url,ImageLoader.getImageListener(
               imageView, R.mipmap.ic_launcher,R.mipmap.ic_launcher
       ));

   }

    //获得RequestQueue的方法
public RequestQueue getRequestQueue(){
    return  mRequestQueue;
}
    public  <T>void  addRequest(Request<T> request){
        mRequestQueue.add(request);
    }

}
