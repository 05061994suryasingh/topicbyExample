package com.chromeinfotech.dialog;

import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.chromeinfotech.BaseActivity.BaseActivity;
import com.chromeinfotech.utils.Utils;

/**
 * MainActivity extends BaseActivity and perform dialog opration on buttonclick
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {

    private EditText edtname;
    private Button btnsave, btnprogressdialog, btncustomdialog, buttondatepicker;
    private ProgressDialog progressDialog ;
    private boolean isCanceled , cancilable , status = true;
    int jumptime1 , jumpTime ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.reference(); //set the Reference
        this.setListenrs(); //set the listner
    }

    /**
     * set the reference
     */
    @Override
    public void reference() {
        edtname           = (EditText) findViewById(R.id.edtname);
        btnsave           = (Button) findViewById(R.id.btnsave);
        btnprogressdialog = (Button) findViewById(R.id.btnprogressdialog);
        btncustomdialog   = (Button) findViewById(R.id.btncustomdialog);
        buttondatepicker  = (Button) findViewById(R.id.buttondatepicker);
    }

    /**
     * set listner to Button
     */
    @Override
    public void setListenrs() {
        btnsave.setOnClickListener(this);
        btnprogressdialog.setOnClickListener(this);
        buttondatepicker.setOnClickListener(this);
        btncustomdialog.setOnClickListener(this);
    }

    /**
     * Override onClick to perform clickoperation on button
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnsave:
                this.setDialog(); //call method setDialog to set the Dialog
                break;
            case R.id.btnprogressdialog:
                this.setprogressbarDialog(); // call the method setprogressbarDialog  to set progress
                break;
            case R.id.btncustomdialog:
                CustomlDialog customlDialog = new CustomlDialog(this);
                customlDialog.show();
                customlDialog.setCancelable(false);
                break;
            case R.id.buttondatepicker:
                DialogFragment dFragment = new DatepickerDialog(this);

                dFragment.getDialog();
                // Show the date picker dialog fragment
                dFragment.show(getFragmentManager(), "Date Picker" );

        }


    }

    /**
     * set the progress Dialog
     */
    private void setprogressbarDialog() {

        if(status){
            this.startprogressDialog();

        } else {

            this.resumeprogressDialog();

        }



    }

    private void resumeprogressDialog() {
        cancilable = false ;
        isCanceled = false ;
        progressDialog.show();
        progressDialog.setProgress(jumptime1);
        final Thread t = new Thread() {
            @Override
            public void run() {

                while(jumptime1 < progressDialog.getMax()) {
                    // Update the progress status
                    if(isCanceled || cancilable)
                    {
                        jumptime1 = jumptime1 ;
                        // Stop the operation/loop
                        break;
                    }

                    try {
                        sleep(300);
                        jumptime1 += 1;
                        progressDialog.setProgress(jumptime1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(jumptime1 == progressDialog.getMax()){
                    progressDialog.dismiss();
                    status= true ;
                }
            }
        };
        t.start();
    }

    private void startprogressDialog() {
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMax(100);
        progressDialog.setMessage("Its loading....");
        progressDialog.setTitle("ProgressDialog bar example");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setCancelable(true);
        cancilable = false ;
        isCanceled = false ;
        this.dilogListner(); //cal the dilogListner to set dilog Listner
        progressDialog.show(); //show the progress dialog
        // progressDoalog.setProgressDrawable(getDrawable(R.drawable.shape));
        this.progressdialogthread();
    }

    private void progressdialogthread() {
        final Thread t = new Thread() {
            @Override
            public void run() {
                jumpTime = 0;
                while(jumpTime < progressDialog.getMax()) {
                    if(isCanceled || cancilable)
                    {
                        jumptime1 = jumpTime ;
                        // Stop the operation/loop
                        break;
                    }

                    // Update the progress status
                    try {
                        sleep(300);
                        jumpTime += 1;
                        progressDialog.setProgress(jumpTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(jumpTime == progressDialog.getMax()){
                    progressDialog.dismiss();
                    status= true ;
                }
            }
        };
        t.start();
    }

    /**
     * set the dialog listner
     */
    private void dilogListner() {

        progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                Utils.printLog("","inside oncancel");
                cancilable = true ;
                progressDialog.dismiss();
                status =false ;
            }
        });
        // Put a cancel button in progress dialog
        progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener(){
            // Set a click listener for progress dialog cancel button
            @Override
            public void onClick(DialogInterface dialog, int which){
                // dismiss the progress dialog
                progressDialog.dismiss();
                // Tell the system about cancellation
                isCanceled = true ;
                status = false ;


            }
        });

    }

    /**
     * set the dialog
     */
    private void setDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this );//create AlertDialog reference
        builder.setTitle("Alert");    //set the Title to dialog
        builder.setCancelable(false); //set calcelable false
        builder.setIcon(R.drawable.male); //set icon to title
        builder.setMessage("do you want to save name"); //set the message

        //set OnClickListener on PositiveButton
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(MainActivity.this ,SecondActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("MESSAGE",edtname.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        //set OnClickListener on PositiveButton
        builder.setNeutralButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Utils.showToast(MainActivity.this," cancel is click");
            }
        });
        builder.show();
    }
}
