package com.jat.beanmanager;

import com.jat.business1.Book;
import org.springframework.context.annotation.Bean;

public class BeanFactory {

    @Bean
    public Book getBook(){
        return new Book();
    }
}
