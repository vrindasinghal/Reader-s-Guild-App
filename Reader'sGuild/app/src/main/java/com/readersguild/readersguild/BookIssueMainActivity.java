package com.readersguild.readersguild;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by vrinda on 01-08-2017.
 */

public class BookIssueMainActivity extends AppCompatActivity {

    private TextView link_open, link_close;
    DataHelpAddBook dataHelpAddBook;
    private Integer one = 1, zero = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_issue_form);

        dataHelpAddBook = new DataHelpAddBook(this);

        link_open = (TextView) findViewById(R.id.textView_open);
        link_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int isInserted = dataHelpAddBook.insertIntoOpenClose(one, zero);
                if (isInserted == 1) {
                    Toast.makeText(BookIssueMainActivity.this, "Book Issue Form Is Now Open", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(BookIssueMainActivity.this, "Unable to Open Book Issue Form", Toast.LENGTH_SHORT).show();
                }
            }
        });

        link_close = (TextView) findViewById(R.id.textView_close);
        link_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int isInserted = dataHelpAddBook.insertIntoOpenClose(zero,one);
                if (isInserted == 1) {
                    Toast.makeText(BookIssueMainActivity.this, "Book Issue Form Is Now Closed", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(BookIssueMainActivity.this, "Unable to Close Book Issue Form", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
