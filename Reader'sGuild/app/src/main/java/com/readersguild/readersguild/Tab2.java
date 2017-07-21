package com.readersguild.readersguild;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by vrinda on 13-07-2017.
 */

public class Tab2 extends Fragment {

   /* DataHelpAddBook dataHelpAddBook;
    MyOpenHelper myOpenHelper;
    private ArrayList<String> arrayListBookName;
    private ArrayList<Integer> arrayListBookId;*/

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /*View rootView = inflater.inflate(R.layout.tab_2, container, false)*/;

        /*myOpenHelper=new MyOpenHelper(getActivity());
        dataHelpAddBook=new DataHelpAddBook(getActivity());
        arrayListBookName = new ArrayList<>();
        View hiddenInfo = inflater.inflate(R.layout.activity_custom_list_view, null);
        ListView listView = (ListView) hiddenInfo.findViewById(listView_custom);

        arrayListBookName = new ArrayList<String>();
        arrayListBookId = new ArrayList<Integer>();
        bindDataInArrayList();
        CustomAdapter adapter = new CustomAdapter(Tab2.this, R.layout.activity_custom_list_view, arrayListBookName, arrayListBookId);
        listView_custom.setAdapter(adapter);

        return rootView;

    }*/
        return inflater.inflate(R.layout.tab_2, container, false);
    }
}