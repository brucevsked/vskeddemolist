package com.vsked.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @ResponseBody
    @RequestMapping("/test")
    public String test(){
        return "testok";
    }
/*
    @ResponseBody
    @RequestMapping("/")
    public String root(){
        return "this is root";
    }

    @ResponseBody
    @RequestMapping("/home")
    public String home(){
        return "welcome home page";
    }
*/
}
