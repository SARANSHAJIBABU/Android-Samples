package customfont.saran.com.customfont;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;


public class MyActivity extends Activity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);


        textView = (TextView) findViewById(R.id.textview);
        //Assets folder should be directly in main folder and not inside res
        Typeface customFont = Typeface.createFromAsset(getAssets(),"fonts/Roboto-BoldItalic.ttf");
        textView.setTypeface(customFont);
    }

}
