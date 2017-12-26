package com.lym.car.servlet;

import com.lanou.commons.CommonUtils;
import com.lym.book.bean.Book;
import com.lym.book.service.impl.BookServiceImpl;
import com.lym.car.bean.CarBean;
import com.lym.car.bean.CarBigBean;
import com.lym.car.service.impl.CarServiceImpl;
import com.lym.user.bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 17/12/23.
 */
@WebServlet(name = "CarServlet",urlPatterns = "/car")
public class CarServlet extends HttpServlet {

    private BookServiceImpl bookService = new BookServiceImpl();
    private CarServiceImpl  carService = new CarServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf8");
        request.setCharacterEncoding("utf8");
        response.setCharacterEncoding("utf8");
        String method = request.getParameter("method");
        switch (method) {
            case "addOrder":addOrder(request, response);
                break;
            case "find":find(request,response);
                break;
            case "delByCarId":delByCarId(request,response);
                break;
            case "findTop":findTop(request,response);
                break;
            case "delByUid":delByUid(request,response);
                break;
        }
    }

    private void addOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bid = request.getParameter("bid");
        String uid = request.getParameter("uid");
        int count = Integer.parseInt(request.getParameter("count"));
        Book book = bookService.findBookByBid(bid);
        double subtotal = count * book.getPrice();

        CarBean carBean = CommonUtils.toBean(request.getParameterMap(),CarBean.class);
        carBean.setCount(count);
        carBean.setSubtotal(subtotal);
        carBean.setUid(uid);
        carBean.setBook(book);
//        System.out.println(book.getBname());
        boolean flag = carService.addOrder(carBean);
        if (flag){
//            System.out.println(carBean);
            find(request, response);
        }else {
            request.setAttribute("msg","添加失败");
            request.getRequestDispatcher("/jsps/msg.jsp").forward(request,response);
        }
    }


    private void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid = request.getParameter("uid");
//        List<CarBean> list = carService.find(uid);
//        list.forEach(System.out::println);
//        request.getSession().setAttribute("list",list);
        List<CarBigBean> list = carService.findAll(uid);
        double sum = 0;
        for (int i = 0; i < list.size() ; i++) {
            sum += list.get(i).getSubtotal();
        }
        request.getSession().setAttribute("sum",sum);
//        list.forEach(System.out::println);
        request.setAttribute("list",list);
        request.getRequestDispatcher("/jsps/cart/list.jsp").forward(request,response);

    }

    private void delByCarId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String carid = request.getParameter("carid");

        boolean success = carService.delByCarId(carid);
        String uid = (String) request.getSession().getAttribute("uid");
        if (success){

            request.setAttribute("msg","删除成功");
            List<CarBigBean> carBigBeen = carService.findAll(uid);
            double sum = 0;
            for (int i = 0; i < carBigBeen.size() ; i++) {
                sum += carBigBeen.get(i).getSubtotal();
            }
            request.getSession().setAttribute("sum",sum);
            request.setAttribute("list",carBigBeen);
            request.getRequestDispatcher("/jsps/cart/list.jsp").forward(request,response);


        }else {
            request.setAttribute("msg","删除失败");
            request.getRequestDispatcher("/jsps/order/msg.jsp").forward(request,response);
        }


    }

    private void findTop(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid = (String) request.getSession().getAttribute("uid");
        List<CarBigBean> carBigBeen = carService.findAll(uid);
        double sum = 0;
        for (int i = 0; i < carBigBeen.size() ; i++) {
            sum += carBigBeen.get(i).getSubtotal();
        }
        request.getSession().setAttribute("sum",sum);
        request.setAttribute("list",carBigBeen);
        request.getRequestDispatcher("/jsps/cart/list.jsp").forward(request,response);
    }


    private void delByUid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid = request.getParameter("uid");
        boolean success = carService.delByUid(uid);
        if (success) {
            request.setAttribute("msg","清空成功");
            List<CarBigBean> carBigBeen = carService.findAll(uid);
            double sum = 0;
            for (int i = 0; i < carBigBeen.size() ; i++) {
                sum += carBigBeen.get(i).getSubtotal();
            }
            request.getSession().setAttribute("sum",sum);
            request.setAttribute("list",carBigBeen);
            request.getRequestDispatcher("/jsps/cart/list.jsp").forward(request,response);
        }else {
            request.setAttribute("msg","删除失败");
            request.getRequestDispatcher("/jsps/order/msg.jsp").forward(request,response);
        }
    }




}
