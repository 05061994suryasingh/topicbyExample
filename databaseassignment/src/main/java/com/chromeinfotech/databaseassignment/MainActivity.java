package com.chromeinfotech.databaseassignment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.chromeinfotech.BaseActivity.BaseActivity;
import com.chromeinfotech.utils.Utils;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    private  Student student ;
    private StudentTable studentTable = new StudentTable(this) ;
    private TextView tv_viewall ;
    private Button   btnretrive , btninsert , btnupdate , btndelete , btnclear ,btnviewall;
    private EditText edt_id , edt_name , edt_fname , edt_address ;
    private String name ,fname ,address , std_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.reference();
        this.init() ;
        this.setListenrs();
    }

    @Override
    public void init() {
        student = new Student() ;
    }

    @Override
    public void reference() {
        edt_id          = (EditText) findViewById(R.id.edt_id);
        edt_name        = (EditText) findViewById(R.id.edt_name);
        edt_fname       = (EditText) findViewById(R.id.edt_fname);
        edt_address     = (EditText) findViewById(R.id.edt_address);
        btnretrive      = (Button)   findViewById(R.id.btnretrive);
        btninsert       = (Button)   findViewById(R.id.btninsert);
        btnupdate       = (Button)   findViewById(R.id.btnupdate);
        btndelete       = (Button)   findViewById(R.id.btndelete);
        btnclear        = (Button)   findViewById(R.id.btnclear);
        btnviewall      = (Button)   findViewById(R.id.btnviewall);
        tv_viewall      = (TextView) findViewById(R.id.tv_viewall);
    }

    @Override
    public void setListenrs() {
        btninsert.setOnClickListener(this);
        btnretrive.setOnClickListener(this);
        btnupdate.setOnClickListener(this);
        btndelete.setOnClickListener(this);
        btnclear.setOnClickListener(this);
        btnviewall.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnretrive :

                String id = edt_id.getText().toString() ;
                if(id.trim().length()==0)
                {
                    Utils.showToast(this, "Please enter Student id");
                    return;
                }else{
                    //Student data = new Student() ;
                    studentTable.openConnection();
                    student =  studentTable.retriveData(id);
                    this.setData(student);
                    studentTable.closeConeection();
                }
                break;
            case R.id.btninsert :
                getdata();
                studentTable.openConnection();
                studentTable.insertData(std_id);
                studentTable.closeConeection();
                clearData();
                break;
            case R.id.btnupdate :
                String id2 = edt_id.getText().toString() ;
                // Checking empty roll number
                if(id2.trim().length()==0)
                {
                    Utils.showToast(this, "Please enter Student id");
                    return;
                }else{
                    studentTable.openConnection();
                    studentTable.updateData(id2);
                    studentTable.closeConeection();
                }

                break;
            case R.id.btndelete :
                String id1 = edt_id.getText().toString() ;
                if(id1.trim().length()==0)
                {
                    Utils.showToast(this , "Please enter Student id");
                    return;
                }else {
                    studentTable.openConnection();
                    studentTable.deleteData(id1);
                    studentTable.closeConeection();

                }
                break;
            case R.id.btnclear :
                clearData();
                break;
            case R.id.btnviewall :
                studentTable.openConnection();
                String data = studentTable.viewAll();
                studentTable.closeConeection();
                tv_viewall.setText(data);
                break;
        }
    }

    private void clearData() {
        edt_id.setText("");
        edt_name.setText("") ;
        edt_fname.setText("") ;
        edt_address.setText("") ;
    }

    private void setData(Student student) {
        edt_id.setText(""+student.getId());
        edt_name.setText(student.getName()) ;
        edt_fname.setText(student.getFname()) ;
        edt_address.setText(student.getAddress()) ;
    }

    public void getdata() {
        std_id      = edt_id.getText().toString() ;
        name    = edt_name.getText().toString() ;
        fname   = edt_fname.getText().toString() ;
        address = edt_address.getText().toString() ;
        student.setId(Integer.parseInt(std_id));
        student.setName(name);
        student.setFname(fname);
        student.setAddress(address);
        studentTable = new StudentTable(this , student) ;
    }
}
