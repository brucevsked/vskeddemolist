package com.vsked.service;


import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vsked.dao.SysUserDao;
import com.vsked.service.BaseService;


@Service
@Transactional
public class SysUserSer extends BaseService{
	
	public Logger log = Logger.getLogger(SysUserSer.class);
	
	@Resource
	private SysUserDao sysUserDao;
	
	/**
	 * 登录业务逻辑
	 * @param req
	 * @return
	 */
	public String login(HttpServletRequest req){
		try{
			Map<String, Object> m=getMaps(req);
			String suName=(String)m.get("suName");
			String suPass=(String)m.get("suPass");
			if(StringUtils.isNotEmpty(suName) && StringUtils.isNotEmpty(suPass) ){
//				suPass=DigestUtils.md5Hex(suPass.getBytes());
				//使用shiro管理登录
				SecurityUtils.getSubject().login(new UsernamePasswordToken(suName, suPass));
				log.info("i has login ok"+suName);
				return "index";
			}else{
				req.setAttribute("error", "用户名或密码为空！");
				return "login";
			}
		}catch(Exception e){
			getMyLog(e,log);
			req.setAttribute("error", "用户名或密码错误请重新输入！");
			return "login";
		}
	}
	
	/**
	 * 根据用户名获取记录
	 * @param suName
	 * @return
	 */
	public Map<String, Object> getSysUserBySuName(String suName) {
		Map<String, Object> m=null;
		try{
			m=sysUserDao.getSysUserBySuName(suName);
		}catch(Exception e){
			getMyLog(e,log);
		}
		return m;
	}
	
	/**
	 * 根据主键获取记录
	 * @param suId
	 * @return
	 */
	public Map<String, Object> getSysUserBySuId(String suId) {
		Map<String, Object> m=null;
		try{
			m=sysUserDao.getSysUserBySuId(suId);
		}catch(Exception e){
			getMyLog(e,log);
		}
		return m;
	}
	
	/**
	 * 获取用户数量
	 * @param m
	 * @return
	 */
	public int getSysUserCount(Map<String, Object> m){
		int sysUserCount=0;
		try{
			sysUserCount=sysUserDao.getSysUserCount(m);
		}catch(Exception e){
			getMyLog(e,log);
		}
		return sysUserCount;
	}

	
	/**
	 * 跳转到编辑用户页
	 * @param suId
	 * @return
	 */
	public String sysUserEditPage(String suId){
		try{
			Map<String, Object> sysUser=getSysUserBySuId(suId);
			Session session=getSession();
			session.setAttribute("sysUser", sysUser);
		}catch(Exception e){
			getMyLog(e,log);
		}
		return "system/sysUserEdit";
	}
	
	/**
	 * 跳转到密码修改页
	 * @param suId
	 * @return
	 */
	public String sysUserChangePassPage(String suId){
		try{
			Map<String, Object> sysUser=getSysUserBySuId(suId);
			Session session=getSession();
			session.setAttribute("sysUser", sysUser);
		}catch(Exception e){
			getMyLog(e,log);
		}
		return "system/sysUserChangePass";
	}
	
	public void getParTest(HttpServletRequest req){
		Map<String, Object> m=getMaps(req);
		System.out.println(m);
	}
	
}
