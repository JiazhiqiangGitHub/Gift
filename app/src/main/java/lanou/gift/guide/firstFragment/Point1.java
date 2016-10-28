package lanou.gift.guide.firstFragment;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by dllo on 16/10/28.
 */
public class Point1 extends View {
    //自定义view 选前三个
    //自定义宽高
    private int r = 10;
    //给钟状态 好变色 默认未选中的状态
    private boolean isSelected = false;
    public Point1(Context context) {
        super(context);
    }

    public Point1(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Point1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    //改变选中状态
    public void setSelected(boolean isSelected){
        this.isSelected = isSelected;
        invalidate();//重新绘制
    }
    //画布
    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);//抗锯齿
        //设置两种状态的颜色
        if (isSelected){
            paint.setColor(0xFFFF0000);
        }else{
            paint.setColor(0xFFEC8602);
        }
        //画圆
        canvas.drawCircle(getWidth()/2,getHeight()/2,r,paint);
    }
}
