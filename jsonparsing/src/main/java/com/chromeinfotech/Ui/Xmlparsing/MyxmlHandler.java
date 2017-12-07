package com.chromeinfotech.Ui.Xmlparsing;

import android.widget.TextView;
import com.chromeinfotech.utils.Utils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by user on 4/4/17.
 */

public class MyxmlHandler extends DefaultHandler {

    private TextView textview1 ;
    private String TAG = this.getClass().getSimpleName();
    boolean name =false ,surname =false ,address =false ;

    public MyxmlHandler(TextView textview1){
        Utils.printLog(TAG  , "inside constructor()");
        this.textview1 = textview1 ;
        Utils.printLog(TAG  , "outside constructor()");
    }

    /**
     * Receive notification of the beginning of the document
     * @throws SAXException
     */
    @Override
    public void startDocument() throws SAXException {
        Utils.printLog(TAG  , "inside startDocument()");
        super.startDocument();
        Utils.printLog(TAG  , "outside startDocument()");
    }

    /**
     * Receive notification of the end of the document.
     * @throws SAXException
     */
    @Override
    public void endDocument() throws SAXException {
        Utils.printLog(TAG  , "inside endDocument()");
        super.endDocument();
        Utils.printLog(TAG  , "outside endDocument()");
    }

    /**
     *   When New XML Node initiating to parse this function called
     * @param uri
     * @param localName
     * @param qName
     * @param attributes
     * @throws SAXException
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        Utils.printLog(TAG  , "inside startElement()");

        if (qName.equalsIgnoreCase("name"))
        {
            name = true;
        }
        if (qName.equalsIgnoreCase("surname"))
        {
            surname = true;
        }
        if (qName.equalsIgnoreCase("address"))
        {
            address = true;
        }

        Utils.printLog(TAG  , "outside startElement()");
    }

    /**
     *  Finished reading the login tag, add it to arraylist
     * @param uri
     * @param localName
     * @param qName
     * @throws SAXException
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        Utils.printLog(TAG  , "inside startElement()");
        super.endElement(uri, localName, qName);

    }

    /**
     * Receive notification of character data inside an element.
     * @param ch
     * @param start
     * @param length
     * @throws SAXException
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        Utils.printLog(TAG  , "inside characters()");
        if (name) {
            textview1.setText(textview1.getText()+"\n\n Name : " + new String(ch, start, length));
            name = false;
        }
        if (surname) {
            textview1.setText(textview1.getText()+"\n Surname : " + new String(ch, start, length));
            surname = false;
        }
        if (address) {
            textview1.setText(textview1.getText()+"\n Address : " + new String(ch, start, length));
            address = false;
        }

        Utils.printLog(TAG  , "outside characters()");
    }
}
