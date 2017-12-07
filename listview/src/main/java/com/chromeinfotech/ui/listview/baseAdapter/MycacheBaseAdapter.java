package com.chromeinfotech.ui.listview.baseAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.chromeinfotech.listview.R;
import com.chromeinfotech.ui.student.Student;

import java.util.List;

/**
 * MycacheBaseAdapter set data to listview
 */

public class MycacheBaseAdapter extends BaseAdapter {
    private final int type_one = 0 ;
    private final int type_two = 1 ;
    private List<Student> list;
    private int type ;
    private   String[] values;
    private Context context;

    //constructor
    public MycacheBaseAdapter(Context context, List<Student> list, String[] mobileArray) {
        this.context = context;
        this.list = list;
        this.values=mobileArray ;

    }
    //return the type count
    @Override
    public int getViewTypeCount() {
        return 2;
    }

    //return the type of item
    @Override
    public int getItemViewType(int position) {
        return list.get(position).getType();

    }
    //return size of list
    @Override
    public int getCount() {
        return list.size();
    }

    //return item at that posotion
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    //return the view and inflate layout on the basis of tItemViewType
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MyViewHolder mViewHolder = new MyViewHolder();
        type = getItemViewType(position);
        LayoutInflater inf=(LayoutInflater.from(context));
        if(convertView == null){
            if (type == type_one) {

                convertView = inf.inflate(R.layout.multicell, null);
                mViewHolder.txtname = (TextView) convertView.findViewById(R.id.txtname);

            }else {
                convertView = inf.inflate(R.layout.row_layout,null);
                mViewHolder.label = (TextView) convertView.findViewById(R.id.label);
                mViewHolder.icon = (ImageView) convertView.findViewById(R.id.icon);
            }
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (MyViewHolder) convertView.getTag();
        }
        if (type == type_one) {
            //  Student student = new Student();
            Student student=(Student) getItem(position) ;
            mViewHolder.txtname.setText(student.getName());
            mViewHolder.txtname.setText(list.get(position).getName());
            //mViewHolder.txtname.setText("surya");

        }else {
            mViewHolder.label.setText(values[position]);
            //mViewHolder.label.setText("surya welcome to chrome");
            mViewHolder.icon.setImageResource(R.drawable.cross_icon);

        }
        // Student student=(Student) getItem(position) ;
        //mViewHolder.txtname.setText(list.get(position).getName());

        return convertView;
    }

    /**
     * MyViewHolder hold the view
     */
    private class MyViewHolder {

        private TextView txtname;
        private TextView label;
        private ImageView icon;
    }
}
