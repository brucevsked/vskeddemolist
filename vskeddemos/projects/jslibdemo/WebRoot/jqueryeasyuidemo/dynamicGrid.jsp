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
    <script type="text/javascript" src="<%=basePath%>js/dojo193/dojo/dojo.js" data-dojo-config="async: true"></script>
    <script type="text/javascript" src="<%=basePath%>js/mydemojs/dojodemo/hellodojo.js"></script>
    
    <link rel="stylesheet" type="text/css" href="<%=basePath%>js/jqueryeasyui136/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>js/jqueryeasyui136/themes/icon.css">
	<script type="text/javascript" src="<%=basePath%>js/jqueryeasyui136/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jqueryeasyui136/jquery.easyui.min.js"></script>
	
	<script type="text/javascript" src="<%=basePath%>js/mydemojs/jqueryeasyuidemo/dynamicGrid.js"></script>
        
  </head>
  
  <body>
  <div id="gridDiv"></div>
  </body>
</html>