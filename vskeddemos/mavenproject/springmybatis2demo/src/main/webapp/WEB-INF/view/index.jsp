<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
request.setAttribute("basePath", basePath);
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="${basePath }">
    
    <title>index</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="content-type" content="text/html;charset=UTF-8">
    <jsp:include page="include/css.jsp"></jsp:include>
  </head>
  
  <body>
<a href="${basePath }customer/index.jsp">测试a</a><br>
<a href="${basePath }demo/picdemo.jsp">图片效果</a><br>

    <jsp:include page="include/js.jsp"></jsp:include>
  </body>
</html>