package com.chromeinfotech.Ui.Bindservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.chromeinfotech.Ui.BaseActivity.BaseActivity;
import com.chromeinfotech.servicewithplaymusic.R;
import com.chromeinfotech.utils.Utils;

/**
 * MyBindServiceActivity
 */
public class MyBindServiceActivity extends BaseActivity implements View.OnClickListener{

    private  MyBindservice myBindservice = null;
    private  boolean isservicebind = false ;
    private Button btnpstop , btnnext , btnpause;
    private String TAG = this.getClass().getSimpleName();
    private Intent intent = null ;
    public static Button btnplay ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bind_service);

        Utils.printLog(TAG,"inside onCreate");

        this.reference();
        this.setListenrs();

        Utils.printLog(TAG,"outside onCreate");
    }

    /**
     * here we bind the service
     */
    @Override
    protected void onStart() {

        Utils.printLog(TAG,"inside onstart");

        super.onStart();
        intent = new Intent(MyBindServiceActivity.this ,MyBindservice.class) ;
        Thread thread = new Thread(){
            @Override
            public void run() {
                bindService(intent ,serviceConnection, Context.BIND_AUTO_CREATE) ;
            }
        };thread.start();

        Utils.printLog(TAG,"outside onstart");
    }

    /**
     * here we unbind the service
     */
    @Override
    protected void onStop() {

        Utils.printLog(TAG,"inside onstart");

        super.onStop();
        if (isservicebind) {
            isservicebind = false;
        }
        unbindService(serviceConnection);

        Utils.printLog(TAG , "outside onstart");
    }

    /**
     * create the references
     */
    @Override
    public void reference() {
        Utils.printLog(TAG , "inside onstart");
        btnnext      = (Button)   findViewById(R.id.btnnext) ;
        btnpstop     = (Button)   findViewById(R.id.btnpstop) ;
        btnpause     = (Button)   findViewById(R.id.btnpause) ;
        btnplay      = (Button)   findViewById(R.id.btnplay);
        Utils.printLog(TAG,"outside onstart");
    }

    /**
     * set Listner
     */
    @Override
    public void setListenrs() {
        Utils.printLog(TAG , "inside onstart");
        btnplay.setOnClickListener(this);
        btnplay.setEnabled(false);
        btnnext.setOnClickListener(this);
        btnpause.setOnClickListener(this);
        btnpstop.setOnClickListener(this);
        Utils.printLog(TAG,"inside onstart");
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Utils.printLog(TAG,"inside onServiceConnected");
            MyBindservice.MylocalBinder mylocalBinder = (MyBindservice.MylocalBinder) service;
            myBindservice = mylocalBinder.getService() ;
            myBindservice.startmusic();
            isservicebind = true;
            Utils.printLog(TAG,"inside onServiceConnected");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Utils.printLog(TAG,"inside onServiceDisconnected");
            isservicebind = false ;
            myBindservice = null;
            Utils.printLog(TAG,"inside onServiceDisconnected");
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnplay:
                if (isservicebind) {
                    Utils.showToast(this , "already playing");
                }else {
                    myBindservice.startmusic();
                    btnplay.setEnabled(false);
                    btnpstop.setEnabled(true);
                    isservicebind = true ;
                }
                break;
            case R.id.btnpstop:

                if (isservicebind) {
                   myBindservice.stopMusic();
                    btnplay.setEnabled(true);
                   btnpstop.setEnabled(false);
                    isservicebind = false;
                }
                break;

        }
    }
}
