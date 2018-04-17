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
  <a href="${basePath }views/ajaxFileUpload.jsp">ajaxfileupload</a><br>
  <a href="${basePath }views/checkboxTest.jsp">checkboxTest</a><br>
  <textarea rows="5" cols="100" id='sMobile'></textarea>
<br><br>
<button onclick="testGet0();" type="button">testGet0</button> 
<button onclick="testGet1();" type="button">testGet1</button> 
<button onclick="testGet2();" type="button">testGet2</button> 
<button onclick="testPost0('${basePath }')" type="button">testPost0</button> 
<button onclick="testPost1('${basePath }')" type="button">testPost1</button> 
<button onclick="testPost2('${basePath }')" type="button">testPost2</button> 
<button onclick="testPost3('${basePath }')" type="button">testPost3</button> 
<button onclick="testPost4('${basePath }')" type="button">testPost4</button> 
<br><br>
<textarea rows="5" cols="100" id='tDecode'></textarea>

	<script type="text/javascript" charset="UTF-8" src="${basePath }js/jquery.min.js"></script>
    <script type="text/javascript" charset="UTF-8" src="${basePath }js/testAjax.js"></script>
  </body>
</html>
