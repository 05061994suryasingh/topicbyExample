package com.chromeinfotech.ui.actionbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.chromeinfotech.actionbar.R;
import com.chromeinfotech.ui.BaseActivity.BaseActivity;

/**
 * Actionbar extends BaseActivity and perform operation like show ,hide toolbar
 */
public class Actionbar extends BaseActivity implements View.OnClickListener{
    private Button btnactivitytwo , showactionbar , hideactionbar ;
    private  Toolbar toolbar ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar);

        this.reference(); //cal reference to set the reference
        setSupportActionBar(toolbar); //set the toolbar
        this.setListenrs(); // set the listner on buttonclick

    }

    /**
     * Override  onCreateOptionsMenu  to create menu
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher); //set actonbar logo
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        return(true);
    }

    /**
     * perform click  operation on actionbar item
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home:
                Toast.makeText(this,"it  is a first activity,so we can not go back ",Toast.LENGTH_LONG).show();
                return true;
            case R.id.Share:
                Toast.makeText(this,"share is clicked",Toast.LENGTH_LONG).show();
                this.doshare();
                return(true);
            case R.id.Search:
                Toast.makeText(this,"Search is clicked",Toast.LENGTH_LONG).show();

                return(true);
            case R.id.about:
                Toast.makeText(this,"about is clicked",Toast.LENGTH_LONG).show();
                return(true);
            case R.id.exit:
                this.finish();
                return(true);
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * share operation on share icon on actionbar
     */
    private void doshare() {
        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.setType("image/*");
        Intent chooser = Intent.createChooser(sendIntent, "Choose share option");
        startActivity(chooser);
    }

    /**
     * perform onclick on button
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            // Now, which button did they press, and take me to that class/activity

            case R.id.btnactivitytwo:
                Intent intent = new Intent(Actionbar.this, Second.class);
                startActivity(intent);
                break;
            case R.id.showactionbar:
                this.showActionBar();
                break;
            case R.id.hideactionbar:
                this.hideActionBar();
                break;
        }
    }

    /**
     * hide the actionbar
     */
    private void hideActionBar() {

        getSupportActionBar().hide();

    }

    /**
     * show the actionbar
     */
    private void showActionBar() {

        getSupportActionBar().show();
    }

    /**
     * create the reference
     */
    @Override
    public void reference() {

        btnactivitytwo = (Button) findViewById(R.id.btnactivitytwo);
        showactionbar = (Button) findViewById(R.id.showactionbar);
        hideactionbar = (Button) findViewById(R.id.hideactionbar);
        toolbar = (Toolbar) findViewById(R.id.toolbar);


    }

    /**
     * set the listner
     */
    @Override
    public void setListenrs() {

        btnactivitytwo.setOnClickListener(this);
        showactionbar.setOnClickListener(this);
        hideactionbar.setOnClickListener(this);

    }
}

