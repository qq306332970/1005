package com.lym.orders.service;

import com.lym.orderitem.bean.OrderItem;
import com.lym.orders.bean.Orders;

import java.util.List;

/**
 * Created by dllo on 17/12/26.
 */
public interface OrderService {

    //添加订单
    boolean add(Orders orders);

    //根据uid查询orderItem集合
    List<OrderItem> find(String uid);

    //查询orders表
    List<Orders> findByUid(String uid);

}
