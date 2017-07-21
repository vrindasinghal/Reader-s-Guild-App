package com.readersguild.readersguild;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by vrinda on 13-07-2017.
 */

public class Tab2 extends Fragment {

    DataHelpAddBook dataHelpAddBook;
    MyOpenHelper myOpenHelper;
    private ArrayList<String> arrayListBookName;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        return inflater.inflate(R.layout.tab_2, container, false);
    }
}
