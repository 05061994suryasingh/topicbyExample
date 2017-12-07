package com.chromeinfotech.databaseassignment;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.chromeinfotech.utils.Utils;

/**
 * Created by user on 14/4/17.
 */

public class MySqlHelper extends SQLiteOpenHelper {
    private  Context context ;
    private String TAG = this.getClass().getSimpleName();

    public MySqlHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, null, version);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Utils.printLog(TAG ,"inside onCreate ()");
        db.execSQL(StudentTable.CREATE_TABLE);
        Utils.showToast(context ,"table created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + StudentTable.STUDENTABLENAME);
       // db.execSQL("DROP table student");
        db.execSQL(StudentTable.CREATE_TABLE);
    }
}
