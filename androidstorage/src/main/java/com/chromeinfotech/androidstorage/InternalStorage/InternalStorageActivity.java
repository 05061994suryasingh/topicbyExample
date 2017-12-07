package com.chromeinfotech.androidstorage.InternalStorage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.chromeinfotech.BaseActivity.BaseActivity;
import com.chromeinfotech.androidstorage.R;
import com.chromeinfotech.utils.Utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class InternalStorageActivity extends BaseActivity implements View.OnClickListener {

    EditText textmsg;
    private Button buttonwrite , buttonread ;
    static final int READ_BLOCK_SIZE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage);
        this.reference();
        this.setListenrs();
    }

    // write text to file
    public void writetofile() {
        // add-write text into file
        try {
            FileOutputStream fileout=openFileOutput("mytextfile.txt", MODE_PRIVATE);
            OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
            outputWriter.write(textmsg.getText().toString());
            outputWriter.close();
            textmsg.setText("");
            //display file saved message
            Utils.showToast(getBaseContext(),"File saved successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Read text from file
    public void readfromfile() {
        //reading text from file
        try {
            FileInputStream fileIn=openFileInput("mytextfile.txt");
            InputStreamReader InputRead= new InputStreamReader(fileIn);
            char[] inputBuffer= new char[READ_BLOCK_SIZE];
            String s="";
            int charRead;
            while ((charRead=InputRead.read(inputBuffer))>0) {
                // char to string conversion
                String readstring=String.copyValueOf(inputBuffer,0,charRead);
                s +=readstring;
            }
            InputRead.close();
            textmsg.setText(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonread:
                readfromfile();
                break;
            case R.id.buttonwrite:
                writetofile();
                break;
        }
    }

    @Override
    public void reference() {
        textmsg=(EditText)findViewById(R.id.editText1);
        buttonread=(Button)findViewById(R.id.buttonread);
        buttonwrite=(Button) findViewById(R.id.buttonwrite);
    }

    @Override
    public void setListenrs() {
        buttonread.setOnClickListener(this);
        buttonwrite.setOnClickListener(this);
    }
}
