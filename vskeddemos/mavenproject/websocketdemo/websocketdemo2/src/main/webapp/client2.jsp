<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
request.setAttribute("basePath", basePath);
%>

<!DOCTYPE html>
<html>
<head>
    <base href="${basePath }">
<title>Testing websockets</title>
</head>
<body>
<div>this is client 2</div>
  <span>
  client1<input type="radio" checked> <br> 
  client2<input type="radio"> <br> 
  </span>
  <span>to</span>
  <span>
  client1<input type="radio"> <br> 
  client2<input type="radio" checked> <br> 
  </span>
  <div>
    <input type="submit" value="Start" onclick="start()" />
  </div>
  <div id="messages"></div>
    <script type="text/javascript" charset="UTF-8" src="${basePath }js/index.js" ></script>
</body>
</html>
