<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("basePath", basePath);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="${basePath }">
    
    <title>index</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="">
	<meta http-equiv="description" content="">

  </head>
  
  <body>
  this is my world.<br/><br/>
  <a href="${basePath }userModule/touserLogin">click here</a>
  <a href="${basePath }jsp/jsonModule/showJsonData.jsp">testGetJson</a>
  <a href="${basePath }testJsonModule/getJsonData">testGetJson</a>
  </body>
</html>
