package com.chromeinfotech.ui.listview.simpleListView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.chromeinfotech.listview.R;
import com.chromeinfotech.ui.BaseActivity.BaseActivity;
import com.chromeinfotech.utils.Utils;

/**
 * simple listview add mobile array
 */
public class Simplelistview extends BaseActivity {
    private  String mobileArray [];
    private TextView label;
    private ArrayAdapter adapter=null;
    private ListView listView=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simplelistview);

        this.reference();
        this.init();
        this.setAdapter();
        this.setListenrs();

    }

    //initialize the mobileArray
    @Override
    public void init() {
        mobileArray = new String[]{"Android", "IPhone", "WindowsMobile", "Blackberry",
                "WebOS", "Ubuntu", "Windows7", "Max OS X", "Solaris" };
    }

    //set the Adapter to listview
    private void setAdapter() {

        adapter = new ArrayAdapter<String>(this, R.layout.activity_simplelistview ,  R.id.label, mobileArray);
        listView.setAdapter(adapter);

    }

    /**
     * set the reference
     */
    @Override
    public void reference() {
        label = (TextView) findViewById(R.id.label) ;
        listView = (ListView) findViewById(R.id.mobile_list);
    }

    /**
     * set listner to listview
     */
    @Override
    public void setListenrs() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = (String)listView.getItemAtPosition(position);
                Utils.showToast(Simplelistview.this,"your selcted item is"+item);
            }
        });
    }
}
