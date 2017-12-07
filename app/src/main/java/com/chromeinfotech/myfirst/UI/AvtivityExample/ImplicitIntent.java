package com.chromeinfotech.myfirst.UI.AvtivityExample;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.chromeinfotech.myfirst.R;
import com.chromeinfotech.myfirst.UI.BaseActivity.BaseActivity;
import com.chromeinfotech.myfirst.utils.Utils;

public class ImplicitIntent extends BaseActivity{
    private EditText editText1;
    private Button Visit;
    String url="https://developer.android.com";
    private String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_implicit);
        Utils.printLog(TAG  , "inside onCreate()");
        this.reference();
        this.setListenrs();
        Utils.printLog(TAG  , "inside onCreate()");
    }

    /**
     * Set the references from the widgets
     */
    @Override
    public void reference() {
        editText1 = (EditText) findViewById(R.id.editText1);
        Visit     = (Button)   findViewById(R.id.Visit);
    }

    /**
     * set Onclicklistner on button
     */
    @Override
    public void setListenrs() {
        Visit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent("com.chromeinfotech.myfirst.UI.AvtivityExample",Uri.parse(url));
                startActivity(intent);
//                Intent sendIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//                Intent chooser = Intent.createChooser(intent, "Choose Your Browser");
//                startActivity(chooser);
            }
        });
    }

}

