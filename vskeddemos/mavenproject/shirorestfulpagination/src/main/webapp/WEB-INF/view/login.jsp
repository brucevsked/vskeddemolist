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
    <title>登录页面</title>
    <script type="text/javascript" src="${basePath }static/js/md5.js"></script>
</head>

<body>
<h1>登录页面----<span style="color: red;">${message }</span></h1>
<form action="${basePath }login" name="user" method="post">
    用户名：<input type="text" name="suName" value="admin" /> <br/>
    密&nbsp;&nbsp;码：
    <input type="password" id="suPass" name="suPass" value="000000"/> <br/>
    <input type="button" onclick="submitform()" value="登录"/>
    <input type="reset" value="重置"/>
</form>
</body>
<script type="text/javascript">
    function submitform(){
        var password = document.getElementById("suPass");
        //md5加密
        document.getElementById("suPass").value = hex_md5(password.value);
        document.user.submit();
    }
</script>
</html>  