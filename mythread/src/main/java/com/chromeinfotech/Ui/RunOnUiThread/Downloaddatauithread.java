package com.chromeinfotech.Ui.RunOnUiThread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.chromeinfotech.Ui.BaseActivity.BaseActivity;
import com.chromeinfotech.mythread.R;
import com.chromeinfotech.utils.Utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Downloaddatauithread extends BaseActivity {
    private TextView txtupdate ;
    private Button btnclick ;
    private String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Utils.printLog(TAG  , "inside onCreate()");

        setContentView(R.layout.activity_downloaddatauithread);
        this.reference();
        this.setListenrs();
        Utils.printLog(TAG  , "outside onCreate()");
    }

    /**
     * set the reference
     */
    @Override
    public void reference() {
        Utils.printLog(TAG  , "inside reference()");
        txtupdate = (TextView) findViewById(R.id.txtupdate) ;
        btnclick  = (Button)   findViewById(R.id.btnclick);
        Utils.printLog(TAG  , "outside reference()");
    }

    /**
     * set the listener
     */
    @Override
    public void setListenrs() {
        Utils.printLog(TAG  , "inside setListenrs()");
        btnclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RunThread();

            }
        });
        Utils.printLog(TAG  , "outside setListenrs()");
    }

    /**
     * seprate thread for downloading data
     */
    private void RunThread() {
        Utils.printLog(TAG  , "inside RunThread()");
        new Thread(){
            @Override
            public void run() {
                downloadData();
            }
        }.start();
        Utils.printLog(TAG  , "outside RunThread()");
    }

    /**
     * download the data
     */
    private void downloadData() {

        Utils.printLog(TAG  , "inside downloadData()");
        String inputLine = null;
        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL( "http://api.letsleapahead.com/LeapAheadMultiFreindzy/index.php?action=getLang&langCode=EN&langId=1&appId=6");
            BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(url.openStream()));
            while ((inputLine = bufferedReader.readLine()) != null) {
                Log.e("TAG", inputLine);
                sb.append(inputLine) ;
            }
            runUithread(String.valueOf(sb));
            bufferedReader.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        Utils.printLog(TAG  , "outside downloadData()");
    }

    /**
     * update the ui
     * @param value
     */
    private void runUithread(final String value) {
        Utils.printLog(TAG  , "inside runUithread()");
        runOnUiThread(new Runnable() {

            @Override
            public void run() {
                txtupdate.setText(value);
            }
        });
        Utils.printLog(TAG  , "outside runUithread()");
    }

}
