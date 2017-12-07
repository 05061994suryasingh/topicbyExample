package com.chromeinfotech.Ui.AsyncTask;


import android.os.AsyncTask;
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

public class DownloadAsyncTask extends BaseActivity {

    private TextView txtupdate ;
    private Button btnclick ;
    private String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_async_task);

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
     * set the Onclick listner on Button
     */
    @Override
    public void setListenrs() {

        Utils.printLog(TAG  , "inside setListenrs()");

        btnclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncTaskRunner runner = new AsyncTaskRunner();
                runner.execute();

            }
        });

        Utils.printLog(TAG  , "outside setListenrs()");
    }

    /**
     * AsyncTask class
     */
    private class AsyncTaskRunner extends AsyncTask<String, String, String> {
        String inputLine = null;
        StringBuilder sb = new StringBuilder();

        /**
         * communication with background Thread
         * @param params
         * @return
         */
        @Override
        protected String doInBackground(String... params) {

            Utils.printLog(TAG  , "inside doInBackground()");

            try {
                URL url = new URL( "http://api.letsleapahead.com/LeapAheadMultiFreindzy/index.php?action=getLang&langCode=EN&langId=1&appId=6");
                BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(url.openStream()));
                while ((inputLine = bufferedReader.readLine()) != null) {
                    Log.e("TAG", inputLine);
                    sb.append(inputLine) ;
                }
                bufferedReader.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            Utils.printLog(TAG  , "outside doInBackground()");
            return String.valueOf(sb);
        }

        /**
         * Runs on the UI thread after doInBackground
         * @param result
         */
        @Override
        protected void onPostExecute(String result) {

            Utils.printLog(TAG  , "inside onPostExecute()");

            txtupdate.setText(result);

            Utils.printLog(TAG  , "outside onPostExecute()");
        }
    }
}
