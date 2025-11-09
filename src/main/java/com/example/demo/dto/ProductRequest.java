package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;

public class ProductRequest {

     @NotNull
    private String idproduct2;

    @NotNull
    private String distance;

    @NotNull
    private String length;

    @NotNull
    private String weight;

    @NotNull
    private Integer price;

    private String status;


    public String getidproduct2() {
        return idproduct2;
    }

    public void setidproduct2(String idproduct2) {
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

    public String getstatus() {
        return status;
    }

    public void setstatus(String status) {
        this.status = status;
    }
}
