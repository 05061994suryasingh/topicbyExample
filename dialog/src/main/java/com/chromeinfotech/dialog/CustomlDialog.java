package com.chromeinfotech.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * custom dialog extends Dialog and set title msg and button to customDialog
 */

public class CustomlDialog extends Dialog implements View.OnClickListener ,DialogInterface{
    private Activity activity;
    public Button btnyes , btnno ;
    private TextView   txtmsg , txttitle ;
    public ImageView imgcansil ;

    /**
     * constructor
     * @param activity
     */
    protected CustomlDialog(Activity activity) {
        super(activity);
        this.activity= activity ;

    }

    /**
     * Override onCreate to setview
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custome_dialog);
        this.setReference();//set Reference
        this.setLstner();   //set listner to btnyes and btnno
    }

    /**
     * set the references
     */
    private void setReference() {
        txttitle = (TextView) findViewById(R.id.txttitle);
        txtmsg = (TextView) findViewById(R.id.txtmsg);
        btnyes = (Button) findViewById(R.id.btnyes);
        btnno = (Button) findViewById(R.id.btnno);
        imgcansil = (ImageView) findViewById(R.id.imgcansil);

    }

    /**
     * set the listner
     */
    private void setLstner() {
        //btnno.setOnClickListener(this);
        //btnyes.setOnClickListener(this);
        imgcansil.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnyes:
                activity.finish(); //close the Activity
                break;
            case R.id.btnno:
                dismiss(); //close the dialog
                break;
            case R.id.imgcansil:
                dismiss(); //close the dialog
                break;
            default:
                break;
        }
        dismiss();
    }

    /**
     * set the own title
     * @param title
     */
    @Override
    public void setTitle(String title) {
        txttitle.setText(title);
    }

    /**
     * set the action message
     * @param message
     */
    @Override
    public void setActionMessage(String message) {
        txtmsg.setText(message);
    }

    /**
     * set the titleicon
     * @param iconId
     */
    @Override
    public void titleicom( int iconId) {


    }

    /**
     * set the Actionbuttonname
     * @param btnpositive
     * @param btnnegative
     */
    @Override
    public void setActionButtonname(String btnpositive, String btnnegative) {
        btnyes.setText(btnpositive);
        btnno.setText(btnnegative);
    }


}
