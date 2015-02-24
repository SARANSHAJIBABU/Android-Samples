package android.saran.com.fragmentlistdialog;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;


public class MainActivity extends ActionBarActivity implements FragmentList.ListItemSelectedListener {

    FragmentDialog mDialog;
    FragmentManager mFragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentManager = getSupportFragmentManager();
        ((FragmentList)mFragmentManager.findFragmentById(R.id.fragment_list)).setListItemSelectedListener(this);
    }

    @Override
    public void onListItemSelected(String item) {
        mDialog = new FragmentDialog(item);

        //Dont need to create a transaction, since show contains create, add and commit
        mDialog.show(mFragmentManager,item);//item is used as Tag of the fragment
    }


}
