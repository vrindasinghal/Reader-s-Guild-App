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
    private ArrayList<String> arrayListContributorsName;
    private ArrayList<Integer> arrayListContributorsRollNumber;
    int layout;

    public CustomAdapterSecond(@NonNull Context context, @LayoutRes int resource, ArrayList<String> getBookNames,
                               ArrayList<Integer> getBookId, ArrayList<String> getContributorsName, ArrayList<Integer> getContributorsRollNumber) {
        super(context, resource, getBookNames);

        this.con = context;
        this.arrayListBookName = getBookNames;
        this.arrayListBookId = getBookId;
        this.arrayListContributorsName = getContributorsName;
        this.arrayListContributorsRollNumber = getContributorsRollNumber;
        this.layout = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) con
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout, parent, false);

        TextView textViewBookName = (TextView) rowView
                .findViewById(R.id.textView_Name);

        TextView bookId = (TextView) rowView
                .findViewById(R.id.textView_bId);

        TextView textViewContributorsName = (TextView) rowView
                .findViewById(R.id.textView_contributors_name);

        TextView rollNumber = (TextView) rowView
                .findViewById(R.id.textView_contributors_roll_number);

        String getBookNameFromArrayList = arrayListBookName.get(position).toString();
        textViewBookName.setText(getBookNameFromArrayList);

        Integer getBookId = arrayListBookId.get(position);
        bookId.setText("" + getBookId);

        String getContributorsNameFromArrayList = arrayListContributorsName.get(position).toString();
        textViewContributorsName.setText(getContributorsNameFromArrayList);

        Integer getRollNumber = arrayListContributorsRollNumber.get(position);
        rollNumber.setText("" + getRollNumber);

        return rowView;
    }
}
