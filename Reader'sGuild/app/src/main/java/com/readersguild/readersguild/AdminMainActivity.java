package com.readersguild.readersguild;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

/**
 * Created by vrinda on 18-07-2017.
 */

public class AdminMainActivity extends AppCompatActivity {

    GridView grid;
    String[] web = {"Add Book","Open Book Issue Form","List of Alloted Books","Remove Book","List of Contributors of Books",
            "Return Book"};
    int[] imageId = {

            R.drawable.rg_add_book,
            R.drawable.rg_book_issue_form,
            R.drawable.rg_alloted_books,
            R.drawable.rg_remove_book,
            R.drawable.rg_book_contributors,
            R.drawable.rg_return_book,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);

        CustomGridAdminMainActivity adapter = new CustomGridAdminMainActivity(AdminMainActivity.this, web, imageId);
        grid = (GridView) findViewById(R.id.grid);
        grid.setAdapter(adapter);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(AdminMainActivity.this, "You Clicked at " + web[+i], Toast.LENGTH_SHORT).show();
            }
        });
    }
}