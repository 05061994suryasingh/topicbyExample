package com.chromeinfotech.utils;
import android.app.FragmentManager;
import android.content.Context;
import android.app.FragmentTransaction;

import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by user on 15/2/17.
 */

public class Utils {
    private static final boolean LOG_ON = true;

    /**
     * This method print the logs
     *
     * @param tag     - Class Name
     * @param message - Message to shoe
     */
    public static void printLog(String tag, String message) {
        if (LOG_ON)
            Log.d(tag, message);
    }

    /**
     * @param context
     * @param message
     */
    public static void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static FragmentManager getFragmentManager(Context context){
        return ((FragmentActivity)context).getFragmentManager();
    }

    public static FragmentTransaction getFragmenttransaction(Context context){
        return ((FragmentActivity)context).getFragmentManager().beginTransaction();
    }

    public static void commitTransaction(FragmentTransaction transaction){
        transaction.commit();
    }
}
