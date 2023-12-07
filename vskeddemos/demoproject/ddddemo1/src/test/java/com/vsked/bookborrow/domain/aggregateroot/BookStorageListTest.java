package com.vsked.bookborrow.domain.aggregateroot;

import com.vsked.bookborrow.domain.valueobject.BookId;
import com.vsked.bookborrow.domain.valueobject.BookStorageItem;
import com.vsked.bookborrow.domain.valueobject.BookStorageListId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashSet;

public class BookStorageListTest {

    private static final Logger log = LoggerFactory.getLogger(BookStorageListTest.class);

    @Test
    public void storeTest(){
        log.debug("start test ");
        Integer bookStorageItem1_serialNumber=new Integer(1);//图书入库选项序号
        Timestamp bookStorageItem1_storageTime=new Timestamp(new Long("1600988818888")); //入库时间
        BookId bookStorageItem1_bookId=new BookId(new Long(1)); //图书唯一标识 系统生成
        String bookStorageItem1_bookNumber="jat-xs001"; //图书编号
        String bookStorageItem1_bookName="百年孤独"; //书名
        String bookStorageItem1_bookAuthor="加西亚-马尔克斯"; //图书作者
        String bookStorageItem1_bookCatagory="小说"; //图书分类
        BigDecimal bookStorageItem1_bookPrice=new BigDecimal(9900);//图书价格 单位（分）
        boolean bookStorageItem1_borrowStatus=false; //图书借出状态 true为未借出 false为已借出
        boolean bookStorageItem1_onShelfStatus=true; //图书上架状态 true为上架 false为未上架
        //新建图书 必要参数 1唯一标识 2图书序列号 3书名 4作者 5图书分类 6价格 7图书上架状态 8图书借出状态
        Book bookStorageItem1_book=new Book(bookStorageItem1_bookId,bookStorageItem1_bookNumber,bookStorageItem1_bookName,bookStorageItem1_bookAuthor,bookStorageItem1_bookCatagory,bookStorageItem1_bookPrice,bookStorageItem1_onShelfStatus,bookStorageItem1_borrowStatus);
        //新建图书入库选项（一行） 必要参数 1选项序列号 2入库时间 3图书
        BookStorageItem bookStorageItem1 =new BookStorageItem(bookStorageItem1_serialNumber,bookStorageItem1_storageTime,bookStorageItem1_book);
        //准备图书入库选项集合(多行)
        Collection<BookStorageItem> bookStorageItems =new HashSet<BookStorageItem>();
        //图书入库选项集合添加一个图书入库选项(一行)
        bookStorageItems.add(bookStorageItem1);

        //准备图书入库表唯一标识
        BookStorageListId bookStorageListId =new BookStorageListId(new Long(10001));
        //创建新图书入库表
        BookStorageList bookStorageList =new BookStorageList(bookStorageListId);
        //图书上架
        bookStorageList.storageBooks(bookStorageItems);
        log.debug("|"+ bookStorageList.getBookStorageListId().getId()+"|");
        log.debug("|"+ bookStorageList.getBookStorageItems()+"|");
    }

}
