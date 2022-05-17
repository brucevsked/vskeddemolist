package com.jat.user.controller;

import com.jat.config.ProjectConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    ProjectConfig projectConfig;

    @GetMapping("/user0")
    public String index(){
        return projectConfig.toString();
    }
}
