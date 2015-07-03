<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
  <base href="<%=basePath%>">
  
    <title>dojo</title>
        
    <meta http-equiv="keywords" content="">
    <meta http-equiv="description" content="">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="<%=basePath%>js/dojo193/dojo/dojo.js" data-dojo-config="async: true"></script>
    <script type="text/javascript" src="<%=basePath%>js/mydemojs/dojodemo/hellodojo.js"></script>
        
  </head>
  
  <body>
  <%=basePath%><br><br>
  <button id="myBt1">clickHere</button>
  <div id="myDiv1"></div>
  </body>
</html>