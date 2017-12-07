package com.chromeinfotech.Ui.Jsonparsingfromurl;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.chromeinfotech.Ui.BaseActivity.BaseActivity;
import com.chromeinfotech.jsonparsing.R;

public class JsonParsingfromUrl extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_parsingfrom_url);
        this.reference();
        this.setListenrs();

    }

    @Override
    public void reference() {

    }

    @Override
    public void setListenrs() {

    }
}
