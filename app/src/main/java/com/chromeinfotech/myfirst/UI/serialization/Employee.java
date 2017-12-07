package com.chromeinfotech.myfirst.UI.serialization;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Country class which implement the Parcelable
 */

public class Employee implements Parcelable{

    private  String name;
    private String fname;
    private String address;

    public static final Creator<Employee> CREATOR = new Creator<Employee>() {
        @Override
        public Employee createFromParcel(Parcel in) {
            return new Employee(in);
        }
        @Override
        public Employee[] newArray(int size) {
            return new Employee[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getfname() {
        return fname;
    }

    public void setfname(String fname) {
        this.fname = fname;
    }

    public String getaddress() {
        return address;
    }

    public void setAddress(String adddress) {
        this.address = adddress;
    }

    public Employee() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(name);
        parcel.writeString(fname);
        parcel.writeString(address);
    }


    Employee(Parcel in){
        this.name = in.readString();
        this.fname = in.readString();
        this.address = in.readString();
    }
}
