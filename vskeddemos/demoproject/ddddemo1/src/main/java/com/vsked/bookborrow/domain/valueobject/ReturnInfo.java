package com.vsked.bookborrow.domain.valueobject;

import com.vsked.bookborrow.domain.aggregateroot.Librarian;

import java.sql.Timestamp;

public class ReturnInfo {

    /**
     * 归还时间
     */
    private Timestamp returnTime;

    /**
     * 归还审查图书管理员
     */
    private Librarian returnLibrarian;
}
