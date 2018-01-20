<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="${pageContext.request.scheme }://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/">
    
    <title>index</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    template1.jsp <br>这儿写完base标签以后其他可以直接写相对根目录
    ${pageContext.request.scheme }://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/ <br>
    <button onclick="ts();">getBasePath</button>
    
	<script type="text/javascript" charset="UTF-8" src="${basePath }js/project/baseSet.js" ></script>
  </body>
</html>
