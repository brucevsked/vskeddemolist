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
    <form name="myform" action="${basePath }demoproc/demo1proc.jsp" method="post" enctype="multipart/form-data" >
       username: <input type="text" name="uname1" ><br>
       username: <input type="text" name="uname2" ><br>
       userfile: <input type="file" name="ufile1"><br>
       userfile: <input type="file" name="ufile2"><br>
       <button type="submit">upload</button>
    </form>
</body>
</html>