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
 * Created by vrinda on 21-07-2017.
 */

public class CustomAdapter extends ArrayAdapter {

    Context con;
    private ArrayList<String> arrayListBookName;
    private ArrayList<Integer> arrayListBookId;
    int layout;
    int i;

    public CustomAdapter(@NonNull Context context, @LayoutRes int resource,
                         ArrayList<String> getName, ArrayList<Integer> getId) {
        super(context, resource, getName);


        this.con = context;
        this.arrayListBookName = getName;
        this.arrayListBookId = getId;
        this.layout = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflter = (LayoutInflater) con
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflter.inflate(layout, parent, false);

        TextView textViewName = (TextView) rowView
                .findViewById(R.id.textView_Name);

        TextView textViewBId = (TextView) rowView
                .findViewById(R.id.textView_bId);

        String getNameFromArraylist = arrayListBookName.get(position).toString();
        textViewName.setText(getNameFromArraylist);
        Integer getId = arrayListBookId.get(position);
        textViewBId.setText(getId);
        return rowView;
    }
}

