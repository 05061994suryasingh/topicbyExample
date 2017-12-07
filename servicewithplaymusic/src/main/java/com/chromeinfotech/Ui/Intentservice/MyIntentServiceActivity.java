package com.chromeinfotech.Ui.Intentservice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.chromeinfotech.Ui.BaseActivity.BaseActivity;
import com.chromeinfotech.servicewithplaymusic.R;
import com.chromeinfotech.utils.Utils;

public class MyIntentServiceActivity extends BaseActivity implements View.OnClickListener{

    private Button btnpstop , btnnext , btnprev, btnplay;
    private  Intent   intent ;
    private String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_intent_service);

        Utils.printLog(TAG,"inside onCreate");

        this.reference();
        this.setListenrs();

        Utils.printLog(TAG,"outside onCreate");
    }

    /**
     * set the reference
     */
    @Override
    public void reference() {

        Utils.printLog(TAG,"inside reference");

        btnnext      = (Button)   findViewById(R.id.btnnext) ;
        btnpstop     = (Button)   findViewById(R.id.btnpstop) ;
        btnprev      = (Button)   findViewById(R.id.btnprev) ;
        btnplay      = (Button)   findViewById(R.id.btnplay);

        Utils.printLog(TAG,"outside reference");
    }

    /**
     * set the listner
     */
    @Override
    public void setListenrs() {

        Utils.printLog(TAG,"inside setListenrs");

        btnplay.setOnClickListener(this);
        btnnext.setOnClickListener(this);
        btnprev.setOnClickListener(this);
        btnpstop.setOnClickListener(this);

        Utils.printLog(TAG,"outside setListenrs");
    }

    /**
     * Called when a view has been clicked.
     * @param v
     */
    @Override
    public void onClick(View v) {
        Utils.printLog(TAG,"inside onClick");
        switch (v.getId()){
            case R.id.btnplay :
                intent = new Intent(MyIntentServiceActivity.this ,MyIntentService.class) ;
                startService(intent) ;
                break;
            case R.id.btnpstop :
                stopService(intent) ;
                break;
        }
        Utils.printLog(TAG,"outside onClick");
    }
}
