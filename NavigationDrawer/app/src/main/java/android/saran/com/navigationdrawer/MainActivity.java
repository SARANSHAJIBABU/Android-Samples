package android.saran.com.navigationdrawer;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

//DrawerLayout ->ContentView (always first) & ListView with customadapter
//ActionBarDrawerToggle class to handle drawer open/closed, sync,optionsItemClicked,configChanges

public class MainActivity extends ActionBarActivity implements AdapterView.OnItemClickListener{
    DrawerLayout drawerLayout;
    ListView listView;
    CustomAdapter adapter;
    ActionBarDrawerToggle drawerListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        listView = (ListView) findViewById(R.id.left_drawer);
        adapter= new CustomAdapter(this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

        drawerListener = new ActionBarDrawerToggle(this,drawerLayout,R.drawable.ic_drawer,R.string.open_drawer,R.string.close_drawer){
            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }
        };

        drawerLayout.setDrawerListener(drawerListener);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        //Tells user abt the presence of drawer by displaying 3horizontal lines and adjust them when clicking
        drawerListener.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //Handles orientation changes
        drawerListener.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        //See whether drawerListener can handle or not
        if(drawerListener.onOptionsItemSelected(item)){
            return true;
        }
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        selectItem(position);
        setActionBarTitle(adapter.getItem(position).toString());
    }

    private void selectItem(int position){
        listView.setSelection(position);
    }

    private void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }
}

class CustomAdapter extends BaseAdapter{
 String[] mPlanets;
    Context mContext;
    
    public CustomAdapter(Context context){
        mContext = context;
        mPlanets = context.getResources().getStringArray(R.array.names);
    }
    @Override
    public int getCount() {
        return mPlanets.length;
    }

    @Override
    public Object getItem(int position) {
        return mPlanets[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.custom_row,parent,false);
        }else{
            row = convertView;
        }
        ImageView imageView = (ImageView) row.findViewById(R.id.imageView);
        TextView textView = (TextView) row.findViewById(R.id.textView);

        imageView.setImageResource(R.drawable.ic_action_cloud);
        textView.setText(getItem(position).toString());
        return row;
    }
}
