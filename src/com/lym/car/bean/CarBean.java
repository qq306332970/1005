package com.lym.car.bean;

import com.lym.book.bean.Book;

/**
 * Created by dllo on 17/12/23.
 */
public class CarBean {

    private String uid,carid,bid;
    private int count;
    private double subtotal;
    private Book book;

    public CarBean() {
    }

    @Override
    public String toString() {
        return "CarBean{" +
                "uid='" + uid + '\'' +
                ", carid='" + carid + '\'' +
                ", bid='" + bid + '\'' +
                ", count=" + count +
                ", subtotal=" + subtotal +
                ", book=" + book +
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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
