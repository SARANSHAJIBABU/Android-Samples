package framelayout.saran.com.framelayoutexample70;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class MyActivity extends Activity {

    ImageView imageView1, imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
    }

    public void clickListener(View view){
        if(view.getId()==R.id.imageView1){
            imageView1.setVisibility(View.GONE);
            imageView2.setVisibility(View.VISIBLE);
        }else if(view.getId()==R.id.imageView2){
            imageView2.setVisibility(View.GONE);
            imageView1.setVisibility(View.VISIBLE);
        }
    }

}
