package com.vsked.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class VskedServletContextListener implements ServletContextListener{

	public void contextDestroyed(ServletContextEvent sc) {
		System.out.println("-----------------------Destroyed the VskedServletContextListener");
	}

	public void contextInitialized(ServletContextEvent sc) {
		System.out.println("------------------------init the VskedServletContextListener");
	}

}
