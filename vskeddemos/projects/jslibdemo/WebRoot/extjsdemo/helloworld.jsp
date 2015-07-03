<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
  <base href="<%=basePath%>">
  
    <title>extjs.html</title>
        
    <meta http-equiv="keywords" content="">
    <meta http-equiv="description" content="">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/extjs421css/resources/css/ext-all.css">
    <script type="text/javascript" src="<%=basePath%>js/extjs421js/ext-all.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/mydemojs/hello.js"></script>
        
  </head>
  
  <body>
  <%=basePath%><br>
  <div id="loginDiv"></div>
  </body>
</html>