package com.etop.controller;

import com.etop.basic.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 处理用户操作的控制器
 *
 * Created by Jeremie on 2014/10/3.
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    //add,edit,del页面并没有写具体逻辑，要验证是否成功，需要观察控制台输出。
    @RequestMapping("/add.html")
    public String addUser(){
        return "/success.jsp";
    }

    @RequestMapping("/edit.html")
    public String updateUser(int id){
        System.out.println("=========================================>要修改的id为:" + id);
        return "/success.jsp";
    }

    @ResponseBody
    @RequestMapping(value = "/del.html",produces = "text/html; charset=utf-8",method= RequestMethod.GET)
    public String deleteUser(String id){
        System.out.println("=========================================>要删除的id为:" + id);
        return "";
    }
}
