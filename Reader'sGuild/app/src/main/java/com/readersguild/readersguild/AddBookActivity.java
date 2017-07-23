package com.readersguild.readersguild;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by vrinda on 19-07-2017.
 */

public class AddBookActivity extends AppCompatActivity {

    private Button addBook;
    private EditText editTextBookId, bookName, contributorsName, contributorsMobileNo;
    private Integer bookID;
    private Long cMobNo;

    DataHelpAddBook DataHelp;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        DataHelp = new DataHelpAddBook(this);

        editTextBookId = (EditText) findViewById(R.id.editText_bookId);
        bookName = (EditText) findViewById(R.id.editText_bookName);
        contributorsName = (EditText) findViewById(R.id.editText_contributorsName);
        contributorsMobileNo = (EditText) findViewById(R.id.editText_contributorsMobileNo);
        addBook = (Button) findViewById(R.id.btn_addBook);
        addBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bookID = Integer.parseInt(editTextBookId.getText().toString());
                cMobNo = Long.parseLong(contributorsMobileNo.getText().toString());
                int isInserted = DataHelp.insertNewBookInBookMaster(bookID, bookName.getText().toString(), contributorsName.getText().toString(), cMobNo);
                if (isInserted == 1) {
                    Toast.makeText(AddBookActivity.this, "Book Added Successfully", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(AddBookActivity.this, "Book Insertion failed", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}

