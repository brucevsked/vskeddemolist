<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
request.setAttribute("basePath", basePath);
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="${basePath }">
    
    <title> </title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">

    <link rel="stylesheet" type="text/css" href="${basePath }css/lib/jqueryui/jquery-ui.min.css">
   
    <link rel="stylesheet" type="text/css" href="${basePath }css/lib/jqgrid/ui.jqgrid.css">
  </head>
  
  <body>
  
  <script type="text/javascript" charset="UTF-8" src="${basePath }js/lib/jquery.js" ></script>
  <script type="text/javascript" charset="UTF-8" src="${basePath }js/lib/jqgrid/i18n/grid.locale-cn.js" ></script>
  <script type="text/javascript" charset="UTF-8" src="${basePath }js/lib/jqgrid/jquery.jqGrid.min.js" ></script>
  <script type="text/javascript" charset="UTF-8" src="${basePath }js/project/demo1.js" ></script>
  </body>
</html>
