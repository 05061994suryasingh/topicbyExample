package com.chromeinfotech.ui.listview.arrayAdapter;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.chromeinfotech.listview.R;
import com.chromeinfotech.ui.listview.arrayAdapter.mySimpleArrayAdapter;

public class myarrayadapterActivity extends ListActivity {

    private  String mobileArray [];
    private TextView label;
    private ArrayAdapter adapter=null;
    private ListView listView=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myarrayadapter);
        this.init();// call the init method
        this.myarrayAdapter();// call the method myarrayAdapter
    }
    //seet the list Adapter
    private void myarrayAdapter () {
        mySimpleArrayAdapter adapter = new mySimpleArrayAdapter(this, mobileArray);
        setListAdapter(adapter);
    }
    //initialize the mobileArray[]
    public void init(){
        mobileArray = new String[]{"Android", "IPhone", "WindowsMobile", "Blackberry",
                "WebOS", "Ubuntu", "Windows7", "Max OS X","Solaris"};
    }

}
