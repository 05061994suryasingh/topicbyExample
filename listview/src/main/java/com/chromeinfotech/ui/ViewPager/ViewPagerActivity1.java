package com.chromeinfotech.ui.ViewPager;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.chromeinfotech.listview.R;
import com.chromeinfotech.ui.BaseActivity.BaseActivity;

/**
 * ViewPagerActivity1 set the viewpageradapter in viewpager
 */
public class ViewPagerActivity1 extends BaseActivity {
    private ViewPagerAdapter1 viewPagerAdapter1 ;
    private  ViewPager mViewPager ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager1);
        this.setAdapter();


    }
    //set Adapter to ViewPager
    private void setAdapter() {
        viewPagerAdapter1 = new ViewPagerAdapter1(this);
        mViewPager        = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(viewPagerAdapter1);
    }

    @Override
    public void reference() {

    }

    @Override
    public void setListenrs() {

    }
}
