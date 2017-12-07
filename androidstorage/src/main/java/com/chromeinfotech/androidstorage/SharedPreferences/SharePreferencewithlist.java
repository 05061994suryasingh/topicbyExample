package com.chromeinfotech.androidstorage.SharedPreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.chromeinfotech.BaseActivity.BaseActivity;
import com.chromeinfotech.androidstorage.R;
import com.chromeinfotech.utils.Utils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SharePreferencewithlist extends BaseActivity implements View.OnClickListener {


    private EditText txtid  ;
    private Button btnsave , btnretrive , btnclear ;
    private SharedPreferences sharedpreferences ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_preferencewithlist);

        this.reference();
        this.setListenrs();
    }


    @Override
    public void reference() {
        txtid      = (EditText) findViewById(R.id.txtid);
        btnsave    = (Button)   findViewById(R.id.btnsave);
        btnretrive = (Button)   findViewById(R.id.btnretrive);
        btnclear   = (Button)   findViewById(R.id.btnclear);

    }

    @Override
    public void setListenrs() {
        btnsave.setOnClickListener(this);
        btnretrive.setOnClickListener(this);
        btnclear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnsave:
                this.setdata();
                break ;
            case R.id.btnretrive:
                this.retrivedata();
                break ;
            case R.id.btnclear:
                this.cleardata();
                break ;
        }
    }

    private void cleardata() {
        txtid.setText("");
    }

    private void retrivedata() {
        String data ="";
        sharedpreferences =getSharedPreferences("MyPref", MODE_PRIVATE);
        Set<String> set = sharedpreferences.getStringSet("Listdata", null);
        List<String> listData=new ArrayList<String>(set);
        for(int i = 0 ; i < listData.size() ; i++ ){
            data += listData.get(i)+"\n";
            Utils.printLog("data" ,"="+listData.get(i));
        }
        txtid.setText(data);

    }

    private void setdata() {

        sharedpreferences = getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        ArrayList<String> list = new ArrayList<String>();
        list.add("1");
        list.add("surya");
        list.add("pramod singh");
        list.add("patna");
        Set<String> setlist = new HashSet<>();
        setlist.addAll(list);
        editor.putStringSet("Listdata", setlist);
        editor.commit() ;
    }
}
