<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
request.setAttribute("basePath", basePath);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="${basePath }">
    
    <title>jstlDemo</title>
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
  ${userName }
  ${userPass }
  <ul>
  <li> <a href="${basePath }coreTagsDemo.jsp">coreTagsDemo</a> </li>
  <li> <a href="${basePath }proc/listmapproc.jsp">fortagDemo</a> </li>
  
  ${ck==null ?'cknull':'cknotnull' }
  ${cv=='null' ?'cvnull':'cvnotnull' }
  ${ca=="null" ?"canull":"canotnull" }
  </ul>
  </body>
</html>
