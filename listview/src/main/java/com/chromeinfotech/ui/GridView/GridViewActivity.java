
package com.chromeinfotech.ui.GridView;

import android.os.Bundle;
import android.widget.GridView;
import com.chromeinfotech.listview.R;
import com.chromeinfotech.ui.BaseActivity.BaseActivity;


public class GridViewActivity extends BaseActivity {
    private  String mobileArray [];
    GridView grid;
    private GridViewAdapter adapter=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        this.init();
        this.myarrayAdapter();
    }

    @Override
    public void reference() {

    }

    //initialize the mobileArray[]
    @Override
    public void init() {
        mobileArray = new String[]{"Android", "IPhone", "WindowsMobile", "Blackberry",
                "WebOS", "Ubuntu", "Windows7", "Max OS X","Solaris" ,"iPhone"};

    }

    @Override
    public void setListenrs() {

    }
    //set Adapter to gridview
    private void myarrayAdapter() {
        adapter = new GridViewAdapter(this, mobileArray);
        grid=(GridView)findViewById(R.id.grid);
        grid.setAdapter(adapter);
    }



}
