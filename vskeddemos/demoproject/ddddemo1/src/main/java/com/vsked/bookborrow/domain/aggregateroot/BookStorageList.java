package com.vsked.bookborrow.domain.aggregateroot;

import com.vsked.bookborrow.domain.valueobject.BookStorageItem;
import com.vsked.bookborrow.domain.valueobject.BookStorageListId;

import java.util.Collection;


/**
 * 图书入库表
 * 这是一个聚合根，用来统一每一次入库信息的完整性
 */
public class BookStorageList {

    /**
     * 图书入库唯一标识
     */
    private BookStorageListId bookStorageListId;

    /**
     * 图书入库选项集合(行)
     */
    private Collection<BookStorageItem> bookStorageItems;

    /**
     * 构造图书入库
     * @param bookStorageListId
     */
    public BookStorageList(BookStorageListId bookStorageListId) throws IllegalArgumentException{
        if(bookStorageListId ==null){
            throw new IllegalArgumentException("bookStoreListId cannot be null.");
        }
        this.bookStorageListId = bookStorageListId;
    }

    /**
     * 上架图书
     * @param bookStorageItems
     * @throws IllegalArgumentException
     */
    public void storageBooks(Collection<BookStorageItem> bookStorageItems) throws IllegalArgumentException {

        if(bookStorageItems ==null){
            throw new IllegalArgumentException("bookStoreItems cannot be null.");
        }

        this.bookStorageListId = bookStorageListId;
        this.bookStorageItems = bookStorageItems;
    }

    public BookStorageListId getBookStorageListId() {
        return bookStorageListId;
    }

    public Collection<BookStorageItem> getBookStorageItems() {
        return bookStorageItems;
    }
}
