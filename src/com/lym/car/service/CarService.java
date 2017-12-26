package com.lym.car.service;

import com.lym.car.bean.CarBean;
import com.lym.car.bean.CarBigBean;
import com.lym.user.bean.User;

import java.util.List;

/**
 * Created by dllo on 17/12/25.
 */
public interface CarService {

//    //查询
//    List<CarBean> find(String uid);

    //添加
    boolean addOrder(CarBean carBean);

    //查询
    List<CarBigBean> findAll(String uid);


    //根据carid删除
    boolean delByCarId(String carid);


    //根据uid清空购物车
    boolean delByUid(String uid);

}
