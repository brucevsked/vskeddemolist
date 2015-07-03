package com.vsked.service;

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
		return userDao.findUserByUserName(userName);
	}
	
	public void loginSuccess(User user) {
		user.setCredits(5+user.getCredits());
		LoginLog loginLog = new LoginLog();
		loginLog.setUserId(user.getUserId());
		loginLog.setIp(user.getLastIp());
		loginLog.setLoginDate(user.getLastVisit());
		userDao.updateLoginInfo(user);
		loginLogDao.insertLoginLog(loginLog);
	}
	
	
	
}
