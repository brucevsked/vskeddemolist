package com.vsked.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.vsked.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @ResponseBody
    @RequestMapping("register")
    public boolean register(@RequestParam("username") String username,
                            @RequestParam("password") String password){
        return userService.register(username,password);
    }
    
    @RequestMapping("login")
    public ModelAndView login(@RequestParam("username") String username,
                              @RequestParam("password") String password){
        return userService.login(username, password);
    }
}
