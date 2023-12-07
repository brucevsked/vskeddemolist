package com.vsked.bookborrow.domain.valueobject;

/**
 * 图书入库唯一标识
 */
public class BookStorageListId {
    private Long id;

    public BookStorageListId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
