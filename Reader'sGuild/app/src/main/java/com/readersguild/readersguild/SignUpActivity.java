package com.readersguild.readersguild;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by vrinda on 19-07-2017.
 */

public class SignUpActivity extends AppCompatActivity {

    private TextView login_link;
    private Button signup_button;

    //DataBase
    DataHelpUserLogin dataHelp;
    MyOpenHelper myOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //DB
        myOpenHelper = new MyOpenHelper(this);
        dataHelp = new DataHelpUserLogin(this);

        signup_button = (Button) findViewById(R.id.btn_signup);
        signup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //dataHelp.insertNewRecordInUserMaster();
            }
        });

        login_link = (TextView) findViewById(R.id.link_login);
        login_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}