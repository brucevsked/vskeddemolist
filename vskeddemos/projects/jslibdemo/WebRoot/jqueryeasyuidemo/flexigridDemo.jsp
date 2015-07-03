<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
  <base href="<%=basePath%>">
  
    <title>easyui</title>
        
    <meta http-equiv="keywords" content="">
    <meta http-equiv="description" content="">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/flexigrid.css">
	<script type="text/javascript" src="<%=basePath%>js/lib/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/lib/jquery.flexigrid.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/mydemojs/jqueryeasyuidemo/flexigridDemo.js"></script>
        
  </head>
  
  <body>
  <div id="gridDiv"></div>
  <table class='flexme4' id='flexme4' style='display: none'></table>
  </body>
</html>