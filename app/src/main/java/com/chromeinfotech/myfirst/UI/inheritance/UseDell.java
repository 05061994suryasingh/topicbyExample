package com.chromeinfotech.myfirst.UI.inheritance;

import com.chromeinfotech.myfirst.utils.Utils;

/**
 * Created by user on 10/2/17.
 */

public class UseDell {
    private String TAG = this.getClass().getSimpleName();
    Hardisk segate = new Hardisk();
    public void save () {
        Utils.printLog(TAG  , "inside save() ");
        segate.writeData();
        Utils.printLog(TAG  , "inside save() ");
    }
}
