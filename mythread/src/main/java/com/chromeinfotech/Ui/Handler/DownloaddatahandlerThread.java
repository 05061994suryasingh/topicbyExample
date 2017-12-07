package com.chromeinfotech.Ui.Handler;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.chromeinfotech.Ui.BaseActivity.BaseActivity;
import com.chromeinfotech.mythread.R;
import com.chromeinfotech.utils.Utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class DownloaddatahandlerThread extends BaseActivity {

    private TextView txtupdate ;
    private Button btnclick ;
    private String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_downloaddatahandler_thread);

        Utils.printLog(TAG  , "inside onCreate()");

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
     * set Onclicklistner on button
     */
    @Override
    public void setListenrs() {

        Utils.printLog(TAG  , "inside setListenrs()");

        btnclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startthread();
            }



        });

        Utils.printLog(TAG  , "outside setListenrs()");
    }

    private void startthread() {

        Utils.printLog(TAG  , "inside startthread()");

        new Thread(new Runnable() {

            @Override
            public void run() {
                downloadData();
            }
        }).start();

        Utils.printLog(TAG  , "outside startthread()");
    }

    /**
     * download data in seprate thread
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
            Message msg = new Message();
            Bundle bundle = new Bundle();
            bundle.putString("Message", String.valueOf(sb));
            msg.setData(bundle);
            // send message to the handler
            handler.sendMessage(msg);
            bufferedReader.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        Utils.printLog(TAG  , "outside downloadData()");
    }

    /**
     *create instance of handler and update the ui
     */
    Handler handler = new Handler() {

        //handles the thread's messages and updates the UI
        @Override
        public void handleMessage(Message msg) {
            Utils.printLog(TAG  , "inside handleMessage()");
            Bundle bundle = msg.getData();
            String message = bundle.getString("Message");
            txtupdate.setText("value=" +message);                //code to update the UI goes here
            Utils.printLog(TAG  , "outside handleMessage()");
        }
    };
}
