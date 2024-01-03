package com.jat.persistance1user.beanmanager;

import org.business1user.BookManager;
import org.business1user.YellowBookManager;
import org.business1user.repository.BookRepository;
import org.business1user.service.BookService;
import org.business1user.service.YellowBookService;
import org.business1user.ui.BookWindow;
import org.business1user.ui.YellowBookWindow;
import org.business1user.ui.vo.BookVO;
import org.business1user.ui.vo.YellowBookVO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class BookBeanConfig {

    @Resource
    BookRepository yellowBookRepository;


    @Bean(name = "yellowBookManager")
    public BookManager getBookManager(){
        BookManager bookManager=new YellowBookManager();
        bookManager.setBookRepository(yellowBookRepository);
        return bookManager;
    }

    @Bean(name = "yellowBookService")
    public BookService getBookService(){
        BookService bookService=new YellowBookService();
        bookService.setBookManager(getBookManager());
        return bookService;
    }

    @Bean(name = "yellowBookWindow")
    public BookWindow getBookWindow(){
        BookWindow bookWindow=new YellowBookWindow();
        bookWindow.setBookService(getBookService());
        return bookWindow;
    }

    @Bean(name = "yellowBookVO")
    public BookVO getBookVO(){
        BookVO bookVO=new YellowBookVO();
        return bookVO;
    }
}
