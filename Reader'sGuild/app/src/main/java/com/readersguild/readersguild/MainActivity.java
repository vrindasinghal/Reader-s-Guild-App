package com.readersguild.readersguild;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button b1;
    private TextView signup_link;
    private Integer one=1;
    DataHelpUserLogin dataHelpUserLogin;
    private EditText editTextUserRollNo, editTextUserPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataHelpUserLogin = new DataHelpUserLogin(this);

        editTextUserRollNo = (EditText) findViewById(R.id.input_roll_number);
        editTextUserPassword = (EditText) findViewById(R.id.input_password);
        b1 = (Button) findViewById(R.id.btn_login);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextUserRollNo.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Please Enter Roll Number", Toast.LENGTH_SHORT).show();
                } else if (editTextUserPassword.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                } else {
                    Integer convertRollNo = Integer.parseInt(editTextUserRollNo.getText().toString().trim());
                    if (dataHelpUserLogin.isUserValid(convertRollNo, editTextUserPassword.getText().toString().trim())) {
                        int isInserted = dataHelpUserLogin.insertRecordInLoginLogut(convertRollNo,one);
                        if (isInserted == 1) {
                            Intent intent = new Intent(MainActivity.this, TabActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this, "Sorry!! Something went Wrong", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "Sorry!! Invalid user", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        signup_link = (TextView) findViewById(R.id.link_signup);
        signup_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}
