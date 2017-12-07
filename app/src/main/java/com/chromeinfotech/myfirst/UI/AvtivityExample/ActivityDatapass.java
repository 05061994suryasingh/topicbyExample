package com.chromeinfotech.myfirst.UI.AvtivityExample;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.chromeinfotech.myfirst.R;
import com.chromeinfotech.myfirst.UI.BaseActivity.BaseActivity;
import com.chromeinfotech.myfirst.utils.Utils;

/**
 * ActivityDatapass receive number from main resource and after squaring send back to main resource
 */
public class ActivityDatapass extends BaseActivity{
    private Button btnAct ;
    private TextView textView2 ;
    private EditText editText1,editText2 ;
    private Bundle extras=null ;
    public int result,firstval,secondval ;
    final int RESULT_CODE_LOGIN = RESULT_OK ;
    private String TAG = this.getClass().getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        Log.i(TAG, "Info about activity_two."); // lig.i means print information
        Utils.printLog(TAG  , "inside onCreate()");
        this.reference(); //call the reference  to set the reference
        this.erorr();     //call error method to set eror msg to setText
        this.intentvalue(); // call intentvalue to get intentvalue from bundle
        this.setListenrs(); // call the setListenrs to set the listner

        Log.d(TAG, "SecondActivity: onCreate()");
        Utils.printLog(TAG  , "outside onCreate()");

    }

    /**
     * get value from bundle and set to edittext
     */
    @Override
    public  void intentvalue(){
        Utils.printLog(TAG  , "inside intentvalue()");
        extras         = getIntent().getExtras();
        String value   = extras.getString("MESSAGE");
        String value1  = extras.getString("MESSAGE1");
        firstval       = Integer.parseInt(value);
        secondval      = Integer.parseInt(value1);
        result         = firstval * secondval;
        editText1.setText(" "+ result);
        Utils.printLog(TAG  , "outside intentvalue()");
    }

    /**
     * genrate Exception to print simple log warning
     */
    private void erorr() {
        Utils.printLog(TAG  , "inside erorr()");
        extras       = getIntent().getExtras();
        String value = extras.getString("MESSAGE");
        firstval      = Integer.parseInt(value);
        try {
            Log.w(TAG,"use an another integer value instead of 0");
            result = firstval /0;

        }
        catch (Exception e) {
            Log.e( e.getClass().getName(), e.getMessage(), e.getCause());
            Log.e(TAG,"devide by zero");
        }
        Log.v(TAG,"after catch"); //log.v printing
        editText2.setText(" "+ result);
        Utils.printLog(TAG  , "outside erorr()");

    }

    /**
     * create the reference of button textview and edittext
     */
    @Override
    public  void reference()
    {
        Utils.printLog(TAG  , "inside reference()");
        textView2 = (TextView)findViewById(R.id.textView2);
        editText1 = (EditText)findViewById(R.id.editText1);
        editText2 = (EditText)findViewById(R.id.editText2);
        btnAct    = (Button) findViewById(R.id.btnAct);
        Utils.printLog(TAG  , "outside reference()");
    }

    /**
     * setOnClickListener on button
     */
    @Override
    public  void setListenrs()//perform intent operation put extra && add onclicklistner
    {
        Utils.printLog(TAG  , "inside setListenrs()");
        btnAct.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                Intent intent   = new Intent();
                String message2 = editText1.getText().toString();
                extras.putString("MESSAGE",message2);
                intent.putExtras(extras);
                setResult(RESULT_CODE_LOGIN,intent);
                finish();

            }});
        Utils.printLog(TAG  , "outside setListenrs()");
    }

    /**
     * overloading onRestart method of Activity
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "SecondActivity: onRestart()");
    }

    /**
     * overloading onStart method of Activity
     */
    @Override
    protected void onStart() {//overloading onstart method
        super.onStart();
        Log.d(TAG, "SecondActivity: onStart()");
    }

    /**
     * overloading onResume method of Activity
     */
    @Override
    protected void onResume() {//overloading onResume method
        super.onResume();
        Log.d(TAG, "SecondActivity: onResume()");
    }

    /**
     * overloading onPause method of Activity
     */
    @Override
    protected void onPause() {//overloading onpause method
        super.onPause();
        Log.d(TAG, "SecondActivity: onPause()");
    }

    /**
     * overloading onStop method of Activity
     */
    @Override
    protected void onStop() {//overloading onstop method
        super.onStop();
        Log.d(TAG, "SecondActivity: onStop()");
    }

    /**
     * overloading onDestroy method of Activity
     */
    @Override
    protected void onDestroy() {//overloading ondestory method
        super.onDestroy();
        Log.d(TAG, "SecondActivity: onDestroy()");
        Log.v(TAG," serive is destroy and retun  to main activity");
    }

}


