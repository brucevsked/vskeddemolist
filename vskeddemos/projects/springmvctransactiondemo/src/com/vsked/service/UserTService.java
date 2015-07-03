package com.vsked.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface UserTService {
	public int addUser(Map m,HttpServletRequest r);
	public Map userLogin(Map m,HttpServletRequest r);

}
