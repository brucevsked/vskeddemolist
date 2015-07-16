<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
request.setAttribute("basePath", basePath);
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="${basePath }">
    
    <title>coreTagsDemo</title>
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
    
    c:out || <c:out value="${'this is output content'}"/> <br/>
     
    c:set || <c:set var="userAge" scope="session" value="${10*2+8}"/> <c:out value="${userAge}"/> <br/>
     
    c:remove || <c:set var="userHeight" scope="session" value="${1.78}"/>
    Before Remove Value: <c:out value="${userHeight}"/> 
    <c:remove var="userHeight"/> 
    After Remove Value: <c:out value="${userHeight}"/><br/>
     
    c:if || <c:set var="girlCount" scope="session" value="${18}"/>
    <c:if test="${girlCount > 10}">
    My girlFriends is: <c:out value="${girlCount}"/>
    </c:if>  <br/>
     
    c:choose || <c:set var="userWife" scope="session" value="${10}"/>
    userWife is : <c:out value="${userWife}"/>
    <c:choose>
      <c:when test="${userWife <= 0}"> alone so ?</c:when>
       <c:when test="${userWife <= 10}">  life is well . </c:when>
       <c:otherwise>  kidding me </c:otherwise>
    </c:choose>  <br/>
    
    c:forEach || <c:forEach var="i" begin="1" end="5">  Item <c:out value="${i}"/> </c:forEach>  <br/>
    
    c:forTokens || <c:forTokens items="b21,b31,b41,b46,b51" delims="," var="weapon"> <c:out value="${weapon}"/> </c:forTokens> <br/>
    
    c:import || 

    <c:url value="index.jsp" var="myURL">
      <c:param name="userName" value="bruce"/>
      <c:param name="userPass" value="hello123456"/>
    </c:url>
    <c:import url="${myURL}"/>

     
  </body>
</html>
