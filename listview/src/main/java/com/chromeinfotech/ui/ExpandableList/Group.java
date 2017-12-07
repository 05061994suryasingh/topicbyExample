package com.chromeinfotech.ui.ExpandableList;

import java.util.ArrayList;

/**
 * with the help of Group class we show Group item of Expandblelist
 */

public class Group  {
    protected String name;
    private ArrayList<Child> childlist = new ArrayList<Child>();
    public Group(String name ) {
        this.name = name;

    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Child> getchildList() {
        return childlist;
    }

    public void setchildList(ArrayList<Child> childlist) {
        this.childlist = childlist;
    }
}
