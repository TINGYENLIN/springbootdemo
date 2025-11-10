package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;

public class ProductRequest {

    @NotNull
    private String distance;

    @NotNull
    private String length;

    @NotNull
    private String weight;

    @NotNull
    private Integer price;

    private String note;


    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
