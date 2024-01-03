package com.jat.controller;

import org.business1user.ui.BookWindow;
import org.business1user.ui.vo.BookVO;
import org.business1user.ui.vo.YellowBookVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/book")
public class BookController {

    @Resource
    BookWindow yellowBookWindow;

//    @GetMapping
//    public void savebook1(){
//        System.out.println("save 1");
//
//        yellowBookWindow.saveBook(new YellowBookVO("11","22"));
//    }



    @GetMapping
    public void saveBook(YellowBookVO bookVO){
        yellowBookWindow.saveBook(bookVO);
    }
}
