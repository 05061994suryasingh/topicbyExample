package com.chromeinfotech.ui.listview.listviewchekbox;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.chromeinfotech.utils.Utils;

import java.util.ArrayList;

/**
 * Created by user on 10/3/17.
 */

public class ViewpagerAdapter extends FragmentStatePagerAdapter {
    int tabCount;
    private String TAG = this.getClass().getSimpleName();
    String  fragment;
    public ArrayList<Fragment> fragments = new ArrayList<Fragment>();

    public ViewpagerAdapter(FragmentManager fm, ArrayList<Fragment> fragments, int tabCount) {
        super(fm);
        Utils.printLog(TAG,"inside ViewpagerAdapter() constructor");
        this.tabCount= tabCount;
        this.fragments=fragments;
        Utils.printLog(TAG,"inside ViewpagerAdapter() constructor");
    }

    @Override
    public Fragment getItem(int position) {
        Utils.printLog(TAG,"inside getItem()");
        return  fragments.get(position) ;

    }
    @Override
    public int getCount() {

        Utils.printLog(TAG,"inside getCount()");
        return tabCount;
    }

}
