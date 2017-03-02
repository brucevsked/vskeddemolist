package com.vsked.shiro;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.HttpMethodPermissionFilter;

public class RestFilter extends HttpMethodPermissionFilter{
	
	@Override
	public boolean isAccessAllowed(ServletRequest request,
			ServletResponse response, Object mappedValue) throws IOException {
		HttpServletRequest req=(HttpServletRequest) request;
		System.out.println("-----------s1,method|"+req.getMethod());
		System.out.println("-----------s2,url|"+req.getRequestURI());
		String resourceFront=req.getRequestURI();
		resourceFront=resourceFront.substring(resourceFront.lastIndexOf("/")+1);
		String permissionMethod=req.getMethod().toLowerCase();
		
		String permission=resourceFront+":"+permissionMethod;
		System.out.println(resourceFront);
		
		Subject subject = getSubject(request, response);
		
		System.out.println("---------s3,hasPermission|"+subject.isPermitted(permission));
		
		return subject.isPermitted(permission);
	}


}
