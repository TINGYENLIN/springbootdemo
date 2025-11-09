package com.example.demo.model;

import java.util.Date;

public class Product {

    private Integer idproduct2;
    private String distance;
    private String length;
    private String weight;
    private Integer price;
    private String description;
    private Date createdDate;
    private Date lastModifiedDate;

    public Integer getidproduct2() {
        return idproduct2;
    }

    public void setidproduct2(Integer idproduct2) {
        this.idproduct2 = idproduct2;
    }

    public String getdistance() {
        return distance;
    }

    public void setdistance(String distance) {
        this.distance = distance;
    }

    public String getlength() {
        return length;
    }

    public void setlength(String length) {
        this.length = length;
    }

    public String getweight() {
        return weight;
    }

    public void setweight(String weight) {
        this.weight = weight;

    }
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

}
