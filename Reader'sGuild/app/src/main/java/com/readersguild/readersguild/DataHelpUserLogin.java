package com.readersguild.readersguild;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by vrinda on 19-07-2017.
 */

public class DataHelpUserLogin {
    SQLiteDatabase db;
    SQLiteOpenHelper mhelper;
    MyOpenHelper myhelp;
    Context context;

    public DataHelpUserLogin(Context con) {
        this.context = con;
        mhelper = new MyOpenHelper(this.context);
        myhelp = new MyOpenHelper(this.context);
        // create a instance of SQLite Database
        this.db = mhelper.getWritableDatabase();
    }

    public Integer insertNewRecordInUserMaster(Integer uMobileNo, String uName, String uEmail, String uPassword, String uBranch, Integer uRollNo, String uHostel, String uRoomNo) {
        try {
            ContentValues conV = new ContentValues();
            conV.put("user_mobileNo", uMobileNo);
            conV.put("user_name", uName);
            conV.put("user_email", uEmail);
            conV.put("user_password", uPassword);
            conV.put("user_branch", uBranch);
            conV.put("user_rollno", uRollNo);
            conV.put("user_hostel", uHostel);
            conV.put("user_roomNo", uRoomNo);
            db.insert(MyOpenHelper.userMaster, null, conV);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public boolean isUserValid(Integer uRollNo, String uPassword) {
        try {
            Cursor c = db.rawQuery("SELECT * FROM " + MyOpenHelper.userMaster + " WHERE user_rollno ='"
                    + uRollNo + "'" + " AND user_password ='" + uPassword + "'", null);
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

    public Integer insertRecordInLoginLogut(Integer rollNo, Integer i) {
        try {
            ContentValues conV = new ContentValues();
            conV.put("roll_no", rollNo);
            conV.put("isLoggedIn", i);
            db.insert(MyOpenHelper.loginLogout, null, conV);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public Cursor getRecordFromLoginLogout() {
        Cursor c;
        try {
            c = db.rawQuery("SELECT * FROM  " + MyOpenHelper.loginLogout, null);
            return c;
        } catch (Exception e) {
            Log.e("Error At", " " + e);
            e.printStackTrace();
            // TODO: handle exception
            return null;
        }
    }

    public Cursor getRollNumber() {
        try {
            Cursor c = db.rawQuery("SELECT * FROM " + MyOpenHelper.userMaster, null);
            return c;
        } catch (Exception e) {
            // TODO: handle exception
            Log.v("In Exception", "Handle Exception");
            e.printStackTrace();
            return null;
        }
    }

    public boolean getStatus(Integer rollNo){
        try {
            Cursor c = db.rawQuery("SELECT * FROM " + MyOpenHelper.loginLogout + " WHERE roll_no ='"
                    + rollNo + "'" + " AND isLoggedIn ='" + ""+1 + "'", null);
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

    public void updateStatus(Integer rollNo){
        try {
            ContentValues conV = new ContentValues();
            conV.put("isLoggedIn",""+0);
            db.update(MyOpenHelper.loginLogout, conV, "roll_no='" + rollNo + "'", null);
            Log.v("TAG", "Updated Status Successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
