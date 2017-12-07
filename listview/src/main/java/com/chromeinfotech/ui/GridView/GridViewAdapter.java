package com.chromeinfotech.ui.GridView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.chromeinfotech.listview.R;

/**
 * adapter set item on row and column in GridView
 */

public class GridViewAdapter extends ArrayAdapter {
    private  String[] values;
    private  Context context;
    public GridViewAdapter(Context context,String[] values) {
        super(context,  R.layout.row_layout, values);
        this.context = context;
        this.values = values;
    }


//retur the view
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        if(convertView == null){
            convertView= inflater.inflate(R.layout.row_layout,null);
        }
        ImageView icon= (ImageView) convertView.findViewById(R.id.icon);
        TextView lable= (TextView) convertView.findViewById(R.id.label);
        lable.setText(values[position]);
        String s = values[position];
        if (s.startsWith("Windows7") || s.startsWith("iPhone")
                || s.startsWith("Solaris")) {
            icon.setImageResource(R.drawable.cross_icon);
        } else {
            icon.setImageResource(R.drawable.ic_launcher);
        }
        return convertView ;
    }

}
