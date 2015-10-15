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
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="">
	<meta http-equiv="description" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  
  <body>
  <br>
  <form id="fm0" name="fm0" method="post" action="${basePath }user/add">
  用户名<input  name="user.uName" value="">
 昵称<input  name="user.uNick" value="">
密码<input  name="user.uPass" value="">
<button type="submit">提交</button>
  </form>
  <br>
  <table>
  <tr> <td colspan="6">用户列表</td></tr>
  <tr>
      <th>用户Id</th>
      <th>用户名</th>
      <th>昵称</th>
      <th>密码</th>
      <th>注册时间</th>
      <th>最后登陆时间</th>
      <th>操作</th>
  </tr>
  <c:forEach items="${p==null?'':p.list}" var="u" varStatus="status">
  <tr>
      <td>${status.index }</td>
      <td>${u.uName }</td>
      <td>${u.uNick }</td>
      <td>${u.uPass }</td>
      <td>${u.regTime }</td>
      <td>${u.lastLoginTime }</td>
      <td><a href="${basePath }user/del/${u.uId }">del</a></td>
  </tr>
  </c:forEach>
  </table>
  </body>
</html>
