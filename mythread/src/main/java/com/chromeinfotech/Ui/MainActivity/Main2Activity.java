package com.chromeinfotech.Ui.MainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.chromeinfotech.Ui.AsyncTask.AsyncTaskActivity;
import com.chromeinfotech.Ui.AsyncTask.DownloadAsyncTask;
import com.chromeinfotech.Ui.BaseActivity.BaseActivity;
import com.chromeinfotech.Ui.Handler.DownloaddatahandlerThread;
import com.chromeinfotech.Ui.Handler.HandlerActivity;
import com.chromeinfotech.Ui.RunOnUiThread.Downloaddatauithread;
import com.chromeinfotech.Ui.RunOnUiThread.RunOnUiThreadActivity;
import com.chromeinfotech.Ui.mythread.MainActivity;
import com.chromeinfotech.mythread.R;

public class Main2Activity extends BaseActivity implements View.OnClickListener {

    private Button btnstartThread, btnHandler, btnRunonUithread, btnasynctask , btnDownloadRunonUithread , btnDownloadHandler , btndownloadasynctask , btnxmlparcer , btnxmlparcerlist ,btnjsonparcer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        this.reference();
        this.setListenrs();
    }

    /**
     * set the reference
     */
    @Override
    public void reference() {
        btnstartThread             = (Button) findViewById(R.id.btnstartThread);
        btnHandler                 = (Button) findViewById(R.id.btnHandler);
        btnRunonUithread           = (Button) findViewById(R.id.btnRunonUithread);
        btnasynctask               = (Button) findViewById(R.id.btnasynctask);
        btnDownloadRunonUithread   = (Button) findViewById(R.id.btnDownloadRunonUithread);
        btnDownloadHandler         = (Button) findViewById(R.id.btnDownloadHandler);
        btndownloadasynctask       = (Button) findViewById(R.id.btndownloadasynctask);

    }

    /**
     * set Onclick listner on button
     */
    @Override
    public void setListenrs() {
        btnstartThread.setOnClickListener(this);
        btnHandler.setOnClickListener(this);
        btnRunonUithread.setOnClickListener(this);
        btnasynctask.setOnClickListener(this);
        btnDownloadRunonUithread.setOnClickListener(this);
        btnDownloadHandler.setOnClickListener(this);
        btndownloadasynctask.setOnClickListener(this);

    }

    /**
     * perform operation  when we click the button
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnstartThread:
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.btnHandler:
                Intent intent1 = new Intent(Main2Activity.this, HandlerActivity.class);
                startActivity(intent1);
                break;
            case R.id.btnRunonUithread:
                Intent intent2 = new Intent(Main2Activity.this, RunOnUiThreadActivity.class);
                startActivity(intent2);
                break;
            case R.id.btnasynctask:
                Intent intent3 = new Intent(Main2Activity.this, AsyncTaskActivity.class);
                startActivity(intent3);
                break;
            case R.id.btnDownloadRunonUithread:
                Intent intent4 = new Intent(Main2Activity.this, Downloaddatauithread.class);
                startActivity(intent4);
                break;
            case R.id.btnDownloadHandler:
                Intent intent5 = new Intent(Main2Activity.this, DownloaddatahandlerThread.class);
                startActivity(intent5);
                break;
            case R.id.btndownloadasynctask:
                Intent intent6 = new Intent(Main2Activity.this, DownloadAsyncTask.class);
                startActivity(intent6);
                break;

        }
    }
}
