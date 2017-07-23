package com.readersguild.readersguild;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by vrinda on 22-07-2017.
 */

public class CustomAdapter extends ArrayAdapter {

    Context con;
    private ArrayList<String> arrayListBookName;
    private ArrayList<Integer> arrayListBookId;
    int layout;
    int i;


    public CustomAdapter(@NonNull Context context, @LayoutRes int resource, ArrayList<String> getBookNames,
                         ArrayList<Integer> getBookId) {
        super(context, resource, getBookNames);

        this.con = context;
        this.arrayListBookName = getBookNames;
        this.arrayListBookId = getBookId;
        this.layout = resource;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflter = (LayoutInflater) con
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflter.inflate(layout, parent, false);

        TextView textViewBookName = (TextView) rowView
                .findViewById(R.id.textView_Name);

        TextView bookId = (TextView) rowView
                .findViewById(R.id.textView_bId);

        String getBookNameFromArraylist = arrayListBookName.get(position).toString();
        textViewBookName.setText(getBookNameFromArraylist);
        Integer getBookId = arrayListBookId.get(position);
        bookId.setText("" + getBookId);
        return rowView;
    }


}


