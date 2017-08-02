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

import java.util.ArrayList;

/**
 * Created by vrinda on 13-07-2017.
 */

public class Tab2 extends Fragment {
    DataHelpAddBook dataHelpAddBook;
    MyOpenHelper myOpenHelper;
    private ArrayList<String> arrayListBookName;
    private ArrayList<Integer> arrayListBookId;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_2, container, false);
        ListView listView = (ListView) rootView.findViewById(R.id.listView_custom);

        myOpenHelper = new MyOpenHelper(getActivity());
        dataHelpAddBook = new DataHelpAddBook(getActivity());
        arrayListBookName = new ArrayList<>();
        arrayListBookName = new ArrayList<String>();
        arrayListBookId = new ArrayList<Integer>();

        getBookDetails();

        CustomAdapter adapter = new CustomAdapter(getActivity(), R.layout.activity_custom_list_view, arrayListBookName, arrayListBookId);
        listView.setAdapter(adapter);
        return rootView;
    }

    private void getBookDetails() {
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
                    arrayListBookId.add(BookId);
                    arrayListBookName.add(bookName);
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
