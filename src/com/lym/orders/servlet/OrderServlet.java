package com.lym.orders.servlet;

import com.lanou.commons.CommonUtils;
import com.lym.orderitem.bean.OrderItem;
import com.lym.orderitem.service.impl.OrderItemServiceImpl;
import com.lym.orders.bean.Orders;
import com.lym.orders.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by dllo on 17/12/26.
 */
@WebServlet(name = "OrderServlet" ,urlPatterns = "/orders")
public class OrderServlet extends HttpServlet {

    private OrderServiceImpl orderService = new OrderServiceImpl();
    private OrderItemServiceImpl orderItemService = new OrderItemServiceImpl();

    List<OrderItem> list;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf8");
        request.setCharacterEncoding("utf8");
        response.setCharacterEncoding("utf8");
        String method = request.getParameter("method");
        switch (method) {
            case "add":
                break;
            case "find":
        }
    }
//
//    private void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        String uid = (String) request.getSession().getAttribute("uid");
////        address = request.getParameter("address");
//        System.out.println(uid);
//        list = orderItemService.findByUid(uid);
//        list.forEach(System.out::println);
////        request.getRequestDispatcher("/jsps/main.jsp").forward(request,response);
//
//        add(request, response);
//
//    }
//
//    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String address = request.getParameter("address");
//
//        for (int i = 0; i < list.size(); i++) {
//            Orders orders = CommonUtils.toBean(request.getParameterMap(),Orders.class);
//            orders.setOid(list.get(i).getOid());
//            orders.setAddress(address);
//            orders.setUid(list.get(i).getUid());
//            orders.setPrice(list.get(i).getPrice());
//            boolean flag = orderService.add(orders);
//            if (!flag){
//                request.getRequestDispatcher("/jsps/order/msg.jsp").forward(request,response);
//                break;
//            }else {
//                continue;
//            }
//        }
//        request.getRequestDispatcher("/jsps/main.jsp").forward(request,response);
//    }

}
