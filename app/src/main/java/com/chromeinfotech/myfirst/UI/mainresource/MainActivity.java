package com.chromeinfotech.myfirst.UI.mainresource;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.chromeinfotech.myfirst.R;
import com.chromeinfotech.myfirst.UI.AvtivityExample.ActivityDatapass;
import com.chromeinfotech.myfirst.UI.AvtivityExample.ImplicitIntent;
import com.chromeinfotech.myfirst.UI.AvtivityExample.MainFragementActivity;
import com.chromeinfotech.myfirst.UI.BaseActivity.BaseActivity;
import com.chromeinfotech.myfirst.UI.Customview.DynamicLinearLayout;
import com.chromeinfotech.myfirst.UI.Drawableanimation.Drawanimation;
import com.chromeinfotech.myfirst.UI.LogFile.LogFileActivity;
import com.chromeinfotech.myfirst.UI.Loginassignment.Login;
import com.chromeinfotech.myfirst.UI.Scrollview.Scrollview;
import com.chromeinfotech.myfirst.UI.SunAssignment.SunClockactivity;
import com.chromeinfotech.myfirst.UI.Widgets.RadioButtonControl;
import com.chromeinfotech.myfirst.UI.Widgets.WebViewControl;
import com.chromeinfotech.myfirst.UI.layouts.FrameLayout;
import com.chromeinfotech.myfirst.UI.layouts.Linearlayout;
import com.chromeinfotech.myfirst.UI.layouts.Relativelayout;
import com.chromeinfotech.myfirst.UI.layouts.TableLayout;
import com.chromeinfotech.myfirst.UI.serialization.MainSerialization;
import com.chromeinfotech.myfirst.utils.Utils;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private String TAG = this.getClass().getSimpleName();
    EditText editText1, editText2,editTextname;
    Button btnActTwo, btnAct,btnAct1,btnAct2,btnAct3,btnAct4,btnAct5,btnAct6,btnAct7,btnAct8,btnAct9,btnAct10,btnimplicitactivity,btnlog,btnSerializable,btnfragement;
    final int REQUEST_CODE_LOGIN = 2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Utils.printLog(TAG  , "inside onCreate()");

        reference();//calling the reference method
        setListenrs();//calling the listner method

        Utils.printLog(TAG  , "outside onCreate()");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        return super.onCreateOptionsMenu(menu);

    }
    @Override
    public void reference() {//overloading reference method
        Utils.printLog(TAG  , "inside reference()");

        // Here is code to go grab and layout the Buttons, they're named btnActTwo, btnAct,btnAct1,btnAct2,btnAct3; etc. and identified as such.     
        editText1           = (EditText) findViewById(R.id.editText1);
        editText2           = (EditText) findViewById(R.id.editText2);
        editTextname        = (EditText) findViewById(R.id.editTextname);
        btnActTwo           = (Button)   findViewById(R.id.buttonlinear);
        btnAct              = (Button)   findViewById(R.id.btnAct);
        btnAct1             = (Button)   findViewById(R.id.btnAct1);
        btnAct2             = (Button)   findViewById(R.id.btnAct2);
        btnAct3             = (Button)   findViewById(R.id.btnAct3);
        btnAct4             = (Button)   findViewById(R.id.btnAct4);
        btnAct5             = (Button)   findViewById(R.id.btnAct5);
        btnAct6             = (Button)   findViewById(R.id.btnAct6);
        btnAct7             = (Button)   findViewById(R.id.btnAct7);
        btnAct8             = (Button)   findViewById(R.id.btnAct8);
        btnAct9             = (Button)   findViewById(R.id.btnAct9);
        btnAct10            = (Button)   findViewById(R.id.btnAct10);
        btnimplicitactivity = (Button)   findViewById(R.id.btnimplicitactivity);
        btnSerializable     = (Button)   findViewById(R.id.btnSerializable);
        btnlog              = (Button)   findViewById(R.id.btnlog);
        btnfragement        = (Button)   findViewById(R.id.btnfragement);
        // Setup the listeners for the buttons, and the button handler      
        Utils.printLog(TAG  , "outside reference()");
    }

    @Override
    public void setListenrs() {
        Utils.printLog(TAG  , "inside setListenrs()");
        btnActTwo.setOnClickListener(this);
        btnAct.setOnClickListener(this);
        btnAct1.setOnClickListener(this);
        btnAct2.setOnClickListener(this);
        btnAct3.setOnClickListener(this);
        btnAct4.setOnClickListener(this);
        btnAct5.setOnClickListener(this);
        btnAct6.setOnClickListener(this);
        btnAct7.setOnClickListener(this);
        btnAct8.setOnClickListener(this);
        btnAct9.setOnClickListener(this);
        btnAct10.setOnClickListener(this);
        btnimplicitactivity.setOnClickListener(this);
        btnlog.setOnClickListener(this);
        btnSerializable.setOnClickListener(this);
        btnfragement.setOnClickListener(this);
        Utils.printLog(TAG  , "outside setListenrs()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Utils.printLog(TAG, "onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Utils.printLog(TAG, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Utils.printLog(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        Utils.printLog(TAG, "onPause()");

        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Utils.printLog(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Utils.printLog(TAG, "onDestroy()");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed
        Utils.printLog(TAG  , "inside onActivityResult()");
        if (requestCode == REQUEST_CODE_LOGIN) {

            switch (resultCode) {
                case RESULT_OK:
                    String message = data.getStringExtra("MESSAGE");
                    editText2.setText(message);
                    break;
                case RESULT_CANCELED:
                    editText2.setText("cancel");
                    break;
                default:
                    break;
            }

        }
        Utils.printLog(TAG  , "outside onActivityResult()");
    }

    //perform onclic operation on button
    @Override
    public void onClick(View v) {
        Utils.printLog(TAG  , "inside onClick()");
        switch(v.getId()) {

            // Now, which button did they press, and take me to that class/activity

            case R.id.btnAct:
                Intent intent = new Intent(MainActivity.this, Relativelayout.class);
                startActivity(intent);
                break;

            case R.id.buttonlinear:    //<<---- notice end line with colon, not a semicolon
                Intent intent1 = new Intent(MainActivity.this,Linearlayout.class);
                startActivity(intent1);
                break;

            case R.id.btnAct1:

                Intent intent2  = new Intent(MainActivity.this,ActivityDatapass.class);
                String message  = editText1.getText().toString();
                String message1 = editTextname.getText().toString();
                Bundle bundle   = new Bundle();
                if(message.equals("") || message1.equals(""))
                {
                    Utils.showToast(this,"please enter the value");
                }
                else {
                    bundle.putString("MESSAGE",message);
                    bundle.putString("MESSAGE1",message1);
                    intent2.putExtras(bundle);
                    //intent2.putExtra("MESSAGE", message);
                    startActivityForResult(intent2, REQUEST_CODE_LOGIN);//here i pass 2
                }
                break;
            case R.id.btnAct2:

                Intent intent3 = new Intent(MainActivity.this,FrameLayout.class);
                startActivity(intent3);
                break;
            case R.id.btnAct3:

                Intent intent4 = new Intent(MainActivity.this,TableLayout.class);
                startActivity(intent4);

                break;
            case R.id.btnAct4:

                Intent intent5 = new Intent(MainActivity.this,Login.class);
                startActivity(intent5);

                break;
            case R.id.btnAct5:

                Intent intent6 = new Intent(MainActivity.this,RadioButtonControl.class);
                startActivity(intent6);

                break;
            case R.id.btnAct6:

                Intent intent7 = new Intent(MainActivity.this,WebViewControl.class);
                startActivity(intent7);

                break;
            case R.id.btnAct7:

                Intent intent8 = new Intent(MainActivity.this,Scrollview.class);
                startActivity(intent8);

                break;
            case R.id.btnAct8:

                Intent intent9 = new Intent(MainActivity.this,DynamicLinearLayout.class);
                startActivity(intent9);

                break;
            case R.id.btnAct9:

                Intent intent10 = new Intent(MainActivity.this,Drawanimation.class);
                startActivity(intent10);

                break;
            case R.id.btnAct10:

                Intent intent11 = new Intent(MainActivity.this,SunClockactivity.class);
                startActivity(intent11);

                break;
            case R.id.btnimplicitactivity:

                Intent intent12 = new Intent(MainActivity.this,ImplicitIntent.class);
                startActivity(intent12);

                break;
            case R.id.btnlog:

                Intent intent13 = new Intent(MainActivity.this,LogFileActivity.class);
                startActivity(intent13);

                break;
            case R.id.btnSerializable:

                Intent intent14= new Intent(MainActivity.this,MainSerialization.class);
                startActivity(intent14);

                break;
            case R.id.btnfragement:

                Intent intent15= new Intent(MainActivity.this,MainFragementActivity.class);
                startActivity(intent15);

                break;
        }

        Utils.printLog(TAG  , "outside onClick()");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.action_add:
                Utils.showToast(this,"add is click");
                return(true);
            case R.id.action_reset:
                Utils.showToast(this,"reset is click");
                return(true);
            case R.id.action_about:
                Utils.showToast(this,"about is click");
                return(true);
            case R.id.action_exit:
                Utils.showToast(this,"finish is click");
                super.onDestroy();
                return(true);
        }
        return(super.onOptionsItemSelected(item));
    }
}
