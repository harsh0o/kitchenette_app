package com.example.kitchenette;

public class ProductModel {
    String name,price;;
    String desc,surl;



    public ProductModel() { }

    public ProductModel(String name, String desc, String surl, String price) {
        this.name = name;
        this.desc = desc;
        this.surl = surl;
        this.price = price;
    }

    public String getSurl() {
        return surl;
    }

    public void setSurl(String surl) {
        this.surl = surl;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


}
