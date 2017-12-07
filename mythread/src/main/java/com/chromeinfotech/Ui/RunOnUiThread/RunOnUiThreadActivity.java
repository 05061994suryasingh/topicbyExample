package com.chromeinfotech.Ui.RunOnUiThread;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.chromeinfotech.Ui.BaseActivity.BaseActivity;
import com.chromeinfotech.mythread.R;
import com.chromeinfotech.utils.Utils;

public class RunOnUiThreadActivity extends BaseActivity {
    private TextView txtupdate ;
    private Button btnclick ;
    private String TAG = this.getClass().getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run_on_ui_thread);

        Utils.printLog(TAG  , "inside onCreate()");

        this.reference();
        this.setListenrs();

        Utils.printLog(TAG  , "outside onCreate()");
    }

    /**
     * set the reference
     */
    @Override
    public void reference() {
        Utils.printLog(TAG  , "inside reference()");
        txtupdate = (TextView) findViewById(R.id.txtupdate) ;
        btnclick  = (Button)   findViewById(R.id.btnclick);
        Utils.printLog(TAG  , "outside reference()");
    }

    /**
     * set the listneer
     */
    @Override
    public void setListenrs() {

        Utils.printLog(TAG  , "inside setListenrs()");
        btnclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RunThread();

            }
        });
        Utils.printLog(TAG  , "outside setListenrs()");

    }

    /**
     * start threan and call RunUiThread() in run method
     */
    private void RunThread() {
        Utils.printLog(TAG  , "inside RunThread()");
        new Thread() {
            public void run() {
                int i =0 ;
                try {
                    while (i++ < 100) {
                        RunUiThread(i) ;
                        Thread.sleep(300);
                    }
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        Utils.printLog(TAG  , "outside RunThread()");
    }

    /**
     * update the ui
     * @param i
     */
    private void RunUiThread(final int i) {
        Utils.printLog(TAG  , "inside RunUiThread()");
        runOnUiThread(new Runnable() {

            @Override
            public void run() {
                txtupdate.setText("value=" + i);
            }
        });
        Utils.printLog(TAG  , "outside RunUiThread()");
    }


}
