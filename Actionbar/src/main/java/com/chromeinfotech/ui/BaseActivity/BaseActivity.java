package com.chromeinfotech.ui.BaseActivity;
import android.support.v7.app.AppCompatActivity;

/**
 * BAseActivity is a Abstract method extends AppCompatActivity
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
