package com.chromeinfotech.Ui.Xmlparsing.Xmlparcerwitharraylist;

import com.chromeinfotech.utils.Utils;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;


/**
 * Created by user on 4/4/17.
 */

public class XmlPArcerHandler extends DefaultHandler{

    private ArrayList<Student> list= new ArrayList<Student>();
    private boolean currentElement =false ;
    private String currentValue ;
    private String TAG = this.getClass().getSimpleName();
    private Student student = null;

    /**
     * return the student list
     * @return
     */
    public ArrayList<Student> getItemsList() {
        return list;
    }

    /**
     * Receive notification of the beginning of the document
     * @throws SAXException
     */
    @Override
    public void startDocument() throws SAXException {
        // Create ArrayList To Store Student object

    }

    /**
     * Receive notification of the end of the document.
     * @throws SAXException
     */
    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
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

        Utils.printLog(TAG ,"inside startElement()");
        currentElement = true;
        currentValue = "";
        if (localName.equals("Student")) {
            student = new Student();
        }
        Utils.printLog(TAG ,"outside startElement()");
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

        Utils.printLog(TAG ,"inside endElement()");

        currentElement = false;
        /** set value */
        if (localName.equalsIgnoreCase("name"))
            student.setName(currentValue);
        else if (localName.equalsIgnoreCase("surname"))
            student.setSurname(currentValue);
        else if (localName.equalsIgnoreCase("address"))
            student.setAddress(currentValue);
        else if (localName.equalsIgnoreCase("Student"))
            list.add(student);

        Utils.printLog(TAG ,"outside endElement()");
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

        Utils.printLog(TAG ,"inside characters()");
        // Read the characters and append them to the currentValue string
        if (currentElement) {
            currentValue = currentValue +  new String(ch, start, length);
        }

        Utils.printLog(TAG ,"outside characters()");
    }
}
