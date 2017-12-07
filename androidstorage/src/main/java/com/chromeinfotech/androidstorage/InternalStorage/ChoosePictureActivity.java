package com.chromeinfotech.androidstorage.InternalStorage;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.chromeinfotech.BaseActivity.BaseActivity;
import com.chromeinfotech.androidstorage.R;
import com.chromeinfotech.utils.Utils;
import com.soundcloud.android.crop.Crop;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

/**
 * Choose Picture from Gallery or click photo from camera and set it to imageview
 */
public class ChoosePictureActivity extends BaseActivity implements View.OnClickListener, View.OnTouchListener{

    private static final int REQUEST_CAMERA  = 0 ;
    private static final int REQUEST_GALLERY = 1 ;
    private ImageView ivImage ;
    private Button btnSelectPhoto ;
    Bitmap bmp;
    Bitmap alteredBitmap;
    Canvas canvas;
    Paint paint;
    Matrix matrix;
    float downx = 0;
    float downy = 0;
    float upx = 0;
    float upy = 0;
    Drawable image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_picture);
        this.reference();
        this.setListenrs();
    }

    /**
     * reference() method is used to set refernce of the widgets.
     */
    @Override
    public void reference() {

        ivImage = (ImageView) findViewById(R.id.ivImage) ;
        btnSelectPhoto = (Button) findViewById(R.id.btnSelectPhoto) ;

    }

    /**
     * reference() method is used to set Listner on  the widgets.
     */
    @Override
    public void setListenrs() {
        btnSelectPhoto.setOnClickListener(this);
        ivImage.setOnTouchListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSelectPhoto :
                this.selectImage() ;
                break;
        }
    }

    /**
     * selectImage call the galerry and camera intent
     */
    private void selectImage() {
        final CharSequence[] items = { "Take Photo", "Choose from Gallery",
                "Cancel" };

        AlertDialog.Builder builder = new AlertDialog.Builder(ChoosePictureActivity.this);
        builder.setTitle("Add Photo!");
        builder.setCancelable(false);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog , int item) {

                if (items[item].equals("Take Photo")) {

                    cameraIntent();

                } else if (items[item].equals("Choose from Gallery")) {
                    galleryIntent();
                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }


    private void beginCrop(Uri source) {
        Uri destination = Uri.fromFile(new File(getCacheDir(), "cropped"));
        Crop.of(source, destination).asSquare().start(this);
    }

    private void handleCrop(int resultCode, Intent result) {
        if (resultCode == RESULT_OK) {
            ivImage.setImageURI(Crop.getOutput(result));
        } else if (resultCode == Crop.RESULT_ERROR) {
            Toast.makeText(this, Crop.getError(result).getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    /**
     *galleryIntent startActivityForResult and pass request code
     */
    private void galleryIntent()
    {

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select File"),REQUEST_GALLERY);
    }

    /**
     *cameraIntent startActivityForResult and pass request code
     */
    private void cameraIntent()
    {        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_CAMERA);
    }

    /**
     * call method to set image ,help of request code
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == REQUEST_GALLERY){
                Utils.printLog("onActivityResult","if");
                Uri imageFileUri = data.getData();
                drawLine(imageFileUri);
            }
            else if (requestCode == REQUEST_CAMERA){
                Utils.printLog("onActivityResult","else if");

                drawLine(getImageUri(this,(Bitmap) data.getExtras().get("data"))) ;
            }
        }
    }

    public Uri getImageUri(Context context, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(context.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }


    private  void drawLine(Uri imageFileUri){
        Utils.printLog("onActivityResult","drawLine"+imageFileUri);
        try {
            BitmapFactory.Options bmpFactoryOptions = new BitmapFactory.Options();
            bmpFactoryOptions.inJustDecodeBounds = true;
            bmp = BitmapFactory.decodeStream(getContentResolver().openInputStream(
                    imageFileUri), null, bmpFactoryOptions);

            bmpFactoryOptions.inJustDecodeBounds = false;
            bmp = BitmapFactory.decodeStream(getContentResolver().openInputStream(
                    imageFileUri), null, bmpFactoryOptions);

            alteredBitmap = Bitmap.createBitmap(bmp.getWidth(), bmp
                    .getHeight(), bmp.getConfig());
            canvas = new Canvas(alteredBitmap);
            paint = new Paint();
            paint.setColor(Color.RED);
            paint.setStrokeWidth(10);
            matrix = new Matrix();
            canvas.drawBitmap(bmp, matrix, paint);

            ivImage.setImageBitmap(alteredBitmap);
            ivImage.setOnTouchListener(this);
        } catch (Exception e) {
            Log.v("ERROR", e.toString());
        }
    }
    /**
     * set clicked image to imageview f
     * @param data
     */
    private void onCaptureImageResult(Intent data) {
        Bitmap bitmapimage = (Bitmap) data.getExtras().get("data");
        ivImage.setImageBitmap(bitmapimage);
    }

    /**
     * select  image from galary and set into imageview
     * @param data
     */
    private void onSelectFromGalleryResult(Intent data) {

        Bitmap bm=null;
        if (data != null) {
            try {
                bm = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), data.getData());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ivImage.setImageBitmap(bm);
    }

    public boolean onTouch(View v, MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                downx = event.getX();
                downy = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                upx = event.getX();
                upy = event.getY();
                canvas.drawLine(downx, downy, upx, upy, paint);
                ivImage.invalidate();
                downx = upx;
                downy = upy;
                break;
            case MotionEvent.ACTION_UP:
                upx = event.getX();
                upy = event.getY();
                canvas.drawLine(downx, downy, upx, upy, paint);
                ivImage.invalidate();
                break;
            case MotionEvent.ACTION_CANCEL:
                break;
            default:
                break;
        }
        return true;
    }

}
