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
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="">
	<meta http-equiv="description" content="">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" charset="UTF-8" src="${basePath }js/project/baseSet.js" ></script>
  </head>
  
  <body>
  template3.jsp <br>
  ${basePath } <br>
  <button onclick="ts();">getBasePath</button>
  </body>
</html>
