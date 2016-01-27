<%@page import="com.vsked.service.TestLoginService"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

if(TestLoginService.testLogin(request)){
	request.getRequestDispatcher("/view/index.jsp").forward(request, response);
	//response.sendRedirect(basePath+"view/index.jsp");
}else{
	//response.sendRedirect(basePath+"view/testLogin.jsp");
	request.getRequestDispatcher("/view/testLogin.jsp").forward(request, response);
}
%>

