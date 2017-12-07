package com.chromeinfotech.Ui.JsonparsingwithExpandablelistview;

/**
 * Created by user on 10/4/17.
 */

public class AdSchedules {

    public int adScheduleid;
    public int adID;
    public long startDate;
    public long endDate;

    public long getEndDate() {
        return endDate;
    }

    public int getAdScheduleid() {
        return adScheduleid;
    }

    public int getAdID() {
        return adID;
    }

    public long getStartDate() {
        return startDate;
    }

    public void setAdScheduleid(int adScheduleid) {
        this.adScheduleid = adScheduleid;
    }

    public void setAdID(int adID) {
        this.adID = adID;
    }

    public void setEndDate(long endDate) {
        this.endDate = endDate;
    }

    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }
}

