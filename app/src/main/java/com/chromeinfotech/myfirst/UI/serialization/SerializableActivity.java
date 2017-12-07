package com.chromeinfotech.myfirst.UI.serialization;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.chromeinfotech.myfirst.R;
import com.chromeinfotech.myfirst.UI.BaseActivity.BaseActivity;
import com.chromeinfotech.myfirst.utils.Utils;

public class SerializableActivity extends BaseActivity {

    private TextView name,capital,population;
    private String TAG = this.getClass().getSimpleName();
    private  Country country = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serializable);

        Utils.printLog(TAG  , "inside onCreate()");

        this.intentvalue();
        this.reference();
        this.setText();
        this.setListenrs();

        Utils.printLog(TAG  , "outside onCreate()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Utils.printLog(TAG, "onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Utils.printLog(TAG, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Utils.printLog(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Utils.printLog(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Utils.printLog(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Utils.printLog(TAG, "onDestroy()");
    }


    @Override
    public void intentvalue(){
        country = (Country) getIntent().getSerializableExtra("serializable");
    }

    @Override
    public void reference() {

        Utils.printLog(TAG  , "inside reference()");

        name       = (TextView) findViewById(R.id.name);
        capital    = (TextView) findViewById(R.id.capital);
        population = (TextView) findViewById(R.id.population);

        Utils.printLog(TAG  , "outside reference()");
    }

    private void setText(){
        name.setText(country.getName());
        capital.setText(country.getCapital());
        population.setText(String.valueOf(country.getpopulation()));
    }

    @Override
    public void setListenrs() {
        Utils.printLog(TAG  , "inside setListenrs()");


        Utils.printLog(TAG  , "outside setListenrs()");

    }
}
