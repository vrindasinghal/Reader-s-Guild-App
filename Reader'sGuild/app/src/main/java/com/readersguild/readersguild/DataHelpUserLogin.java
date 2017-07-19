package com.readersguild.readersguild;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by vrinda on 19-07-2017.
 */

public class DataHelpUserLogin {
    SQLiteDatabase db;
    SQLiteOpenHelper mhelper;
    MyOpenHelper myhelp;
    Context context;
    Cursor c1;

    public DataHelpUserLogin(Context con) {
        this.context = con;
        mhelper = new MyOpenHelper(this.context);
        myhelp = new MyOpenHelper(this.context);
        // create a instance of SQLite Database
        this.db = mhelper.getWritableDatabase();
    }

    public Integer insertNewRecordInUserMaster(Integer uMobileNo ,String uName,String uEmail, String uPassword,String uBranch,Integer uRollNo,String uHostel,String uRoomNo) {
        try {
            ContentValues conV = new ContentValues();
            conV.put("user_mobileNo", uMobileNo);
            conV.put("user_name", uName);
            conV.put("user_email", uEmail);
            conV.put("user_password", uPassword);
            conV.put("user_branch", uBranch);
            conV.put("user_rollno",uRollNo );
            conV.put("user_hostel", uHostel);
            conV.put("user_roomNo", uRoomNo);
            db.insert(MyOpenHelper.userMaster, null, conV);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
}
