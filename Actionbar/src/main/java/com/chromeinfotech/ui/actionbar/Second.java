package com.chromeinfotech.ui.actionbar;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import com.chromeinfotech.actionbar.R;
import com.chromeinfotech.ui.BaseActivity.BaseActivity;

/**
 * second activity only show back button on actionbar and perform back operation
 */
public class Second extends BaseActivity {
private  Toolbar toolbar ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        this.reference();
        setSupportActionBar(toolbar); //set the toolbar
        getSupportActionBar().setHomeButtonEnabled(true); //set homeenable true
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //display home button
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;


        }


        return super.onOptionsItemSelected(item);
    }

    /**
     * set the Reference
     */
    @Override
    public void reference() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    @Override
    public void setListenrs() {

    }
}
