package android.saran.com.fragmentswipetab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;

//Must implement ActionBar.TabListener, ViewPager.OnPageChangeListener to listen to actionbar tab selected and
//viepager page selected events and change accordingly
public class MainActivity extends ActionBarActivity implements ActionBar.TabListener, ViewPager.OnPageChangeListener{

    ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.pager);
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new PagerAdapter(fragmentManager));
        mViewPager.setOnPageChangeListener(this);

        ActionBar actionBar = getSupportActionBar();
        //Specify that tabs should be displayed in the action bar.
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        //Add tab to actionbar
        actionBar.addTab(actionBar.newTab()
                        .setText("Tab1")
                        .setTabListener(this));

        actionBar.addTab(actionBar.newTab()
                .setText("Tab2")
                .setTabListener(this));

        actionBar.addTab(actionBar.newTab()
                .setText("Tab3")
                .setTabListener(this));
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        //Link action bar tabs with viewpager
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onPageScrolled(int i, float v, int i2) {

    }

    @Override
    public void onPageSelected(int i) {
        //Link ViewPager swipe with actionbar
        getSupportActionBar().setSelectedNavigationItem(i);
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    public class PagerAdapter extends FragmentPagerAdapter{

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int id) {
            Fragment fragment = null;
            if(id == 0){
                fragment = new FragmentA();
            }else if(id ==1){
                fragment = new FragmentB();
            }else{
                fragment = new FragmentC();
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
