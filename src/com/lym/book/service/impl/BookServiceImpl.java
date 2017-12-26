package com.lym.book.service.impl;

import com.lym.book.bean.Book;
import com.lym.book.dao.impl.BookDaoImpl;
import com.lym.book.service.BookService;



import java.util.List;

/**
 * Created by dllo on 17/12/22.
 */
public class BookServiceImpl implements BookService {

    BookDaoImpl bookDao = new BookDaoImpl();

    @Override
    public List<Book> findAllBook() {
        return bookDao.findAllBook();
    }


    @Override
    public List<Book> findByCid(String cid) {
        return bookDao.findByCid(cid);
    }

    @Override
    public Book findBookByBid(String bid) {
        return bookDao.findBookByBid(bid);
    }
}
