package com.vsked.servlet;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName="UserFilter",value="/*",dispatcherTypes={DispatcherType.REQUEST,DispatcherType.FORWARD})
public class UserFilter implements Filter{

	public void destroy() {	}

	public void doFilter(ServletRequest req, ServletResponse res,FilterChain fc) throws IOException, ServletException {
		System.out.println("this is filter for user");
		fc.doFilter(req, res);
	}

	public void init(FilterConfig fc) throws ServletException {
		
	}

}
