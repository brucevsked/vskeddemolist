package com.vsked.bookborrow.domain.valueobject;

import com.vsked.bookborrow.domain.aggregateroot.Borrower;
import com.vsked.bookborrow.domain.aggregateroot.Librarian;

import java.sql.Timestamp;

public class BorrowInfo {

    /**
     * 出借时间
     */
    private Timestamp lendTime;

    /**
     * 借阅人
     */
    private Borrower borrower;

    /**
     * 出借图书管理员
     */
    private Librarian lendLibrarian;


}
