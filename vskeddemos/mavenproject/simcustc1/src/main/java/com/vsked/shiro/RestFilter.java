package com.vsked.shiro;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.HttpMethodPermissionFilter;
import org.springframework.beans.factory.annotation.Autowired;

import com.vsked.service.SysUserRoleSer;

public class RestFilter extends HttpMethodPermissionFilter{
	
	private static final Logger log = Logger.getLogger(RestFilter.class);
	
	@Autowired
	SysUserRoleSer sysUserRoleSer;
			
	@SuppressWarnings("unchecked")
	@Override
	public boolean isAccessAllowed(ServletRequest request,
			ServletResponse response, Object mappedValue) throws IOException {
		HttpServletRequest req=(HttpServletRequest) request;
		log.debug("reqmethod|"+req.getMethod());
		log.debug("requrl|"+req.getRequestURI());
		String resourceFront=req.getRequestURI();
		String[] tmpArray=resourceFront.split("/");
		String permissionMethod=req.getMethod().toLowerCase();
		
		String permission=tmpArray[2]+":"+permissionMethod;
		log.debug(permission);
		
		Subject subject = getSubject(request, response);
		Map<String, Object> userMap=((Map<String, Object>) subject.getPrincipal());
		String suId=(String)userMap.get("SUID");
		
		Map<String, Object> parMap=new HashMap<String, Object>();
		parMap.put("suId", suId);
		parMap.put("spName", permission);
		
		return sysUserRoleSer.isPermitted(parMap);
	}
	
}
