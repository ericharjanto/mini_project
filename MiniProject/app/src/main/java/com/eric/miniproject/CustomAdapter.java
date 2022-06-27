package com.eric.miniproject;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {

    Context c;
    List<ArrayList> data;
    LayoutInflater inflater;

    public CustomAdapter(Context c , List data){
        this.c = c;
        this.data = data;
        inflater = LayoutInflater.from(c);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.listview, null);
        TextView tv = (TextView) view.findViewById(R.id.textView4);
        tv.setText(String.valueOf(data.get(i)));

        Log.d("Data", String.valueOf(data.get(i)));
        return view;
    }
}
