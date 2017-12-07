package com.chromeinfotech.databaseassignment;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.chromeinfotech.utils.Utils;

/**
 * Created by user on 14/4/17.
 */

public class StudentTable {

    Student student = new Student() ;
    Context context ;
    public static final String STUDENTABLENAME = "student";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_FNAME = "fathername";
    private static final String KEY_ADDRESS = "address";
    private int id ;
    private  String name ,fname , address;
    private String TAG = this.getClass().getSimpleName();
    private SQLiteDatabase sqLiteDatabase = null ;

    public  static  String CREATE_TABLE = "CREATE TABLE " + STUDENTABLENAME + "("
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME + " TEXT,"
            + KEY_FNAME + " TEXT," + KEY_ADDRESS + " TEXT" + ")";

    public  StudentTable(Context context, Student student){
        this.context = context ;
        this.student =student ;
    }

    public StudentTable(Context context) {
        this.context =context;
    }

    public void insertData(String std_id){

        if(sqLiteDatabase == null){
            return ;
        }

        id        =  student .getId() ;
        name      =  student .getName() ;
        fname     =  student .getFname() ;
        address   =  student .getAddress() ;
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM student WHERE id='"+std_id+"'", null);
        if(cursor != null && cursor.getCount() != 0)
        {
            Utils.showToast(context ,"duplicate value insert plz insert unique id value");
        }
        else
        {
            String QUERY = "insert into "+ STUDENTABLENAME + "(id,name,fathername,address) values ('" +id +"','"+ name +"','"+fname+"' ,'"+address + "')" ;
            Utils.printLog("QUERY" , " QUERY : " + QUERY);
            sqLiteDatabase.execSQL(QUERY);
        }


    }
    public  void openConnection(){
        Utils.printLog(TAG ,"inside openConnection");
        sqLiteDatabase = new MySqlHelper(context, Dbconstant.DBNAME , null, Dbconstant.VERSION).getReadableDatabase();
        //sqLiteDatabase.create(null);
        Utils.printLog(TAG ,"outside openConnection");
    }

    public void closeConeection(){
        if(sqLiteDatabase != null && sqLiteDatabase.isOpen()) {
            sqLiteDatabase.close();
        }
    }

    public Student retriveData(String id){

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM student WHERE id='"+id+"'", null);
        if(cursor.moveToFirst())
        {
            // Displaying record if found
            student.setId(cursor.getInt(0));
            student.setName(cursor.getString(1));
            student.setFname(cursor.getString(2));
            student.setAddress(cursor.getString(3));
        }
        else
        {
            Utils.showToast(context, "Invalid id");
        }
        return student;
    }

    public void updateData(String id2){
        // Searching roll number
        Cursor c=sqLiteDatabase.rawQuery("SELECT * FROM student WHERE id='"+id2+"'", null);
        if(c.moveToFirst())
        {
            // Modifying record if found
            sqLiteDatabase.execSQL("UPDATE student SET name='"+"surya"+"',address='"+"jharkhand"+
                    "' WHERE id='"+id2+"'");
            Utils.showToast(context, "Record Modified");
        }
        else
        {
            Utils.showToast(context, "Invalid id");
        }

    }

    public void deleteData(String id){
        // Searching roll number
        Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM student WHERE id='"+ id +"'", null);
        if(c.moveToFirst())
        {
            // Deleting record if found
            sqLiteDatabase.execSQL("DELETE FROM student WHERE id='"+id+"'");
            Utils.showToast(context, "Record Deleted");
        }
        else
        {
            Utils.showToast(context, "Invalid id");
        }
    }

    public String viewAll(){
        // Retrieving all records
        Cursor c=sqLiteDatabase.rawQuery("SELECT * FROM student", null);
        // Checking if no records found
        if(c.getCount()==0)
        {
            Utils.showToast(context, "No records found");
            return "";
        }
        // Appending records to a string buffer
        StringBuffer buffer=new StringBuffer();
        while(c.moveToNext())
        {
            buffer.append("id: "+c.getString(0)+"\n");
            buffer.append("Name: "+c.getString(1)+"\n");
            buffer.append("fname: "+c.getString(2)+"\n");
            buffer.append("address: "+c.getString(3)+"\n\n");
        }
        return String.valueOf(buffer);
    }
}


