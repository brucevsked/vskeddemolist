package com.vsked.bookborrow.domain.valueobject;

import com.vsked.bookborrow.domain.aggregateroot.Book;

/**
 * 图书借阅登记表选项
 */
public class BookBorrowReturnRegisterItem {

    /**
     * 图书借阅登记序号从1开始递增
     */
    private Integer serialNumber;

    /**
     * 图书
     */
    private Book book;

    /**
     * 借阅信息
     */
    private BorrowInfo borrowInfo;

    /**
     * 归还信息
     */
    private ReturnInfo returnInfo;

}
