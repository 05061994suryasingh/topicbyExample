package com.chromeinfotech.broadcasr_receiver.BroadcastType.LocalBroadcast;

import android.content.IntentFilter;
import android.os.Bundle;

import com.chromeinfotech.broadcasr_receiver.BaseActivity.BaseActivity;
import com.chromeinfotech.broadcasr_receiver.R;
import com.chromeinfotech.broadcasr_receiver.utils.Utils;

public class LocalbroadcastActivitiy extends BaseActivity {
private FirstLocalReceiver myReceiver ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_broadcast_activiti);
    }

    @Override
    public void reference() {

    }

    @Override
    public void setListenrs() {

    }
    @Override
    protected void onResume() {
        super.onResume();
        myReceiver = new FirstLocalReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("myDynamicregisterReceiver");
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

}
