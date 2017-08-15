<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<% 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
request.setAttribute("basePath", basePath);
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="${basePath }">
    
    <title>vsked</title>

  </head>
  
  <body>
  <form id="myFm" action="${basePath }proc/checkboxTestProc.jsp">
  <input type="text" name="lost" value="xway"><br>
  <input type="checkbox" name="hobby" value="1">足球<br>
  <input type="checkbox" name="hobby" value="2">游泳<br>
  <input type="checkbox" name="hobby" value="3">跑步<br>
  <input type="checkbox" name="hobby" value="4">看书<br>
  <input type="checkbox" name="hobby" value="5">手游<br>
  <button type="submit" >提交</button>
  </form>

    <script type="text/javascript" charset="UTF-8" src="${basePath }js/checkboxTest.js"></script>
  </body>
</html>
