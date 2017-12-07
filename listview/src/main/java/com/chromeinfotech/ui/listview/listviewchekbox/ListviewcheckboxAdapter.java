package com.chromeinfotech.ui.listview.listviewchekbox;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.chromeinfotech.listview.R;
import com.chromeinfotech.ui.student.Student;

import java.util.ArrayList;

/**
 * Created by user on 16/3/17.
 */

public class ListviewcheckboxAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Student> students;
    //constructor that recive context and arraylist student
    public ListviewcheckboxAdapter(Context context, ArrayList<Student> students) {
        this.context = context;
        this.students = students;
    }

    //return number of item present in Arraylist student
    @Override
    public int getCount() {
        return students.size();
    }

    //return item object from selected position
    @Override
    public Object getItem(int position) {
        return students.get(position);
    }

    // return id of item at that position
    @Override
    public long getItemId(int position) {
        return position;
    }

    //return view
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        MyViewHolder mViewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(context);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.listcheckbox, null);
            mViewHolder = new MyViewHolder(convertView);
            convertView.setTag(mViewHolder);
            convertView.setTag(R.id.checkbox, mViewHolder.checkbox);

        } else {
            mViewHolder = (MyViewHolder) convertView.getTag();
        }

        final Student student = (Student) getItem(position);
        mViewHolder.checkbox.setTag(position); //set tag at position
        mViewHolder.txtstatus.setTag(position); //set tag at position
        mViewHolder.checkbox.setChecked(student.isselected()); //setceck the checkkbox
        mViewHolder.txtstatus.setText(students.get(position).getSelected());
        mViewHolder.txtname.setText(student.getName()); //return the name

        if(student.isBtnchecked()){
            mViewHolder.btnaccepted.setVisibility(convertView.GONE);
            mViewHolder.btndecline.setVisibility(convertView.GONE);
            mViewHolder.txtstatus.setVisibility(convertView.VISIBLE);
        }else {
            mViewHolder.btnaccepted.setVisibility(convertView.VISIBLE);
            mViewHolder.btndecline.setVisibility(convertView.VISIBLE);
            mViewHolder.txtstatus.setVisibility(convertView.GONE);
        }

        //set Onclicklistner on btnaccepted
        final MyViewHolder finalMViewHolder = mViewHolder;

        mViewHolder.btnaccepted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                students.get(position).setSelected("Accepted");
                student.setTextviewchecked(true);
                student.setBtnchecked(true);
                finalMViewHolder.txtstatus.setVisibility(view.VISIBLE);
                notifyDataSetChanged();
            }

        });

        //set Onclicklistner on btndecline
        mViewHolder.btndecline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (finalMViewHolder.checkbox.isChecked()) {
                    finalMViewHolder.checkbox.setChecked(false);
                }
                students.get(position).setSelected("Rejected");
                student.setTextviewchecked(true);
                student.setBtnchecked(true);
                notifyDataSetChanged();

            }
        });
        this.setListner(mViewHolder,position); //setlistner method is used to set the listner
        return convertView;
    }

    private void setListner(final MyViewHolder mViewHolder, final int position) {

//        mViewHolder.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                int position = (Integer) buttonView.getTag();
//                students.get(position).setisselected(buttonView.isChecked());
//            }
//        });
        mViewHolder.checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                students.get(position).setselected(!(students.get(position).isselected()));
                ListviewcheckboxAdapter.this.notifyDataSetChanged();
            }
        });
    }

    //add total selected student into arraylist
    ArrayList<Student> getselectedcheckbox() {
        ArrayList<Student> student1 = new ArrayList<Student>();
        for (Student student : students) {
            if (student.isselected())
                student1.add(student);
        }
        return student1;
    }
    /***
     *MyViewHolder  class use here to hold the view
     */
    private class MyViewHolder {

        private TextView  txtname , txtstatus ;
        private Button btnaccepted , btndecline ;
        private CheckBox checkbox ;

        public MyViewHolder(View view) {
            txtname     = (TextView) view.findViewById(R.id.txtname); // set the view references of textview
            txtstatus   = (TextView) view.findViewById(R.id.txtstatus);
            btnaccepted = (Button) view.findViewById(R.id.btnaccepted);
            btndecline  = (Button) view.findViewById(R.id.btndecline);
            checkbox    = (CheckBox) view.findViewById(R.id.checkbox);
        }

    }
}
