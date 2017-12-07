package com.chromeinfotech.Ui.MainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.chromeinfotech.Ui.BaseActivity.BaseActivity;
import com.chromeinfotech.Ui.Bindservice.MyBindServiceActivity;
import com.chromeinfotech.Ui.Intentservice.MyIntentServiceActivity;
import com.chromeinfotech.Ui.servicewithplaymusic.MainServiceActivity;
import com.chromeinfotech.servicewithplaymusic.R;
import com.chromeinfotech.utils.Utils;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    private Button intentservice ,bindservice , normalservice;
    private String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Utils.printLog(TAG,"inside onCreate");

        this.reference();
        this.setListenrs();

        Utils.printLog(TAG,"outside onCreate");
    }

    /**
     * Called when a view has been clicked.
     * @param v
     */
    @Override
    public void onClick(View v) {
        Utils.printLog(TAG,"inside onClick");
        switch (v.getId())
        {
            case R.id.intentservice:
                Intent intent = new Intent(MainActivity.this, MyIntentServiceActivity.class);
                startActivity(intent);
                break;
            case R.id.bindservice:
                Intent intent1 = new Intent(MainActivity.this, MyBindServiceActivity.class);
                startActivity(intent1);
                break;
            case R.id.normalservice:
                Intent intent3 = new Intent(MainActivity.this, MainServiceActivity.class);
                startActivity(intent3);
                break;
        }
        Utils.printLog(TAG,"outside onClick");
    }

    /**
     * Set the references from the widgets
     */
    @Override
    public void reference() {
        Utils.printLog(TAG,"inside reference");
        intentservice   = (Button) findViewById(R.id.intentservice);
        bindservice     = (Button) findViewById(R.id.bindservice);
        normalservice   = (Button) findViewById(R.id.normalservice);
        Utils.printLog(TAG,"outside reference");
    }

    /**
     * set listner
     */
    @Override
    public void setListenrs() {
        Utils.printLog(TAG,"inside setListenrs");
        intentservice.setOnClickListener(this);
        bindservice.setOnClickListener(this);
        normalservice.setOnClickListener(this);
        Utils.printLog(TAG,"outside setListenrs");
    }
}
