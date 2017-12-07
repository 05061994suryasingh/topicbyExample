package com.chromeinfotech.myfirst.UI.serialization;

import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.chromeinfotech.myfirst.R;
import com.chromeinfotech.myfirst.UI.BaseActivity.BaseActivity;
import com.chromeinfotech.myfirst.utils.Utils;

import java.util.ArrayList;

public class ParcableActivity extends BaseActivity {

    private TextView name,fname,address;
    Employee employee=null;
    private String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcable);
        Utils.printLog(TAG  , "inside onCreate()");

        this.intentvalue();
        this.reference();
        this.setText();
        this.setListenrs();

        Utils.printLog(TAG  , "outside onCreate()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Utils.printLog(TAG, "onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Utils.printLog(TAG, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Utils.printLog(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Utils.printLog(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Utils.printLog(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Utils.printLog(TAG, "onDestroy()");
    }

    @Override
    public void intentvalue() {

        Parcelable[] list = getIntent().getParcelableArrayExtra("parceble");
        employee = (Employee) list[0];

    }

    private void setText() {

        name.setText(employee.getName());
        fname.setText(employee.getfname());
        address.setText(employee.getaddress());

    }

    @Override
    public void reference() {

        Utils.printLog(TAG  , "inside reference()");
        name     = (TextView) findViewById(R.id.name);
        fname    = (TextView) findViewById(R.id.fname);
        address  = (TextView) findViewById(R.id.address);

        Utils.printLog(TAG  , "outside reference()");
    }


    @Override
    public void setListenrs() {
        Utils.printLog(TAG  , "inside setListenrs()");

        Utils.printLog(TAG  , "outside setListenrs()");

    }
}
