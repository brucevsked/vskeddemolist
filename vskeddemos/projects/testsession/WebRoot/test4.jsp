<%@page import="com.vsked.ehcache.TestEhCache"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
request.setAttribute("basePath", basePath);

%>

<%

if(!TestEhCache.isInit){
	TestEhCache.init();
}

out.println(request.getSession().getId()+"|"+TestEhCache.showAllCache());
System.out.println(request.getSession().getId()+"|"+TestEhCache.showAllCache());
%>

<%
String agentName=request.getParameter("agentName");
String agentValue=request.getParameter("agentValue");
String terminalName=request.getParameter("terminalName");
String terminalValue=request.getParameter("terminalValue");

if(agentName!=null){
	TestEhCache.updateCache(agentName, agentValue);
	TestEhCache.updateCache(terminalName, terminalValue);
}
%>
<!DOCTYPE HTML>
<html>
  <head>
    <base href="${basePath }">
    
    <title>test4</title>
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
  <hr>
  ehcache test  <hr>
 <form action="${basePath }test4.jsp">
 agentName:<input id="agentName" name="agentName" > <br>
 agentValue:<input id="agentValue" name="agentValue" > <br>
 terminalName:<input id="terminalName" name="terminalName" > <br>
 terminalValue:<input id="terminalValue" name="terminalValue" > <br>
 <button type="submit">let's submit</button>
 </form>
 
  </body>
</html>
