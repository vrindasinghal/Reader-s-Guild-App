package com.readersguild.readersguild;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by vrinda on 21-07-2017.
 */

public class RemoveBookActivity extends AppCompatActivity {

    EditText bookIdToBeRemoved;
    DataHelpAddBook dataHelpRemoveBook;
    Integer bookID;
    Button removeBook;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_book);

        dataHelpRemoveBook = new DataHelpAddBook(this);

        bookIdToBeRemoved = (EditText) findViewById(R.id.editText_bookId);
        removeBook = (Button) findViewById(R.id.btn_removeBook);

        removeBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bookID = Integer.parseInt(bookIdToBeRemoved.getText().toString());
                int isDeleted = dataHelpRemoveBook.deleteBookFromDatabase(bookID);
                if (isDeleted == 1) {
                    Toast.makeText(RemoveBookActivity.this, "Book Removed Successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RemoveBookActivity.this, "Book removal failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
