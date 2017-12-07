package com.chromeinfotech.navigationdrawer;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * set the data into listview
 */

public class DrawerCustomAdapter extends ArrayAdapter<DataModel> {

    Context mContext;
    int layoutResourceId;
    DataModel data[] = null;

    public DrawerCustomAdapter(Context mContext, int layoutResourceId, DataModel[] data) {

        super(mContext, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        View listItem = convertView;
        LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
        if(convertView == null) {
            listItem = inflater.inflate(layoutResourceId, parent, false);
            viewHolder.imageViewIcon = (ImageView) listItem.findViewById(R.id.imageViewIcon);
            viewHolder.textViewName = (TextView) listItem.findViewById(R.id.textViewName);
            // viewHolder.img_headerimage = (ImageView) listItem.findViewById(R.id.img_headerimage);
            //viewHolder.tv_header = (TextView) listItem.findViewById(R.id.tv_header);
        }

        DataModel dataModel = data[position];
        viewHolder.imageViewIcon.setImageResource(dataModel.icon);
        viewHolder.textViewName.setText(dataModel.name);
        //  viewHolder.imageViewIcon.setImageResource(R.drawable.cross_icon);
        //viewHolder.textViewName.setText("header");
        return listItem;
    }
    private static class ViewHolder
    {
        private ImageView imageViewIcon ,img_headerimage;
        private TextView  textViewName , tv_header;

    }
}
