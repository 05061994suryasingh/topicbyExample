package com.chromeinfotech.ui.student;

/**
 * Created by user on 7/3/17.
 */

public class Student {

    protected String name;
    protected String address;
    protected int age;
    boolean isselected;
    boolean btnchecked;
    boolean textviewchecked;
    String selected ;

    public String getSelected() {
        return selected;
    }
    public void setSelected(String selected) {
        this.selected = selected;
    }


    public boolean isTextviewchecked() {
        return textviewchecked;
    }
    public void setTextviewchecked(boolean textviewchecked) {
        this.textviewchecked = textviewchecked;
    }

    public boolean isBtnchecked() {
        return btnchecked;
    }

    public void setBtnchecked(boolean btnchecked) {
        this.btnchecked = btnchecked;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    protected int type;

    public Student(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }
    public Student() {

    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public boolean isselected() {
        return isselected;
    }

    public void setselected(boolean isselected) {
        this.isselected = isselected;
    }
}
