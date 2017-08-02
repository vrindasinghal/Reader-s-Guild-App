package com.readersguild.readersguild;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by vrinda on 13-07-2017.
 */

public class Tab3 extends Fragment {
    private Integer open, close;
    DataHelpAddBook dataHelpAddBook;
    MyOpenHelper myOpenHelper;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView1 = inflater.inflate(R.layout.tab_3, container, false);

        myOpenHelper = new MyOpenHelper(getActivity());
        dataHelpAddBook = new DataHelpAddBook(getActivity());

        getIssueFormState();
        if (open == 1 && close == 0) {
            //todo
            Toast.makeText(Tab3.this.getActivity(), "Open State", Toast.LENGTH_SHORT).show();
        } else if (open == 0 && close == 1) {
            //todo
            Toast.makeText(Tab3.this.getActivity(), "Closed State", Toast.LENGTH_SHORT).show();
        }
        return rootView1;
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

