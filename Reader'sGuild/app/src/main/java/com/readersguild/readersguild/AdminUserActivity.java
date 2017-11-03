package com.readersguild.readersguild;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by vrinda on 14-07-2017.
 */

public class AdminUserActivity extends Activity {

    private Button button1, button2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_user);

        button1 = (Button) findViewById(R.id.button_admin);
        button2 = (Button) findViewById(R.id.button_user);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminUserActivity.this, AdminLoginActivity.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminUserActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
