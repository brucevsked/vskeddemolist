<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>reg</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="">
	<meta http-equiv="description" content="">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <a href="<%=basePath%>toIndex" >index</a><br><br>
  reg
  <form action="<%=basePath%>userc/reg" method="post">
  用户名:<input id="userName" name="userName" value="" /> <br>
  密码:<input id="password" name="password" value="" /> <br>
  信用:<input id="credits" name="credits" value="" /> <br>
  <button type="submit">怒吼吧骚年</button>
  </form>
  
  </body>
</html>
