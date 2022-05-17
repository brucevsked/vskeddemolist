package com.jat.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.jat.config.ProjectConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    ProjectConfig projectConfig;

    @GetMapping("/user1")
    public String index(String id){
        log.info("1|{}",projectConfig.toString());
        log.info("1|{}",id);
        return "Hello Nacos Discovery---1|||"+id;
    }
}
