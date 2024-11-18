package com.example.myapi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Paint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<Myrecycle> {

    MainActivity mainActivity;
    ArrayList<ModelClass> alldata;


    public MyAdapter(MainActivity mainActivity, ArrayList<ModelClass> alldata) {
        this.mainActivity = mainActivity;
        this.alldata = alldata;
    }

    @NonNull
    @Override
    public Myrecycle onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View vv = LayoutInflater.from(mainActivity).inflate(R.layout.detail, parent, false);
        Myrecycle myrecycle = new Myrecycle(vv);

        return myrecycle;
    }

    @Override
    public void onBindViewHolder(@NonNull Myrecycle holder, @SuppressLint("RecyclerView") int position) {
        ModelClass model = alldata.get(position);

        Glide.with(mainActivity).load(model.getThumbnail()).into(holder.img);


        holder.txt.setText(model.getTitle());
        holder.price.setText("₹" + String.valueOf(model.getPrice()));
        holder.discount.setText("  " + String.valueOf(model.getDiscountPercentage()) + "%off");

        int k = ((int) (100 - model.getDiscountPercentage()));
        int t = model.getPrice() * 100;
        holder.rate.setText(String.valueOf("" + t / k));
        holder.rate.setPaintFlags(holder.rate.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
//        holder.rate.setText(String.valueOf("  " + t / k), TextView.BufferType.SPANNABLE);
//        Spannable spannable = (Spannable) tvMRP.getText();
//        spannable.setSpan(new StrikethroughSpan(), 3, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        holder.rating.setText(String.valueOf(model.getRating()) + "✰");




        // new class
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent k = new Intent(mainActivity, MainItemview.class);
                mainActivity.startActivity(k.putExtra("data", alldata.get(position)));
            }
        });

    }

    @Override
    public int getItemCount() {
        return alldata.size();
    }
}

class Myrecycle extends RecyclerView.ViewHolder {

    TextView txt, price, discount, rate, rating;
    ImageView img;


    public Myrecycle(@NonNull View itemView) {
        super(itemView);

        img = itemView.findViewById(R.id.img);

        txt = itemView.findViewById(R.id.txt);
        price = itemView.findViewById(R.id.price);
        discount = itemView.findViewById(R.id.discount);
        rate = itemView.findViewById(R.id.rate);
        rating = itemView.findViewById(R.id.rating);
    }
}