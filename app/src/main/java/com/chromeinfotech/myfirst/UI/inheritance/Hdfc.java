package com.chromeinfotech.myfirst.UI.inheritance;

import android.util.Log;

import com.chromeinfotech.myfirst.utils.Utils;

/**
 * Created by user on 9/2/17.
 */

public class Hdfc extends Bank {
    private String TAG = this.getClass().getSimpleName();
    @Override
    public void deposit() {
        Utils.printLog(TAG  , "inside deposit() ");
        Log.d("hdfc","deposit successsful");
        Utils.printLog(TAG  , "outside deposit() ");
    }
    @Override
    public void Rateofinterest() {
        Utils.printLog(TAG  , "inside Rateofinterest() ");
        Log.d("hdfc","rate of interest is 8%");
        Utils.printLog(TAG  , "outside Rateofinterest() ");
    }
}
