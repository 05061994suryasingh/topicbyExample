package com.chromeinfotech.twitterintegration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.chromeinfotech.BaseActivity.BaseActivity;
import com.twitter.sdk.android.core.identity.TwitterAuthClient;

/**
 * Perform Twitter Login and Logout.
 */
public class MainActivity extends BaseActivity implements View.OnClickListener{

    private Button btnLogout ,btnLogin;
    private TextView status;
    private TwitterManager twitterManager ;
    private TwitterAuthClient mTwitterAuthClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.reference();
        this.init();
        this.setListenrs();

    }

    /**
     * Initialization perform
     */
    @Override
    public void init() {
        twitterManager     = new TwitterManager(this);
        mTwitterAuthClient = new TwitterAuthClient();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mTwitterAuthClient.onActivityResult(requestCode, resultCode, data);
    }

    /**
     * Set the references from the widgets
     */
    @Override
    public void reference() {
        status      = (TextView)findViewById(R.id.status);
        btnLogout   = (Button) findViewById(R.id.btn_logout) ;
        btnLogin    = (Button) findViewById(R.id.btn_login) ;

    }

    /**
     * set Listner on the view
     */
    @Override
    public void setListenrs() {
        btnLogout.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
    }

    /**
     * called when a  view has been clicked
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                twitterManager.twitterLogin();
                break ;
            case R.id.btn_logout:
                twitterManager.twitterLogout();
                break;
        }
    }
}
