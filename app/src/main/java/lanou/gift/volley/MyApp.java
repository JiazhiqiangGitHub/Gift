package lanou.gift.volley;

import android.app.Application;
import android.content.Context;

/**
 * Created by dllo on 16/10/24.
 */

public class MyApp extends Application{
    //!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // !!!!!!!!!!  在清单中注册  写name
    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    //跟界面无关的东西才能用  在布局的时候不能用

    //为了VolleySingleton中Context的问题
    private static Context sContext;
    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
    }
    public static Context getContext(){
        return  sContext;
    }
}
