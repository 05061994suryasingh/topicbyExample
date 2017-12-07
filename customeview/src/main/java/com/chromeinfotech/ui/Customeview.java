package com.chromeinfotech.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.chromeinfotech.ui.BaseActivity.BaseActivity;
import com.chromeinfotech.customeview.R;
import com.chromeinfotech.ui.Exception.myException;
import com.chromeinfotech.utils.Utils;

/**
 *
 */
public class Customeview extends BaseActivity implements View.OnClickListener{

    private LinearLayout linearlayout = null;
    private Button btnadd , btnremove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customeview);

        this.reference();//calling the method reference
        this.setListenrs();//calling the method setListeners

    }

    //Override the onclick() method of view.OnClickListener
    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btnadd:
                this.addView(this.getview());
                break;
            case R.id.btnremove:
                this.generateException();
                break;
        }
    }

    //declare a method that generate an Exception when no view available in linear layout
    private void generateException() {
        try {
            this.removeView();
        }catch (myException e){
            Utils.showToast(this,e.toString());
        }
    }

    //create view and return view to addview()
    private View getview() {

        View view = getLayoutInflater().inflate(R.layout.itemlayout,linearlayout,false);//create view reference

        final Button buttonclick = (Button) view.findViewById(R.id.buttonclick);//crete button Reference
        buttonclick.setTag(1);//set Tag to button buttonclick
        buttonclick.setText("play");

        final EditText edittext = (EditText) view.findViewById(R.id.edittext);

        buttonclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = edittext.getText().toString();
                if(msg.isEmpty()){
                    Utils.showToast(Customeview.this, "plz enter the value in editbox");
                } else {
                    Utils.showToast(Customeview.this, edittext.getText().toString());

                    final int status = (Integer) v.getTag();
                    if (status == 1) {
                        this.resetButton();
                        buttonclick.setText("stop");
                        v.setTag(0);
                    } else {
                        buttonclick.setText("play");
                        v.setTag(1);
                    }
                }
            }

            //Reset the Button text add set all button text to play
            private void resetButton() {
                Utils.printLog("Customeview","in resetButton");
                int childCount = linearlayout.getChildCount();
                for (int i = 0; i < childCount ; ++i ) {
                    View view = linearlayout.getChildAt(i);
                    Button buttonclick = (Button) view.findViewById(R.id.buttonclick);
                    buttonclick.setText("play");
                    buttonclick.setTag(1);
                }
            }
        });
        return view;
    }

    //add view to linear layout
    private void addView( View view) {
        int numberOfItems = linearlayout.getChildCount();
        if(numberOfItems < 20) {
            linearlayout.addView(view);
        }
        else{
            Utils.showToast(this , "Limit cross");
        }
    }

    //remove view from linear layout
    private void removeView()  throws myException {
        int numberOfItems = linearlayout.getChildCount();
        if(numberOfItems <= 0) {
            throw new myException("No item available in the list!");
        }else {
            linearlayout.removeViewAt(numberOfItems - 1);
        }
    }

    //overload the reference method of BaseActivity and create reference inside the function
    @Override
    public void reference() {
        linearlayout   = (LinearLayout) findViewById(R.id.linearlayout);
        btnadd         = (Button) findViewById(R.id.btnadd);
        btnremove      = (Button) findViewById(R.id.btnremove);
    }


    //overload the setListner method to set listner
    @Override
    public void setListenrs() {
        btnadd.setOnClickListener(this);//add onClickListner on btnadd
        btnremove.setOnClickListener(this);//add onClickListner on btnremove
    }
}
