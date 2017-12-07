package com.chromeinfotech.ui.listview.listviewchekbox;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.chromeinfotech.listview.R;
import com.chromeinfotech.ui.BaseActivity.BaseActivity;
import com.chromeinfotech.ui.student.Student;
import com.chromeinfotech.utils.Utils;

import java.util.ArrayList;

/**
 *ListviewCheckbox main Activity which extends BaseActivity and set data to adapter with the help of listview reference
 */
public class ListviewCheckbox extends BaseActivity implements View.OnClickListener , TabLayout.OnTabSelectedListener{

    private String[] name;
    private ListView listView ;
    private Button btnclick ;
    public ArrayList<Fragment> fragments = new ArrayList<Fragment>();
    private ViewPager viewPager ;
    private TabLayout tabLayout ;
    private String TAG = this.getClass().getSimpleName();
    private int[] tabIcons ;
    private ArrayList<Student> student ;
    private ListviewcheckboxAdapter listviewcheckboxAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_checkbox);

        this.reference();  // call reference method to set Reference
        //this.setItem();
        this.init();
        this.setFragment();//call init method of BaseActivity  to perform initialization
        //this.setTabIcons();
        this.setname();    //call to setname
       // this.setviewpagerAdapter();
        this.setAdapter(); // set adapter is used to setAdapter to listview
        this.setListenrs();//call setListenrs method of BaseActivity  to set listner


    }

    private void setFragment() {
        Utils.printLog(TAG,"inside setFragment");
        Fragment1 fragment1 = new Fragment1();
        Fragment2 fragment2 = new Fragment2();
        fragments.add(fragment1);
        fragments.add(fragment2);
        Utils.printLog(TAG,"inside setFragment");
    }

    private void setviewpagerAdapter() {
        Utils.printLog(TAG,"inside setFragment");
        ViewpagerAdapter adapter = new ViewpagerAdapter(getSupportFragmentManager(),fragments,tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        Utils.printLog(TAG,"inside setFragment");
    }

    private void setItem() {
        Utils.printLog(TAG,"inside setItem");
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.addTab(tabLayout.newTab().setText("Tab1"));
        tabLayout.addTab(tabLayout.newTab().setText("Accepted"));
        tabLayout.addTab(tabLayout.newTab().setText("Rejected"));
        Utils.printLog(TAG,"outside setItem");
    }
    private void setTabIcons() {
        Utils.printLog(TAG,"inside setupTabIcons");
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        Utils.printLog(TAG,"outside setupTabIcons");
    }

    /// Override method of BaseActivty to initialization
    @Override
    public void init() {
        Utils.printLog(TAG,"inside init");
        tabIcons = new int[]{
                R.drawable.male,
                R.drawable.ic_launcher,
                R.drawable.cross_icon};
        Utils.printLog(TAG,"outside init");
        name = new String[] { "surya" , "ankit" , "nikhil" , "lalit" , "vaibhav" , "lavi" ,"naman" ,"amit" ,"manjay" ,"aman" ,"roushan" ,"paras" , "vivek" ,"rohit" ,"raman" };

    }

    /***
     *set adapter to listview
     */
    private void setAdapter() {
        listviewcheckboxAdapter =new ListviewcheckboxAdapter(this , student); //constructor of adapter classs here we pass  ArrayList<Student> instance
        listView.setAdapter(listviewcheckboxAdapter); //set Adapter
    }

    // set name to Student object
    private void setname() {

        student = new ArrayList<Student>(); //arraylist os student
        for (int i = 0 ; i < name.length; i++) {
            Student item = new Student(); //create object
            item.setName(name[i]); //set name
            student.add(item);
        }

    }

    /**
     * create reference
     */
    @Override
    public void reference() {
        listView  = (ListView) findViewById(R.id.list); //set the reference
        btnclick  = (Button) findViewById(R.id.btncount);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout=(TabLayout) findViewById(R.id.tabLayout);
    }

    /**
     * set Listner
     */
    @Override
    public void setListenrs() {
        btnclick.setOnClickListener(this); // set onclickListner to button btnclick
    }

    /**
     * method perform onclick operation and print selecteditem within toast
     * @param v is the Reference of view
     */
    @Override
    public void onClick(View v) {
        String result= "";
        for (Student student : listviewcheckboxAdapter.getselectedcheckbox()) {
            if (student.isselected()){
                result +=student.getName() + "\n" ;
            }
        }
        if(result.equalsIgnoreCase("")){
            Utils.showToast(this,"no student is selected");
        }else{
            Utils.showToast(this ," the selected student are\n" +result );
        }
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
