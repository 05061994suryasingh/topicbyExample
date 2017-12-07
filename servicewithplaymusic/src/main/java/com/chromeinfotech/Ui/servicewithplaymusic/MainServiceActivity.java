package com.chromeinfotech.Ui.servicewithplaymusic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.chromeinfotech.Ui.BaseActivity.BaseActivity;
import com.chromeinfotech.servicewithplaymusic.R;
import com.chromeinfotech.utils.Utils;

public class MainServiceActivity extends BaseActivity implements View.OnClickListener {

    private  Button btnpstop , btnnext , btnprev;
    public static Button   btnplay ;
    public static SeekBar  seekBar ;
    public static TextView songName;
    public static TextView songDuration ;
    private Intent playbackServiceIntent;
    boolean isservicestart =false ;
    private String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Utils.printLog(TAG,"inside onCreate");

        this.reference();
        this.init();
        this.setListenrs();

        Utils.printLog(TAG,"outside onCreate");
    }

    /**
     * Ensure any created loaders are now started.
     */
    @Override
    protected void onStart() {
        super.onStart();
    }

    /**
     * Set the references from the widgets
     */
    @Override
    public void reference() {
        Utils.printLog(TAG,"inside reference");
        btnnext      = (Button)   findViewById(R.id.btnnext) ;
        btnpstop     = (Button)   findViewById(R.id.btnpstop) ;
        btnprev      = (Button)   findViewById(R.id.btnprev) ;
        btnplay      = (Button)   findViewById(R.id.btnplay);
        seekBar      = (SeekBar)  findViewById(R.id.seekBar);
        songDuration = (TextView) findViewById(R.id.songDuration) ;
        songName     = (TextView) findViewById(R.id.songName);
        Utils.printLog(TAG,"outside reference");



    }

    /**
     * set the listner
     */
    @Override
    public void setListenrs() {
        Utils.printLog(TAG,"inside setListenrs()");
        btnplay.setOnClickListener(this);
        btnnext.setOnClickListener(this);
        btnprev.setOnClickListener(this);
        btnpstop.setOnClickListener(this);
        Utils.printLog(TAG,"outside setListenrs()");

    }

    /**
     * Dispatch onStop() to all fragments. Ensure all loaders are stopped.
     */
    @Override
    protected void onStop() {
        Utils.printLog(TAG,"inside onStop()");
        super.onStop();
        if(isservicestart) {
            stopService(playbackServiceIntent);
            btnplay.setText("play");
        }else {
            Utils.showToast(this ,"service ia not start");
        }
        Utils.printLog(TAG,"outside onStop()");
    }

    /**
     * Called when a view has been clicked.
     * @param v
     */
    @Override
    public void onClick(View v) {
        Utils.printLog(TAG,"inside onClick");
        switch (v.getId()){
            case R.id.btnplay :
                Thread  mythread =new Thread(){
                    @Override
                    public void run() {

                        playbackServiceIntent = new Intent(MainServiceActivity.this, Myservice.class);
                        startService(playbackServiceIntent);
                        isservicestart = true;
                    }

                };mythread.start();
                btnplay.setText("pause");
                Utils.showToast(MainServiceActivity.this ," service is start");
                break;
            case R.id.btnpstop :
                if(isservicestart) {
                    stopService(playbackServiceIntent);
                    isservicestart =false ;
                    btnplay.setText("play");
                }else {
                    Utils.showToast(this ,"service ia not start");
                }
                break;
        }
        Utils.printLog(TAG,"outside onClick");
    }
}
