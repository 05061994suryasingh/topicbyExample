package com.chromeinfotech.ui.ExpandableList;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import com.chromeinfotech.listview.R;
import java.util.ArrayList;


/**
 * BaseEpandable is a adapter receive data ad set data to list
 */

public class BaseEpandable extends BaseExpandableListAdapter {

    private ArrayList<Group> parentItems ;
    private Context  context ;

    //costructor
    public BaseEpandable(Context context, ArrayList<Group> parentItems) {
        this.context=context;
        this.parentItems = parentItems;
    }

    //return the total number of group
    @Override
    public int getGroupCount() {
        return parentItems.size();
    }

    //return the the total number of child in that groupposition
    @Override
    public int getChildrenCount(int groupPosition) {
        return parentItems.get(groupPosition).getchildList().size();
    }

    //return the group on that groupposition
    @Override
    public Object getGroup(int groupPosition) {
        return parentItems.get(groupPosition);
    }

    //return the child
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return parentItems.get(groupPosition).getchildList().get(childPosition);
    }

    //return the groupid on that groupposition
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    //return the childid on that childposition
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    //return the groupview
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        Group group = (Group) getGroup(groupPosition);
        MyViewHolder mViewHolder;
        LayoutInflater inf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = inf.inflate(R.layout.list_group, null);
            mViewHolder = new MyViewHolder(convertView);
            convertView.setTag(mViewHolder);
        }else {
            mViewHolder = (MyViewHolder) convertView.getTag();
        }

        mViewHolder.lstgroup.setText(group.getName());
        return convertView;
    }

    //return the childview
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        MychildHolder MychildHolder;
        Child child = (Child) getChild(groupPosition, childPosition);
        LayoutInflater inf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView == null){
            convertView = inf.inflate(R.layout.list_child, null);
            MychildHolder = new MychildHolder(convertView);
            convertView.setTag(MychildHolder);
        }else {
            MychildHolder = (MychildHolder) convertView.getTag();
        }

        MychildHolder.listchild.setText(child.getName());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    /**
     * MyViewHolder class hold the view
     */
    private class MyViewHolder {

        private TextView lstgroup;

        public MyViewHolder(View item) {
            lstgroup = (TextView) item.findViewById(R.id.lstgroup);

        }
    }

    /**
     * MyViewHolder class hold the view
     */
    private class MychildHolder {

        private TextView listchild;

        public MychildHolder(View item) {
            listchild = (TextView) item.findViewById(R.id.listchild);

        }
    }
}
