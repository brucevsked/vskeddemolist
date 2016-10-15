package com.etop.controller;

import javax.validation.Valid;

import com.etop.basic.controller.BaseController;
import com.etop.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.etop.pojo.User;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * 处理用户登录登出的控制器
 *
 * Created by Jeremie on 2014/10/3.
 */
@Controller
public class HomeController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/login.html",method=RequestMethod.GET,produces = "text/html; charset=utf-8")
    public String loginForm(Model model,String message){
        if(!StringUtils.isEmpty(message))
            model.addAttribute(message);
        model.addAttribute("user", new User());
        return "/login.jsp";
    }

    @RequestMapping(value="/login.html",method=RequestMethod.POST,produces = "text/html; charset=utf-8")
    public String login(@Valid User user,BindingResult bindingResult,Model model,RedirectAttributes attr){
        try {
            if(bindingResult.hasErrors()){
                addMessage(attr, "用户名或密码错误");
                return "redirect:/login.html";
            }
            //使用shiro管理登录
            SecurityUtils.getSubject().login(new UsernamePasswordToken(user.getUsername(), user.getPassword()));
            //获取所有用户信息，权限由前端shiro标签控制
            List<User> userList = userService.getAllUser();
            model.addAttribute("userList", userList);
            return "/user.jsp";
        } catch (AuthenticationException e) {
            addMessage(attr, "用户名或密码错误");
            return "redirect:/login.html";
        }
    }

    @RequestMapping(value="/logout.html",method=RequestMethod.GET)
    public String logout(RedirectAttributes attr){
        //使用权限管理工具进行用户的退出，注销登录
        SecurityUtils.getSubject().logout();
        addMessage(attr, "您已安全退出");
        return "redirect:/login.html";
    }

    @RequestMapping("/403.html")
    public String unauthorizedRole(){
        return "/403.jsp";
    }
} 