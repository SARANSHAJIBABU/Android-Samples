package edittexttest.saran.com.edittexttest;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;


public class MyActivity extends Activity {

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        editText = (EditText) findViewById(R.id.editText);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Toast.makeText(getBaseContext()," in beforeTextChanged",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Toast.makeText(getBaseContext()," in onTextChanged",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void afterTextChanged(Editable s) {
                Toast.makeText(getBaseContext()," in afterTextChanged",Toast.LENGTH_SHORT).show();
                if(s.length()>0){
                    if(Integer.parseInt(s.toString())>100){
                        s.replace(0,s.length(),"100");
                    }
                }
            }
        });
    }

}
