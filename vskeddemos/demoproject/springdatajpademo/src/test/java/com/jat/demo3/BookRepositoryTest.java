package com.jat.demo3;

import com.jat.test.BaseTestWithTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.testng.annotations.Test;
import javax.annotation.Resource;


public class BookRepositoryTest extends BaseTestWithTransactional {

    private static final Logger log = LoggerFactory.getLogger(BookRepositoryTest.class);

    @Resource
    BookRepository bookRepository;

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void create(){
        log.trace(" start test create 事务执行完后才会发送sql到服务器，对比日志");
        Long bid=1L;
        String bookName="西游记11";
        BookEntity bookEntity=new BookEntity(bid,bookName);
        log.info("当前保存前的实体是:{}",bookEntity);
        BookEntity bookEntitySaved=bookRepository.save(bookEntity);//可以打断点看日志
        log.info("当前保存后的实体是:{}",bookEntitySaved);

        bookEntity=new BookEntity(bid,"道德经");
        bookRepository.save(bookEntity);

        bookEntity=new BookEntity(bid,"坏蛋是怎样炼成的");
        bookRepository.save(bookEntity);
        /**
         2021-07-07 at 14:25:00 CST traceId:[] TRACE com.jat.demo3.BookRepositoryTest 21 create -  start test create 事务执行完后才会发送sql到服务器，对比日志
         2021-07-07 at 14:25:00 CST traceId:[] INFO  com.jat.demo3.BookRepositoryTest 25 create - 当前保存前的实体是:BookEntity{bid=1, bookName='西游记11'}
         Hibernate: select bookentity0_.bid as bid1_0_0_, bookentity0_.bookName as bookname2_0_0_ from book bookentity0_ where bookentity0_.bid=?
         2021-07-07 at 14:25:07 CST traceId:[] INFO  com.jat.demo3.BookRepositoryTest 27 create - 当前保存后的实体是:BookEntity{bid=1, bookName='西游记11'}
         */
    }

    @Rollback(value = false) //单元测试后数据库数据回滚，false为不回滚,如果需要保留数据就设置为false
    @Test
    public void createFlush(){
        log.trace(" start test createFlush 执行完saveAndFlush后就会立即发送sql到服务器，对比日志");
        Long bid=1L;
        String bookName="西游记11";
        BookEntity bookEntity=new BookEntity(bid,bookName);
        log.info("当前保存前的实体是:{}",bookEntity);
        BookEntity bookEntitySaved=bookRepository.saveAndFlush(bookEntity);
        log.info("当前保存后的实体是:{}",bookEntitySaved);

        bookEntity=new BookEntity(bid,"道德经");
        bookRepository.saveAndFlush(bookEntity);

        bookEntity=new BookEntity(bid,"坏蛋是怎样炼成的");
        bookRepository.saveAndFlush(bookEntity);
        /**
         2021-07-07 at 14:27:14 CST traceId:[] TRACE com.jat.demo3.BookRepositoryTest 45 createFlush -  start test createFlush 执行完saveAndFlush后就会立即发送sql到服务器，对比日志
         2021-07-07 at 14:27:14 CST traceId:[] INFO  com.jat.demo3.BookRepositoryTest 49 createFlush - 当前保存前的实体是:BookEntity{bid=1, bookName='西游记11'}
         Hibernate: select bookentity0_.bid as bid1_0_0_, bookentity0_.bookName as bookname2_0_0_ from book bookentity0_ where bookentity0_.bid=?
         Hibernate: update book set bookName=? where bid=?
         2021-07-07 at 14:27:15 CST traceId:[] INFO  com.jat.demo3.BookRepositoryTest 51 createFlush - 当前保存后的实体是:BookEntity{bid=1, bookName='西游记11'}
         Hibernate: update book set bookName=? where bid=?
         Hibernate: update book set bookName=? where bid=?
         */
    }


}
