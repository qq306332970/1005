package com.lym.user.dao;

import com.lym.user.bean.User;

import java.util.List;

/**
 * Created by dllo on 17/12/21.
 */
public interface UserDao {

    //查询
    List<User> findAll(String username,String password);

    //注册
    boolean insert(User user);


}
