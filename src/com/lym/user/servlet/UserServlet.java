package com.lym.user.servlet;

import com.lanou.commons.CommonUtils;

import com.lym.user.bean.User;
import com.lym.user.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by dllo on 17/12/21.
 */
@WebServlet(name = "UserServlet",urlPatterns = "/user")
public class UserServlet extends HttpServlet {

    private UserServiceImpl userService = new UserServiceImpl();



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf8");
        request.setCharacterEncoding("utf8");
        response.setCharacterEncoding("utf8");
        String method = request.getParameter("method");
        switch (method){
            case "findAll":findAll(request,response);
                break;
            case "insert":insert(request,response);
                break;
            case "quit":quit(request,response);
        }
    }


    private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        List<User> userList = userService.findAll(username,password);
        if (userList.size() == 0){
            request.setAttribute("msg","登录失败");
            request.getRequestDispatcher("/jsps/msg.jsp").forward(request,response);
        }else {
            HttpSession session = request.getSession();
            request.setAttribute("msg","登录成功");
            session.setAttribute("username",username);
            String uid = userList.get(0).getUid();
            session.setAttribute("uid",uid);
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }
    }

    private void insert(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        User user;
        user = CommonUtils.toBean(request.getParameterMap(),User.class);
        boolean flag  = userService.insert(user);
        if (flag){
            request.setAttribute("msg","添加成功");
            request.getRequestDispatcher("/jsps/user/login.jsp").forward(request,response);
        }else {
            request.setAttribute("msg","添加失败");
            request.getRequestDispatcher("/jsps/msg.jsp").forward(request,response);
        }
    }

    private void quit(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("username");
        request.setAttribute("msg","退出成功");
        request.getRequestDispatcher("/jsps/user/login.jsp").forward(request,response);
    }
}
