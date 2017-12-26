package com.lym.user.dao.impl;

import com.lym.user.bean.User;
import com.lym.user.dao.UserDao;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 17/12/21.
 */
public class UserDaoImpl implements UserDao {

    ComboPooledDataSource dataSource = new ComboPooledDataSource();
    QueryRunner queryRunner = new QueryRunner(dataSource);
    private int flag;

    @Override
    public List<User> findAll(String username,String password) {

        List<User> userList = new ArrayList<>();
        String sql = "select * from USER where username = ? and password = ?";
        try {
            userList = queryRunner.query(sql,new BeanListHandler<User>(User.class),username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    @Override
    public boolean insert(User user) {
        String sql = "insert into USER values (?,?,?,?,?,?)";

        if (user.getUsername().equals("") || user.getPassword().equals("")) {
            return false;
        } else {
            try {
                flag = queryRunner.update(sql, user.getUid(), user.getUsername(), user.getPassword(), user.getEmail(), user.getCode(), user.getState());
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (flag > 0) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }


}
