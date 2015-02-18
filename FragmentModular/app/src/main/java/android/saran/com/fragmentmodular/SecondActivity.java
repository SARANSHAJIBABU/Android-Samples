package android.saran.com.fragmentmodular;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;


public class SecondActivity extends ActionBarActivity {
    private static final String EXTRA_INDEX = "index";
    FragmentB fragmentB;
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        fragmentManager = getSupportFragmentManager();
        fragmentB = (FragmentB) fragmentManager.findFragmentById(R.id.fragmentb);
        int index = getIntent().getIntExtra(EXTRA_INDEX,0);
        fragmentB.updateUI(index);
    }
}
