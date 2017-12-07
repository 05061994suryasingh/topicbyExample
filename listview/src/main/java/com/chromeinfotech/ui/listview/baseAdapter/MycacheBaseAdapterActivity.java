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

public class MycacheBaseAdapterActivity extends BaseActivity implements AdapterView.OnClickListener,AdapterView.OnItemClickListener {
    private String[] name;
    private String[] address;
    private int age ,pos ,childcount;
    private EditText edittxtid;
    private Button btnADD,btnRemove;
    private ListView listView;
    private    MycacheBaseAdapter adapter;
    private String mobileArray [];
    List<Student> student;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mycache_base_adapter);
        this.init();
        this.reference();
        this.setListenrs();
        this.setValue();
        this.setAdapter();

    }

    /**
     * set the Adapter to listview
     */
    private void setAdapter() {
        adapter = new MycacheBaseAdapter(this ,student,mobileArray);//cal the constructor of MycacheBaseAdapter
        listView.setAdapter(adapter);
    }

    //set the value and type
    private void setValue() {
        student = new ArrayList<Student>();
        for (int i = 0; i < name.length; i++) {
            if(i%2==0){
                Student item = new Student();
                item.setName(name[i]);
                item.setType(1);
                student.add(item);
            }else {

                Student item = new Student();
                item.setName(name[i]);
                item.setType(0);
                student.add(item);
            }

        }
    }

    //create the refernce
    @Override
    public void reference() {
        listView = (ListView) findViewById(R.id.list);
        btnADD = (Button) findViewById(R.id.btnADD);
        btnRemove = (Button) findViewById(R.id.btnRemove);
        edittxtid = (EditText) findViewById(R.id.edittxtid);
    }

    //override the init method of BaseActivity to initialize the name[], address[] and age
    @Override
    public void init() {
        name = new String[] { "surya" , "ankit" , "nikhil" , "lalit" , "vaibhav" , "lavi" };

        address = new String[] { "patna" , "allahabad" , "punjab" , "bijnor" , "gazipur" , "ghaziabad"};
        age = 22;
        mobileArray = new String[]{"Android", "IPhone", "WindowsMobile", "Blackberry",
                "WebOS", "Ubuntu", "Windows7", "Max OS X","Solaris"};
    }

    //set listner to btnAdd, btnRemove and listview
    @Override
    public void setListenrs() {
        btnADD.setOnClickListener(this);
        btnRemove.setOnClickListener(this);
        listView.setOnItemClickListener(this);
    }

    /**
     * perform onclick on button
     * @param v
     */
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnADD:
                this.additem();
                break;
            case R.id.btnRemove:
                this.removeitem();
                break;

        }

    }
    //add item to listview
    private void additem() {

        if(true){
            return;
        }
        String string= edittxtid.getText().toString();

        if(string.equals("") ){
            student.remove(pos);
            student.add(pos, new Student("vicky", "patna", 22));
            adapter.notifyDataSetChanged();

        }else {
            int position=Integer.parseInt(string);
            if(position< this.childCount()) {
                student.remove(position);
                student.add(position, new Student("vicky", "patna", 22));
                adapter.notifyDataSetChanged();
            }else {
                Utils.showToast(this,"plz enter position within range");
            }
        }
    }

    //Remove item from listview
    private void removeitem() {
        String string= edittxtid.getText().toString();
        if(string.equals("")){
            student.remove(pos);
            adapter.notifyDataSetChanged();
        }else {
            int position=Integer.parseInt(string);
            if(position< this.childCount()) {
                student.remove(position);
                adapter.notifyDataSetChanged();
            }else {
                Utils.showToast(this,"plz enter the position between range");
            }
        }

    }

    /**
     * perform onitemclick on listview
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Utils.showToast(this,"selected"+position);

        pos=position;
    }

    /**
     * count the child in the listview
     * @return
     */
    private int childCount() {

        childcount=listView.getChildCount();
        return childcount;

    }
}
