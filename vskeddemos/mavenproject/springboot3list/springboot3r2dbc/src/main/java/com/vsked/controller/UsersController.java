package com.vsked.controller;

import com.vsked.r2dbc.mysql.model.Users;
import com.vsked.r2dbc.mysql.service.UsersService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    @Resource
    UsersService usersService;

    @GetMapping("/testCreate")
    @ResponseBody
    public String testCreate() {
        Users myUser=new Users(null,"user1","password1");
        usersService.save(myUser);
        return "ok";
    }
}
