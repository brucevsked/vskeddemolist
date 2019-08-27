package com.vsked.controller;

import com.vsked.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class SysUserController {

    @Autowired
    SysUserService sysUserService;

    @RequestMapping("/apia/v1/user/login")
    public String appuserlogin(HttpServletRequest req, HttpServletResponse res){
        return sysUserService.sysUserLogin(req,res);
    }

    @RequestMapping("/apia/v1/user/list")
    public String list(){
        return sysUserService.list();
    }

    @RequestMapping("/apia/v1/user/add")
    public String add(){
        return sysUserService.add();
    }

    @RequestMapping("/apia/v1/user/edit")
    public String edit(){
        return sysUserService.edit();
    }

    @RequestMapping("/apia/v1/user/del")
    public String del(){
        return sysUserService.del();
    }

    @RequestMapping("/hello")
    public String index(){
        return "hellosystem";
    }

}
