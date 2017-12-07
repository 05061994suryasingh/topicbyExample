package com.chromeinfotech.myfirst.UI.layouts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.chromeinfotech.myfirst.R;
import com.chromeinfotech.myfirst.UI.inheritance.UseDell;
import com.chromeinfotech.myfirst.utils.Utils;

public class Linearlayout extends AppCompatActivity {
    private String TAG = this.getClass().getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linearlayout);
        Utils.printLog(TAG  , "inside onCreate()");

        this.Operation();

        Utils.printLog(TAG  , "outside onCreate()");

    }

    public void Operation(){
        Utils.printLog(TAG  , "inside Operation()");
        UseDell useDell = new UseDell();
        useDell.save();
        Utils.printLog(TAG  , "outside Operation()");
    }
}
