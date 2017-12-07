package com.chromeinfotech.navigationdrawer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.chromeinfotech.BaseActivity.BaseActivity;

public class MainActivity extends BaseActivity {

    private String[] mNavigationDrawerItemTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private  Toolbar toolbar;
    private   DataModel[] drawerItem ;
    private ActionBar actionBar ;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.reference();
        this.init();
        this.setNavigationDrawer();
        this.setListenrs();
    }

    @Override
    public void init() {
        mDrawerTitle = getTitle();
        mNavigationDrawerItemTitles= getResources().getStringArray(R.array.navigation_drawer_items_array);
        setupToolbar();
        drawerItem = new DataModel[7];
        drawerItem[0] = new DataModel(R.drawable.profile, "Profile");
        drawerItem[1] = new DataModel(R.drawable.album, "Album");
        drawerItem[2] = new DataModel(R.drawable.earning, "Earning");
        drawerItem[3] = new DataModel(R.drawable.rating, "Ratings");
        drawerItem[4] = new DataModel(R.drawable.setting, "Settings");
        drawerItem[5] = new DataModel(R.drawable.help, "Help");
        drawerItem[6] = new DataModel(R.drawable.logout, "Logout");
        setAdapter();
        setNavigationDrawer();
    }

    private void setAdapter() {
        DrawerCustomAdapter adapter = new DrawerCustomAdapter(this, R.layout.list_view_item_row, drawerItem);
        mDrawerList.setAdapter(adapter);
    }

    private void setupToolbar() {
         setSupportActionBar(toolbar);
         getSupportActionBar().setDisplayShowHomeEnabled(true);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.menu_icon);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
    }

    @Override
    public void reference() {
        toolbar         = (Toolbar)      findViewById(R.id.toolbar);
        mDrawerLayout   = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList     = (ListView)     findViewById(R.id.left_drawer);
    }

    @Override
    public void setListenrs() {
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
    }

    public class DrawerItemClickListener implements android.widget.AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }
    private void selectItem(int position) {

        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new ProfileFragment();
                break;
            case 1:
                fragment = new AlbumFragment();
                break;
            case 2:
                fragment = new EarningFragment();
                break;
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            setTitle(mNavigationDrawerItemTitles[position]);
            mDrawerLayout.closeDrawer(mDrawerList);

        } else {
            Log.e("MainActivity", "Error in creating fragment");
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(mDrawerList);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }
}
