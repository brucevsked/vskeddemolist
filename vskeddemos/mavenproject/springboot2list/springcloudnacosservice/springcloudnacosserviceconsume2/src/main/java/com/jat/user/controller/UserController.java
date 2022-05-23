package com.jat.user.controller;

import com.jat.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;

    @GetMapping("/getUser")
    public String index1(String id){
        log.info("--------------:{}",id);
        //openfeign + loaderbalance
        return userService.index(id);
    }


}
