package com.vsked.controller;

import com.vsked.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SysUserController {

    @Autowired
    SysUserService sysUserService;

    @RequestMapping("/apia/v1/user/list")
    @ResponseBody
    public String list(){
        return sysUserService.list();
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String index(){
        return "hellosystem";
    }

}
