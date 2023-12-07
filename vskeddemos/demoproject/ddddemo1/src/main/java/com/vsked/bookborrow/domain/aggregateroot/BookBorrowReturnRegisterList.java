package com.vsked.bookborrow.domain.aggregateroot;

import com.vsked.bookborrow.domain.valueobject.BookBorrowReturnRegisterId;
import com.vsked.bookborrow.domain.valueobject.BookBorrowReturnRegisterItem;

import java.util.Collection;

/**
 * 图书借阅登记表
 */
public class BookBorrowReturnRegisterList {

    private BookBorrowReturnRegisterId bookBorrowReturnRegisterId;

    private Collection<BookBorrowReturnRegisterItem> bookBorrowReturnRegisterItems;

    //根据书名或人名找借阅信息

    //借书

    //还书

}
