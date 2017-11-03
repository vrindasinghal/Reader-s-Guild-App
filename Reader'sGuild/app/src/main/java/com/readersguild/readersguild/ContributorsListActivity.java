package com.readersguild.readersguild;

import android.app.Dialog;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by vrinda on 30-10-2017.
 */

public class ContributorsListActivity extends AppCompatActivity {

    DataHelpAddBook dataHelpFindContributor;
    MyOpenHelper myOpenHelper;

    EditText bookIDToFindContributor;
    Integer bookID;

    private String contributorsName;
    private Integer contributorsRollNumber;

    private ArrayList<String> arrayListBookName;
    private ArrayList<Integer> arrayListBookId;
    private ArrayList<String> arrayListContributorsName;
    private ArrayList<Integer> arrayListContributorsRollNumber;

    private TextView searchLink;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contributors_list);
        ListView listView_custom_contributors_list = (ListView) findViewById(R.id.listView_custom_contributors_list);

        myOpenHelper = new MyOpenHelper(this);
        dataHelpFindContributor = new DataHelpAddBook(this);

        arrayListBookName = new ArrayList<String>();
        arrayListBookId = new ArrayList<Integer>();
        arrayListContributorsName = new ArrayList<String>();
        arrayListContributorsRollNumber = new ArrayList<Integer>();

        bookIDToFindContributor = (EditText) findViewById(R.id.input_search_bookid);

        getContributorsName();

        CustomAdapterSecond adapter = new CustomAdapterSecond(ContributorsListActivity.this, R.layout.activity_custom_list_view_second, arrayListBookName, arrayListBookId, arrayListContributorsName, arrayListContributorsRollNumber);
        listView_custom_contributors_list.setAdapter(adapter);

        searchLink = (TextView) findViewById(R.id.search_button);

        searchLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
    }

    private void showDialog() {
        final Dialog dialog = new Dialog(ContributorsListActivity.this);
        dialog.setContentView(R.layout.activity_custom_dialog_search_contributor);

        dialog.setTitle("Search Contributor");

        Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonFindContributor);
        //if button is clicked, close the custom dialog
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookID = Integer.parseInt(bookIDToFindContributor.getText().toString());
                getContributor();
                dialog.dismiss();
                //TODO:
                //Show a new dialog to display the search results.
            }
        });
        dialog.show();

    }

    private void getContributor() {
        Cursor c1;
        try {
            /**** OPEN OR CREATE DATABASE *****/
            dataHelpFindContributor.db = openOrCreateDatabase(MyOpenHelper.DATABASE_NAME, 0, null);
            /** THIS METHOD IS USED TO GET ALL RECORDS FROM DB */
            c1 = dataHelpFindContributor.getBookRecords();
            if (c1.moveToFirst()) {
                Log.v("Message in C1", "Not Null");
                do {
                    Integer allBookId = c1.getInt(0);
                    if (allBookId == bookID) {
                        contributorsName = c1.getString(2);
                        contributorsRollNumber = c1.getInt(3);
                        break;
                    }
                } while (c1.moveToNext());
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    private void getContributorsName() {
        Cursor c1;
        try {
            /*OPEN OR CREATE DATABASE*/
            dataHelpFindContributor.db = openOrCreateDatabase(MyOpenHelper.DATABASE_NAME, 0, null);
            /*THIS METHOD IS USED TO GET ALL RECORDS FROM DATABASE*/
            c1 = dataHelpFindContributor.getBookRecords();
            if (c1.moveToFirst()) {
                Log.v("Message in C1", "Not Null");
                do {
                    Integer BookId = c1.getInt(0);
                    String bookName = c1.getString(1);
                    String contributorsName = c1.getString(2);
                    Integer contributorsRollNumber = c1.getInt(3);
                    arrayListBookId.add(BookId);
                    arrayListBookName.add(bookName);
                    arrayListContributorsName.add(contributorsName);
                    arrayListContributorsRollNumber.add(contributorsRollNumber);
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