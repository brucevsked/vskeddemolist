package com.vsked.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vsked.service.SysUserSer;



@Controller
//@Scope("prototype") //开启非单例模式 用于并发控制
public class LoginCtl {
	
	public Logger log = Logger.getLogger(LoginCtl.class);
	
	@Resource
	private SysUserSer sysUserSer;
	
	/**
	 * 登陆页面只能用get方式提交
	 * @return
	 */
	@GetMapping("login")
	public String loginPage(){
		return "login";
	}
	
	@GetMapping("index")
	public String index(){
		System.out.println("get index");
		log.info("here is messagea1");
		return "index";
	}
	
	@PostMapping("user")
	public String userAdd(){
		log.info("user/add");
		return "useradd";
	}
	
	@GetMapping("user")
	public String userList(){
		log.info("user/list");
		return "userlist";
	}
	
	@PutMapping("user")
	@ResponseBody
	public String userEdit(){
		log.info("user/edit");
		return "useredit";
	}
	
	
	@DeleteMapping("user")
	@ResponseBody
	public String userDel(){
		log.info("user/del");
		return "userdel";
	}
	
	@PatchMapping("user")
	@ResponseBody
	public String userChangePass(){
		log.info("user/userChangePass");
		return "userpass";
	}
	
	/**
	 * 主页显示 只能用get方式提交
	 * @param request
	 * @return
	 */
	@GetMapping("/mainPage")
	public String mainPage() {
		return "main";
	}
	
	/**
	 * 跳转到403页面只能用get方式提交
	 * @param request
	 * @return
	 */
	@GetMapping("/page403")
	public String page403() {
		return "page403";
	}
	
	/**
	 * 创建用户会话 只能用post方式提交
	 * @param req
	 * @return
	 */
	@PostMapping("/login")
	public String login(HttpServletRequest req) {
		return sysUserSer.login(req);
	}
	
	
    @RequestMapping(value="/logout",method=RequestMethod.GET)
    public String logout(RedirectAttributes attr){
        //使用权限管理工具进行用户的退出，注销登录
        SecurityUtils.getSubject().logout();
        sysUserSer.addMessage(attr, "您已安全退出");
        return "login";
    }
	
}
