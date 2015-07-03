<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title> </title>
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
    test <br>
    <a href="<%=basePath%>extjsdemo/helloworld.jsp">hellowrold extjs</a> <br>
    
    <a href="<%=basePath%>UserServlet">UserServlet</a> <br>
    <a href="<%=basePath%>GenerateServlet">GenerateServlet</a> <br>
    <a href="<%=basePath%>SortGridServlet">SortGridServlet</a> <br>
    <a href="<%=basePath%>SortGridServlet?isArray=true">SortGridServlet for isArray</a> <br>
    
    <a href="<%=basePath%>extjsdemo/basicGrid.jsp">basicGrid extjs</a> <br>
    <a href="<%=basePath%>extjsdemo/arrayGrid.jsp">arrayGrid extjs</a> <br>
    <a href="<%=basePath%>extjsdemo/sortGrid.jsp">sortGrid extjs</a> <br>
    <a href="<%=basePath%>extjsdemo/arrayStoreGrid.jsp">ArrayGrid extjs</a> <br>
    <hr>
    <a href="<%=basePath%>highstockdemo/highstockSpline.jsp">highstockSpline|</a> <br>
    <hr>
    <a href="<%=basePath%>dojodemo/hellodojo.jsp">hello dojo</a> <br>
    <a href="<%=basePath%>dojodemo/eventTest.jsp">eventTest</a> <br>
    <a href="<%=basePath%>dojodemo/dojoEnhancedGridDemo.jsp">dojoEnhancedGridDemo|</a> <br>
    <a href="<%=basePath%>dojodemo/dgridDemo.jsp">dgridDemo|</a> <br>
    <a href="<%=basePath%>dojodemo/gridXDemo.jsp">gridXdemo|</a> <br>
    <hr>
    <a href="<%=basePath%>jqueryeasyuidemo/dynamicGrid.jsp">easyUI data grid|</a> <br>
    <a href="<%=basePath%>jqueryeasyuidemo/flexigridDemo.jsp">flexigridDemo|</a> <br>
  </body>
</html>
