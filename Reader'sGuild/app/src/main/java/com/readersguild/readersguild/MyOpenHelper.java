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


    public MyOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + adminMaster
                + "(adminID INTEGER PRIMARY KEY,admin_password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
