package com.vsked.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vsked.dao.LoginLogDao;
import com.vsked.dao.UserDao;
import com.vsked.entity.LoginLog;
import com.vsked.entity.User;


@Service
@Transactional
public class UserService {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private LoginLogDao loginLogDao;
	
	public boolean hasMatchUser(String userName, String password) {
		int matchCount = userDao.getMatchCount(userName, password);
		return matchCount>0;
	}
	
	public User findUserByUserName(String userName) {
		return userDao.findUserByUsName(userName);
	}
	
	public void loginSuccess(User user) {
		LoginLog loginLog = new LoginLog();
		loginLog.setUserId(user.getUsId());
		loginLog.setIp(user.getUsLastIp());
		loginLog.setLoginDate(user.getUsLastVisit());
		userDao.updateLoginInfo(user);
		loginLogDao.insertLoginLog(loginLog);
	}
	
	public String getUserList(){
		String result="";
		List<Map<String, Object>> userList=userDao.getUserList();
		for(Map<String, Object> user:userList){
			result+=user.toString()+"<br>";
		}
		return result;
	}
	
	
	
}
