<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
request.setAttribute("basePath", basePath);
%>

<!DOCTYPE>
<html>
  <head>
    <base href="${basePath }">
    
    <title>登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">

    <link rel="stylesheet" href="${basePath }css/project/sysUserLogin.css" >
    
  </head>
  
  <body>    
	<div id="screenDiv">
    <div id="loginDiv">
    	<div id="ti1">虚商的客服</div><br/>
    	<div id="backResult"> </div>
    	<div id="unameDiv"><label>用户名</label>&nbsp;&nbsp;<input id="suName" name="suName" type="text"></div><br/>
    	<div id="upassDiv"><label>密&nbsp;&nbsp;码&nbsp;&nbsp;&nbsp;</label><input id="suPass" name="suPass" type="password"></div> <br/>
    	<div id="ubuttonDiv"> 
    	<button type="button" id="loginBt">登录</button>
    	<button type="button" id="resetBt">重写</button></div>

    </div>
	</div>
	
	<script src="${basePath}js/lib/jquery.min.js"></script>
    <script src="${basePath}js/lib/md5.js"></script>
    <script src="${basePath}js/project/common.js"></script>
	<script src="${basePath}js/project/sysUserLogin.js"></script>
	
  </body>
</html>
