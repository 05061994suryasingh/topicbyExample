package com.chromeinfotech.myfirst.UI.Loginassignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.chromeinfotech.myfirst.UI.Widgets.RadioButtonControl;
import com.chromeinfotech.myfirst.R;
import com.chromeinfotech.myfirst.UI.BaseActivity.BaseActivity;
import com.chromeinfotech.myfirst.utils.Utils;

public class Login extends BaseActivity implements View.OnClickListener{
    private Button Loginbtn,Signupbtn;
    private String TAG = this.getClass().getSimpleName();
    private EditText edtEmail ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Utils.printLog(TAG  , "inside onCreate()");
        this.reference();//calling the reference method
        this.setListenrs();//calling the listner method
        Utils.printLog(TAG  , "outside onCreate()");

    }


    @Override
    public void onClick(View v) {
        Utils.printLog(TAG  , "inside onClick()");
        switch (v.getId()) {

            // Now, which button did they press, and take me to that class/activity
            case R.id.Loginbtn:
                Intent intent = new Intent(Login.this, RadioButtonControl.class);
                startActivity(intent);
                break;
            case R.id.Signupbtn:
                Intent intent1 = new Intent(Login.this, Sign_up.class);
                startActivity(intent1);
                break;


        }
        Utils.printLog(TAG  , "outside onClick()");
    }
    @Override
    public void reference() {
        Utils.printLog(TAG  , "inside reference()");
        edtEmail   = (EditText) findViewById(R.id.edtEmail)  ;
        Loginbtn  = (Button) findViewById(R.id.Loginbtn);
        Signupbtn = (Button) findViewById(R.id.Signupbtn);
        Utils.printLog(TAG  , "outside reference()");
    }

    @Override
    public void setListenrs() {
        Utils.printLog(TAG  , "inside setListenrs()");
        Loginbtn.setOnClickListener(this);
        Signupbtn.setOnClickListener(this);
      //  edtEmail.addTextChangedListener(new FourDigitCardFormatWatcher());
        edtEmail.addTextChangedListener(new HyphenDelimitTextWatcher(edtEmail));
        Utils.printLog(TAG  , "outside setListenrs()");
    }
}
