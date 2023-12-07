package com.vsked.auth.web;

import com.vsked.bookborrow.applicationservice.BookApplicationService;
import com.vsked.bookborrow.web.VO.BookVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    /*
    @Autowired
    BookApplicationService bookApplicationService;


    @PostMapping("/book")
    @ResponseBody
    public String bookOnTheShelf(@RequestBody BookVO bookVO){
        return bookApplicationService.putBookOnTheShelf();
    }

     */
}
