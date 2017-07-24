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
    Integer i = 1;
    DataHelpUserLogin dataHelpUserLogin;
    private EditText editTextUserMobNo, editTextUserPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataHelpUserLogin = new DataHelpUserLogin(this);

        editTextUserMobNo = (EditText) findViewById(R.id.input_mobile_number);
        editTextUserPassword = (EditText) findViewById(R.id.input_password);
        b1 = (Button) findViewById(R.id.btn_login);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextUserMobNo.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Please Enter Mobile Number", Toast.LENGTH_SHORT).show();
                } else if (editTextUserPassword.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                } else {
                    Integer convertMobNo = Integer.parseInt(editTextUserMobNo.getText().toString().trim());
                    if (dataHelpUserLogin.isUserValid(convertMobNo, editTextUserPassword.getText().toString().trim())) {
                        Intent intent = new Intent(MainActivity.this, TabActivity.class);
                        startActivity(intent);



                        //CHANGES
                        /*int isInserted = dataHelpUserLogin.insertRecordInLoginLogut("9999999999", i);
                        if (isInserted == 1) {


                        } else {
                            Toast.makeText(MainActivity.this, "Sorry!! Something Wrong", Toast.LENGTH_SHORT).show();
                        }*/

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
