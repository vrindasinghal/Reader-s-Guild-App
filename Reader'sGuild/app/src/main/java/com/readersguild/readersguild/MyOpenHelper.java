package com.readersguild.readersguild;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by vrinda on 18-07-2017.
 */

public class MyOpenHelper extends SQLiteOpenHelper {
    // TODO: Create public field for each column in your table.
    public static final String DATABASE_NAME = "mydatabase";
    private static final int DATABASE_VERSION = 1;

    public static final String adminMaster = "adminTable";
    public static final String userMaster = "userMaster";
    public static final String bookMaster = "bookTable";
    public static final String loginLogout = "loginLogoutStatus";

    public MyOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + adminMaster
                + "(adminID INTEGER PRIMARY KEY,admin_password TEXT)");

        db.execSQL("CREATE TABLE IF NOT EXISTS " + userMaster
                + "(user_mobileNo INTEGER PRIMARY KEY,user_name TEXT,user_email TEXT,user_password TEXT,user_branch TEXT, user_rollno INTEGER, user_hostel TEXT,user_roomNo TEXT)");

        db.execSQL("CREATE TABLE IF NOT EXISTS " + bookMaster
                + "(bookId INTEGER PRIMARY KEY,book_name TEXT,contributors_name TEXT,contributors_mobile_no BIGINT)");

        db.execSQL("CREATE TABLE IF NOT EXISTS " + loginLogout
                + "(mobile_no INTEGER PRIMARY KEY,isLoggedIn INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}
