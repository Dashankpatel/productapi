package com.example.myapi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class ModelClass implements Serializable
{

    private Integer id;
    private String title;
    private String description;
    private String category;
    private int price;
    private double discountPercentage;
    private double rating;
    private Integer stock;
    private String[] tags;
    //   private String brand;
    private ArrayList<HashMap<String, Object>> reviews;
    private ArrayList<String> images;
    private String thumbnail;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

//    public String getBrand() {
//        return brand;
//    }
//
//    public void setBrand(String brand) {
//        this.brand = brand;
//    }

    public ArrayList<HashMap<String, Object>> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<HashMap<String, Object>> reviews) {
        this.reviews = reviews;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public ModelClass(Integer id, String title, String description, String category, int price, double discountPercentage, double rating, Integer stock, String[] tags, ArrayList<HashMap<String, Object>> reviews, ArrayList<String> images, String thumbnail) {

        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.price = (int) price;
        this.discountPercentage = discountPercentage;
        this.rating = rating;
        this.stock = stock;
        this.tags = tags;
//        this.brand = brand;
        this.reviews = reviews;
        this.images = images;
        this.thumbnail = thumbnail;
    }
}
