package com.jat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GlobalController {

    @RequestMapping("/")
    public String error1(){
        return "error please check code";
    }
}
