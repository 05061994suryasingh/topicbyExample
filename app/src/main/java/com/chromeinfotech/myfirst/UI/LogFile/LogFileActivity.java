package com.chromeinfotech.myfirst.UI.LogFile;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.chromeinfotech.myfirst.R;
import com.chromeinfotech.myfirst.utils.Utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class LogFileActivity extends AppCompatActivity {
    private String TAG   = this.getClass().getSimpleName();
    BufferedReader input = null;
    File file = null;
    private TextView logtext;
    FileOutputStream outputStream = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_file);
        Utils.printLog(TAG  , "inside onCreate()");
        logtext = (TextView) findViewById(R.id.logtext);
        this.writeTOfile();
        this.Readfile();
        Utils.printLog(TAG  , "outside onCreate()");
    }

    /**
     * read the file
     */
    private void Readfile() {
        Utils.printLog(TAG  , "inside Readfile()");
        try {
            file  = new File(getCacheDir(), "MyCache");
            input = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line="";
            StringBuffer buffer = new StringBuffer();
            while ((line        = input.readLine()) != null) {
                buffer.append(line);
                logtext.setText(line);
            }

            Log.d(TAG, buffer.toString());
        }

        catch (IOException e) {
            Log.e(TAG, "File not found!");
            logtext.setText(e.getMessage());
            String msg = e.getMessage().toString();
            addtofile(msg);
        }
        Utils.printLog(TAG  , "outside Readfile()");
    }

    /**
     * write the file
     */
    private void writeTOfile() {
        Utils.printLog(TAG,"inside writeTOfile");
        String content ="welcome kk welcome to akgec";
        try {
            file = new File(getCacheDir(), "MyCache");
            outputStream = new FileOutputStream(file);
            outputStream.write(content.getBytes());
            outputStream.close();
        } catch (Exception e) {
            Log.e(TAG,"error");
        }
        Utils.printLog(TAG,"outside writeTOfile");
    }

    /**
     * write Exception to file
     * @param msg
     */
    public  void addtofile(String msg) {
        Utils.printLog(TAG, "inside addtofile");
        String content = msg;
        try {
            file         = new File(getCacheDir() , "MyCache");
            outputStream = new FileOutputStream(file);
            outputStream.write(content.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Utils.printLog(TAG, "outside addtofile");
    }
}


