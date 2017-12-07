package com.chromeinfotech.broadcasr_receiver.DynamicRegisterreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.chromeinfotech.broadcasr_receiver.BaseActivity.BaseActivity;
import com.chromeinfotech.broadcasr_receiver.R;
import com.chromeinfotech.broadcasr_receiver.utils.Utils;

public class DynamicRegisterActivity extends BaseActivity {

    private  MyDynamicRegisterReceiver myReceiver = null ;
    private IntentFilter filter = null ;
    private Button btnsongpause ,btnsongplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_register);
        this.reference();
        this.setListenrs();
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter();
        filter.addAction("myDynamicregisterReceiver");
        myReceiver = new MyDynamicRegisterReceiver();
        registerReceiver(myReceiver, filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(myReceiver);


    }

    @Override
    protected void onDestroy() {
        Utils.printLog("DynamicRegisterActivity" , "inside onDestroy()");
        super.onDestroy();
    }

    @Override
    public void reference()
    {
        btnsongpause = (Button) findViewById(R.id.btnsongpause) ;
        btnsongplay =  (Button) findViewById(R.id.btnsongplay) ;
    }

    @Override
    public void setListenrs() {
        btnsongplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("message" , "song play");
                intent.setAction("myDynamicregisterReceiver") ;
                sendBroadcast(intent);
            }
        });
        btnsongpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("message" , "song stop");
                intent.setAction("myDynamicregisterReceiver") ;
                sendBroadcast(intent);
            }
        });

    }
}
