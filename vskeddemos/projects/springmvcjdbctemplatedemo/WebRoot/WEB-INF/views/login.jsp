<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>views/login</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>    
    <c:if test="${!empty error}">
    	<font color="red"><c:out value="${error}"/></font>
    </c:if>
    
    <form action="<c:url value='/loginCheck.html'/>" method="post">
    	用户名：
    	<input type="text" name="userName"/>
    	<br>
    	密码：
    	<input type="password" name="password"/>
    	<br>
    	<input type="submit" value="登录"/>
    	<input type="reset" value="重置"/>
    </form>
  </body>
</html>
