package com.lym.book.dao;


import com.lym.book.bean.Book;

import java.util.List;

/**
 * Created by dllo on 17/12/22.
 */
public interface BookDao {

    //查询全部
    List<Book> findAllBook();

    //通过cid查询
    List<Book> findByCid(String cid);

    //通过bid查book对象
    Book findBookByBid(String bid);

}
