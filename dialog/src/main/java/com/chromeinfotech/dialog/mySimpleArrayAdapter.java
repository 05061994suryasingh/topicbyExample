package com.chromeinfotech.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * mySimpleArrayAdapter  set data into listview
 */

public class mySimpleArrayAdapter extends ArrayAdapter<String> {
    private final Context context;
    private List<String> liste;

    //constructor
    public mySimpleArrayAdapter(Context context, List<String> values) {
        super(context,  R.layout.listview_item, values);
        this.context = context;
        this.liste = values;
    }
    //return the view
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.listview_item, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.listname);
        String value = liste.get(position);
        textView.setText(value);
        return rowView;
    }
}
