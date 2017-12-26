package com.lym.user.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by dllo on 17/10/17.
 */

public class AFilter implements Filter {
    //Filter的作用就是用于拦截请求的


    /**
     *
     * 初始化操作  只运行一次
     * @param config
     * @throws ServletException
     */

    public void init(FilterConfig config) throws ServletException {
        System.out.println("过滤器开启");
    }




    /**
     *
     * 每次请求都会执行
     * @param req
     * @param resp
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String name = (String) request.getSession().getAttribute("username");

        if ((name == null || name.trim().length() < 0) && !request.getSession().isNew()){
            req.getRequestDispatcher("/jsps/msg.jsp").forward(req,resp);
        }else  {
            //放行
            chain.doFilter(req, resp);
        }
    }

    public void destroy() {
        System.out.println("过滤器销毁");
    }

}
