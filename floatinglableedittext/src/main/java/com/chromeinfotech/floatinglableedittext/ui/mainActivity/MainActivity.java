package com.chromeinfotech.floatinglableedittext.ui.mainActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.design.widget.TextInputLayout;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.chromeinfotech.floatinglableedittext.R;
import com.chromeinfotech.floatinglableedittext.ui.BaseActivity.BaseActivity;

import java.lang.reflect.Field;

public class MainActivity extends BaseActivity implements View.OnFocusChangeListener {

    private TextInputLayout input_layout_name, input_layout_password,input_layout_email, til;
    private EditText input_email, input_name ,input_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reference();
        setListenrs();
    }



    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        switch (v.getId()) {
            case R.id.input_email:
                til = input_layout_email;
                Log.d("onFocusChange", "username");
                if (!hasFocus) {
                    Log.d("username", "Username");
                    setInputTextLayoutColor(Color.GRAY);
                    if(!input_email.getText().toString().equals("")) {
                        Log.d("username", "if,if");
                        input_email.setHintTextColor(Color.BLACK);
                        setInputTextLayoutColor(Color.BLACK);
                    }
                }
                else {
                    Log.d("username", "else");
                    setInputTextLayoutColor(Color.GREEN);
                }
                break;

            case R.id.input_name:
                til = input_layout_name;
                Log.d("onFocusChange", "password");
                if (!hasFocus) {
                    setInputTextLayoutColor(Color.GRAY);
                    Log.d("password", "if");
                    if(!input_name.getText().toString().equals("")) {
                        Log.d("username", "if,if");
                        til = input_layout_name;
                        setInputTextLayoutColor(Color.BLACK);
                    }
                }
                else {
                    Log.d("password", "else");
                    setInputTextLayoutColor(Color.GREEN);
                }
                break;
            case R.id.input_password:
                til = input_layout_password;
                Log.d("onFocusChange", "password");
                if (!hasFocus) {
                    setInputTextLayoutColor(Color.GRAY);
                    Log.d("password", "if");
                    if(!input_password.getText().toString().equals("")) {
                        Log.d("username", "if,if");
                        til = input_layout_password;
                        setInputTextLayoutColor(Color.BLACK);
                    }
                }
                else {
                    Log.d("password", "else");
                    setInputTextLayoutColor(Color.GREEN);
                }
                break;

        }

    }



    public void setInputTextLayoutColor( @ColorInt int color) {

        try {
            Field fDefaultTextColor = TextInputLayout.class.getDeclaredField("mDefaultTextColor");
            fDefaultTextColor.setAccessible(true);
            fDefaultTextColor.set(til, new ColorStateList(new int[][]{{0}}, new int[]{color}));

            Field fFocusedTextColor = TextInputLayout.class.getDeclaredField("mFocusedTextColor");
            fFocusedTextColor.setAccessible(true);
            fFocusedTextColor.set(til, new ColorStateList(new int[][]{{0}}, new int[]{color}));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void reference() {
        input_layout_name      = (TextInputLayout) findViewById(R.id.input_layout_name);
        input_layout_password  = (TextInputLayout) findViewById(R.id.input_layout_password);
        input_layout_email     = (TextInputLayout) findViewById(R.id.input_layout_email);
        input_email            = (EditText) findViewById(R.id.input_email);
        input_name             = (EditText) findViewById(R.id.input_name);
        input_password         = (EditText) findViewById(R.id.input_password);
    }

    @Override
    public void setListenrs() {
        input_email.setOnFocusChangeListener(this);
        input_name.setOnFocusChangeListener(this);
        input_password.setOnFocusChangeListener(this);
    }
}
