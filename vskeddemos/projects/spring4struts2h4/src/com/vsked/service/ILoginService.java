package com.vsked.service;

import com.vsked.po.Login;


public interface ILoginService {
	
	public Login getByID(String username);
	
	public boolean login(String username,String password);
}
