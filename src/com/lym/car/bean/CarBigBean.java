package com.lym.car.bean;

import com.lym.book.bean.Book;

/**
 * Created by dllo on 17/12/25.
 */
public class CarBigBean {

    private String uid,carid,bid,image,bname,author;
    private double price;
    private int count;
    private double subtotal;

    public CarBigBean() {
    }

    @Override
    public String toString() {
        return "CarBigBean{" +
                "uid='" + uid + '\'' +
                ", carid='" + carid + '\'' +
                ", bid='" + bid + '\'' +
                ", image='" + image + '\'' +
                ", bname='" + bname + '\'' +
                ", author='" + author + '\'' +
                ", price='" + price + '\'' +
                ", count=" + count +
                ", subtotal=" + subtotal +
                '}';
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCarid() {
        return carid;
    }

    public void setCarid(String carid) {
        this.carid = carid;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
