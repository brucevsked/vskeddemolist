<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
request.setAttribute("basePath", basePath);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="${basePath }">
    
    <title>views/index.jsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="">
	<meta http-equiv="description" content="">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
	<link type="text/css" href="${basePath }css/allStyle.css" rel="stylesheet" />
  </head>
  
  <body>
    welcome to vsked's world <br>
    <a href="${basePath }restc/welcome">Home</a> <br><br>
    <a href="${basePath }restc/login/mynameisvsked">view myname</a> <br><br>
    
  ${u==null?'添加':'更新'}用户
  
  <form id="fm" action="${basePath }restc/userOperate" method="POST" onsubmit="" >
  <input type="hidden" name="userId" id="userId" value="${u.userId }" /> 
  <table>
  <tr><td>用户名</td><td><input type="text" id="userName" name="userName" value="${u.userName }" /></td></tr>
  <tr><td>昵称</td><td><input type="text" id="userNickName" name="userNickName" value="${u.userNickName }" /></td></tr><tr>
  <tr><td>密码</td><td><input type="text" id="userPass" name="userPass" value="${u.userPass	 }" /></td></tr>
  <tr><td>确认密码</td><td><input type="text" id="userPass1" name="userPass1" value="${u.userPass }" /></td></tr>
  <tr><td>邮箱</td><td><input type="text" id="userEmail" name="userEmail" value="${u.userEmail }" /></td></tr>
  <tr><td>手机号</td><td><input type="text" id="userMobile" name="userMobile" value="${u.userName }" /></td></tr>
  <tr><td colspan="2"><button type="submit">提交</button></td></tr>
  </table>
  </form>
  
   ${u==null?'添加':'更新'}用户 User
    <form id="fm" action="${basePath }restc/userOperate1" method="POST" onsubmit="" >
  <input type="hidden" name="userId" id="userId" value="${u.userId }" /> 
  <table>
  <tr><td>用户名</td><td><input type="text" id="userName" name="userName" value="${u.userName }" /></td></tr>
  <tr><td>昵称</td><td><input type="text" id="userNickName" name="userNickName" value="${u.userNickName }" /></td></tr><tr>
  <tr><td>密码</td><td><input type="text" id="userPass" name="userPass" value="${u.userPass	 }" /></td></tr>
  <tr><td>确认密码</td><td><input type="text" id="userPass1" name="userPass1" value="${u.userPass }" /></td></tr>
  <tr><td>邮箱</td><td><input type="text" id="userEmail" name="userEmail" value="${u.userEmail }" /></td></tr>
  <tr><td>手机号</td><td><input type="text" id="userMobile" name="userMobile" value="${u.userName }" /></td></tr>
  <tr><td colspan="2"><button type="submit">提交</button></td></tr>
  </table>
  </form>
  </body>
</html>
