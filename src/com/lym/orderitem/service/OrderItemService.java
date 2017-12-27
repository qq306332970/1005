package com.lym.orderitem.service;

import com.lym.orderitem.bean.OrderItem;

import java.util.List;

/**
 * Created by dllo on 17/12/25.
 */
public interface OrderItemService {

    //添加到orderitem中
    boolean insert(OrderItem orderItem);

    //根据uid查询
    List<OrderItem> findByUid(String uid);

}
