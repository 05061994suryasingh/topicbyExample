package com.chromeinfotech.ui.MainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.chromeinfotech.listview.R;
import com.chromeinfotech.ui.BaseActivity.BaseActivity;
import com.chromeinfotech.ui.ExpandableList.BaseExpandapleActivity;
import com.chromeinfotech.ui.GridView.GridViewActivity;
import com.chromeinfotech.ui.GridView.Gridviewmulticell.GridAdapteractivity;
import com.chromeinfotech.ui.ViewPager.Viewpagerwithfragement.ViewPagerActivity;
import com.chromeinfotech.ui.ViewPager.ViewPagerActivity1;
import com.chromeinfotech.ui.listview.listviewchekbox.ListviewCheckbox;
import com.chromeinfotech.ui.listview.simpleListView.Simplelistview;
import com.chromeinfotech.ui.listview.arrayAdapter.myarrayadapterActivity;
import com.chromeinfotech.ui.listview.baseAdapter.MybaseAdapterActivity;
import com.chromeinfotech.ui.listview.baseAdapter.MycacheBaseAdapterActivity;

/**
 * start  all activity on button click
 */
public class MainActivity extends BaseActivity implements View.OnClickListener{
    private Button btnsimplelistview , btnarrayadapter , btnbaseadapter , btncachebaseadapter ,btnExpandablelise , btnmulticell ,btngridmulticell ,btnviewPager , btnviewPager1 ,btnlistview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.reference();
        this.setListenrs();
    }

    /**
     * set the reference
     */
    @Override
    public void reference() {
        btnsimplelistview   = (Button) findViewById(R.id.btnsimplelistview);
        btnarrayadapter     = (Button) findViewById(R.id.btnarrayadapter);
        btnbaseadapter      = (Button) findViewById(R.id.btnbaseadapter);
        btncachebaseadapter = (Button) findViewById(R.id.btncachebaseadapter);
        btnExpandablelise   = (Button) findViewById(R.id.btnExpandablelise);
        btnmulticell        = (Button) findViewById(R.id.btnmulticell);
        btngridmulticell    = (Button) findViewById(R.id.btngridmulticell);
        btnviewPager        = (Button) findViewById(R.id.btnviewPager);
        btnviewPager1       = (Button) findViewById(R.id.btnviewPager1);
        btnlistview         = (Button) findViewById(R.id.btnlistview);

    }

    /**
     * set the listner on button
     */
    @Override
    public void setListenrs() {
        btnsimplelistview.setOnClickListener(this);
        btnarrayadapter.setOnClickListener(this);
        btnbaseadapter.setOnClickListener(this);
        btncachebaseadapter.setOnClickListener(this);
        btnExpandablelise.setOnClickListener(this);
        btnmulticell.setOnClickListener(this);
        btngridmulticell.setOnClickListener(this);
        btnviewPager.setOnClickListener(this);
        btnviewPager1.setOnClickListener(this);
        btnlistview.setOnClickListener(this);

    }

    /**
     *Override onclick button and get each button id
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnsimplelistview:
                Intent intent = new Intent(MainActivity.this,Simplelistview.class);
                startActivity(intent);
                break;
            case R.id.btnarrayadapter:
                Intent intent1 = new Intent(MainActivity.this,myarrayadapterActivity.class);
                startActivity(intent1);
                break;
            case R.id.btnbaseadapter:
                Intent intent3 = new Intent(MainActivity.this,MybaseAdapterActivity.class);
                startActivity(intent3);
                break;
            case R.id.btncachebaseadapter:
                Intent intent4 = new Intent(MainActivity.this , MycacheBaseAdapterActivity.class);
                startActivity(intent4);
                break;
            case R.id.btnExpandablelise:
                Intent intent5 = new Intent(MainActivity.this , BaseExpandapleActivity.class);
                startActivity(intent5);
                break;
            case R.id.btnmulticell:
                Intent intent6 = new Intent(MainActivity.this , GridViewActivity.class);
                startActivity(intent6);
                break;
            case R.id.btngridmulticell:
                Intent intent7 = new Intent(MainActivity.this , GridAdapteractivity.class);
                startActivity(intent7);
                break;
            case R.id.btnviewPager:
                Intent intent8 = new Intent(MainActivity.this , ViewPagerActivity.class);
                startActivity(intent8);
                break;
            case R.id.btnviewPager1:
                Intent intent9 = new Intent(MainActivity.this , ViewPagerActivity1.class);
                startActivity(intent9);
                break;
            case R.id.btnlistview:
                Intent intent10 = new Intent(MainActivity.this , ListviewCheckbox.class);
                startActivity(intent10);
                break;
        }
    }
}
