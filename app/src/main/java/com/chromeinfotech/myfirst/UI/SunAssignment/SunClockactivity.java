package com.chromeinfotech.myfirst.UI.SunAssignment;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.chromeinfotech.myfirst.R;
import com.chromeinfotech.myfirst.UI.BaseActivity.BaseActivity;
import com.chromeinfotech.myfirst.utils.Utils;

public class SunClockactivity  extends BaseActivity {
    private Animation sunAnimation,hourAnimation;
    private Animation clockAnimation;
    private ImageView sun , clock , hour;
    private String TAG = this.getClass().getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sun_clockactivity);
        Utils.printLog(TAG  , "inside onCreate()");
        this.reference();
        this.setListenrs();
        Utils.printLog(TAG  , "inside onCreate()");
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
    public void reference() {
        Utils.printLog(TAG  , "inside reference()");
        sunAnimation = AnimationUtils.loadAnimation(this, R.anim.sun_movement);
        clockAnimation = AnimationUtils.loadAnimation(this, R.anim.clock_movement);
        hourAnimation  = AnimationUtils.loadAnimation(this, R.anim.hour_movement);
        sun            = (ImageView) findViewById(R.id.sun);
        hour           = (ImageView) findViewById(R.id.hour);
        clock          =(ImageView)findViewById(R.id.clock);
        sun.startAnimation(sunAnimation);
        clock.startAnimation(clockAnimation);
        hour.startAnimation(hourAnimation);
        Utils.printLog(TAG  , "outside reference()");
    }

    @Override
    public void setListenrs() {
        Utils.printLog(TAG  , "inside setListenrs()");

        Utils.printLog(TAG  , "outside setListenrs()");
    }
}

