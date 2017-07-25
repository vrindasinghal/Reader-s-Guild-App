package com.readersguild.readersguild;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by vrinda on 19-07-2017.
 */

public class SignUpActivity extends AppCompatActivity {

    private TextView login_link;
    private Button signup_button;
    private EditText editTextName, editTextEmail, editTextMobileNumber, editTextPassword, editTextBranch, editTextRollNo, editTextHostel, editTextRoom;

    private int uMobNo,uRollNo;

    DataHelpUserLogin dataHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        dataHelp = new DataHelpUserLogin(this);
        signup_button = (Button) findViewById(R.id.btn_signup);

        editTextName = (EditText) findViewById(R.id.input_signup_name);
        editTextEmail = (EditText) findViewById(R.id.input_signup_email);
        editTextMobileNumber = (EditText) findViewById(R.id.input_signup_mNumber);
        editTextPassword = (EditText) findViewById(R.id.input_signup_password);
        editTextBranch = (EditText) findViewById(R.id.input_signup_branch);
        editTextRollNo = (EditText) findViewById(R.id.input_signup_rollno);
        editTextHostel = (EditText) findViewById(R.id.input_signup_hostel);
        editTextRoom = (EditText) findViewById(R.id.input_signup_room);

        signup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uMobNo = Integer.parseInt(editTextMobileNumber.getText().toString());
                uRollNo = Integer.parseInt(editTextRollNo.getText().toString());
                Integer isUserInserted = dataHelp.insertNewRecordInUserMaster(uMobNo, editTextName.getText().toString(),
                        editTextEmail.getText().toString(),
                        editTextPassword.getText().toString().trim(),
                        editTextBranch.getText().toString(), uRollNo,
                        editTextHostel.getText().toString(), editTextRoom.getText().toString());
                if (isUserInserted == 1) {
                    Toast.makeText(SignUpActivity.this, "User Inserted Into DataBase", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SignUpActivity.this, "Failed To Insert User Into DataBase", Toast.LENGTH_SHORT).show();
                }
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