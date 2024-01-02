package com.example.bookdemo.service;

import com.example.bookdemo.pojo.Admin;
import com.example.bookdemo.security.utils.JwtBean;
import javax.servlet.http.HttpServletRequest;

public interface AdminService {
    public Admin login(String username, String password);
    Admin selectByName(String username);
    JwtBean login(String username, String password, HttpServletRequest request);
}
