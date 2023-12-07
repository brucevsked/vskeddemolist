package com.vsked.bookborrow.domain.PO;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="book")
public class BookPO {

    @Id
    private Long bookId;

    private String bookName;

    private boolean bookBorrowStatus;

    private boolean bookOnShelfStatus;

    public BookPO() {
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public boolean isBookBorrowStatus() {
        return bookBorrowStatus;
    }

    public void setBookBorrowStatus(boolean bookBorrowStatus) {
        this.bookBorrowStatus = bookBorrowStatus;
    }

    public boolean isBookOnShelfStatus() {
        return bookOnShelfStatus;
    }

    public void setBookOnShelfStatus(boolean bookOnShelfStatus) {
        this.bookOnShelfStatus = bookOnShelfStatus;
    }

    /**
     * 构造方法
     * @param bookId
     * @param bookName
     * @param bookBorrowStatus
     * @param bookOnShelfStatus
     */
    public BookPO(Long bookId, String bookName, boolean bookBorrowStatus, boolean bookOnShelfStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookBorrowStatus = bookBorrowStatus;
        this.bookOnShelfStatus = bookOnShelfStatus;
    }

}
