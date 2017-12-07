package com.chromeinfotech.ui.GridView.Gridviewmulticell;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.chromeinfotech.listview.R;
import com.chromeinfotech.ui.student.Student;
import com.chromeinfotech.utils.Utils;;
import java.util.List;

/**
 * Created by user on 9/3/17.
 */

public class GridAdaptermulticell extends BaseAdapter {
    private  int typeone = 0;
    private  int typetwo = 1, type ;
    private  int typethree = 2;
    private List<Student> student;
    private  Context context = null;
    public GridAdaptermulticell(List<Student> student, Context context ) {
        this.student = student;
        this.context = context;

    }

    //return the number of typecount
    @Override
    public int getViewTypeCount() {

        return 3;
    }

    //return the item view type
    @Override
    public int getItemViewType(int position) {

        return student.get(position).getType();
    }

    // return the size of arraylist student
    @Override
    public int getCount() {
        return student.size();
    }

    //return the item
    @Override
    public Object getItem(int position) {
        return student.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    //return the view  inthis method we inflate multiple layout basis of ItemViewType
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder myViewHolder= new MyViewHolder();
        LayoutInflater inflater = LayoutInflater.from(context);
        Student student=(Student) getItem(position) ;
        type = getItemViewType(position);
        Utils.printLog("adapter","type"+type);
        if(convertView == null){
            if (type == typeone){
                convertView = inflater.inflate(R.layout.multicell, null);
                myViewHolder.txtname = (TextView) convertView.findViewById(R.id.txtname);


            }else if(type == typetwo){
                convertView = inflater.inflate(R.layout.gridlist, null);
                myViewHolder.lstgrid = (TextView) convertView.findViewById(R.id.lstgrid);

            }else{
                convertView = inflater.inflate(R.layout.list_group, null);
                myViewHolder.lstgroup = (TextView) convertView.findViewById(R.id.lstgroup);
            }
            if (type == typeone) {

                myViewHolder. txtname.setText(student.getName());


            }else if(type == typetwo){
                myViewHolder.lstgrid.setText(student.getAddress());

            }else {
                myViewHolder.lstgroup.setText(""+student.getAge());
            }
        }
        return convertView;
    }

    /**
     * class that hold the view
     */
    private class MyViewHolder {

        private TextView txtname ,lstgrid ,lstgrid1 ,lstgroup ;
    }
}
