package com.lym.orderitem.dao.impl;

import com.lym.orderitem.bean.OrderItem;
import com.lym.orderitem.dao.OrderItemDao;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 17/12/25.
 */
public class OrderItemDaoImpl implements OrderItemDao {

    ComboPooledDataSource dataSource = new ComboPooledDataSource();
    QueryRunner queryRunner = new QueryRunner(dataSource);

    @Override
    public boolean insert(OrderItem orderItem) {

        String sql = "insert into orderitem values (?,?,?,?,?)";
        int count;
        try {
            count = queryRunner.update(sql,orderItem.getIid(),orderItem.getCount(),orderItem.getSubtotal(),orderItem.getOid(),orderItem.getBid());
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return count != 0;
    }


}
