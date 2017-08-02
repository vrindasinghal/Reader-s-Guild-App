package com.readersguild.readersguild;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by vrinda on 18-07-2017.
 */
public class DataHelpAdminLogin {
    /* Initialization SQLiteDatabase & create reference variable */
    SQLiteDatabase db;
    /* Database open/upgrade helper*/
    SQLiteOpenHelper mhelper;
    MyOpenHelper myhelp;
    /**
     * Context of the application using the database.
     */
    Context context;

    public DataHelpAdminLogin(Context con) {

        this.context = con;
        mhelper = new MyOpenHelper(this.context);
        myhelp = new MyOpenHelper(this.context);
        // create a instance of SQLite Database
        this.db = mhelper.getWritableDatabase();
    }

    public Integer insertNewRecordInAdminMaster(Integer adminId, String password) {
        try {
            ContentValues conV = new ContentValues();
            conV.put("adminID", adminId);
            conV.put("admin_password", password);
            db.insert(MyOpenHelper.adminMaster, null, conV);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }


    public boolean isAdminValid(Integer adminId, String adminPassword) {
        try {

            Cursor c = db.rawQuery("SELECT  * FROM " + MyOpenHelper.adminMaster + " WHERE adminID = "
                    + adminId + " AND admin_password = " + adminPassword, null);
            if (c.moveToFirst()) {

                Log.v("TAG", "Congrats Valid User");
                return true;

            } else {

                Log.v("TAG", "Invalid User");
                return false;

            }

        } catch (Exception e) {
            // TODO: handle exception
            Log.v("In Exception", "Handle Exception");
            e.printStackTrace();
            return false;
        }

    }
}

