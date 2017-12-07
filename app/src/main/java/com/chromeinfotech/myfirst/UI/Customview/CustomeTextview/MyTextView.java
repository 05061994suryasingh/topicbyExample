package com.chromeinfotech.myfirst.UI.Customview.CustomeTextview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.chromeinfotech.myfirst.utils.Utils;

/**
 * Created by user on 16/2/17.
 */

public class MyTextView extends TextView {
    private String TAG = this.getClass().getSimpleName();
    private Typeface mTypeface;
    private Context context;

    /**
     * constructor
     * @param context
     */
    public MyTextView(Context context) {
        super(context);
        Utils.printLog(TAG  , "inside Mytextconstructor(Context context)");

        this.setColor();
        this.setFont();
        this.context = context;
        Utils.printLog(TAG  , "outside Mytextconstructor(Context context)");
    }

    /**
     * constructor
     * @param context
     * @param attrs
     */
    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Utils.printLog(TAG  , "inside Mytextconstructor(Context context, AttributeSet attrs)");
        this.setColor();
        this.setFont();
        Utils.printLog(TAG  , "outside MyTextView(Mytextconstructor(Context context, AttributeSet attrs)");
    }

    /**
     * constructor
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Utils.printLog(TAG  , "inside MyTextView(Context context, AttributeSet attrs, int defStyleAttr)");
        this.setColor();
        this.setFont();
        Utils.printLog(TAG  , "outside MyTextView(Context context, AttributeSet attrs, int defStyleAttr)");
    }

    /**
     * set the font of textview
     */
    public void setFont(){
        Utils.printLog(TAG  , "inside setfont()");
        mTypeface= Typeface.createFromAsset(getContext().getAssets(), "fonts/Roboto-BlackItalic.ttf");
        this.setTypeface(mTypeface);
        Utils.printLog(TAG  , "outside setfont()");

    }

    /**
     * set text and Background color of textview
     */
    public void setColor(){
        Utils.printLog(TAG  , "inside setColor()");
        this.setTextColor(Color.RED);
        this.setBackgroundColor(Color.BLUE);
        Utils.printLog(TAG  , "outside setColor()");

    }
}
