<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
  <base href="<%=basePath%>">
  
    <title>dgrid</title>
        
    <meta http-equiv="keywords" content="">
    <meta http-equiv="description" content="">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="<%=basePath%>js/dojo193/dojo/resources/dojo.css" media="screen">
    <link rel="stylesheet" href="<%=basePath%>js/dojo193/dijit/themes/claro/claro.css" media="screen">
    <link rel="stylesheet" href="<%=basePath%>js/dojo193/dgrid/css/skins/claro.css" media="screen">
    <script type="text/javascript" src="<%=basePath%>js/mydemojs/dojodemo/dojoExtendsConfig.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/dojo193/dojo/dojo.js" data-dojo-config="async: true"></script>
    <script type="text/javascript" src="<%=basePath%>js/mydemojs/dojodemo/loginForm.js"></script>
        
  </head>
  
<body class="claro">
	<div id="gridDiv"></div>
</body>
</html>