package com.vsked.service.impl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vsked.dao.LoginLogTDAO;
import com.vsked.dao.UserTDAO;
import com.vsked.service.UserTService;

@Service
@Transactional
public class UserTServiceImpl implements UserTService{
	
	@Autowired
	UserTDAO ud;
	
	@Autowired
	LoginLogTDAO lld;

	@Override
	public int addUser(Map m,HttpServletRequest r) {
		m.put("lastIp", getIP(r));
		return ud.addUser(m);
	}

	@Override
	public Map userLogin(Map m,HttpServletRequest r) {
		Map tm=ud.userLogin(m);
		
		if(tm!=null){
			tm.put("ip", getIP(r));
			lld.addLog(tm);
			ud.updateUserLastIP(tm);
		}
			
		return tm;
	}
	
	public String getIP(HttpServletRequest req){
		String ip=req.getHeader("x-forwarded-for");
		if(ip==null||ip.length()==0||"unknown".equalsIgnoreCase(ip)){
			ip=req.getHeader("Proxy-Client-IP");
		}
		if(ip==null||ip.length()==0||"unknown".equalsIgnoreCase(ip)){
			ip=req.getHeader("WL-Proxy-Client-IP");
		}
		if(ip==null||ip.length()==0||"unknown".equalsIgnoreCase(ip)){
			ip=req.getRemoteAddr();
		}
		return ip;
	}

}
