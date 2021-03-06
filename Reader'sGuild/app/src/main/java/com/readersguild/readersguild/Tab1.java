package com.readersguild.readersguild;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by vrinda on 13-07-2017.
 */

public class Tab1 extends Fragment {

    private DataHelpUserLogin dataHelpUserLogin;
    private Integer USER_ROLL_NUMBER;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        dataHelpUserLogin = new DataHelpUserLogin(getActivity());
        getRecordsFromDatabase();
        return inflater.inflate(R.layout.tab_1, container, false);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
        return;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout_menu:
                if (dataHelpUserLogin.getStatus(USER_ROLL_NUMBER)) {
                    Intent intent = new Intent(getActivity(), AdminUserActivity.class);
                    startActivity(intent);
                    dataHelpUserLogin.updateStatus(USER_ROLL_NUMBER);
                    return true;
                }
        }
        return onOptionsItemSelected(item);
    }

    public void getRecordsFromDatabase() {
        Cursor c1;
        try {
            /**** OPEN OR CREATE DATABASE *****/
            dataHelpUserLogin.db = getActivity().openOrCreateDatabase(MyOpenHelper.DATABASE_NAME, 0, null);
            /** THIS METHOD IS USED TO GET ALL RECORDS FROM DB */
            c1 = dataHelpUserLogin.getRollNumber();
            /** check if returned cursor not null **/
            if (c1.moveToFirst()) {
                Log.v("Message in C1", "Not Null");
                do {
                    //int a = c1.getColumnCount();
                    USER_ROLL_NUMBER = c1.getInt(0);
                    Log.v("UserRollNumber", "" + USER_ROLL_NUMBER);
                } while (c1.moveToNext());
            }
            //dh.db.close();
        } catch (Exception e) { // TODO: handle exception
            e.printStackTrace();
        }
    }
}
