<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
request.setAttribute("basePath", basePath);

%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="${basePath }">
    
    <title>index</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="">
	<meta http-equiv="description" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
 <%
 request.getSession().setAttribute("myName", "lostworld");
 out.println("set value success!"+"myName is"+"lostworld|"+request.getSession().getId());
 System.out.println("set value success!"+"myName is"+"lostworld|"+request.getSession().getId());
 %>
 <hr>
  <a href="${basePath }lost.jsp">lost</a><hr>
  <a href="${basePath }test2.jsp">test2</a> <hr>
  <a href="${basePath }test3.jsp">test3</a> <hr>
  <a href="${basePath }test4.jsp">test4</a> <hr>
  </body>
</html>
