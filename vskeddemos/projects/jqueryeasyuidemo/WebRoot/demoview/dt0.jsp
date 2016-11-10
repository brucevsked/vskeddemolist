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
    
    <title>dt0</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	 <c:import url="../head.jsp" />
  </head>
  
  <body>
  <table id="mytb" cellspacing="0" cellpadding="0"> 
    <thead> 
        <tr> 
            <th field="a1">a11</th> 
            <th field="a2" >a22</th> 
            <th field="a3" >a33</th> 
            <th field="a4" >a44</th>
         </tr>
    </thead> 
</table> 

  <script type="text/javascript" charset="UTF-8" src="${basePath }js/project/dt0.js"></script>
  </body>
</html>
