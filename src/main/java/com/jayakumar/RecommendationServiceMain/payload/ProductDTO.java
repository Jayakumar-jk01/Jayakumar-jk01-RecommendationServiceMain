package com.jayakumar.RecommendationServiceMain.payload;

import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ProductDTO {

    private Long productId;

    @NotBlank
    @Size(min = 3, message = "product name must be atleast 3 characters")
    private String productName;

    private double price;

    private String color;

    private String size;

    private int rating;

    private int views;

    private int likes;

    private int purchases;

    public ProductDTO() {
    }

    public ProductDTO(Long productId, String productName,
                      double price, String color, String size,
                      int rating, int views, int likes, int purchases) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.color = color;
        this.size = size;
        this.rating = rating;
        this.views = views;
        this.likes = likes;
        this.purchases = purchases;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public @NotBlank @Size(min = 3, message = "product name must be atleast 3 characters") String getProductName() {
        return productName;
    }

    public void setProductName(@NotBlank @Size(min = 3, message = "product name must be atleast 3 characters") String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getPurchases() {
        return purchases;
    }

    public void setPurchases(int purchases) {
        this.purchases = purchases;
    }

//    @Transient
//    private double relevanceScore;
//
//    public double getRelevanceScore() {
//        return relevanceScore;
//    }
//
//    public void setRelevanceScore(double relevanceScore) {
//        this.relevanceScore = relevanceScore;
//    }
}
