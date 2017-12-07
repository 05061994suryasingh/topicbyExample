package com.chromeinfotech.ui.listview.arrayAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.chromeinfotech.listview.R;
import com.chromeinfotech.utils.Utils;

/**
 * mySimpleArrayAdapter  set data into listview
 */

public class mySimpleArrayAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;

    //constructor
    public mySimpleArrayAdapter(Context context,String[] values) {
        super(context,  R.layout.row_layout, values);
        this.context = context;
        this.values = values;
    }
    //return the view
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Utils.printLog("ContactAdapter" ," value1111" + values[position]);
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row_layout, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.label);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        textView.setText(values[position]);
        String s = values[position];
        if (s.startsWith("Windows7") || s.startsWith("iPhone")
                || s.startsWith("Solaris")) {
            imageView.setImageResource(R.drawable.cross_icon);
        } else {
            imageView.setImageResource(R.drawable.ic_launcher);
        }
        return rowView;
    }
}
