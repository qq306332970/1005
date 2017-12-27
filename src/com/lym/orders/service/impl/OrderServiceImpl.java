package com.lym.orders.service.impl;

import com.lanou.commons.CommonUtils;
import com.lym.orderitem.bean.OrderItem;
import com.lym.orders.bean.Orders;
import com.lym.orders.dao.impl.OrdersDaoImpl;
import com.lym.orders.service.OrderService;

import java.util.List;

/**
 * Created by dllo on 17/12/26.
 */
public class OrderServiceImpl implements OrderService {

    private OrdersDaoImpl ordersDao = new OrdersDaoImpl();

    @Override
    public boolean add(Orders orders) {
        orders.setId(CommonUtils.uuid());
        return ordersDao.add(orders);
    }

    @Override
    public List<OrderItem> find(String uid) {
        return ordersDao.find(uid);
    }

    @Override
    public List<Orders> findByUid(String uid) {
        return ordersDao.findByUid(uid);
    }
}
