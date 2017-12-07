package com.chromeinfotech.broadcasr_receiver.BroadcastType.OrderedBroadcast;

import android.content.*;

import com.chromeinfotech.broadcasr_receiver.utils.Utils;

/**
 * Created by user on 30/3/17.
 */

public class SecondBroadcastReceiver extends android.content.BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String intentvalue = intent.getStringExtra("Messsage") ;
        Utils.showToast(context , "SecondBroadcastReceiver"+intentvalue);
    }
}
