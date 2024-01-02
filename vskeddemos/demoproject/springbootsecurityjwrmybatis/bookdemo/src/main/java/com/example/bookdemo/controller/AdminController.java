package com.example.bookdemo.controller;

import com.example.bookdemo.pojo.Admin;
import com.example.bookdemo.security.utils.JwtBean;
import com.example.bookdemo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
public class AdminController {
    @Autowired
    AdminService adminService;
    /*@PostMapping("login")
    public Admin login(String username, String password){
        Admin login = adminService.login(username, password);
        return login;
    }*/
    /*@PostMapping("/login")
    public JwtBean login(String username, String password, HttpServletRequest request) {
        System.out.println(username+password);
        return adminService.login(username, password,request);
    }*/
    //错误写法
    @PostMapping("/login")
    public JwtBean login(@RequestBody Admin admin, HttpServletRequest request) {
        System.out.println(admin.getUsername()+admin.getPassword());
        return adminService.login(admin.getUsername(),admin.getPassword(),request);
    }
}
