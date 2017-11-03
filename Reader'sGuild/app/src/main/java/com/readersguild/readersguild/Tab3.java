package com.readersguild.readersguild;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by vrinda on 13-07-2017.
 */

public class Tab3 extends Fragment {
    private Integer open, close;
    DataHelpAddBook dataHelpAddBook;
    MyOpenHelper myOpenHelper;

    private ArrayList<String> arrayListBookName;
    private ArrayList<Integer> arrayListBookId;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView1 = inflater.inflate(R.layout.tab_3, container, false);
        ListView listView = (ListView) rootView1.findViewById(R.id.listView_custom_available_books);

        myOpenHelper = new MyOpenHelper(getActivity());
        dataHelpAddBook = new DataHelpAddBook(getActivity());

        arrayListBookName = new ArrayList<String>();
        arrayListBookId = new ArrayList<Integer>();

        getIssueFormState();
        if (open == 1 && close == 0) {
            getAvailableBooks();
            CustomAdapter adapter = new CustomAdapter(getActivity(), R.layout.activity_custom_list_view, arrayListBookName, arrayListBookId);
            listView.setAdapter(adapter);
            //Toast.makeText(Tab3.this.getActivity(), "Open State", Toast.LENGTH_SHORT).show();
        } else if (open == 0 && close == 1) {
            Toast.makeText(Tab3.this.getActivity(), "Book issue form is closed", Toast.LENGTH_SHORT).show();
        }
        return rootView1;
    }

    private void getAvailableBooks() {
        Cursor c1;
        try {
            /**** OPEN OR CREATE DATABASE *****/
            dataHelpAddBook.db = getActivity().openOrCreateDatabase(MyOpenHelper.DATABASE_NAME, 0, null);
            /** THIS METHOD IS USED TO GET ALL RECORDS FROM DB */
            c1 = dataHelpAddBook.getBookRecords();
            if (c1.moveToFirst()) {
                Log.v("Message in C1", "Not Null");
                do {
                    Integer BookId = c1.getInt(0);
                    String bookName = c1.getString(1);
                    Integer issued = c1.getInt(5), returned = c1.getInt(6);
                    if (issued == 0 && returned == 1) {
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

    private void getIssueFormState() {
        Cursor c1;
        try {
            /**** OPEN OR CREATE DATABASE *****/
            dataHelpAddBook.db = getActivity().openOrCreateDatabase(MyOpenHelper.DATABASE_NAME, 0, null);
            /** THIS METHOD IS USED TO GET ALL RECORDS FROM DB */
            c1 = dataHelpAddBook.getBookIssueFormRecords();
            if (c1.moveToFirst()) {
                Log.v("Message in C1", "Not Null");
                do {
                    open = c1.getInt(1);
                    close = c1.getInt(2);
                } while (c1.moveToNext());
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}

