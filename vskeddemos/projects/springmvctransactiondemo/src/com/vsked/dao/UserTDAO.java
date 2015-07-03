package com.vsked.dao;

import java.util.Map;

public interface UserTDAO {
	public int addUser(Map m);
	public Map userLogin(Map m);
	public int updateUserLastIP(Map m);
}
