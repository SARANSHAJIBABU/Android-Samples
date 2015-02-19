package android.saran.com.fragmenttransactions;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    FragmentA fragmenta;
    FragmentB fragmentB;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
    }

    public void addA(View v){
        //onAttach -> onCreate ->onCreateView ->onActivityCreated->onStart->onResume
        fragmenta = new FragmentA();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container,fragmenta,"A");
        fragmentTransaction.commit();
    }
    public void removeA(View v){
        //onPause->onStop->onDestroyView->onDestroy->onDetach
        fragmenta = (FragmentA) fragmentManager.findFragmentByTag("A");
        if(fragmenta == null){
            Toast.makeText(this,"FragmentA doesnt exist",Toast.LENGTH_SHORT).show();
        }else{
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(fragmenta);
            fragmentTransaction.commit();
        }
    }
    public void replaceA(View v){
        //onPause->onStop->onDestroyView->onDestroy->onDetach
        //onAttach -> onCreate ->onCreateView ->onActivityCreated->onStart->onResume
        fragmenta = new FragmentA();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container,fragmenta,"A");
        fragmentTransaction.commit();
    }
    public void addB(View v){
        fragmentB = new FragmentB();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container, fragmentB,"B");
        fragmentTransaction.commit();
    }
    public void removeB(View v){
        fragmentB = (FragmentB) fragmentManager.findFragmentByTag("B");
        if(fragmentB==null){
            Toast.makeText(this,"FragmentB doesnt exist",Toast.LENGTH_SHORT).show();
        }else{
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(fragmentB);
            fragmentTransaction.commit();
        }
    }
    public void replaceB(View v){
        fragmentB = new FragmentB();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragmentB, "B");
        fragmentTransaction.commit();
    }

    public void attachA(View v){
        //Reveals the existing layout,if hidden using detach(). only onAttachView&onActivityCreated will get executed. onAttach and onCreate wont.
        fragmenta = (FragmentA) fragmentManager.findFragmentByTag("A");
        if(fragmenta==null){
            Toast.makeText(this,"Fragment A doesnt exist", Toast.LENGTH_SHORT).show();
        }else{
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.attach(fragmenta);
            fragmentTransaction.commit();
        }
    }
    public void detachA(View v){
        //Hides the existing layout. only onDestroyView will get executed. onDestroy and onDetach wont.
        fragmenta = (FragmentA) fragmentManager.findFragmentByTag("A");
        if(fragmenta==null){
            Toast.makeText(this,"Fragment A doesnt exist",Toast.LENGTH_SHORT).show();
        }else{
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.detach(fragmenta);
            fragmentTransaction.commit();
        }
    }


}
