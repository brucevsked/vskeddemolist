package com.vsked.controller;

import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.vsked.service.SysUserSer;

@Controller
public class UserController {
	
	private static final Logger log = Logger.getLogger(UserController.class);
	
	@Autowired
	private SysUserSer sysUserSer;
	
	/**
	 * 跳转到登录界面
	 * @param req
	 * @return
	 */
	@GetMapping("login")
	public String loginPage(HttpServletRequest req){
		log.debug(""+req.getRequestedSessionId());
		return "login";
	}
	
	/**
	 * 用户登录处理创建用户会话 只能用post方式提交
	 * @param req
	 * @return
	 */
	@PostMapping("/login")
	public String login(HttpServletRequest req) {
		return sysUserSer.login(req);
	}
	
	/**
	 * 登录成功后主页
	 * @return
	 */
	@GetMapping("index")
	public String index(){
		return "index";
	}
	
	@GetMapping("userListPage")
	public String userListPage(){
		return "userList";
	}
	
	@PostMapping("userListData")
	@ResponseBody
	public String userListData(HttpServletRequest req){
		return sysUserSer.sysUserList(req);
	}
	
	@GetMapping("userAddPage")
	public String userAddPage(){
		return "userAdd";
	}
	
	@PostMapping("userAddProc")
	@ResponseBody
	public String userAddProc(HttpServletRequest req){
		return sysUserSer.userAddProc(req);
	}
	
	@GetMapping("userEditPage")
	public String userEditPage(HttpServletRequest req){
		return sysUserSer.userEditPage(req);
	}
	
	@PostMapping("userEditProc")
	@ResponseBody
	public String userEditProc(HttpServletRequest req){
		return sysUserSer.userEditProc(req);
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
	 * 注销
	 * @param attr
	 * @return
	 */
    @RequestMapping(value="/logout",method=RequestMethod.GET)
    public String logout(RedirectAttributes attr){
        //使用权限管理工具进行用户的退出，注销登录
        SecurityUtils.getSubject().logout();
        sysUserSer.addMessage(attr, "您已安全退出");
        return "login";
    }
    
	@GetMapping("userPassPage")
	public String userPassPage(HttpServletRequest req){
		return sysUserSer.userPassPage(req);
	}
	
	@PostMapping("userPassProc")
	@ResponseBody
	public String userPassProc(HttpServletRequest req){
		return sysUserSer.userPassProc(req);
	}
    
}
