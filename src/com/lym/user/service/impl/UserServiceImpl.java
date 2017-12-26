package com.lym.user.service.impl;

import com.lanou.commons.CommonUtils;
import com.lym.user.bean.User;
import com.lym.user.dao.UserDao;
import com.lym.user.dao.impl.UserDaoImpl;
import com.lym.user.service.UserService;

import java.util.List;

/**
 * Created by dllo on 17/12/21.
 */
public class UserServiceImpl implements UserService {

    private UserDaoImpl userDao = new UserDaoImpl();

    @Override
    public List<User> findAll(String username,String password) {
        return userDao.findAll(username,password);
    }

    @Override
    public boolean insert(User user) {
        user.setUid(CommonUtils.uuid());
        return userDao.insert(user);
    }
}
