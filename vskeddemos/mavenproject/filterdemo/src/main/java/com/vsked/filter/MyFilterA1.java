package com.vsked.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.vsked.service.BaseService;

public class MyFilterA1 implements Filter{

	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		System.out.println("MyFilterA1|"+new BaseService().getMaps((HttpServletRequest) request));
		
		chain.doFilter(request, response);
	}

	public void destroy() {
		
	}

}
