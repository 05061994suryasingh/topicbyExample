package com.chromeinfotech.MainActivity;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.chromeinfotech.androidstorage.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExternalActivity extends AppCompatActivity implements View.OnClickListener {


    private Button button1, button2;
    private EditText FullName, companyAddress, emailEdit, phEdit, title;
    private String filename = "SampleFile";
    private String filepath = "MyFileStorage";
    private final int  PERMISSION_REQUEST_CODE = 100 ;
    private File myExternalFile;
    private String myData = "";

    private String Fname, Email, Company, Phone, Title, checkComma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external);
        if (Build.VERSION.SDK_INT >= 23)
        {
            if (checkPermission())
            {
                // Code for above or equal 23 API Oriented Device
                // Your Permission granted already .Do next code
            } else {
                requestPermission(); // Code for permission
            }
        }
        else
        {

            // Code for Below 23 API Oriented Device
            // Do next code
        }
        FullName = (EditText) findViewById(R.id.fname_editText);
        emailEdit = (EditText) findViewById(R.id.email_editText);
        companyAddress = (EditText) findViewById(R.id.companyAddress_editText);
        phEdit = (EditText) findViewById(R.id.phno_editText);
        title = (EditText) findViewById(R.id.title_editText);
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);
    }

    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(ExternalActivity.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

    private void requestPermission() {

        if (ActivityCompat.shouldShowRequestPermissionRationale(ExternalActivity.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            Toast.makeText(ExternalActivity.this, "Write External Storage permission allows us to do store images. Please allow this permission in App Settings.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(ExternalActivity.this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.e("value", "Permission Granted, Now you can use local drive .");
                } else {
                    Log.e("value", "Permission Denied, You cannot use local drive .");
                }
                break;
        }
    }

    /**
     * called when button has been clicked
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                getValue();
                checkValidation();
                break;
            case R.id.button2:
                break;
        }
    }

    private void checkValidation() {

        for(int i=0; i<checkComma.length();i++)
            if(checkComma.charAt(i)==',') {
                Toast.makeText(getApplicationContext(),"Please remove comma's from your input", Toast.LENGTH_LONG).show();
                return;
            }
        if(FullName.getText().toString().length()==0)
        {
            Toast.makeText(getApplicationContext(),"Name Cannot Be Blank", Toast.LENGTH_LONG).show();
            FullName.setError("Name Cannot Be Blank");
            return;
        }
        else if(!android.util.Patterns.EMAIL_ADDRESS.matcher(emailEdit.getText().toString()).matches())
        {
//Validation for Invalid Email Address
            Toast.makeText(getApplicationContext(), "Invalid Email", Toast.LENGTH_LONG).show();

            return;
        }
        else if(!Patterns.PHONE.matcher(phEdit.getText().toString()).matches())
        {

            Toast.makeText(getApplicationContext(),"Invallid Phone Number", Toast.LENGTH_LONG).show();
            phEdit.setError("Invallid Phone Number");
            return;
        }

        if(Fname.equals("")||Email.equals("")||Company.equals("")||Phone.equals("") || Title.equals(""))
        {
            Toast.makeText(getApplicationContext(), "Field Vacant", Toast.LENGTH_LONG).show();
            return;
        }
        else
        {      //      save();
            writeToFile(filename,checkComma);
            Toast.makeText(getApplicationContext(), "Saved ", Toast.LENGTH_LONG).show();
            FullName.setText("");
            emailEdit.setText("");
            phEdit.setText("");
            companyAddress.setText("");
            title.setText("");
        }

    }

    /**
     * check validation
     */
    private void getValue() {
        Fname = FullName.getText().toString();
        Email = emailEdit.getText().toString();
        Company = companyAddress.getText().toString();
        Phone = phEdit.getText().toString();
        Title = title.getText().toString();
        checkComma = Fname + Email + Company + Phone + Title;
    }

    /**
     * write data into the file
     * @param fileName
     * @param body
     */
    public  void writeToFile(String fileName, String body)
    {
        FileOutputStream fos = null;

        try {
            final File dir = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/kk/" );

            if (!dir.exists())
            {
                if(!dir.mkdirs()){
                    Log.e("ALERT","could not create the directories");
                }
            }

            final File myFile = new File(dir, fileName + ".txt");

            if (!myFile.exists())
            {
                myFile.createNewFile();
            }

            fos = new FileOutputStream(myFile);

            fos.write(body.getBytes());
            fos.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
   }

