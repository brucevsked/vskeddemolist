package com.vsked.bookborrow.domain.aggregateroot;

import com.vsked.bookborrow.domain.PO.BookPO;
import com.vsked.bookborrow.domain.valueobject.*;

import java.math.BigDecimal;


public class Book {

    /**
     * 书籍唯一标识，由系统自动生成(如snowflake算法)
     */
    private BookId bookId;

    /**
     * 图书编号
     */
    private String number;

    /**
     * 书名
     */
    private String name;

    /**
     * 作者
     */
    private String author;

    /**
     * 类型
     */
    private String catagory;

    /**
     * 书箱价格单位（分）
     */
    private BigDecimal price;

    /**
     * 上架状态
     * true 已上架
     * false 未上架
     */
    private boolean onShelfStatus;

    /**
     * 借阅状态
     * true 未借出
     * false 已借出
     */
    private boolean borrowStatus;

    /**
     * 获取书箱唯一标识
     * @return
     */
    public BookId bookId(){
        return this.bookId;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getCatagory() {
        return catagory;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public boolean isBorrowStatus() {
        return borrowStatus;
    }

    public boolean isOnShelfStatus() {
        return onShelfStatus;
    }

    /**
     * 是否可借阅
     * @return
     */
    public boolean canBorrow() throws Exception {
        boolean isCanBorrow=false;
        if(isOnShelfStatus()==false){
            throw new Exception("书籍未上架，暂不能借用，请联系管理员。");
        }
        if(isBorrowStatus()==false){
            throw new Exception("书籍已借出，暂不能借用，请联系管理员。");
        }
        //书已经上架 并且 借阅状态为未借出
        isCanBorrow=(isOnShelfStatus()==true && isBorrowStatus()==true);
        return isCanBorrow;
    }

    public boolean equals(Object anObject){
        boolean equalObjects = false;
        if(anObject!=null && this.getClass()==anObject.getClass()){
            Book typedObject=(Book)anObject;
            equalObjects=typedObject.bookId.equals(this.bookId);
        }
        return equalObjects;
    }

    public Book(BookId bookId, String number, String name, String author, String catagory, BigDecimal price, boolean onShelfStatus, boolean borrowStatus) throws IllegalArgumentException {

        if(bookId==null){
            throw new IllegalArgumentException("bookId cannot be null.");
        }

        if(number==null){
            throw new IllegalArgumentException("book number cannot be null.");
        }

        if(name==null){
            throw new IllegalArgumentException("book name cannot be null.");
        }

        if(author==null){
            throw new IllegalArgumentException("book author cannot be null.");
        }

        if(catagory==null){
            throw new IllegalArgumentException("book catagory cannot be null.");
        }

        if(price==null){
            throw new IllegalArgumentException("book price cannot be null.");
        }

        this.bookId = bookId;
        this.number = number;
        this.name = name;
        this.author = author;
        this.catagory = catagory;
        this.price = price;
        this.borrowStatus = borrowStatus;
        this.onShelfStatus = onShelfStatus;
    }

    /**
     * 将领域模型转换为数据库模型(domain Entity to PO)
     * @return
     */
    public BookPO createBookPO(){
        //TODO fixed
        Long bookId=this.bookId.getBookId();
        String bookName="";
        boolean bookBorrowStatus=true;
        boolean bookOnShelfStatus=true;
        return new BookPO(bookId,bookName,bookBorrowStatus,bookOnShelfStatus);
    }

    @Override
    public String toString() {
        return "Book{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", catagory='" + catagory + '\'' +
                '}';
    }
}
