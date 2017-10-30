package com.readersguild.readersguild;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by vrinda on 30-10-2017.
 */

public class ContributersListActivity extends AppCompatActivity {

    DataHelpAddBook dataHelpAddBook;
    MyOpenHelper myOpenHelper;

    private ArrayList<String> arrayListBookName;
    private ArrayList<Integer> arrayListBookId;
    private ArrayList<String> arrayListContributersName;
    private ArrayList<Integer> arrayListContributersRollNumber;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contributers_list);
        ListView listView_custom_contributers_list = (ListView) findViewById(R.id.listView_custom_contributers_list);

        myOpenHelper = new MyOpenHelper(this);
        dataHelpAddBook = new DataHelpAddBook(this);

        arrayListBookName = new ArrayList<String>();
        arrayListBookId = new ArrayList<Integer>();
        arrayListContributersName = new ArrayList<String>();
        arrayListContributersRollNumber = new ArrayList<Integer>();

        getContributersName();

        CustomAdapterSecond adapter = new CustomAdapterSecond(ContributersListActivity.this, R.layout.activity_custom_list_view_second, arrayListBookName, arrayListBookId, arrayListContributersName, arrayListContributersRollNumber);
        listView_custom_contributers_list.setAdapter(adapter);

    }

    private void getContributersName() {
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
                    String contributersName = c1.getString(2);
                    Integer contributersRollNumber = c1.getInt(3);
                    arrayListBookId.add(BookId);
                    arrayListBookName.add(bookName);
                    arrayListContributersName.add(contributersName);
                    arrayListContributersRollNumber.add(contributersRollNumber);
                    Log.v("srNumber", "" + BookId);
                    Log.v("slipDate", "" + bookName);
                } while (c1.moveToNext());
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}