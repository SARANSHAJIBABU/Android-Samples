package com.Saran.customviewapp;


import com.Saran.customviewapp.R;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
	
	private CustomView customView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		customView = (CustomView) findViewById(R.id.customview);
	}
	
	public void clickButton(View v){
		
		if(customView.getColorOfCircle() == Color.GREEN){
			customView.setColorOfCircle(Color.RED);
			customView.setColorOfLabel(Color.YELLOW);
			customView.setLabelOfCircle("Sarans");
		}else{
			customView.setColorOfCircle(Color.GREEN);
			customView.setColorOfLabel(Color.BLACK);
			customView.setLabelOfCircle("Hurray");
		}

	}
}
