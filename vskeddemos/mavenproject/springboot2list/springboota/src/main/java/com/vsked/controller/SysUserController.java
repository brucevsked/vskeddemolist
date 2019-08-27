package com.vsked.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SysUserController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "helloinfo";
    }
}
