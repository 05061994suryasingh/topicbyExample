package com.chromeinfotech.Ui.AsyncTask;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.chromeinfotech.Ui.BaseActivity.BaseActivity;
import com.chromeinfotech.mythread.R;
import com.chromeinfotech.utils.Utils;

public class AsyncTaskActivity extends BaseActivity {

    private TextView txtupdate ;
    private EditText edittime ;
    private Button btnclick ;
    private String TAG = this.getClass().getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);

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
        edittime  = (EditText) findViewById(R.id.edittime) ;

        Utils.printLog(TAG  , "outside reference()");
    }

    /**
     * set the listner on button
     */
    @Override
    public void setListenrs() {

        Utils.printLog(TAG  , "inside setListenrs()");

        btnclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncTaskRunner runner = new AsyncTaskRunner();
                String sleepTime = edittime.getText().toString();
                runner.execute(sleepTime);}



        });

        Utils.printLog(TAG  , "outside setListenrs()");
    }

    /**
     * AsyncTask class
     */
    private class AsyncTaskRunner extends AsyncTask<String, String, String> {

        ProgressDialog progressDialog;

        /**
         * verride this method to perform a computation on a background thread
         * @param params
         * @return
         */
        @Override
        protected String doInBackground(String... params) {

            Utils.printLog(TAG  , "inside doInBackground()");

            publishProgress("Sleeping..."); // Calls onProgressUpdate()
            try {
                int time = Integer.parseInt(params[0])*1000;

                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();

            } catch (Exception e) {
                e.printStackTrace();
            }

            Utils.printLog(TAG  , "outside doInBackground()");
            return "completed";
        }

        /**
         * runs on the UI thread after doInBackground.
         * @param result
         */
        @Override
        protected void onPostExecute(String result) {

            Utils.printLog(TAG  , "inside onPostExecute()");

            // execution of result of Long time consuming operation
            progressDialog.dismiss();
            txtupdate.setText(result);

            Utils.printLog(TAG  , "outside onPostExecute()");
        }

        /**
         * Runs on the UI thread before doInBackground.
         */
        @Override
        protected void onPreExecute() {

            Utils.printLog(TAG  , "inside onPreExecute()");

            progressDialog = ProgressDialog.show(AsyncTaskActivity.this,"ProgressDialog",
                    "Wait for "+edittime.getText().toString()+ " seconds");
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

            Utils.printLog(TAG  , "outside onPreExecute()");
        }

        /**
         * Runs on the UI thread after publishProgress is invoked
         * @param text
         */
        @Override
        protected void onProgressUpdate(String... text) {

            Utils.printLog(TAG  , "inside onProgressUpdate()");

            Utils.showToast(AsyncTaskActivity.this ,"onProgressUpdate" + text[0]);

            Utils.printLog(TAG  , "outside onProgressUpdate()");

        }
    }
}
