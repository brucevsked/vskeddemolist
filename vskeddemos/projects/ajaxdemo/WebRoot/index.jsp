<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<% 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
request.setAttribute("basePath", basePath);
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="${basePath }">
    
    <title>hyfd</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" charset="UTF-8" src="${basePath }js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" charset="UTF-8" src="${basePath }js/testAjax.js"></script>
  </head>
  
  <body>
  <textarea rows="5" cols="100" id='sMobile'></textarea>
<br><br>
<button onclick="testPost0('${basePath }')">testPost0</button> 
<button onclick="testPost1('${basePath }')">testPost1</button> 
<button onclick="testPost2('${basePath }')">testPost2</button> 
<button onclick="testPost3('${basePath }')">testPost3</button> 
<button onclick="testPost4('${basePath }')">testPost4</button> 
<br><br>
<textarea rows="5" cols="100" id='tDecode'></textarea>
  </body>
</html>
