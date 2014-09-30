package com.Saran.customviewapp;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;

public class CustomView extends View {
	
	private int colorOfCircle,colorOfLabel;
	private String labelOfCircle;
	private Paint circlePaint;

	public CustomView(Context context,AttributeSet attrs) {
		super(context,attrs);
		
		circlePaint = new Paint();
		
		TypedArray a = context.getTheme().obtainStyledAttributes(attrs,R.styleable.CustomView,0,0);
		
		try{
			colorOfCircle = a.getInt(R.styleable.CustomView_colorOfCircle,0);
			colorOfLabel = a.getInt(R.styleable.CustomView_colorOfLabel, 0);
			labelOfCircle = a.getString(R.styleable.CustomView_labelOfCircle);
		}finally{
			a.recycle();
		}
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		int viewWidthHalf = this.getMeasuredWidth()/2;
		int viewHeightHalf = this.getMeasuredHeight()/2;
		
		int radius = 0;
		
		radius = (viewWidthHalf>viewHeightHalf)?viewHeightHalf-10:viewWidthHalf-10;
		circlePaint.setStyle(Style.FILL);
		circlePaint.setAntiAlias(true);
		circlePaint.setColor(colorOfCircle);
		canvas.drawCircle(viewWidthHalf, viewHeightHalf, radius, circlePaint);
		
		circlePaint.setColor(colorOfLabel);
		circlePaint.setTextAlign(Paint.Align.CENTER);
		circlePaint.setTextSize(50);
		canvas.drawText(labelOfCircle, viewWidthHalf, viewHeightHalf, circlePaint);
	}

	public int getColorOfCircle() {
		return colorOfCircle;
	}

	public void setColorOfCircle(int colorOfCircle) {
		this.colorOfCircle = colorOfCircle;
		invalidate();
		requestLayout();
	}

	public int getColorOfLabel() {
		return colorOfLabel;
	}

	public void setColorOfLabel(int colorOfLabel) {
		this.colorOfLabel = colorOfLabel;
		invalidate();
		requestLayout();
	}

	public String getLabelOfCircle() {
		return labelOfCircle;
	}

	public void setLabelOfCircle(String labelOfCircle) {
		this.labelOfCircle = labelOfCircle;
		invalidate();
		requestLayout();
	}
	
	

}
