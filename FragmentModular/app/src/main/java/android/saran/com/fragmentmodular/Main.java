package android.saran.com.fragmentmodular;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;


public class Main extends ActionBarActivity implements FragmentA.Communicator{
    private static final String EXTRA_INDEX = "index";
    FragmentA fragmentA;
    FragmentB fragmentB;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        fragmentA = (FragmentA) fragmentManager.findFragmentById(R.id.fragmenta);
        fragmentA.setDelegate(this);
    }

    @Override
    public void updateUI(int index) {
        fragmentB = (FragmentB) fragmentManager.findFragmentById(R.id.fragmentb);
        if(fragmentB!=null && fragmentB.isVisible()){
            //Landscape mode
            fragmentB.updateUI(index);
        }else{
            //Portrait mode
            Intent intent = new Intent(this,SecondActivity.class);
            intent.putExtra(EXTRA_INDEX,index);
            startActivity(intent);
        }
    }
}
