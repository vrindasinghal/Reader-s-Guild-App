package com.readersguild.readersguild;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by vrinda on 16-10-2017.
 */

public class AllotedBookListActivity extends AppCompatActivity {
    DataHelpAddBook dataHelpAddBook;
    MyOpenHelper myOpenHelper;

    private ArrayList<String> arrayListBookName;
    private ArrayList<Integer> arrayListBookId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alloted_book_list);
        ListView listView_custom_allotedBooks = (ListView) findViewById(R.id.listView_custom_allotedBooks);

        myOpenHelper = new MyOpenHelper(this);
        dataHelpAddBook = new DataHelpAddBook(this);

        arrayListBookName = new ArrayList<String>();
        arrayListBookId = new ArrayList<Integer>();

        getAllotedBooks();

        CustomAdapter adapter = new CustomAdapter(AllotedBookListActivity.this, R.layout.activity_custom_list_view, arrayListBookName, arrayListBookId);
        listView_custom_allotedBooks.setAdapter(adapter);

    }

    private void getAllotedBooks() {
        Cursor c1;
        try {
            /**** OPEN OR CREATE DATABASE *****/
            dataHelpAddBook.db = openOrCreateDatabase(MyOpenHelper.DATABASE_NAME, 0, null);
            /** THIS METHOD IS USED TO GET ALL RECORDS FROM DB */
            c1 = dataHelpAddBook.getBookRecords();
            if (c1.moveToFirst()) {
                Log.v("Message in C1", "Not Null");
                do {
                    Integer BookId = c1.getInt(0);
                    String bookName = c1.getString(1);
                    Integer issued = c1.getInt(5), returned = c1.getInt(6);
                    if (issued == 1 && returned == 0) {
                        arrayListBookId.add(BookId);
                        arrayListBookName.add(bookName);
                        Log.v("srNumber", "" + BookId);
                        Log.v("slipDate", "" + bookName);
                    }
                } while (c1.moveToNext());
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}

//TODO: Add issuing persons roll no.(need to change the custom_list_view and add an item in the array list)