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

public class DataHelpAddBook {
    /* Initialization SQLiteDatabase & create reference variable */
    SQLiteDatabase db;
    /* Database open/upgrade helper*/
    SQLiteOpenHelper mhelper;
    MyOpenHelper myhelp;
    /**
     * Context of the application using the database.
     */
    Context context;

    public DataHelpAddBook(Context con) {

        this.context = con;
        mhelper = new MyOpenHelper(this.context);
        myhelp = new MyOpenHelper(this.context);
        // create a instance of SQLite Database
        this.db = mhelper.getWritableDatabase();
    }

    public Integer insertNewBookInBookMaster(Integer bookId, String bookName, String contributorsName, Long contributorsMobileNo) {
        try {
            ContentValues conV = new ContentValues();
            conV.put("bookId", bookId);
            conV.put("book_name", bookName);
            conV.put("contributors_name", contributorsName);
            conV.put("contributors_mobile_no", contributorsMobileNo);
            db.insert(MyOpenHelper.bookMaster, null, conV);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public Cursor getBookRecords() {
        Cursor c;
        try {
            c = db.rawQuery("select * from  " + MyOpenHelper.bookMaster, null);
            return c;
        } catch (Exception e) {
            Log.e("Error At", " " + e);
            e.printStackTrace();
            // TODO: handle exception
            return null;
        }
    }
}

