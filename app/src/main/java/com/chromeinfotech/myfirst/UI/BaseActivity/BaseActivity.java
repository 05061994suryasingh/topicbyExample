package com.chromeinfotech.myfirst.UI.BaseActivity;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity{

    /**
     * Set the references from the widgets
     */
    public abstract void reference();
    public  void init(){};
    public abstract void setListenrs();
    public void intentvalue(){};

}
