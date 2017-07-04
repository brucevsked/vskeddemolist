<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
request.setAttribute("basePath", basePath);
%>

<!DOCTYPE html>
<html>
<head>
    <base href="${basePath }">
<title>Testing websockets</title>
</head>
<body>
  <div><a href="${basePath }client1.jsp">client1</a> </div> 
  <div><a href="client2.jsp">client2</a></div>
</body>
</html>
