package android.saran.com.simpleanimation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v){
        startActivity(new Intent(this,SecondActivity.class));
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_left);
    }
}
