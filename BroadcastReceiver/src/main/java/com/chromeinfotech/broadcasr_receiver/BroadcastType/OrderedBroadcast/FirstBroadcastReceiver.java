package com.chromeinfotech.broadcasr_receiver.BroadcastType.OrderedBroadcast;

import android.content.Context;
import android.content.Intent;

import com.chromeinfotech.broadcasr_receiver.utils.Utils;

/**
 * Created by user on 30/3/17.
 */

public class FirstBroadcastReceiver extends android.content.BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String intentvalue = intent.getStringExtra("Messsage") ;
        Utils.showToast(context , "FirstBroadcastReceiver"+intentvalue);
    }
}
