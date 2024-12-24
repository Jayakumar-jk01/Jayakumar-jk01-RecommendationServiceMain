package com.jayakumar.RecommendationServiceMain.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProductPurchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    private  String productName;

    private Long userId;

    private Integer quantity;

    private Double totPrice;

    public ProductPurchase() {
    }

    public ProductPurchase(Long id,String productName,  Long userId, Integer quantity, Double totPrice) {
        this.id = id;
       this.productName=productName;
        this.userId = userId;
        this.quantity = quantity;
        this.totPrice = totPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotPrice() {
        return totPrice;
    }

    public void setTotPrice(Double totPrice) {
        this.totPrice = totPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
