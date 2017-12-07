package com.chromeinfotech.stringoperation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.chromeinfotech.BaseActivity.BaseActivity;
import com.chromeinfotech.utils.Utils;

public class MainActivity extends BaseActivity implements View.OnClickListener{
    private TextView txtResult ;
    private EditText editText ;
    private Button btnreverse ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.reference();
        this.setListenrs();
    }

    @Override
    public void reference() {
        txtResult = (TextView) findViewById(R.id.txtResult);
        editText =(EditText) findViewById(R.id.editText);
        btnreverse =(Button) findViewById(R.id.btnreverse);
    }

    @Override
    public void setListenrs() {
        btnreverse.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnreverse:
                Utils.showToast(this,"btnclick");
                this.setinput();
                break;
        }
    }

    private void setinput() {
        MyString mystring = new MyString();
        String input =editText.getText().toString();
        mystring.Reverse(input);
    }
}
