package com.chromeinfotech.myfirst.UI.Customview.CustomeTextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.chromeinfotech.myfirst.R;
import com.chromeinfotech.myfirst.utils.Utils;

public class CustomTextView extends AppCompatActivity {
    private String TAG = this.getClass().getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_text_view);
        Utils.printLog(TAG  , "inside onCreate()");

        Utils.printLog(TAG  , "outside onCreate()");
    }
}
