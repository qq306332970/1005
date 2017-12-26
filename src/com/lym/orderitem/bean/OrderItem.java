package com.lym.orderitem.bean;

/**
 * Created by dllo on 17/12/25.
 */
public class OrderItem {

    private String iid,oid,bid;
    private int count;
    private double subtotal;

    public OrderItem() {
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "iid='" + iid + '\'' +
                ", oid='" + oid + '\'' +
                ", bid='" + bid + '\'' +
                ", count=" + count +
                ", subtotal=" + subtotal +
                '}';
    }

    public String getIid() {
        return iid;
    }

    public void setIid(String iid) {
        this.iid = iid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
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
}
