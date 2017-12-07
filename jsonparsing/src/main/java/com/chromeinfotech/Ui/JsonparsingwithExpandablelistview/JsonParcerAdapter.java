package com.chromeinfotech.Ui.JsonparsingwithExpandablelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import com.chromeinfotech.jsonparsing.R;
import java.util.ArrayList;
import java.util.List;

/**
 *set the data
 */

public class JsonParcerAdapter extends BaseExpandableListAdapter {

    private List<BeaconInfo> beaconInfoList = null;
    private Context context;
    private ArrayList<ImageList> adImages;
    private ArrayList<AdSchedules> adSchedules;
    private ViewHolder viewHolder = null;
    private ViewHolder1 viewHolder1;
    private LayoutInflater layoutInflater;

    class ViewHolder{
        TextView id ;
        TextView name;
        TextView uuID;
        TextView vendor;
        TextView major;
        TextView minor;
        TextView status;
        TextView latitude;
        TextView longitude;
    }

    class ViewHolder1{
        TextView adID;
        TextView adName;
        TextView enabled;
        TextView shopID;
        TextView shopName;
        TextView description;
        TextView validUpTo;
        TextView createDate;
        TextView updateDate;
        TextView adSchedules, adScheduleId, adId, startDate, endDate;

    }

    public JsonParcerAdapter(Context con,LayoutInflater inflater, List<BeaconInfo> beaconInfoList){
        context = con;
        layoutInflater = inflater;
        this.beaconInfoList = beaconInfoList;

    }

    @Override
    public int getGroupCount() {
        return beaconInfoList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return beaconInfoList.get(groupPosition).getItems().size();


    }

    @Override
    public Object getGroup(int groupPosition) {
        return beaconInfoList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return beaconInfoList.get(groupPosition).getItems();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return groupPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        if(convertView == null) {
            convertView          = LayoutInflater.from(context).inflate(R.layout.cell_layout, parent, false);
            viewHolder           = new ViewHolder();
            viewHolder.id        = (TextView) convertView.findViewById(R.id.tv_beaconID);
            viewHolder.name      = (TextView) convertView.findViewById(R.id.tv_beaconName);
            viewHolder.uuID      = (TextView) convertView.findViewById(R.id.tv_beaconUUID);
            viewHolder.vendor    = (TextView) convertView.findViewById(R.id.tv_beaconVendor);
            viewHolder.major     = (TextView) convertView.findViewById(R.id.tv_major);
            viewHolder.minor     = (TextView) convertView.findViewById(R.id.tv_minor);
            viewHolder.status    = (TextView) convertView.findViewById(R.id.tv_status);
            viewHolder.latitude  = (TextView) convertView.findViewById(R.id.tv_latitude);
            viewHolder.longitude = (TextView) convertView.findViewById(R.id.tv_longitude);

            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.id.setText(String.valueOf(beaconInfoList.get(groupPosition).getBeaconID()));
        viewHolder.name.setText(beaconInfoList.get(groupPosition).getBeaconName());
        viewHolder.uuID.setText(beaconInfoList.get(groupPosition).getBeaconUUID());
        viewHolder.vendor.setText(beaconInfoList.get(groupPosition).getBeaconVendor());
        viewHolder.major.setText(String.valueOf(beaconInfoList.get(groupPosition).getMajor()));
        viewHolder.minor.setText(String.valueOf(beaconInfoList.get(groupPosition).getMinor()));
        viewHolder.status.setText(String.valueOf(beaconInfoList.get(groupPosition).isStatus()));
        viewHolder.latitude.setText(String.valueOf(beaconInfoList.get(groupPosition).getLatitude()));
        viewHolder.longitude.setText(String.valueOf(beaconInfoList.get(groupPosition).getLongitude()));


        return convertView;
    }


    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        if(convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.ads_layout, parent, false);
            viewHolder1 = new ViewHolder1();
            viewHolder1.adID          = (TextView) convertView.findViewById(R.id.adID);
            viewHolder1.adName        = (TextView) convertView.findViewById(R.id.adName);
            viewHolder1.enabled       = (TextView) convertView.findViewById(R.id.enabled);
            viewHolder1.shopID        = (TextView) convertView.findViewById(R.id.shopID);
            viewHolder1.shopName      = (TextView) convertView.findViewById(R.id.shopName);
            viewHolder1.description   = (TextView) convertView.findViewById(R.id.description);
            viewHolder1.validUpTo     = (TextView) convertView.findViewById(R.id.validUpTo);
            viewHolder1.createDate    = (TextView) convertView.findViewById(R.id.createDate);
            viewHolder1.updateDate    = (TextView) convertView.findViewById(R.id.updateDate);
            viewHolder1.adSchedules   = (TextView) convertView.findViewById(R.id.adSchedules);
            viewHolder1.adScheduleId  = (TextView) convertView.findViewById(R.id.adScheduleId);
            viewHolder1.adId          = (TextView) convertView.findViewById(R.id.adId);
            viewHolder1.startDate     = (TextView) convertView.findViewById(R.id.startDate);
            viewHolder1.endDate       = (TextView) convertView.findViewById(R.id.endDate);
            convertView.setTag(viewHolder1);
        }
        else{
            viewHolder1 = (ViewHolder1) convertView.getTag();
        }

        viewHolder1.adID.setText(String.valueOf(beaconInfoList.get(groupPosition).getItems().get(childPosition).getAdID()));
        viewHolder1.adName.setText(beaconInfoList.get(groupPosition).getItems().get(childPosition).getAdName());
        viewHolder1.enabled.setText(String.valueOf(beaconInfoList.get(groupPosition).getItems().get(childPosition).isEnabled()));
        viewHolder1.shopID.setText(String.valueOf(beaconInfoList.get(groupPosition).getItems().get(childPosition).getShopID()));
        viewHolder1.shopName.setText(beaconInfoList.get(groupPosition).getItems().get(childPosition).getShopName());
        viewHolder1.description.setText(beaconInfoList.get(groupPosition).getItems().get(childPosition).getDescription());
        viewHolder1.validUpTo.setText(beaconInfoList.get(groupPosition).getItems().get(childPosition).getValidUpTo());
        adImages = beaconInfoList.get(groupPosition).getItems().get(childPosition).getImages();
        viewHolder1.createDate.setText(beaconInfoList.get(groupPosition).getItems().get(childPosition).getCreateDate());
        viewHolder1.updateDate.setText(beaconInfoList.get(groupPosition).getItems().get(childPosition).getUpdateDate());
        adSchedules = beaconInfoList.get(groupPosition).getItems().get(childPosition).getShedules();
        viewHolder1.adSchedules.setText("Schedules : ");

        if(adSchedules.size()>0){
            viewHolder1.adScheduleId.setText("\tAd Schedule : "+adSchedules.get(0).getAdScheduleid());
            viewHolder1.adId.setText("\tAd id : "+adSchedules.get(0).getAdID());
            viewHolder1.startDate.setText("\tStart Date : "+adSchedules.get(0).getStartDate());
            viewHolder1.endDate.setText("\tEnd Date : "+adSchedules.get(0).getEndDate());
        }else{
            viewHolder1.adScheduleId.setText("\tAd Schedule : Null");
            viewHolder1.adId.setText("\tAd id : Null");
            viewHolder1.startDate.setText("\tStart Date : Null");
            viewHolder1.endDate.setText("\tEnd Date : Null");
        }
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }}
