package com.chromeinfotech.Ui.Xmlparsing;

import android.os.Bundle;
import android.widget.TextView;
import com.chromeinfotech.Ui.BaseActivity.BaseActivity;
import com.chromeinfotech.jsonparsing.R;
import com.chromeinfotech.utils.Utils;
import java.io.InputStream;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class MyXmlParserActivity extends BaseActivity {

    private String TAG = this.getClass().getSimpleName();
    private TextView  textView1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_may_xml_parser);

        Utils.printLog(TAG ,"inside onCreate()");

        this.reference();
        this.parsexml();
        //this.setListenrs();

        Utils.printLog(TAG ,"outside onCreate()");
    }

    /**
     * parsexml with SAXParserFactory
     */
    private void parsexml() {

        Utils.printLog(TAG ,"inside parsexml()");
        Thread thread = new Thread(){
            @Override
            public void run() {
                try {

                    SAXParserFactory factory  = SAXParserFactory.newInstance();
                    SAXParser saxParser       = factory.newSAXParser();
                    MyxmlHandler myxmlhandler = new  MyxmlHandler(textView1);
                    InputStream inputstream   = getAssets().open("file.xml");
                    saxParser.parse(inputstream , myxmlhandler);
                    Thread.sleep(5000) ;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } ;thread.start();

        Utils.printLog(TAG , "outside parsexml()");
    }

    /**
     * Set the references from the widgets
     */
    @Override
    public void reference() {

        Utils.printLog(TAG , "inside reference()");
        textView1 = (TextView) findViewById(R.id.textView1);
        Utils.printLog(TAG , "outside reference()");
    }

    /**
     * set listner
     */
    @Override
    public void setListenrs() {
        Utils.printLog(TAG , "inside reference()");

        Utils.printLog(TAG , "outside reference()");
    }
}
