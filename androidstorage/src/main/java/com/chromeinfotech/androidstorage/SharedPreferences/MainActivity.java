package com.chromeinfotech.androidstorage.SharedPreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.chromeinfotech.BaseActivity.BaseActivity;
import com.chromeinfotech.androidstorage.R;
import com.google.gson.Gson;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    private EditText txtid , txtname , txtfname , txtaddress ;
    private Button btnsave , btnretrive , btnclear ;
    Student student = new Student() ;
    String data ;
    private SharedPreferences sharedpreferences ;
    Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.reference();
        this.setListenrs();
    }

    @Override
    public void reference() {
        txtid      = (EditText) findViewById(R.id.txtid);
        txtname    = (EditText) findViewById(R.id.txtname);
        txtfname   = (EditText) findViewById(R.id.txtfname);
        txtaddress = (EditText) findViewById(R.id.txtaddress);
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
        txtname.setText("");
        txtfname.setText("");
        txtaddress.setText("");
    }

    private void retrivedata() {

        sharedpreferences =getSharedPreferences("MyPref", MODE_PRIVATE);


        if(sharedpreferences.contains("stddata")){
            data = sharedpreferences.getString("stddata" ,null) ;
            Student std = gson.fromJson(data ,  student.getClass()) ;
            txtid.setText(std.getStdid());
            txtname.setText(std.getName());
            txtaddress.setText(std.getAddress());
            txtfname.setText(std.getFname());

          }
    }

    private void setdata() {

        sharedpreferences = getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        student.setStdid("2");
        student.setName("surya");
        student.setFname("pramod singh");
        student.setAddress("jharkhand");
        data = gson.toJson(student) ;
        editor.putString("stddata" ,data) ;
        editor.commit() ;
    }
}
