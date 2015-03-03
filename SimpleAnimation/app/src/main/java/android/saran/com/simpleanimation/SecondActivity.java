package android.saran.com.simpleanimation;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;


public class SecondActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void onClick(View v){
        finish();
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
    }
}
