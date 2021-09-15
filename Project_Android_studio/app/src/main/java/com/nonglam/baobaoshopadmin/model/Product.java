package com.nonglam.baobaoshopadmin.model;

public class Product {
    private int productID;
    private String name;
    private int price;
    private int quantity;
    private String thumbnail;
    private String detailImage;
    private String description;
    private int height;
    private String origin;

    public Product(int productID, String name, int price, int quantity, String thumbnail, String detailImage, String description, int height, String origin) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.thumbnail = thumbnail;
        this.detailImage = detailImage;
        this.description = description;
        this.height = height;
        this.origin = origin;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDetailImage() {
        return detailImage;
    }

    public void setDetailImage(String detailImage) {
        this.detailImage = detailImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public  String toString(){
        return getName() + " " + getOrigin() + " " + getHeight() + " " + getPrice() + " " + getProductID();
    }
}
