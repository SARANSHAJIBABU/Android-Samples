package android.saran.com.simpleanimation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    public void onClick(View v){
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.fade_out);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                button.setVisibility(View.INVISIBLE);
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_left);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        button.startAnimation(animation);
    }

    @Override
    protected void onResume() {
        super.onResume();
        button.setVisibility(View.VISIBLE);
    }
}
