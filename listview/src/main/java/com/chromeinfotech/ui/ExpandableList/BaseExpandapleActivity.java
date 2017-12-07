package com.chromeinfotech.ui.ExpandableList;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import com.chromeinfotech.listview.R;
import com.chromeinfotech.ui.BaseActivity.BaseActivity;
import com.chromeinfotech.utils.Utils;

import java.util.ArrayList;

public class BaseExpandapleActivity extends BaseActivity implements ExpandableListView.OnGroupClickListener ,ExpandableListView.OnChildClickListener,ExpandableListView.OnGroupCollapseListener ,ExpandableListView.OnGroupExpandListener {

    private ArrayList<Group> parentItems = new ArrayList<Group>();
    private ExpandableListView expListView = null;
    private String[] groupname;
    private int lastExpandedPosition = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_expandaple);

        this.reference();
        this.setListenrs();
        this.groupname();
        this.setGroupitem();
        this.result();
    }


    //create reference of ExpandableListView
    @Override
    public void reference() {

        expListView = (ExpandableListView) findViewById(R.id.expandableList);


    }

    //set adapter to ExpandableListView
    private void result() {
        BaseEpandable adapter = new BaseEpandable(this, parentItems); //constructor of BaseEpandable
        expListView.setAdapter(adapter);
    }

    //initialize the groupname
    private void groupname() {
        groupname = new String[]{"DELL", "HP", "LENEVO", "SONI", "HCL", "SAMSUNG"};

    }

    //set listner to ExpandableListView
    @Override
    public void setListenrs() {

        expListView.setOnGroupClickListener(this);
        expListView.setOnChildClickListener(this);
        expListView.setOnGroupCollapseListener(this);
        expListView.setOnGroupExpandListener(this);


    }

    //set the groupitem to all group
    private void setGroupitem() {

        for (int i = 0; i < groupname.length; i++) {
            Group item = new Group(groupname[i]);
            ArrayList<Child> childlist = new ArrayList<Child>();
            childlist.add(new Child("1"));
            childlist.add(new Child("2"));
            childlist.add(new Child("3"));
            item.setchildList(childlist);
            parentItems.add(item);

        }
    }

    /**
     * Callback method to be invoked when a child in this expandable list has been clicked.
     * @param parent
     * @param v
     * @param groupPosition
     * @param childPosition
     * @param id
     * @return
     */
    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

        Utils.showToast(this,"child is selected group position="+groupPosition+"child position="+childPosition);
        return false;
    }

    /**
     * Callback method to be invoked when a group in this expandable list has been clicked.
     * @param parent
     * @param v
     * @param groupPosition
     * @param id
     * @return
     */
    @Override
    public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
        Utils.showToast(this,"group is selected group position="+groupPosition);
        return false;
    }

    /**
     * Callback method to be invoked when a group in this expandable list has been collapsed.
     * @param groupPosition
     */
    @Override
    public void onGroupCollapse(int groupPosition) {

    }

    /**
     * Callback method to be invoked when a group in this expandable list has been expanded.
     * @param groupPosition
     */
    @Override
    public void onGroupExpand(int groupPosition) {
        if(groupPosition != lastExpandedPosition){
            expListView.collapseGroup(lastExpandedPosition); //expand the group except the selected group
            lastExpandedPosition = groupPosition;
        }


    }
}