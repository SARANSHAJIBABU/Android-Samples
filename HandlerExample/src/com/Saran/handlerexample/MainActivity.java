package com.Saran.handlerexample;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;

public class MainActivity extends Activity {
	Thread thread;
	Handler handler;
	ProgressBar progressBar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		progressBar = (ProgressBar) findViewById(R.id.progressBar1);
		
		thread = new Thread(new Mythread());
		thread.start();
		
		handler = new Handler(){
			public void handleMessage(Message msg) {				
				progressBar.setProgress(msg.arg1);
				
			}
		};
	}
	
	//Runs in seperate thread
	class Mythread implements Runnable{

		@Override
		public void run() {
			for(int i=0; i< 100; i++){
				Message message = Message.obtain();
				message.arg1 = i;
				
				//Send message using the handler reference of main thread
				handler.sendMessage(message);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
