package com.lym.orderitem.service.impl;

import com.lanou.commons.CommonUtils;
import com.lym.orderitem.bean.OrderItem;
import com.lym.orderitem.dao.impl.OrderItemDaoImpl;
import com.lym.orderitem.service.OrderItemService;

import java.util.List;

/**
 * Created by dllo on 17/12/25.
 */
public class OrderItemServiceImpl implements OrderItemService {

    private OrderItemDaoImpl orderItemDao = new OrderItemDaoImpl();

    @Override
    public boolean insert(OrderItem orderItem) {
        orderItem.setIid(CommonUtils.uuid());
        return orderItemDao.insert(orderItem);
    }


}
