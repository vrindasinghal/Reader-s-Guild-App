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
    private EditText editTextBookId, bookName, contributorsName, contributorsRollNo;
    private Integer bookID, cRollNo, iRollNo = 0, issued = 0, returned = 1, reIssued = 0;

    DataHelpAddBook DataHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        DataHelp = new DataHelpAddBook(this);

        editTextBookId = (EditText) findViewById(R.id.editText_bookId);
        bookName = (EditText) findViewById(R.id.editText_bookName);
        contributorsName = (EditText) findViewById(R.id.editText_contributorsName);
        contributorsRollNo = (EditText) findViewById(R.id.editText_contributorsRollNo);
        addBook = (Button) findViewById(R.id.btn_addBook);

        addBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextBookId.getText().toString().equals("")) {
                    Toast.makeText(AddBookActivity.this, "Book ID cannot be empty", Toast.LENGTH_SHORT).show();
                } else if (bookName.getText().toString().equals("")) {
                    Toast.makeText(AddBookActivity.this, "Please Enter BookName", Toast.LENGTH_SHORT).show();
                } else if (contributorsName.getText().toString().equals("")) {
                    Toast.makeText(AddBookActivity.this, "Please Enter Contributor's Name", Toast.LENGTH_SHORT).show();
                } else if (contributorsName.getText().toString().equals("")) {
                    Toast.makeText(AddBookActivity.this, "Please Enter Contributor's Roll No.", Toast.LENGTH_SHORT).show();
                } else {
                    bookID = Integer.parseInt(editTextBookId.getText().toString());
                    cRollNo = Integer.parseInt(contributorsRollNo.getText().toString());
                    int isInserted = DataHelp.insertNewBookInBookMaster(bookID, bookName.getText().toString(), contributorsName.getText().toString(), cRollNo, iRollNo, issued, returned, reIssued);
                    if (isInserted == 1) {
                        Toast.makeText(AddBookActivity.this, "Book Added Successfully", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(AddBookActivity.this, "Book Insertion failed", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}

