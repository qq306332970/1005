package com.lym.orderitem.servlet;

import com.lanou.commons.CommonUtils;
import com.lym.car.bean.CarBigBean;
import com.lym.car.service.impl.CarServiceImpl;
import com.lym.orderitem.bean.OrderItem;
import com.lym.orderitem.service.impl.OrderItemServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by dllo on 17/12/25.
 */
@WebServlet(name = "OrderItemServlet",urlPatterns = "/orderItem")
public class OrderItemServlet extends HttpServlet {

    private OrderItemServiceImpl orderItemService = new OrderItemServiceImpl();
    private CarServiceImpl carService = new CarServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf8");
        request.setCharacterEncoding("utf8");
        response.setCharacterEncoding("utf8");
        String method = request.getParameter("method");
        switch (method) {
            case "insert":insert(request, response);
                break;
            case "":
                break;
        }
    }

    private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //查询购物车
        String uid = request.getParameter("uid");
        List<CarBigBean> list = carService.findAll(uid);
        list.forEach(System.out::println);
        request.setAttribute("list",list);
        request.getRequestDispatcher("/jsps/order/desc.jsp").forward(request,response);



//
//        int count = Integer.parseInt(request.getParameter("count"));
//        double subtotal = Double.parseDouble(request.getParameter("subtotal"));
//        String oid = request.getParameter("oid");
//        String bid = request.getParameter("bid");
//        CommonUtils.toBean(request.getParameterMap(), OrderItem.class);
//        OrderItem orderItem = new OrderItem();
//        orderItem.setCount(count);
//        orderItem.setSubtotal(subtotal);
//        orderItem.setOid(oid);
//        orderItem.setBid(bid);
//        orderItemService.insert(orderItem);

    }





}
