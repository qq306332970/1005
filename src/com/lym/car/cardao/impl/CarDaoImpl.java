package com.lym.car.cardao.impl;

import com.lym.car.bean.CarBean;
import com.lym.car.bean.CarBigBean;
import com.lym.car.cardao.CarDao;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 17/12/25.
 */
public class CarDaoImpl implements CarDao {

    ComboPooledDataSource dataSource = new ComboPooledDataSource();
    QueryRunner queryRunner = new QueryRunner(dataSource);
    private int flag;


    /**
     * 添加
     * @return
     */
    @Override
    public boolean addOrder(CarBean carBean) {

        String sql = "insert into car values (?,?,?,?,?,?,?,?)";
        try {
            flag = queryRunner.update(sql,carBean.getCarid(),carBean.getBook().getImage(),carBean.getBook().getBname(),carBean.getBook().getAuthor(),carBean.getBook().getPrice(),carBean.getCount(),carBean.getSubtotal(),carBean.getUid());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (flag > 0) {
                return true;
            } else {
                return false;
            }
        }
    }



    @Override
    public List<CarBigBean> findAll(String uid) {

        List<CarBigBean> carBigBean = new ArrayList<>();
        String sql = "select * from car where uid = ?";
        try {
            carBigBean = queryRunner.query(sql,new BeanListHandler<>(CarBigBean.class),uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return carBigBean;
    }

//
//    @Override
//    public List<CarBean> find(String uid) {
//
//        List<CarBean> carBeanList = new ArrayList<>();
//        String sql = "select * from car where uid = ?";
//        try {
//            carBeanList = queryRunner.query(sql,new BeanListHandler<>(CarBean.class),uid);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return carBeanList;
//    }



    @Override
    public boolean delByCarId(String carid) {

        String sql = "delete from car where carid = ?";
        int count;
        try {
            count = queryRunner.update(sql,carid);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return count != 0;

    }

    @Override
    public boolean delByUid(String uid) {

        String sql = "delete from car where uid = ?";
        int count;
        try {
            count = queryRunner.update(sql,uid);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return count != 0;
    }


}
