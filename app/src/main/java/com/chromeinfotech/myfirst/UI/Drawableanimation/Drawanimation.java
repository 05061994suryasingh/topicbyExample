package com.chromeinfotech.myfirst.UI.Drawableanimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.chromeinfotech.myfirst.R;
import com.chromeinfotech.myfirst.utils.Utils;

public class Drawanimation extends AppCompatActivity{
    private String TAG = this.getClass().getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawanimation);
        Utils.printLog(TAG  , "inside onCreate()");

        Utils.printLog(TAG  , "outside onCreate()");

    }

}
