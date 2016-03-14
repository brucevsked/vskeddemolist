<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
request.setAttribute("basePath", basePath);
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="${basePath }">
    
    <title>index</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="">
	<meta http-equiv="description" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
  </head>
  
  <body>
    <form name="myform" action="${basePath }demoproc/demo2proc.jsp" method="post" enctype="multipart/form-data" >
       username: <input type="text" name="uname" ><br>
       userpass: <input type="text" name="upass" ><br>
       userage:  <input type="text" name="uage" ><br>
       userfile1: <input type="file" name="ufile1"><br>
       userfile2: <input type="file" name="ufile2"><br>
       userfile3: <input type="file" name="ufile3"><br>
       <button type="submit">upload</button>
    </form>
  </body>
</html>
