package com.chromeinfotech.ui.BaseActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 *BaseActivity  is abstract class
 */
public abstract class BaseActivity extends AppCompatActivity{

    /**
     * Set the references from the widgets
     */
    public abstract void reference();
    public  void init(){};
    public abstract void setListenrs();
    public void intentvalue(){};




}
