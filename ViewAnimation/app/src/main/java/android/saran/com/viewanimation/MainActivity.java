package android.saran.com.viewanimation;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{

    Button alphaButton;
    Button translateButton;
    Button rotateButton;
    Button scaleButton;
     Button setButton;
    TranslateAnimation translateAnimation;
    AlphaAnimation alphaAnimation;
    RotateAnimation rotateAnimation;
    ScaleAnimation scaleAnimation;
    AnimationSet animationSet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alphaButton = (Button) findViewById(R.id.button);
        alphaButton.setOnClickListener(this);
        translateButton = (Button) findViewById(R.id.button2);
        translateButton.setOnClickListener(this);
        rotateButton = (Button) findViewById(R.id.button3);
        rotateButton.setOnClickListener(this);
        scaleButton = (Button) findViewById(R.id.button4);
        scaleButton.setOnClickListener(this);
        setButton = (Button) findViewById(R.id.button5);
        setButton.setOnClickListener(this);

        alphaAnimation = new AlphaAnimation(1,0);
        alphaAnimation.setDuration(1000);

        //Specifies how fromXValue,toXValue,fromYValue,toYValue should be interpreted.->Animation.ABSOLUTE,Animation.RELATIVE_TO_PARENT,Animation.RELATIVE_TO_SELF
        translateAnimation = new TranslateAnimation(Animation.ABSOLUTE,0,
                Animation.RELATIVE_TO_PARENT,1,
                Animation.ABSOLUTE,0,Animation.ABSOLUTE,1);
        translateAnimation.setDuration(1000);

                       //(float fromDegrees, float toDegrees, int pivotXType, float pivotXValue, int pivotYType, float pivotYValue)
        rotateAnimation = new RotateAnimation(0,360,Animation.RELATIVE_TO_SELF,.5f,Animation.RELATIVE_TO_SELF,.5f);
        rotateAnimation.setDuration(1000);

                 //fromX,toX,fromY,toY
        scaleAnimation = new ScaleAnimation(1,2,1,2);
        scaleAnimation.setDuration(1000);

                      //(boolean shareInterpolator)
        animationSet = new AnimationSet(true);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(rotateAnimation);
        animationSet.addAnimation(scaleAnimation);
    }


    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button:
                view.startAnimation(alphaAnimation);
                break;
            case R.id.button2:
                view.startAnimation(translateAnimation);
                break;
            case R.id.button3:
                view.startAnimation(rotateAnimation);
                break;
            case R.id.button4:
                view.startAnimation(scaleAnimation);
                break;
            case R.id.button5:
                view.startAnimation(animationSet);
                break;
        }
    }
}
