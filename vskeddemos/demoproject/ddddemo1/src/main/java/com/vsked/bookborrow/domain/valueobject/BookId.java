package com.vsked.bookborrow.domain.valueobject;

/**
 * 系统自动生成唯一编号
 */
public class BookId {

    private Long bookId;

    public BookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getBookId() {
        return bookId;
    }
}
