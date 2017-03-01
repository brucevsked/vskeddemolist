package com.vsked.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.vsked.dao.SysRoleDao;


@Service
@Transactional
public class SysRoleSer extends BaseService{
	
	public Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	SysRoleDao sysRoleDao;
	
	
	public int getSysRoleCount(Map<String, Object> m){
		int count=0;
		try{
			count=sysRoleDao.getSysRoleCount(m);
		}catch(Exception e){
			getMyLog(e,log);
		}
		return count;
	}
	
	public Map<String, Object> getSysRoleBySrId(String srId){
		return sysRoleDao.getSysRoleBySrId(srId);
	}
	
	
	public String sysRoleEditPage(String srId){
		try{
			Map<String, Object> sysRole=getSysRoleBySrId(srId);
			Session session=getSession();
			session.setAttribute("sysRole", sysRole);
		}catch(Exception e){
			getMyLog(e,log);
		}
		return "system/sysRoleEdit";
	}
	
	
}
