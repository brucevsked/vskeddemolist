<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
request.setAttribute("basePath", basePath);
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="${basePath }">
    
    <title>index</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    This is my JSP page.0 <br>
    <a href="${basePath }template1.jsp">template1</a> <br>
    <a href="${basePath }template2.jsp">template2</a> <br>
    <a href="${basePath }template3.jsp">template3</a> <br>
    <a href="${basePath }template4.jsp">template4</a> <br>
  </body>
</html>
