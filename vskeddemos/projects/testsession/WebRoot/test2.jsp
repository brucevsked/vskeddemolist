<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
request.setAttribute("basePath", basePath);

System.out.println("Hello,Apache and Tomcat!!!!!!!!====="+request.getSession().getAttribute("myName"));

%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="${basePath }">
    
    <title>DreamWork</title>
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
Server Info:

<%

out.println(request.getLocalAddr() + " : " + request.getLocalPort()+"<br>");%>

<%

  out.println("<br> ID " + session.getId()+"<br>");

  // 如果有新的 Session 属性设置

  String dataName = request.getParameter("dataName");

  if (dataName != null && dataName.length() > 0) {

     String dataValue = request.getParameter("dataValue");

     session.setAttribute(dataName, dataValue);

  }

  out.println("<b>Session 列表</b><br>");

  System.out.println("============================");

  Enumeration e = session.getAttributeNames();

  while (e.hasMoreElements()) {

     String name = (String)e.nextElement();

     String value = session.getAttribute(name).toString();

     out.println( name + " = " + value+"<br>");

         System.out.println( name + " = " + value);

   }

%>

  <form action="test2.jsp" method="POST">

    名称:<input type=text size=20 name="dataName">

     <br>

    值:<input type=text size=20 name="dataValue">

     <br>

    <input type=submit>

   </form>

  </body>
</html>
