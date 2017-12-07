package com.chromeinfotech.Ui.JsonparsingwithExpandablelistview;

import java.util.ArrayList;

/**
 * Created by user on 10/4/17.
 */

public class BeaconInfo {

    int      beaconID;
    String   beaconName ;
    String   beaconUUID ;
    String   beaconVendor ;
    int      major ;
    int      minor;
    boolean  status ;
    double   latitude;
    double   longitude;

    public String getBeaconUUID() {
        return beaconUUID;
    }

    public void setBeaconUUID(String beaconUUID) {
        this.beaconUUID = beaconUUID;
    }

    public int getBeaconID() {
        return beaconID;
    }

    public void setBeaconID(int beaconID) {
        this.beaconID = beaconID;
    }

    public String getBeaconName() {
        return beaconName;
    }

    public void setBeaconName(String beaconName) {
        this.beaconName = beaconName;
    }

    public String getBeaconVendor() {
        return beaconVendor;
    }

    public void setBeaconVendor(String beaconVendor) {
        this.beaconVendor = beaconVendor;
    }

    public int getMajor() {
        return major;
    }

    public void setMajor(int major) {
        this.major = major;
    }

    public int getMinor() {
        return minor;
    }

    public void setMinor(int minor) {
        this.minor = minor;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public ArrayList<Advertisements> getItems() {
        return items;
    }

    public void setItems(ArrayList<Advertisements> items) {
        this.items = items;
    }


ArrayList<Advertisements> items = new ArrayList<>();

}
