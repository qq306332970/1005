package com.lym.orderitem.dao;

import com.lym.orderitem.bean.OrderItem;

import java.util.List;

/**
 * Created by dllo on 17/12/25.
 */
public interface OrderItemDao {

    //把购物车数据添加到orderitem中
    boolean insert(OrderItem orderItem);


}
