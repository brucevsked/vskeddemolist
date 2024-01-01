package com.jat.demo3;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

@Table(name = "book")//表名
@Entity //实体 表示实体化后可以被跟踪
public class BookEntity implements Serializable {

    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = 6701867656484039109L;

    @Id //实体实例化后唯一标识 数据库中主键
    @Column(name = "bid",columnDefinition = "bigint") //列名与列定义
    private Long bid;

    @Column(name = "bookName")
    private String bookName;

    public BookEntity() {
        //要有空构造
    }

    public BookEntity(Long bid, String bookName) {
        this.bid = bid;
        this.bookName = bookName;
    }

    public Long getBid() {
        return bid;
    }

    public void setBid(Long bid) {
        this.bid = bid;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "bid=" + bid +
                ", bookName='" + bookName + '\'' +
                '}';
    }
}
