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
  |<a href="${basePath }index">index</a>|this is project|<a href="${basePath }hello">hello</a><br>
  <div id="myResult"></div>
  <button type="button" onclick="getUserList()">userList</button>
  <script type="text/javascript" src="${basePath }js/lib/jquery.js"></script>
  <script type="text/javascript" src="${basePath }js/project/index.js"></script>
  </body>
</html>

