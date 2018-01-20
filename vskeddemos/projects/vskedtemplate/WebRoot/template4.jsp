<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="basePath" value="${pageContext.request.scheme }://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/" scope="request"/>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="${basePath }">
    
    <title>index</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
  </head>
  
  <body>
  template4.jsp <br>
  ${basePath } <br>
  <button onclick="ts();">getBasePath</button>
  <script type="text/javascript" charset="UTF-8" src="${basePath }js/project/baseSet.js" ></script>
  </body>
</html>
