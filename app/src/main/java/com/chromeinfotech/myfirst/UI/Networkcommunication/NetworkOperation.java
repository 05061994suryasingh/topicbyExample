package com.chromeinfotech.myfirst.UI.Networkcommunication;

import com.chromeinfotech.myfirst.utils.Utils;

/**
 * Created by user on 9/2/17.
 */

public class NetworkOperation {
    private  Networkcall nc;
    private String TAG = this.getClass().getSimpleName();
    public NetworkOperation(Networkcall nc){

        this.nc=nc;
    }

    /**
     * peform callback
     */
    public  void Result() {
        Utils.printLog(TAG  , "inside Result()");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        nc.CallBack();
        Utils.printLog(TAG  , "outside Result()");
    }
}