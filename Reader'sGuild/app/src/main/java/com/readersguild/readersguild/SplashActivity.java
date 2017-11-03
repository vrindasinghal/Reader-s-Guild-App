package com.readersguild.readersguild;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

/**
 * Created by vrinda on 13-07-2017.
 */

public class SplashActivity extends Activity {
    private static int SPLASH_TIME_OUT = 2000;

    DataHelpAdminLogin dataHelp;
    DataHelpUserLogin dataHelpUserLogin;
    MyOpenHelper myOpenHelper;
    Cursor c1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        myOpenHelper = new MyOpenHelper(this);
        dataHelp = new DataHelpAdminLogin(this);
        dataHelp.insertNewRecordInAdminMaster(123, "123");
        dataHelpUserLogin = new DataHelpUserLogin(this);
        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                getRecordLoginLogout();
            }
        }, SPLASH_TIME_OUT);
    }

    private void getRecordLoginLogout() {
        try {
            Log.v("TAG", "In getRecordLoginLogout");
            /**** OPEN OR CREATE DATABASE *****/
            dataHelpUserLogin.db = openOrCreateDatabase(MyOpenHelper.DATABASE_NAME, 0, null);

            /** THIS METHOD IS USED TO GET ALL RECORDS FROM DB */
            c1 = dataHelpUserLogin.getRecordFromLoginLogout();

            /** check if returned cursor not null **/
            if (c1.moveToFirst()) {
                Log.v("TAG", "Not Null");
                do {
                    Integer status = Integer.parseInt(c1.getString(1).trim());
                    if (status == 0) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent i = new Intent(SplashActivity.this, AdminUserActivity.class);
                                startActivity(i);
                                finish();
                            }
                        }, SPLASH_TIME_OUT);
                    } else {
                        Intent i = new Intent(SplashActivity.this, TabActivity.class);
                        startActivity(i);
                    }
                } while (c1.moveToNext());
            } else {
                Log.v("TAG", "LoginLogout null, Cant check Status");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent i = new Intent(SplashActivity.this, AdminUserActivity.class);
                        startActivity(i);
                        finish();
                    }
                }, SPLASH_TIME_OUT);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

