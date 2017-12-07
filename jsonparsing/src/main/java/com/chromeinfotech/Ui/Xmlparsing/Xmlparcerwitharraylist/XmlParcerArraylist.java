package com.chromeinfotech.Ui.Xmlparsing.Xmlparcerwitharraylist;

import android.os.Bundle;
import android.widget.TextView;
import com.chromeinfotech.Ui.BaseActivity.BaseActivity;
import com.chromeinfotech.jsonparsing.R;
import com.chromeinfotech.utils.Utils;
import java.io.InputStream;
import java.util.ArrayList;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class XmlParcerArraylist extends BaseActivity {

    private XmlPArcerHandler myxmlhandler = new  XmlPArcerHandler();
    private String TAG = this.getClass().getSimpleName();
    private TextView output ;
    String parsedData = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml_parcer_arraylist);

        Utils.printLog(TAG ,"inside onCreate()");

        this.reference();
        this.xmlparcer();
        this.setListenrs();

        Utils.printLog(TAG ,"inside onCreate()");
    }

    private void xmlparcer() {

        Utils.printLog(TAG ,"inside parsexml()");
        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    SAXParserFactory factory  = SAXParserFactory.newInstance();
                    SAXParser saxParser       = factory.newSAXParser();
                    InputStream inputstream   = getAssets().open("file.xml");
                    saxParser.parse(inputstream , myxmlhandler);
                    getStudentData();
                    Thread.sleep(5000);
                    runOnuiThread() ;

                } catch (Exception e) {
                    e.printStackTrace();
                }



            }
        };thread.start();

        Utils.printLog(TAG , "outside parsexml()");
    }

    private void runOnuiThread() {
        runOnUiThread(new Runnable() {

            @Override
            public void run() {
                output.setText(parsedData); //set the data into textview
            }
        });
    }

    private void getStudentData() {

        Utils.printLog(TAG ,"inside getStudentData()");

        ArrayList<Student> studentlist = myxmlhandler.getItemsList();
        for(int i=0;i < studentlist.size() ; i++){
            Student student = studentlist.get(i);
            parsedData = parsedData + "----------------------------------------\n";
            parsedData = parsedData + "name: " + student.getName() + "\n";
            parsedData = parsedData + "surname: " + student.getSurname() + "\n";
            parsedData = parsedData + "address: " + student.getAddress() + "\n";

            Utils.printLog(TAG ,"outside getStudentData()");

        }
    }

    @Override
    public void reference() {
        Utils.printLog(TAG ,"inside reference()");

        output = (TextView) findViewById( R.id.output) ;

        Utils.printLog(TAG ,"outside reference()");

    }

    @Override
    public void setListenrs() {

    }
}
