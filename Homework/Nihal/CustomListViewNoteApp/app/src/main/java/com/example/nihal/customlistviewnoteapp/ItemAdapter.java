package com.example.nihal.customlistviewnoteapp;

import android.content.ClipData;
import android.content.Context;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class ItemAdapter extends  BaseAdapter {


    private ArrayList<TotalItem> arrayList;

    public ItemAdapter(ArrayList<TotalItem> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View inflatedView;
        LayoutInflater li = LayoutInflater.from(parent.getContext());
        if(convertView == null)
            inflatedView = li.inflate(R.layout.layout_row,parent,false);
        else
            inflatedView=convertView;

        final TotalItem currentPosition = (TotalItem) getItem(position);

        TextView noteTitle,noteTime;
        noteTitle = inflatedView.findViewById(R.id.tvTitle);
        noteTime = inflatedView.findViewById(R.id.tvTime);


        Button btnDelete = inflatedView.findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.remove(position);
                notifyDataSetChanged();

            }
        });

        noteTime.setText(currentPosition.getTime());
        //noteTime.setText(DateUtils.getRelativeDateTimeString(this, secondsAgo, DateUtils.SECOND_IN_MILLIS, DateUtils.WEEK_IN_MILLIS, DateUtils.FORMAT_ABBREV_ALL));
        noteTitle.setText(currentPosition.getTitle());
        return inflatedView;
    }
}