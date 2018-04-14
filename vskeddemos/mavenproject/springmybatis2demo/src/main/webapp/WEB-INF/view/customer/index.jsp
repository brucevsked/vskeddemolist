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
    
    <title>客服导航</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="content-type" content="text/html;charset=UTF-8">
    <jsp:include page="../include/css.jsp"></jsp:include>
  </head>
  
  <body>
  <a href="${basePath }index.jsp">首页</a>
  导航菜单:<br/><br/>
<div>
<a href="${basePath }proc/c1proc.jsp">售前咨询</a><br/><br/>
</div>
<div>
<a href="${basePath }">售后咨询</a><br/><br/>
</div>
<div>
<a href="${basePath }">品牌咨询</a><br/><br/>
</div>
      <jsp:include page="../include/js.jsp"></jsp:include>
  </body>
</html>