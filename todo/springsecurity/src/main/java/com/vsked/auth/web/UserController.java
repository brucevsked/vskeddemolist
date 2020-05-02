package com.vsked.auth.web;

import com.vsked.auth.service.TestService;
import com.vsked.auth.service.UserService;
import com.vsked.auth.validator.UserValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private TestService testService;

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return testService.test1();
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }

    @GetMapping({"/", "/welcome"})
    public String welcome(Model model) {
        return "welcome";
    }
}
