package com.chromeinfotech.ui.listview.baseAdapter;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.chromeinfotech.listview.R;
import com.chromeinfotech.ui.BaseActivity.BaseActivity;
import com.chromeinfotech.ui.student.Student;
import com.chromeinfotech.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class MybaseAdapterActivity extends BaseActivity implements View.OnClickListener,AdapterView.OnItemClickListener{
    private String[] name;
    private  String[] address;
    private int age;
    private ListView listView;
    private List<Student> student;
    private Button btnadd,btnremove;
    int pos,childcount;
    private    EditText edittext;
    private    MyBaseAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mybase_adapter);
        this.init();
        this.reference();
        this.setListenrs();
        this.setValue();
        this.setAdapter();

    }
    //set Adapter to listview
    private void setAdapter() {
        adapter = new MyBaseAdapter(this, student);// create object of MyBaseAdapter
        listView.setAdapter(adapter);//set adapter to listview
    }
    //set the value
    private void setValue() {
        student = new ArrayList<Student>();
        for (int i = 0; i < name.length; i++) {
            Student item = new Student(name[i], address[i], age);//set value
            student.add(item);
        }
    }

    //create the reference of listview,btn,and edittext
    @Override
    public void reference() {
        listView = (ListView) findViewById(R.id.list);
        btnadd = (Button) findViewById(R.id.btnadd);
        btnremove = (Button) findViewById(R.id.btnremove);
        edittext = (EditText) findViewById(R.id.edittext);

    }
    //initialize the name ,address and age
    @Override
    public void init() {
        name = new String[] { "surya" , "ankit" , "nikhil" , "lalit" , "vaibhav" , "lavi" };

        address = new String[] { "patna" , "allahabad" , "punjab" , "bijnor" , "gazipur" , "ghaziabad"};
        age = 22;

    }

    //set listner to button and listview
    @Override
    public void setListenrs() {
        btnadd.setOnClickListener(this);
        btnremove.setOnClickListener(this);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnadd:
                this.additem();
                break;
            case R.id.btnremove:
                this.removeitem();
                break;

        }

    }


    //add item to listview dynamically at run time
    private void additem() {

        String string= edittext.getText().toString();
        if(string.equals("") ){
            // student.remove(pos);
            student.add(pos, new Student("vicky", "patna", 22));
            adapter.notifyDataSetChanged();
        }else {
            int position=Integer.parseInt(string);
            if(position <= this.childCount()) {
                //student.remove(position);
                student.add(position, new Student("vicky", "patna", 22));
                adapter.notifyDataSetChanged();
            }else {
                Utils.showToast(this,"plz enter position within range");
            }
        }
    }

    //count the child available in listvieww
    private int childCount() {

        childcount=listView.getChildCount();
        return childcount;

    }

    //remove item to specified position
    private void removeitem() {
        String string= edittext.getText().toString();
        if(string.equals("")) {
            if (this.childCount() > 0) {
                student.remove(pos);
                adapter.notifyDataSetChanged();
            }else {
                Utils.showToast(this,"no item available to delete");
            }
        }else {
            int position=Integer.parseInt(string);
            if(position < this.childCount()) {
                student.remove(position);
                adapter.notifyDataSetChanged();
            }else {
                Utils.showToast(this,"plz enter the position between range");
            }
        }

    }

    /**
     * listview on itemclick listner
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Utils.showToast(this,"selected"+position);

        pos=position; //initialize the current selected item index to pos
    }
}

