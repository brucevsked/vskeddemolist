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
  <form id="myFm" action="${basePath }proc/ajaxFileUploadProc.jsp">
  用户名<input id="uname" name="uname"><br>
  头像<input type="file" id="profilePic" name="profilePic"><br>
  <button type="button" onclick="uploadFile('${basePath }proc/ajaxFileUploadProc.jsp')">提交</button>
  </form>
  <div id="resultA1"></div>
	<script type="text/javascript" charset="UTF-8" src="${basePath }js/jquery.min.js"></script>
	<script type="text/javascript" charset="UTF-8" src="${basePath }js/jquery.form.js"></script>
    <script type="text/javascript" charset="UTF-8" src="${basePath }js/ajaxFileUpload.js"></script>
  </body>
</html>
