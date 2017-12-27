package com.lym.orders.dao.impl;

import com.lym.orderitem.bean.OrderItem;
import com.lym.orders.bean.Orders;
import com.lym.orders.dao.OrdersDao;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 17/12/26.
 */
public class OrdersDaoImpl implements OrdersDao {

    ComboPooledDataSource dataSource = new ComboPooledDataSource();
    QueryRunner queryRunner = new QueryRunner(dataSource);

    @Override
    public boolean add(Orders orders) {

        String sql = "insert into orders values (?,?,?,?,?,?,?)";

        int count;
        try {
            count = queryRunner.update(sql,orders.getId(),orders.getOid(),orders.getOrdertime(),orders.getPrice(),orders.getState(),orders.getUid(),orders.getAddress());
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return count != 0;
    }

    @Override
    public List<OrderItem> find(String uid) {

        List<OrderItem> list = new ArrayList<>();
        String sql ="select * from orderitem where uid = ?";
        try {
            list = queryRunner.query(sql,new BeanListHandler<>(OrderItem.class),uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }



    @Override
    public List<Orders> findByUid(String uid) {

        List<Orders> list = new ArrayList<>();
        String sql = "select * from orders where uid = ?";

        try {
            list = queryRunner.query(sql,new BeanListHandler<>(Orders.class),uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

}
