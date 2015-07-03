<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
  <base href="<%=basePath%>">
  
    <title>hightstock</title>
        
    <meta http-equiv="keywords" content="">
    <meta http-equiv="description" content="">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="<%=basePath%>js/jquery111/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/highstock201/js/highstock.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/mydemojs/highstockSpline.js"></script>
        
  </head>
  
  <body>
  <button onclick="getJsonData('<%=basePath%>highstockdemo/generateJsonData.jsp')">clickHere</button>
  <div id="myct1"></div>
  <div id="myct2"></div>
  </body>
</html>