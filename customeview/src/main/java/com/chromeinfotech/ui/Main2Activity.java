package com.chromeinfotech.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.chromeinfotech.customeview.R;
import com.chromeinfotech.ui.BaseActivity.BaseActivity;
import com.chromeinfotech.ui.Fragmentcass.MainActivity;

/**
 * Main2Activity  extends BaseActivity and perform operation like switch customview and listanddetails fragment
 */
public class Main2Activity extends BaseActivity implements View.OnClickListener{

    private Button btncustomview, btnlandscap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        this.reference();
        this.setListenrs();

    }

    /**
     * set the reference
     */
    @Override
    public void reference() {
        btncustomview = (Button) findViewById(R.id.btncustomview);
        btnlandscap = (Button) findViewById(R.id.btnlandscap);
    }

    /**
     * set the listner
     */
    @Override
    public void setListenrs() {
        btncustomview.setOnClickListener(this);
        btnlandscap.setOnClickListener(this);
    }

    /**
     * btnlandscap onclick tperform onclick operation on button
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            // Now, which button did they press, and take me to that class/activity

            case R.id.btncustomview:
                Intent intent = new Intent(Main2Activity.this, Customeview.class);
                startActivity(intent); //start the custom activity
                break;

            case R.id.btnlandscap:    //<<---- notice end line with colon, not a semicolon
                Intent intent1 = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent1); //start main Activity
                break;
        }
    }
}
