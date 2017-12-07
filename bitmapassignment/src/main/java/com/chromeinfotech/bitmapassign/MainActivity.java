package com.chromeinfotech.bitmapassign;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.chromeinfotech.BaseActivity.BaseActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Button btnclick ;
    private ImageView imgfinal ,imgfinal1 ;
    private EditText edt_text ,edt_text1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.reference();
        this.setListenrs();
    }

    @Override
    public void reference() {

        btnclick = (Button) findViewById( R.id.btnclick) ;
        imgfinal = (ImageView) findViewById( R.id.imgfinal) ;
        imgfinal1 = (ImageView) findViewById( R.id.imgfinal1) ;
        edt_text = (EditText) findViewById( R.id.edt_text) ;
        edt_text1 = (EditText) findViewById( R.id.edt_text1) ;
    }

    @Override
    public void setListenrs() {

    btnclick.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
           case  R.id.btnclick:
               this.setBitmap();
            break ;
        }
    }

    private void setBitmap() {
        String text=edt_text.getText().toString();
        int width=edt_text.getMeasuredWidth();

        //background color red
        int color= Color.RED;
        Bitmap img=drawText(text, width, color);
        imgfinal.setImageBitmap(img);

        //background transparent
        int colorT=Color.TRANSPARENT;
        Bitmap img1=drawText(text,width,colorT);
        imgfinal1.setImageBitmap(img1);
    }

    private Bitmap drawText(String text, int textWidth, int color) {
        Bitmap b = null ;
        return b;

    }

    public Bitmap drawTextToBitmap(Context gContext,int gResId , String gText) {
        Bitmap bitmap = null ;

        return bitmap ;
    }
}
