package com.chromeinfotech.ui.GridView.Gridviewmulticell;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import com.chromeinfotech.listview.R;
import com.chromeinfotech.ui.BaseActivity.BaseActivity;
import com.chromeinfotech.ui.student.Student;

import java.util.ArrayList;
import java.util.List;

public class GridAdapteractivity extends BaseActivity {
    private  String name [] , address [];
    private GridView grid;
    Student item = new Student();
    private int age ;
    List<Student> student = new ArrayList<Student>();;
    private GridAdaptermulticell adapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_adapteractivity);
        this.reference();
        this.init();
        this.setvalue();
        //this.setname();
        //this.setAddress();
        //this.setage();
        this.adapteroperation();

    }

//    private void setage() {
//        for (int i = 0; i < name.length ; i++) {
//
//            Student item = new Student();
//            item.setAge(age);
//            item.setType(2);
//            student.add(item);
//        }
//    }
//
//    private void setAddress() {
//        for (int i = 0; i < address.length ; i++) {
//            Student item = new Student();
//            item.setAddress(address[i]);
//            item.setType(1);
//            student.add(item);
//        }
//    }
//
//    private void setname() {
//        for (int i = 0; i < name.length ; i++) {
//            Student item = new Student();
//            item.setName(name[i]);
//            item.setType(0);
//            student.add(item);
//        }
//    }

    //set value and setType
    private void setvalue() {

        for (int i = 0; i < name.length ; i++) {
            if (i % 3 == 0) {
                Student item = new Student();
                item.setName(name[i]);
                item.setType(0);
                student.add(item);
            } else if( i% 3 == 1) {
                Student item = new Student();
                item.setAddress(address[i]);
                item.setType(1);
                student.add(item);
            }else {
                Student item = new Student();
                item.setAge(age);
                item.setType(2);
                student.add(item);
            }
        }
    }

    //initialize the  name[] , array[] and age
    @Override
    public void init() {
        name = new String[] { "surya" , "ankit" , "nikhil" , "lalit" , "vaibhav" , "lavi" ,"amit" ,"paras" , "aman" ,"lavnya","arpan" , "manjay"};
        address = new String[] { "patna" , "allahabad" , "punjab" , "bijnor" , "gazipur" , "ghaziabad" , "palamu" , "delhi" , "goa" ,"mumbai" , "gujrat" , "bihar"};
        age = 22;
    }

    @Override
    public void setListenrs() {

    }

    //set the adapter to gridview
    private void adapteroperation() {
        adapter = new GridAdaptermulticell( student , this );
        grid=(GridView)findViewById(R.id.grid);
        grid.setAdapter(adapter);

    }

    @Override
    public void reference() {

    }
}
