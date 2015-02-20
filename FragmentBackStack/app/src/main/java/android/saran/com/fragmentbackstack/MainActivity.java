package android.saran.com.fragmentbackstack;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements FragmentManager.OnBackStackChangedListener {

    FragmentA fragmenta;
    FragmentB fragmentB;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        fragmentManager.addOnBackStackChangedListener(this);
    }

    public void addA(View v){
        //onAttach -> onCreate ->onCreateView ->onActivityCreated->onStart->onResume
        fragmenta = new FragmentA();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container,fragmenta,"A");
        fragmentTransaction.addToBackStack("addA");
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
            fragmentTransaction.addToBackStack("removeA");
            fragmentTransaction.commit();
        }
    }
    public void replaceA(View v){
        //onPause->onStop->onDestroyView->onDestroy->onDetach
        //onAttach -> onCreate ->onCreateView ->onActivityCreated->onStart->onResume
        fragmenta = new FragmentA();
        fragmentTransaction = fragmentManager.beginTransaction();
        //Custom fragment animation enabled entry ->slide in from top, exit -> slide out from bottom
        fragmentTransaction.setCustomAnimations(R.anim.abc_slide_in_top, R.anim.abc_slide_out_bottom);
        fragmentTransaction.replace(R.id.container,fragmenta,"A");
        fragmentTransaction.addToBackStack("replaceWithA");
        fragmentTransaction.commit();
    }
    public void addB(View v){
        fragmentB = new FragmentB();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container, fragmentB,"B");
        fragmentTransaction.addToBackStack("addB");
        fragmentTransaction.commit();
    }
    public void removeB(View v){
        fragmentB = (FragmentB) fragmentManager.findFragmentByTag("B");
        if(fragmentB==null){
            Toast.makeText(this,"FragmentB doesnt exist",Toast.LENGTH_SHORT).show();
        }else{
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(fragmentB);
            fragmentTransaction.addToBackStack("removeB");
            fragmentTransaction.commit();
        }
    }

    public void attachA(View v){
        //Reveals the existing layout,if hidden using detach(). only onAttachView&onActivityCreated will get executed. onAttach and onCreate wont.
        fragmenta = (FragmentA) fragmentManager.findFragmentByTag("A");
        if(fragmenta==null){
            Toast.makeText(this,"Fragment A doesnt exist", Toast.LENGTH_SHORT).show();
        }else{
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.attach(fragmenta);
            fragmentTransaction.addToBackStack("attachA");
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
            fragmentTransaction.addToBackStack("detachA");
            fragmentTransaction.commit();
        }
    }

    public void backPress(View v){
        //emulate backbutton behavior
        fragmentManager.popBackStack();
    }

    public void popA(View v){
        //Removes all backstack entries until addA, includes addA
        fragmentManager.popBackStack("addA",FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    public void popTillA(View v){
        //Removes backstack entries until addA, excludes addA
        fragmentManager.popBackStack("addA",0);
    }


    @Override
    public void onBackStackChanged() {
        int backStackCount = fragmentManager.getBackStackEntryCount();
        Toast.makeText(this,"BackStack Count = "+backStackCount,Toast.LENGTH_SHORT).show();
        for(int i=backStackCount-1; i>=0; i--){
            FragmentManager.BackStackEntry entry = fragmentManager.getBackStackEntryAt(i);
            Log.d("Test",entry.getName());
        }
        Log.d("Test","<++++++++++++++++++++++++++++++++++++++++++++++++++>");
    }
}
