package com.chromeinfotech.mapassignment;

import android.graphics.Bitmap;

/**
 * Created by user on 19/4/17.
 */

public class MyMarkaerData {

    public  double  latitude;
    public  double  longitude;
    public  String  title;
    public Bitmap iconbitmap ;

    public Bitmap getIconbitmap() {
        return iconbitmap;
    }

    public void setIconbitmap(Bitmap iconbitmap) {
        this.iconbitmap = iconbitmap;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}

