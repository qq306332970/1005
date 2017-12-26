package com.lym.book.servlet;

import com.lym.book.bean.Book;
import com.lym.book.service.impl.BookServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by dllo on 17/12/22.
 */
@WebServlet(name = "BookServlet",urlPatterns = "/book")
public class BookServlet extends HttpServlet {

    private BookServiceImpl bookService = new BookServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf8");
        request.setCharacterEncoding("utf8");
        response.setCharacterEncoding("utf8");
        String method = request.getParameter("method");
        switch (method){
            case "findAllBook": findAllBook(request,response);
                break;
            case "findByCid":findByCid(request,response);
                break;
            case "findBookByBid":findBookByBid(request, response);
        }
    }


    private void findAllBook(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        List<Book> bookList = bookService.findAllBook();
        request.setAttribute("bookList",bookList);
        request.getRequestDispatcher("/jsps/book/list.jsp").forward(request,response);
    }


    private void findByCid(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String cid = request.getParameter("cid");
        List<Book> bookList = bookService.findByCid(cid);
        request.setAttribute("bookList",bookList);
        request.getRequestDispatcher("/jsps/book/list.jsp").forward(request,response);
    }

    private void findBookByBid(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String bid = request.getParameter("bid");
        Book book = bookService.findBookByBid(bid);
//        System.out.println(book.toString());
        request.setAttribute("book",book);
        request.getRequestDispatcher("jsps/book/desc.jsp").forward(request,response);
    }
}
