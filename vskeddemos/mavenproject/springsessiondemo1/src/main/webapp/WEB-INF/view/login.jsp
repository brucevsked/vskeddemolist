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
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">

  </head>
  
  <body>
   ${userSession}<br>
${pageContext.session.id}
  <form action="${basePath }UserController/loginproc.html" method="post">
  userName:<input id="userName" name="userName" value="admin"><br>
  userPass:<input id="userPass" name="userPass" value="admin"><br>
  <button type="submit">登录</button> &nbsp;&nbsp;
  <button type="reset">重写</button>
 </form>
  </body>
</html>
