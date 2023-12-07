package com.vsked.bookborrow.domain.valueobject;

/**
 * 借阅人登记表唯一标识
 */
public class BorrowerListId {

    private Long borrowerListId;

    public BorrowerListId(Long borrowerListId) {
        this.borrowerListId = borrowerListId;
    }

    public Long getBorrowerListId() {
        return borrowerListId;
    }
}
