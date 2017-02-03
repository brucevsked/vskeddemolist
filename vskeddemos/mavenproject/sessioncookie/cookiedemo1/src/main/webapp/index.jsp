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
  
     <c:if test="${userSession.userId==null }"><c:redirect url="${basePath }login.jsp" /></c:if>

      <form action="${basePath }proc/logoutProc.jsp" method="post" onsubmit="logout()">
        欢迎你: ${userSession.userName}   &nbsp; &nbsp; &nbsp; &nbsp;
      <button type="submit">退出</button>
      </form>
      <br>
 当前第:  ${userSession.loginCount } 次登陆 <br>
 ${userSession}
 
  <script src="${basePath }js/lib/jquery.min.js"></script>
  <script src="${basePath }js/lib/jquery.cookie.js"></script>
  
  <script src="${basePath }js/project/index.js"></script>
  </body>
</html>