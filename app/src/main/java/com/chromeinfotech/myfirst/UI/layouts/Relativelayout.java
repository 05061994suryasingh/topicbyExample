package com.chromeinfotech.myfirst.UI.layouts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import com.chromeinfotech.myfirst.R;
import com.chromeinfotech.myfirst.UI.inheritance.Hdfc;
import com.chromeinfotech.myfirst.UI.mainresource.MainActivity;
import com.chromeinfotech.myfirst.utils.Utils;

public class Relativelayout extends AppCompatActivity {
    private String TAG = this.getClass().getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relativelayout);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Utils.printLog(TAG  , "inside onCreate()");
        this.compute();
        Utils.printLog(TAG  , "outside onCreate()");
    }

    private void compute()
    {
        Utils.printLog(TAG  , "inside compute()");
        Hdfc hdfc = new Hdfc();
        hdfc.Rateofinterest();
        hdfc.deposit();
        Utils.printLog(TAG  , "outside compute()");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent backMainTest = new Intent(this,MainActivity.class);
                startActivity(backMainTest);
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        } }
}
