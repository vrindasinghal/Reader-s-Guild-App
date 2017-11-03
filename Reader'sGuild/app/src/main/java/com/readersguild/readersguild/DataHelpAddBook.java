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
    /*
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

    public Integer insertNewBookInBookMaster(Integer bookId, String bookName, String contributorsName, Integer contributorsRollNo, Integer issuersRollNo,
                                             Integer issued, Integer returned, Integer reIssued) {
        try {
            ContentValues conV = new ContentValues();
            conV.put("bookId", bookId);
            conV.put("book_name", bookName);
            conV.put("contributors_name", contributorsName);
            conV.put("contributors_roll_no", contributorsRollNo);
            conV.put("issuers_roll_no", issuersRollNo);
            conV.put("isIssued", issued);
            conV.put("isReturned", returned);
            conV.put("isReIssued", reIssued);
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

    public int deleteBookFromDatabase(Integer bookId) {
        try {
            db.delete(MyOpenHelper.bookMaster, "bookId=" + bookId, null);
            return 1;
        } catch (Exception e) {
            Log.e("Error At", " " + e);
            e.printStackTrace();
            return 0;
        }
    }

    public Integer insertIntoOpenClose(Integer id, Integer isOpen, Integer isClose) {
        try {
            ContentValues conV = new ContentValues();
            conV.put("openCloseId", id);
            conV.put("openBookIssue", isOpen);
            conV.put("closeBookIssue", isClose);
            db.insert(MyOpenHelper.openClose, null, conV);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public Integer updateOpenClose(Integer Id, Integer open, Integer close) {
        try {
            ContentValues conV = new ContentValues();
            conV.put("openBookIssue", open);
            db.update(MyOpenHelper.openClose, conV, "openCloseId='" + Id + "'", null);
            conV.put("closeBookIssue", close);
            db.update(MyOpenHelper.openClose, conV, "openCloseId='" + Id + "'", null);
            Log.v("DataHelp", "Updated OpenClose Successfully");
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Integer updateReturnedBookStatus(Integer id) {
        Integer one = 1, zero = 0;
        try {
            ContentValues conV = new ContentValues();
            conV.put("isIssued", zero);
            db.update(MyOpenHelper.bookMaster, conV, "bookId='" + id + "'",null);
            conV.put("isReturned",one);
            db.update(MyOpenHelper.bookMaster, conV, "bookId='" + id + "'",null);
            conV.put("isReIssued", zero);
            db.update(MyOpenHelper.bookMaster, conV, "bookId='" + id + "'",null);
            return 1;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Cursor getBookIssueFormRecords() {
        Cursor c;
        try {
            c = db.rawQuery("select * from  " + MyOpenHelper.openClose, null);
            return c;
        } catch (Exception e) {
            Log.e("Error At", " " + e);
            e.printStackTrace();
            // TODO: handle exception
            return null;
        }
    }
}

