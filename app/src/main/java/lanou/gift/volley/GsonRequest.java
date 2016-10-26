package lanou.gift.volley;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;

/**
 * Created by dllo on 16/10/24.
 */
//重写Request 简化  自定义的请求 直接返回数据类
public class GsonRequest<T> extends Request<T> {
    private final Response.Listener<T> mListener;
    private Gson mGson;
    private Class<T> mTClass;

    public GsonRequest(int method, Class<T> tClass,//在2号位再写一个参数 用于Gson解析,数据类的类型
                                        // 因为数据类会变 系统不知道要传进来
                       String url,Response.Listener<T> mListener,//复制粘贴到下面参数的3号位
                       Response.ErrorListener listener) {
        super(method, url, listener);
        //对成功的监听进行赋值
        this.mListener = mListener;
        mGson = new Gson();
        this.mTClass = tClass;
    }
    //复制上面代码 删除第一个参数 和里面内容
    public GsonRequest(Class<T> tClass,
                       String url,Response.Listener<T> mListener,
                       Response.ErrorListener listener) {
        this(Method.GET,tClass,url,mListener,listener);
    }


    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        String parsed;//请求成功的字符串
        try {
            parsed = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
        } catch (UnsupportedEncodingException e) {
            parsed = new String(response.data);
        }
        //自定义的解析
        T t = mGson.fromJson(parsed,mTClass);
        return Response.success(t,HttpHeaderParser.parseCacheHeaders(response));
    }



    @Override
    protected void deliverResponse(T response) {
        mListener.onResponse(response);
    }
}
