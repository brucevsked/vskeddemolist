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
    
    <title>login</title>
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
   <form action="${basePath }userc/${method}" method="post">
   <c:if test="${method=='edit'}">
   <input type="hidden" name="buId" value="${u.buId }">
   </c:if>
   <div><label>序列</label><span><input type="text" name="buSeq" id="buSeq" value="${u.buSeq }"></span></div>
   <div><label>登录编号</label><span><input type="text" name="buLoginId" id="buLoginId" value="${u.buLoginId }"></span></div>
   <div><label>登录名称</label><span><input type="text" name="buLoginName" id="buLoginName" value="${u.buLoginName }"></span></div>
   <div><label>手机号</label><span><input type="text" name="buLoginMobile" id="buLoginMobile" value="${u.buLoginMobile }"></span></div>
   <div><label>邮箱</label><span><input type="text" name="buLoginEmail" id="buLoginEmail" value="${u.buLoginEmail }"></span></div>
   <div><label>密码</label><span><input type="text" name="buLoginPass" id="buLoginPass" value="${u.buLoginPass }"></span></div>
   <div><label>确认密码</label><span><input type="text" name="buLoginRePass" id="buLoginRePass" value="${u.buLoginPass }"></span></div>
   <div><label>状态</label><span><input type="text" name="buStatus" id="buStatus" value="${u.buStatus }"></span></div>
   <div><label>最后登陆IP</label><span><input type="text" name="buLastLoginIp" id="buLastLoginIp" value="${u.buLastLoginIp }"></span></div>
   <div><label>备注</label><span><textarea name="buMemo" id="buMemo" rows="5" cols="20">${u.buMemo }</textarea></span></div>
   <div><button type="submit">提交</button><button type="reset">重写</button></div>
   </form>
  </body>
</html>
