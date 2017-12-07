package com.chromeinfotech.ui.listview.baseAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.chromeinfotech.listview.R;
import com.chromeinfotech.ui.student.Student;

import java.util.List;

/**
 * Created by user on 7/3/17.
 */

public class MyBaseAdapter extends BaseAdapter {

    private TextView txtname , txtaddress ,txtage ;
    private List<Student> list;
    private Context context;
    //constructor
    public MyBaseAdapter(Context context, List<Student> list) {
        this.context = context;
        this.list = list;

    }


    // return the size of item in list
    @Override
    public int getCount() {
        return list.size();
    }
    //return item
    @Override
    public Object getItem(int position) {
        return null;
    }
    //return itemid at that position
    @Override
    public long getItemId(int position) {
        return 0;
    }
    //return the view
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView == null){
            convertView = inflater.inflate(R.layout.list_item,null);

        }
        txtname = (TextView) convertView.findViewById(R.id.txtname);
        txtaddress = (TextView) convertView.findViewById(R.id.txtaddress);
        txtage = (TextView) convertView.findViewById(R.id.txtage);
        txtname.setText(list.get(position).getName());
        txtaddress.setText(list.get(position).getAddress());
        txtage.setText(""+list.get(position).getAge());
        return convertView;
    }
}
