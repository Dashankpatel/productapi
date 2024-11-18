package com.example.myapi;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;

public class MyPagerAdapter extends PagerAdapter {

    MainItemview mainItemview;
    ModelClass nm;

    public MyPagerAdapter(MainItemview mainItemview, ModelClass nm) {
        this.mainItemview = mainItemview;
        this.nm = nm;
    }

    @Override
    public int getCount() {
        return nm.getImages().size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @SuppressLint("MissingInflatedId")
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        ImageView next;

        View pg = LayoutInflater.from(mainItemview).inflate(R.layout.newimg,container,false);

        next = pg.findViewById(R.id.next);
        Glide.with(mainItemview).load(nm.getImages().get(position)).into(next);
        container.addView(pg);

        return pg;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((View) object);
    }
}
