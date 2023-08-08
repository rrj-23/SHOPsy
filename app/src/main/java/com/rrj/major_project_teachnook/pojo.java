package com.rrj.major_project_teachnook;

public class pojo {
    int image;
    String brand;
    String name;
    String price;

    public pojo(String name, String brand,int image , String price) {
        this.image = image;
        this.brand = brand;
        this.name = name;
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
