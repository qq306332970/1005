package com.lym.orderitem.servlet;

import com.lanou.commons.CommonUtils;
import com.lym.car.bean.CarBigBean;
import com.lym.car.service.impl.CarServiceImpl;
import com.lym.orderitem.bean.OrderItem;
import com.lym.orderitem.service.impl.OrderItemServiceImpl;
import com.lym.orders.bean.Orders;
import com.lym.orders.service.OrderService;
import com.lym.orders.service.impl.OrderServiceImpl;
import com.lym.orders.servlet.OrderServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by dllo on 17/12/25.
 */
@WebServlet(name = "OrderItemServlet",urlPatterns = "/orderItem")
public class OrderItemServlet extends HttpServlet {

    private OrderItemServiceImpl orderItemService = new OrderItemServiceImpl();
    List<OrderItem> orderItemList;
    String b;
    private CarServiceImpl carService = new CarServiceImpl();
    SimpleDateFormat df;
    Date day;
    List<OrderItem> list;
    List<OrderItem> list1;
    private OrderServiceImpl orderService = new OrderServiceImpl();



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf8");
        request.setCharacterEncoding("utf8");
        response.setCharacterEncoding("utf8");
        String method = request.getParameter("method");
        switch (method) {
            case "find":find(request, response);
                break;
            case "add":add(request,response);
                break;
            case "delCar":delCar(request,response);
                break;
            case "findByOid":findByOid(request, response);
                break;

        }
    }

    private void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //订单编号
        Random r = new Random();
        int a = r.nextInt(10000)+1;
        request.setAttribute("a",a);
        b = Integer.toString(a);


        //生成当前时间
        day=new Date();
        df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        request.setAttribute("time",df.format(day));




        //查询展示
        String uid = request.getParameter("uid");
        orderItemList = orderItemService.findByUid(uid);
//        orderItemList.forEach(System.out::println);
        request.setAttribute("orderItemList",orderItemList);
        request.getRequestDispatcher("/jsps/order/desc.jsp").forward(request,response);

//        for (int i = 0; i < orderItemList.size(); i++) {
//            OrderItem orderItem = CommonUtils.toBean(request.getParameterMap(),OrderItem.class);
//            orderItem.setCount(orderItemList.get(i).getCount());
//            orderItem.setSubtotal(orderItemList.get(i).getSubtotal());
//            orderItem.setUid(orderItemList.get(i).getUid());
//            orderItem.setOid(b);
////            orderItem.setOid();
//            boolean flag = orderItemService.insert(orderItem);
//            if (!flag){
//                request.getRequestDispatcher("/jsps/order/msg.jsp").forward(request,response);
//                break;
//            }else {
//                continue;
//            }
//        }
//        request.getRequestDispatcher("/jsps/order/desc.jsp").forward(request,response);

    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        for (int i = 0; i < orderItemList.size(); i++) {
            OrderItem orderItem = CommonUtils.toBean(request.getParameterMap(),OrderItem.class);
            orderItem.setCount(orderItemList.get(i).getCount());
            orderItem.setSubtotal(orderItemList.get(i).getSubtotal());
            orderItem.setUid(orderItemList.get(i).getUid());
            orderItem.setOid(b);
            boolean flag = orderItemService.insert(orderItem);
            if (!flag){
                request.getRequestDispatcher("/jsps/order/msg.jsp").forward(request,response);
                break;
            }else {
                continue;
            }
        }
        request.getRequestDispatcher("/jsps/order/success.jsp").forward(request,response);
//        delCar(request, response);
        find1(request, response);


    }


    //结算后删除购物车
    private void delCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uid = (String) request.getSession().getAttribute("uid");
        carService.delByUid(uid);
        request.getRequestDispatcher("/jsps/main.jsp").forward(request,response);

    }




    private void find1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uid = (String) request.getSession().getAttribute("uid");
//        address = request.getParameter("address");
//        System.out.println(uid);
        list = orderService.find(uid);
        list1 = orderItemService.findByUid(uid);
//        request.getSession().setAttribute("list1",list1);
//        list.forEach(System.out::println);
//        list1.forEach(System.out::println);
//        request.getRequestDispatcher("/jsps/main.jsp").forward(request,response);

        add1(request,response);

    }

    private void add1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String address = request.getParameter("address");

//        for (int i = 0; i < list.size(); i++) {
            Orders orders = CommonUtils.toBean(request.getParameterMap(),Orders.class);
            orders.setOid(list.get(0).getOid());
            orders.setAddress(address);
            orders.setUid(list.get(0).getUid());
//            orders.setPrice(list.get(0).getPrice());
            orders.setOrdertime(df.format(day));
            orders.setPrice((Double) request.getSession().getAttribute("sum"));
            boolean flag = orderService.add(orders);
            if (!flag){
                request.getRequestDispatcher("/jsps/order/msg.jsp").forward(request,response);
            }else {
                request.getRequestDispatcher("jsps/order/success.jsp").forward(request,response);
            }
//        }
    }



    private void findByOid(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

        String uid = (String) request.getSession().getAttribute("uid");
        List<Orders> ordersList = orderService.findByUid(uid);
        ordersList.forEach(System.out::println);
        request.setAttribute("ordersList",ordersList);
        request.getRequestDispatcher("/jsps/order/list.jsp").forward(request,response);
    }

}
