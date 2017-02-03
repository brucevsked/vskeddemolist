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
    
    <title>login</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
  </head>
  
  <body>
  
       <c:if test="${userSession.userId!=null }"><c:redirect url="${basePath }index.jsp" /></c:if>
  
  <form id="fm1" action="${basePath }proc/loginProc.jsp" method="post">
  userName:<input id="userName" name="userName" value="">admin<br>
  userPass:<input id="userPass" name="userPass" value="">password<br>
  <button type="submit">登录</button> &nbsp;&nbsp;
  <button type="reset">重写</button>
 </form>
 
  <script src="${basePath }js/lib/jquery.min.js"></script>
  <script src="${basePath }js/lib/jquery.cookie.js"></script>
  
  <script src="${basePath }js/project/login.js"></script>
  
  </body>
</html>
