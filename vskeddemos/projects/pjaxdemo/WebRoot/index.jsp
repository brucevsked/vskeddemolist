<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="<%=basePath%>js/lib/jquery/jquery-1.11.3.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="<%=basePath%>js/lib/jquery/jquery.pjax.js" type="text/javascript" charset="utf-8"></script>
  </head>
  
  <body>
    hello this is a pjax test  <br><br><br>
    <div id="tsDva1"> this is aaa you can click here</div>
    <div id="tsDva2"> <a href='javascript:void(0);' id="tsLk1">this is bbb</a> </div>
    <div id="tsDva3"> <button id="tsPjBt">here is new</button></div>
    <script type="text/javascript">
    $(document).ready(function(){
    	$("#tsDva1").click(function(){
    		$.pjax({
    			  url: '<%=basePath%>a2.jsp',
    			  container: '#tsDva1'
    			})
    	});
    	$("#tsLk1").click(function(){
    		$.pjax({
    			  url: '<%=basePath%>a3.jsp',
    			  container: '#tsDva2'
    			})
    	});
    	$("#tsPjBt").click(function(){
    		$.pjax({
    			  url: '<%=basePath%>a4.jsp',
    			  container: '#tsDva3'
    			})
    	});
    	
    });
    
    </script>
  </body>
</html>
