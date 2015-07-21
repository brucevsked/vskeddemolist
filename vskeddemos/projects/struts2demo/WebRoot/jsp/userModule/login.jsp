<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("basePath", basePath);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="${basePath }">
    
    <title>userModule/login</title>
    
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
  <s:form action="userModule/userLogin" >
  <!--  
  <s:textfield name="dataMap['userName']" key="userName" />
  <s:textfield name="dataMap['userPass']" key="userPass" />
  -->
  <s:textfield name="u.userName" label="userName" />
  <s:textfield name="u.userPass" key="userPass" />
  
  <s:hidden name="log.logId" value="88"/>
  <s:hidden name="log.logName" value="this is another object" />
  <s:hidden name="avInput" value="here you are" />
  <s:submit value="let's go" />
  </s:form>
  </body>
</html>
