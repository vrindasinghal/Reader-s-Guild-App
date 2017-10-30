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
 * Created by vrinda on 30-10-2017.
 */

public class CustomAdapterSecond extends ArrayAdapter {
    Context con;
    private ArrayList<String> arrayListBookName;
    private ArrayList<Integer> arrayListBookId;
    private ArrayList<String> arrayListContributersName;
    private ArrayList<Integer> arrayListContributersRollNumber;
    int layout;

    public CustomAdapterSecond(@NonNull Context context, @LayoutRes int resource, ArrayList<String> getBookNames,
                               ArrayList<Integer> getBookId, ArrayList<String> getContributersName,ArrayList<Integer> getContributersRollNumber) {
        super(context, resource, getBookNames);

        this.con = context;
        this.arrayListBookName = getBookNames;
        this.arrayListBookId = getBookId;
        this.arrayListContributersName = getContributersName;
        this.arrayListContributersRollNumber=getContributersRollNumber;
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

        TextView textViewContributersName = (TextView) rowView
                .findViewById(R.id.textView_contributers_name);

        TextView rollNumber = (TextView) rowView
                .findViewById(R.id.textView_contributers_roll_number);

        String getBookNameFromArraylist = arrayListBookName.get(position).toString();
        textViewBookName.setText(getBookNameFromArraylist);

        Integer getBookId = arrayListBookId.get(position);
        bookId.setText("" + getBookId);

        String getContributersNameFromArrayList=arrayListContributersName.get(position).toString();
        textViewContributersName.setText(getContributersNameFromArrayList);

        Integer getRollNumber = arrayListContributersRollNumber.get(position);
        rollNumber.setText("" + getRollNumber);

        return rowView;
    }
}
