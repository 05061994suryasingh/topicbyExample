package com.chromeinfotech.myfirst.UI.layouts;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.chromeinfotech.myfirst.UI.Networkcommunication.NetworkOperation;
import com.chromeinfotech.myfirst.UI.Networkcommunication.Networkcall;
import com.chromeinfotech.myfirst.R;
import com.chromeinfotech.myfirst.utils.Utils;

public class TableLayout extends AppCompatActivity {
    private String TAG = this.getClass().getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_layout);

        Utils.printLog(TAG  , "inside onCreate()");

        this.Network_Operaton();

        Utils.printLog(TAG  , "outside onCreate()");

    }

    private void Network_Operaton() {
        Utils.printLog(TAG  , "inside Network_Operaton()");
        NetworkOperation no = new NetworkOperation(new Networkcall() {
            @Override
            public void CallBack() {
                Log.d("callback"," callbcak called  successsfully");

            }
        });
        no.Result();
        Utils.printLog(TAG  , "outside Network_Operaton()");
    }
}