package com.chromeinfotech.myfirst.UI.inheritance;

import android.util.Log;

import com.chromeinfotech.myfirst.utils.Utils;

/**
 * Created by user on 10/2/17.
 */

public class Hardisk {
    private String TAG = this.getClass().getSimpleName();

    public void writeData()
    {
        Utils.printLog(TAG  , "inside writeData() ");
        Log.d("hdfc","write successsful");
        Utils.printLog(TAG  , "outside writeData() ");
    }
}




