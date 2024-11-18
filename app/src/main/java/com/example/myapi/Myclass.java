package com.example.myapi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Myclass extends BaseAdapter {

    String[] array;
    MainActivity mainActivity;

    public Myclass(String[] array, MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        this.array = array;
    }

    @Override
    public int getCount() {
        return array.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return (long) position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(mainActivity).inflate(R.layout.detail, parent, false);

        TextView txt;
        txt = convertView.findViewById(R.id.txt);

        txt.setText(array[position]);

        return convertView;
    }
}
