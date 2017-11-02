package com.readersguild.readersguild;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by vrinda on 02-11-2017.
 */

public class ReturnBookActivity extends AppCompatActivity {

    EditText editTextToReturnBookId;
    Button btnReturnBook;
    Integer toReturnBookId;
    DataHelpAddBook dataHelpReturnBook;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_return_book);

        dataHelpReturnBook = new DataHelpAddBook(this);

        editTextToReturnBookId = (EditText) findViewById(R.id.editText_toReturn_bookId);
        btnReturnBook = (Button) findViewById(R.id.btn_returnBook);

        btnReturnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toReturnBookId = Integer.parseInt(editTextToReturnBookId.getText().toString());
                int isReturned = dataHelpReturnBook.updateReturnedBookStatus(toReturnBookId);
                if (isReturned == 1) {
                    Toast.makeText(ReturnBookActivity.this, "Book Returned Successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ReturnBookActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
