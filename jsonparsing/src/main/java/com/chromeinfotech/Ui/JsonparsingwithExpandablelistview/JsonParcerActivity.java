package com.chromeinfotech.Ui.JsonparsingwithExpandablelistview;

import android.os.Bundle;
import android.widget.ExpandableListView;

import com.chromeinfotech.Ui.BaseActivity.BaseActivity;
import com.chromeinfotech.jsonparsing.R;

import java.util.ArrayList;

public class JsonParcerActivity extends BaseActivity {

    private JsonParcerAdapter jsonParcerAdapter = null;
    private ArrayList<BeaconInfo> beaconInfoArrayList;
    private ExpandableListView expandablelist ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_parcer);
        init();
        this.reference();
        this.setListenrs();
    }

    @Override
    public void init() {

    }
    @Override
    public void reference() {

        JSonParcerclass jsonParser = new JSonParcerclass(this);
        Data data = jsonParser.parsedData();
        beaconInfoArrayList = data.getBeaconInfoArrayList();
        jsonParcerAdapter = new JsonParcerAdapter(this, getLayoutInflater(),beaconInfoArrayList);
        expandablelist = (ExpandableListView) findViewById(R.id.expandablelist) ;
        expandablelist.setAdapter(jsonParcerAdapter);
    }

    @Override
    public void setListenrs() {

    }
}
