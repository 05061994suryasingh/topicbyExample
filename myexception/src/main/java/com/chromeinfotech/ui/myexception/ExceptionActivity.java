package com.chromeinfotech.ui.myexception;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.chromeinfotech.myexception.R;
import com.chromeinfotech.ui.BaseActivity.BaseActivity;
import com.chromeinfotech.ui.networkoperation.Exception.Emptyuri;
import com.chromeinfotech.ui.networkoperation.Exception.InvalidUri;
import com.chromeinfotech.ui.networkoperation.NetworkOperation;
import com.chromeinfotech.utils.Utils;

/**
 * ExceptionActivity check uri is valid or not on the basis of http and https
 */
public class ExceptionActivity extends BaseActivity implements View.OnClickListener {
    private Button btnclick;
    private EditText edituri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exception);

        this.reference();
        this.setListenrs();
    }

    /**
     * set the reference of editbox and button
     */
    @Override
    public void reference() {
        edituri  = (EditText) findViewById(R.id.edituri);
        btnclick = (Button) findViewById(R.id.btnclick);
    }

    /**
     * set the listner on buttonclick
     */
    @Override
    public void setListenrs() {
        btnclick.setOnClickListener(this);
    }

    /**
     * Override onClick on button press to check uri is valid or not if not valid then print exception message using toast
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnclick:
                this.sendUri();
                break;
        }
    }

    private void sendUri() {
        NetworkOperation  networkOperation=new NetworkOperation();
        String uri = edituri.getText().toString();
        Utils.printLog("tag","senduri");
        try {
            Utils.printLog("tag","inside try");
            networkOperation.doRequest(uri); //call the method of networkOperation class
        }
        catch (Emptyuri emptyuri) {
            Utils.printLog("tag","inside catch");
            Utils.showToast(this,emptyuri.toString());
        } catch (InvalidUri invalidUri) {
            Utils.showToast(this,invalidUri.toString());
        }
    }
}
