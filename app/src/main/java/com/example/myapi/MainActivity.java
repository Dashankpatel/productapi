package com.example.myapi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {


    RecyclerView recycle;
    ArrayList<ModelClass> alldata = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycle = findViewById(R.id.recycle);

        RequestQueue que = Volley.newRequestQueue(MainActivity.this);
        String url = "https://dummyjson.com/products";

        StringRequest rs = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject allData = new JSONObject(response);
                    JSONArray products = allData.getJSONArray("products");

                    for (int i = 0; i < products.length(); i++) {

                        JSONObject singleproduct = products.getJSONObject(i);

                        Integer id = singleproduct.getInt("id");
                        String title = singleproduct.getString("title");
                        String description = singleproduct.getString("description");
                        String category = singleproduct.getString("category");
                        int price = (int) singleproduct.getDouble("price");
                        double discountPercentage = singleproduct.getDouble("discountPercentage");
                        double rating = singleproduct.getDouble("rating");
                        Integer stock = singleproduct.getInt("stock");

                        JSONArray jsonTags = singleproduct.getJSONArray("tags");
                        String[] tags = new String[jsonTags.length()];
                        for (int t = 0; t < jsonTags.length(); t++) {
                            tags[t] = jsonTags.getString(t);
                        }

                        JSONArray jsonReviews = singleproduct.getJSONArray("reviews");
                        ArrayList<HashMap<String, Object>> reviews = new ArrayList<>();
                        for (int k = 0; k < jsonReviews.length(); k++) {
                            JSONObject reviewMap = jsonReviews.getJSONObject(k);

                            HashMap<String, Object> hash = new HashMap<>();
                            hash.put("rating", reviewMap.getInt("rating"));
                            hash.put("comment", reviewMap.getString("comment"));
                            hash.put("date", reviewMap.getString("date"));
                            hash.put("reviewerName", reviewMap.getString("reviewerName"));
                            hash.put("reviewerEmail", reviewMap.getString("reviewerEmail"));

                            reviews.add(hash);
                        }

                        JSONArray jsonImages = singleproduct.getJSONArray("images");
                        ArrayList<String> images = new ArrayList<>();
                        for (int k = 0; k < jsonImages.length(); k++) {
                            images.add(jsonImages.getString(k));
                        }

                        String thumbnail = singleproduct.getString("thumbnail");

                        ModelClass modelClass = new ModelClass(id, title, description, category, price,
                                discountPercentage, rating, stock, tags, reviews, images, thumbnail);
                        alldata.add(modelClass);
                    }

                } catch (JSONException e) {
                    Log.e("==te==", "onResponse: " + e);
                }

                Log.d("-+-+-", "onResponse: " + Arrays.toString(alldata.get(0).getTags()));

                MyAdapter adpter = new MyAdapter(MainActivity.this, alldata);
                recycle.setAdapter(adpter);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.e("====e====", "onErrorResponse: " + error.getLocalizedMessage());

            }
        });

        que.add(rs);
    }
}