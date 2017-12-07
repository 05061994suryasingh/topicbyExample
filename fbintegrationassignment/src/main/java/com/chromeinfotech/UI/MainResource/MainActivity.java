package com.chromeinfotech.UI.MainResource;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.chromeinfotech.UI.BaseActivity.BaseActivity;
import com.chromeinfotech.UI.fbintegrationassignment.LoginActivity;
import com.chromeinfotech.fbintegrationassignment.R;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareButton;
import com.facebook.share.widget.ShareDialog;
import java.io.InputStream;
import java.util.Arrays;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private ShareDialog shareDialog;
    private   Toolbar toolbar ;
    private int counter = 0;
    private ShareButton shareButton;
    private   FloatingActionButton fab ;
    private Button logout , btnpoststatus , btnpostphoto , btndeletepost ;
    private  String name , surname , imageUrl ;
    private  TextView nameView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(this);
        setContentView(R.layout.activity_main);

        this.reference();
        this.init();
        this.setdata();
        this.setListenrs();
    }

    private void setdata() {

        Bundle inBundle = getIntent().getExtras();
        name       = inBundle.get("name").toString();
        surname    = inBundle.get("surname").toString();
        imageUrl   = inBundle.get("imageUrl").toString();
        nameView.setText("" + name + " " + surname);

        new MainActivity.DownloadImage((ImageView)findViewById(R.id.profileImage)).execute(imageUrl);

    }

    @Override
    public void init() {
        setSupportActionBar(toolbar);
        shareDialog =   new ShareDialog(this) ;
    }
    private void postStatusUpdate() {
        ShareLinkContent content = new ShareLinkContent.Builder()
                .setContentUrl(Uri.parse("https://google.com"))
                .build();
        LoginManager.getInstance().logInWithPublishPermissions(MainActivity.this , Arrays.asList("publish_actions"));
        shareDialog.show(content);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnpostphoto:

                postPhoto();
                break;
            case R.id.btnpoststatus:
                postStatusUpdate();
                break;

            case R.id.logout:
                logoutfb();
                break;
            case R.id.fab:
                postPhoto() ;
                break;
            case R.id.btndeletepost:
                deletePhoto() ;
                break;

        }
    }

    private void deletePhoto() {

    }

    public void postPhoto() {

        //check counter
        if(counter == 0) {
            //save the screenshot
            View rootView = findViewById(android.R.id.content).getRootView();
            rootView.setDrawingCacheEnabled(true);
            // creates immutable clone of image
            final Bitmap image =  BitmapFactory.decodeResource(getResources() , R.mipmap.ic_launcher) ;
            // destroy
            rootView.destroyDrawingCache();

            //share dialog
            AlertDialog.Builder shareDialog = new AlertDialog.Builder(this);
            shareDialog.setTitle("Share image");
            shareDialog.setMessage("Share image to Facebook?");
            shareDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    //share the image to Facebook
                    SharePhoto photo = new SharePhoto.Builder().setBitmap(image).build();
                    SharePhotoContent content = new SharePhotoContent.Builder().addPhoto(photo).build();
                    shareButton.setShareContent(content);
                    counter = 1;
                 shareButton.performClick();
                }
            });
            shareDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            shareDialog.show();
        }
        else {
            counter = 0;
            shareButton.setShareContent(null);
        }
    }

    private void logoutfb() {
        LoginManager.getInstance().logOut();
        Intent login = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(login);
        finish();
    }

    @Override
    public void reference() {
        toolbar         = (Toolbar) findViewById(R.id.toolbar);
        fab             = (FloatingActionButton) findViewById(R.id.fab);
        logout          = (Button)findViewById(R.id.logout);
        btnpostphoto    = (Button) findViewById(R.id.btnpostphoto);
        btnpoststatus   = (Button)findViewById(R.id.btnpoststatus);
        nameView        = (TextView)findViewById(R.id.nameAndSurname);
        shareButton     = (ShareButton) findViewById(R.id.share_btn);
        btndeletepost   = (Button) findViewById(R.id.btndeletepost);
    }

    @Override
    public void setListenrs() {
        fab.setOnClickListener(this);
        logout.setOnClickListener(this);
        btnpostphoto.setOnClickListener(this);
        btnpoststatus.setOnClickListener(this);
        btndeletepost.setOnClickListener(this);
    }

    public class DownloadImage extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImage(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }
        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}
