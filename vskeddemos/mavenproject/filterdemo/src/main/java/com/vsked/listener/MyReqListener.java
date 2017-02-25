package com.vsked.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

import com.vsked.service.BaseService;

public class MyReqListener implements ServletRequestListener{

	public void requestDestroyed(ServletRequestEvent sre) {
		
	}

	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("MyReqListener|"+new BaseService().getMaps((HttpServletRequest) sre.getServletRequest()));
	}

}
