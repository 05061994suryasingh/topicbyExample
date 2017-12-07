package com.chromeinfotech.ui.ViewPager.Viewpagerwithfragement;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import com.chromeinfotech.listview.R;
import com.chromeinfotech.ui.BaseActivity.BaseActivity;
import com.chromeinfotech.utils.Utils;
import java.util.ArrayList;

/**
 * add fragment to viewpager with the help of pageradapter
 */
public class ViewPagerActivity extends BaseActivity implements TabLayout.OnTabSelectedListener ,FragementCommunication{

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;
    private String TAG = this.getClass().getSimpleName();
    private int[] tabIcons ;
    int position;
    public ArrayList<Fragment> fragments = new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        Utils.printLog(TAG,"inside onCreateView");

        this.reference();
        this.setItem();
        this.init();
        this.setFragment();
        this.setAdapter();
        this.setListenrs();
        this.setTabIcons();

        Utils.printLog(TAG,"outside onCreateView");
    }

    /**
     * add the fragment object to arraylist
     */
    private void setFragment() {
        Utils.printLog(TAG,"inside setFragment");
        Fragment1 fragment1 = new Fragment1();
        Fragment2 fragment2 = new Fragment2();
        Fragment3 fragment3 = new Fragment3();
        fragments.add(fragment1);
        fragments.add(fragment2);
        fragments.add(fragment3);
        Utils.printLog(TAG,"outside setFragment");
    }

    /**
     * set tabicon to tablayout
     */
    private void setTabIcons() {
        Utils.printLog(TAG,"inside setupTabIcons");
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        Utils.printLog(TAG,"outside setupTabIcons");
    }

    /**
     * initialize the tabicon
     */
    @Override
    public void init() {
        Utils.printLog(TAG,"inside init");
        tabIcons = new int[]{
                R.drawable.bluetooth,
                R.drawable.google,
                R.drawable.apple};
        Utils.printLog(TAG,"outside init");

    }

    /**
     * set the tab name
     */
    private void setItem() {
        Utils.printLog(TAG,"inside setItem");
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.addTab(tabLayout.newTab().setText("Tab1"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab2"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab3"));
        Utils.printLog(TAG,"outside setItem");
    }

    /**
     * set the adapter to viewpager
     */
    private void setAdapter() {
        Utils.printLog(TAG,"inside setAdapter");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ViewpagerAdapter adapter = new ViewpagerAdapter(getSupportFragmentManager(),fragments,tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        Utils.printLog(TAG,"outside setAdapter");
    }

    /**
     * create the reference
     */
    @Override
    public void reference() {
        Utils.printLog(TAG,"inside reference");
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        Utils.printLog(TAG,"outside reference");
    }

    /**
     * set listner to viewpager and tablayout
     */
    @Override
    public void setListenrs() {
        Utils.printLog(TAG,"inside setListenrs");
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(this);
        Utils.printLog(TAG,"outside setListenrs");
    }

    /**
     * method of tabSelectedListener call when tab is selected
     * @param tab
     */
    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        Utils.printLog("ViewPagerActivity"," inside onTabSelected");
        viewPager.setCurrentItem(tab.getPosition());
        position = tab.getPosition() ;
        Utils.printLog(TAG,"outside onTabSelected");
    }

    /**
     * method of tabSelectedListener call when tab is unselected
     * @param tab
     */
    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        Utils.printLog("ViewPagerActivity"," inside onTabUnselected");
        Fragment1 fragment1 = (Fragment1) ((ViewpagerAdapter) viewPager.getAdapter()).getItem(0);
        fragment1.setText("hello surya welcome");
    }

    /**
     * method of tabSelectedListener call when tab is Reselected
     * @param tab
     */
    @Override
    public void onTabReselected(TabLayout.Tab tab) {
        Utils.printLog("ViewPagerActivity"," inside onTabReselected");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Utils.printLog(TAG,"inside onOptionsItemSelected");
        switch(item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;


        }

        Utils.printLog(TAG,"outside onOptionsItemSelected");
        return super.onOptionsItemSelected(item);
    }

    /**
     * message of  FragementCommunication interface
     * @param msg
     */
    @Override
    public void onItemSelected(String msg) {

        Utils.printLog(TAG,"inside onItemSelected");
        Utils.printLog("ViewPagerActivity","message=" +msg);
        Utils.printLog("ViewPagerActivity","message=" +position);

        if(position == 0) {
            Fragment2 fragment2 = (Fragment2) ((ViewpagerAdapter) viewPager.getAdapter()).getItem(1);
            fragment2.setText(msg);

        }else if(position == 1){
            Fragment3 fragment3 = (Fragment3) ((ViewpagerAdapter) viewPager.getAdapter()).getItem(2);
            fragment3.setText(msg);
        }

        Utils.printLog(TAG,"outside onItemSelected");
    }

    @Override
    public void onBackPressed(){
        Utils.printLog(TAG,"inside onBackPressed");
        if(viewPager.getCurrentItem()==0){
            super.onBackPressed();
        }else{
            viewPager.setCurrentItem(viewPager.getCurrentItem()-1);
        }
        Utils.printLog(TAG,"outside onBackPressed");
    }

}

