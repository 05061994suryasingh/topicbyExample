package com.chromeinfotech.Ui.Handler;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.chromeinfotech.Ui.BaseActivity.BaseActivity;
import com.chromeinfotech.mythread.R;
import com.chromeinfotech.utils.Utils;

public class HandlerActivity extends BaseActivity {

    private TextView txtupdate ;
    private Button btnclick ;
    // private  Handler handler = new Handler();
    private String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
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
     * set listner on button
     */
    @Override
    public void setListenrs() {
        Utils.printLog(TAG  , "inside setListenrs()");
        btnclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startthread();
            }
        });
        Utils.printLog(TAG  , "outside setListenrs()");
    }

    /**
     * function start the thread
     */
    private void startthread() {
        Utils.printLog(TAG  , "inside startthread()");
         Thread thread = new Thread() {
            @Override
            public void run() {
                for(int i =0 ;i< 100 ; i++){
                    try {
                        Message msg = new Message();
                        Bundle bundle = new Bundle();
                        bundle.putString("Message", ""+i);
                        msg.setData(bundle);
                        handler.sendMessage(msg);  // send message to the handler
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };thread.start();
        Utils.printLog(TAG  , "outside startthread()");
    }


    /**
     *create instance of handler
     */
    Handler handler = new Handler() {

        //handles the thread's messages and updates the UI
        @Override
        public void handleMessage(Message msg) {
            Utils.printLog(TAG  , "inside handleMessage()");
            Bundle bundle = msg.getData();
            String message = bundle.getString("Message");
            txtupdate.setText("value=" +message);                //code to update the UI goes here....
            Utils.printLog(TAG  , "outside handleMessage()");
        }
    };

}
