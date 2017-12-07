package com.chromeinfotech.Ui.MainActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.chromeinfotech.Ui.BaseActivity.BaseActivity;
import com.chromeinfotech.Ui.JsonparsingwithExpandablelistview.JsonParcerActivity;
import com.chromeinfotech.Ui.JsonparsingwithListview.JsonparcerActivityListview;
import com.chromeinfotech.Ui.Xmlparsing.MyXmlParserActivity;
import com.chromeinfotech.Ui.Xmlparsing.Xmlparcerwitharraylist.XmlParcerArraylist;
import com.chromeinfotech.jsonparsing.R;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    private Button  btnxmlparcer , btnxmlparcerlist ,btnjsonparcer ,btnjsonparcer1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.reference();
        this.setListenrs();
    }

    @Override
    public void reference() {
        btnxmlparcer               = (Button) findViewById(R.id.btnxmlparcer);
        btnxmlparcerlist           = (Button) findViewById(R.id.btnxmlparcerlist);
        btnjsonparcer              = (Button) findViewById(R.id.btnjsonparcer);
        btnjsonparcer1              = (Button) findViewById(R.id.btnjsonparcer1);

    }

    @Override
    public void setListenrs() {
        btnxmlparcer.setOnClickListener(this);
        btnxmlparcerlist.setOnClickListener(this);
        btnjsonparcer.setOnClickListener(this);
        btnjsonparcer1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnxmlparcer:
                Intent intent = new Intent(MainActivity.this, MyXmlParserActivity.class);
                startActivity(intent);
                break;
            case R.id.btnxmlparcerlist:
                Intent intent1 = new Intent(MainActivity.this, XmlParcerArraylist.class);
                startActivity(intent1);
                break;
            case R.id.btnjsonparcer:
                Intent intent2 = new Intent(MainActivity.this, JsonparcerActivityListview.class);
                startActivity(intent2);
                break;
            case R.id.btnjsonparcer1:
                Intent intent3 = new Intent(MainActivity.this, JsonParcerActivity.class);
                startActivity(intent3);
                break;
        }
    }
}
