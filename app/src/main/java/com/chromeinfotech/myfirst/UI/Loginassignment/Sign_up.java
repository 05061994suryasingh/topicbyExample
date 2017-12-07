package com.chromeinfotech.myfirst.UI.Loginassignment;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.chromeinfotech.myfirst.UI.BaseActivity.BaseActivity;
import com.chromeinfotech.myfirst.R;
import com.chromeinfotech.myfirst.utils.Utils;

public class Sign_up extends BaseActivity {
    private Switch mySwitch;
    private String TAG = this.getClass().getSimpleName();
    private TextView textView,textView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Utils.printLog(TAG  , "inside onCreate()");

        this.reference();
        this.setListenrs();

        Utils.printLog(TAG  , "outside onCreate()");

    }

    @Override
    public void reference() {
        Utils.printLog(TAG  , "inside reference()");
        textView  = (TextView) findViewById(R.id.textView);
        textView1 = (TextView) findViewById(R.id.textView1);
        mySwitch  = (Switch)   findViewById(R.id.toggle);
        Utils.printLog(TAG  , "outside reference()");
    }

    @Override
    public void setListenrs() {
        Utils.printLog(TAG  , "inside setListenrs()");
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked   ) {
                if (isChecked) {
                    textView.setTextColor(Color.RED);
                    textView1.setTextColor(Color.BLACK);
                } else {
                    textView1.setTextColor(Color.RED);
                    textView.setTextColor(Color.BLACK);
                }
            }
        });
        Utils.printLog(TAG  , "outside setListenrs()");

    }


}