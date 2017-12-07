package com.chromeinfotech.Ui.JsonparsingwithExpandablelistview;

import java.util.ArrayList;

/**
 * Created by user on 10/4/17.
 */

public class Advertisements {


    public int adID;
    public String adName;
    public boolean enabled;
    public int shopID;
    public String shopName;
    public String description;
    public String validUpTo;
    public  String createDate;
    public ArrayList<ImageList> images;

    public ArrayList<AdSchedules>shedules;
    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public  String updateDate;

    public ArrayList<ImageList> getImages() {
        return images;
    }

    public void setImages(ArrayList<ImageList> images) {
        this.images = images;
    }

    public ArrayList<AdSchedules> getShedules() {
        return shedules;
    }

    public void setShedules(ArrayList<AdSchedules> shedules) {
        this.shedules = shedules;
    }



    public int getAdID() {
        return adID;
    }

    public void setAdID(int adID) {
        this.adID = adID;
    }

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        this.adName = adName;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getShopID() {
        return shopID;
    }

    public void setShopID(int shopID) {
        this.shopID = shopID;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getValidUpTo() {
        return validUpTo;
    }

    public void setValidUpTo(String validUpTo) {
        this.validUpTo = validUpTo;
    }
}
