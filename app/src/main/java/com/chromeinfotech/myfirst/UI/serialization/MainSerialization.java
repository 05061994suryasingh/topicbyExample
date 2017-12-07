package com.chromeinfotech.myfirst.UI.serialization;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.chromeinfotech.myfirst.R;
import com.chromeinfotech.myfirst.UI.BaseActivity.BaseActivity;
import com.chromeinfotech.myfirst.utils.Utils;

public class MainSerialization extends BaseActivity implements View.OnClickListener {

    private Button btnSerializable, btnParcable;
    private String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_serialization);

        Utils.printLog(TAG  , "inside onCreate()");

        this.reference();
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

    /**
     * Called when a view has been clicked.
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.Serializable:
                this.clickToShowSerializable();
                break;
            case R.id.parcable:
                this.clickToShowparcalable();
                break;
        }
    }

    /**
     * Called when a view has been clicked.
     */
    @Override
    public void reference() {

        Utils.printLog(TAG  , "inside reference()");

        btnSerializable = (Button) findViewById(R.id.Serializable);
        btnParcable     = (Button) findViewById(R.id.parcable);

        Utils.printLog(TAG  , "outside reference()");
    }

    /**
     * setListner on Button
     */
    @Override
    public void setListenrs() {
        Utils.printLog(TAG  , "inside setListenrs()");

        btnSerializable.setOnClickListener(this);
        btnParcable.setOnClickListener(this);

        Utils.printLog(TAG  , "outside setListenrs()");
    }

    /**
     * This method create the serialable objetc and set to intent and pas to the next screen
     */
    private void clickToShowSerializable(){

        Intent mIntent = new Intent(this,SerializableActivity.class);
        mIntent.putExtras(this.getBundle());
        startActivity(mIntent);
    }

    /**
     * return the Bundle
     * @return
     */
    private Bundle getBundle(){

        Bundle bundle = new Bundle();
        bundle.putSerializable("serializable",this.getCountryObject());
        return bundle;

    }

    /**
     * return th object of country
     * @return
     */
    private Country getCountryObject(){
        Country country = new Country();
        country.setName("india");
        country.setCapital("new_delhi");
        country.setpopulation(1500000);
        return country;
    }

    /**
     * This method set the parcalable object to intent and pass to the next screen
     */
    private void clickToShowparcalable(){
        Employee employee = new Employee();
        employee.setName("surya");
        employee.setfname("pramod singh");
        employee.setAddress("jharkhand");
        Intent intent  = new Intent(this,ParcableActivity.class);
        Bundle mBundle = new Bundle();
        //mBundle.putParcelable("parceble",employee);
        Employee[] list = new Employee[2];
        list[0]         = employee;
        list[1]         = employee;
        mBundle.putParcelableArray("parceble",list);
        intent.putExtras(mBundle);
        startActivity(intent);
    }



}
