package com.codegym.model;

public class Product {
    int id;
    String productCode;
    String productName;
    int price;
    String img;
    int unit;
    static int num=0;
    public Product() {
        num++;
        this.id=num;
    }

    public Product(String productCode, String productName, int price, int unit,String img) {
        num++;
        this.id=num;
        this.productCode = productCode;
        this.productName = productName;
        this.price = price;
        this.unit = unit;
        this.img=img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public static int getNum() {
        return num;
    }

    public static void setNum(int num) {
        Product.num = num;
    }
}
