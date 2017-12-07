package com.chromeinfotech.myfirst.UI.Customview;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chromeinfotech.myfirst.R;
import com.chromeinfotech.myfirst.UI.BaseActivity.BaseActivity;
import com.chromeinfotech.myfirst.utils.Utils;

public class DynamicLinearLayout extends BaseActivity  implements View.OnClickListener{
    private String TAG = this.getClass().getSimpleName();
    private LinearLayout linearlayout=null;
    private Button buttonadd,buttonRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_linear_layout);

        Utils.printLog(TAG  , "inside oncreate()");

        this.reference();
        this.setListenrs();

        Utils.printLog(TAG  , "outside setColor()");
    }

    /**
     * Set the references from the widgets
     */
    @Override
    public void reference() {
        Utils.printLog(TAG  , "inside reference()");
        linearlayout       = (LinearLayout) findViewById(R.id.linearlayout);
        buttonadd          = (Button)       findViewById(R.id.buttonadd);
        buttonRemove       = (Button)       findViewById(R.id.buttonRemove);
        Utils.printLog(TAG  , "outside reference()");
    }

    /**
     * set listner on Button
     */
    @Override
    public void setListenrs() {
        Utils.printLog(TAG  , "inside setListenrs()");
        buttonadd.setOnClickListener(this);
        buttonRemove.setOnClickListener(this);
        Utils.printLog(TAG  , "outside setListenrs()");

    }

    /**
     * Called when a view has been clicked.
     * @param v
     */
    @Override
    public void onClick(View v) {
        Utils.printLog(TAG  , "inside onClick() ");

        switch(v.getId()) {
            case R.id.buttonadd:
                this.addView();
                break;
            case R.id.buttonRemove:
                this.removeView();
                break;
        }
        Utils.printLog(TAG  , "outside onClick()");

    }

    /**
     * add  the view to layout
     */
    private void addView(){
        Utils.printLog(TAG  , "inside addView() ");
        int numberOfItems = linearlayout.getChildCount();
        if(numberOfItems < 100) {
            TextView rowTextView = new TextView(this);
            rowTextView.setText("This is row " + System.currentTimeMillis());
            linearlayout.addView(rowTextView);
        }else{
            Utils.showToast(this , "Limit cross");
        }
        Utils.printLog(TAG  , "outside addView() ");
    }

    /**
     * Remove  the view from layout
     */
    private void removeView(){
        Utils.printLog(TAG  , "inside removeView() ");
        int numberOfItems = linearlayout.getChildCount();
        if(numberOfItems >= 1) {
            linearlayout.removeViewAt(numberOfItems - 1);
        }else{
            Utils.showToast(this , "No item available in the list.");
        }
        Utils.printLog(TAG  , "outside removeView() ");
    }
}
