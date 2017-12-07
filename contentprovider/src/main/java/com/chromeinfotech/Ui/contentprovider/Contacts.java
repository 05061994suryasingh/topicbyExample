package com.chromeinfotech.Ui.contentprovider;

import android.graphics.Bitmap;

/**
 * Created by user on 21/4/17.
 */

public class Contacts {
    public  String name ;
    public  Bitmap contactphoto ;
    public  String details ;

    public Bitmap getContactphoto() {
        return contactphoto;
    }

    public void setContactphoto(Bitmap contactphoto) {
        this.contactphoto = contactphoto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getphonenumber() {
        return details;
    }

    public void setphonenumber(String details) {
        this.details = details;
    }

}
