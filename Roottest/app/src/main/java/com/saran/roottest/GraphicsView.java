package com.saran.roottest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Saran on 12/2/16.
 */
public class GraphicsView extends View{
    private static final String QUOTE = "This is a test. This is a demo";
    private Paint cPaint;

    public GraphicsView(Context context) {
        super(context);
        init();
    }


    public GraphicsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        int color = Color.BLUE;

//        path = new Path();
//        path.addCircle(150,150,100, Path.Direction.CW);



        cPaint = new Paint();
        cPaint.setAntiAlias(true);
        cPaint.setStyle(Paint.Style.FILL);
        cPaint.setStrokeWidth(3);
        cPaint.setColor(color);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(300,300,100,cPaint);
       //canvas.drawPath(path,cPaint);
    }
}
