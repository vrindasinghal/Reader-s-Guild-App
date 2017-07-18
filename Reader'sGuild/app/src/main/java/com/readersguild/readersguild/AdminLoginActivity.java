package com.readersguild.readersguild;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by vrinda on 14-07-2017.
 */

public class AdminLoginActivity extends AppCompatActivity {

    DataHelpAdminLogin dataHelp;
    MyOpenHelper myOpenHelper;
    private Button b1;
    private EditText e1, e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        b1 = (Button) findViewById(R.id.btn_admin_login);
        e1 = (EditText) findViewById(R.id.input_admin_Id);
        e2 = (EditText) findViewById(R.id.input_admin_password);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (e1.equals() && e2.equals())
                {
                    Intent intent = new Intent(AdminLoginActivity.this, AdminMainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
