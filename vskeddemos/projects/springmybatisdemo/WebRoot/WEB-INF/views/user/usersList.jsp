<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("basePath", basePath);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="${basePath }">
    
    <title>2usersList</title>
    <meta http-equiv="charset" content="utf-8">
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
  
<table>
<caption>用户列表</caption>
<tr><td>用户id</td><td>用户名</td><td>密码</td><td>邮箱</td><td>最后登录IP</td><td>用户说明</td><td>编辑</td>
</tr>
 <c:forEach items="${dataList==null?'':dataList}" var="u" varStatus="status">
<tr>
  <td>${u.buId }</td>
  <td>${u.buLoginName }</td>
  <td>${u.buLoginPass }</td>
  <td>${u.buLoginEmail }</td>
  <td>${u.buLastLoginIp }</td>
  <td>${u.buMemo }</td>
  <td><a href="${basePath }userc/toEdit?buId=${u.buId }">编辑</a></td>
</tr>
</c:forEach>
</table>
  </body>
</html>
