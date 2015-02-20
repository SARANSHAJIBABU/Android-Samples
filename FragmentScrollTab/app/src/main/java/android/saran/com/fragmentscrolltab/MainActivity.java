package android.saran.com.fragmentscrolltab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        FragmentManager fragmentManager = getSupportFragmentManager();
        viewPager.setAdapter(new CustomAdapter(fragmentManager));
    }


    public class CustomAdapter extends FragmentPagerAdapter{
        //While using FragmentPagerAdapter, fragment's UI  get destroyed when scrolled away [onDestroyView called], but onDetach wont get called
        //leaving java object there. But fragment state wont get saved. Suitable for small no of tabs
        //Can use FragmentStatePagerAdapter also
        //In that case fragment state will be saved in onSaveInstanceState and fragment get destroyed and detached
        //But when scrolled back, restore state using saved bundle
        public CustomAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            Fragment fragment = null;
            switch(i){
                case 0:
                    fragment = new FragmentA();
                    break;
                case 1:
                    fragment = new FragmentB();
                    break;
                case 2:
                    fragment = new FragmentC();
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if(position == 0){
                return "TabA";
            }else if(position ==1){
                return "TabB";
            }else if(position == 2){
                return "TabC";
            }
            return "";
        }
    }

}
