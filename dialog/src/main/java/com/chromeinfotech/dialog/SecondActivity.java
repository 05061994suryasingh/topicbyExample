package com.chromeinfotech.dialog;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.chromeinfotech.BaseActivity.BaseActivity;
import com.chromeinfotech.utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * recive the data from MainActivity and set it to textview txtname
 */
public class SecondActivity extends BaseActivity implements View.OnClickListener {

    private TextView txtname ,label ;
    private  String mobileArray [];
    private Button btndelete , btnexit ;
    private ListView listview ;
    private List<String> liste;
    List<String> entries = new ArrayList<String>();
    private ArrayList<String> data = new ArrayList<>();
    private int listposition ;
    private    String item ;
    private mySimpleArrayAdapter adapter=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        this.init();
        this.reference();    // set the Reference
        this.intentvalue(); //set the intentvalue
        this.addArraylistData();
        this.setAdapter();
        this.setListenrs();

    }

    private void addArraylistData() {
        for (int i = 0; i < mobileArray.length; ++i) {
            liste = new ArrayList<String>();
            Collections.addAll(liste, mobileArray);
//            data.add(mobileArray[i]);
        }
    }

    private void setAdapter() {
        adapter = new mySimpleArrayAdapter(this ,liste);
        listview.setAdapter(adapter);
    }

    @Override
    public void reference() {
        txtname   = (TextView)  findViewById(R.id.txtname);
        btndelete = (Button)    findViewById(R.id.btndelete);
        btnexit   = (Button)    findViewById(R.id.btnexit);
        listview  = (ListView)  findViewById(R.id.list);


    }

    @Override
    public void init() {

        mobileArray = new String[]{"Android", "IPhone", "WindowsMobile", "Blackberry",
                "WebOS", "Ubuntu", "Windows7", "Max OS X", "Solaris" };

    }



    /**
     * get data from bundle and set it to textview txtname
     */
    @Override
    public void intentvalue() {
        Bundle bundle = getIntent().getExtras();
        String data = bundle.getString("MESSAGE");
        Utils.printLog("data","data"+data);
        txtname.setText(data);
    }

    @Override
    public void setListenrs() {
        btnexit.setOnClickListener(this);
        btndelete.setOnClickListener(this);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                item = (String)listview.getItemAtPosition(position);
                listposition = position;
                Utils.showToast(SecondActivity.this,"your selcted item is"+item);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnexit:
                final CustomlDialog custome = new CustomlDialog(this);
                custome.show();
                custome.setTitle("exit");
                custome.setActionMessage("are you want to exit?");
                custome.btnyes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        custome.dismiss();
                        SecondActivity.this.finish();
                    }
                });
                custome.btnno.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        custome.dismiss();
                    }
                });
                break;
            case R.id.btndelete:
                final CustomlDialog custome1 = new CustomlDialog(this);
                custome1.show();
                custome1.setTitle("delete");
                custome1.setActionMessage("do you want to delete?");
                custome1.btnyes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        liste.remove(listposition);
                        adapter.notifyDataSetChanged();
                        custome1.dismiss();
                       Utils.showToast(SecondActivity.this,"btn yes is click");
                    }
                });
                custome1.btnno.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Utils.showToast(SecondActivity.this,"btn no is click");
                        custome1.dismiss();

                    }
                });
                break;
        }
    }
}
