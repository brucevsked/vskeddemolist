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
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    
    <link rel="stylesheet" type="text/css" href="${basePath }js/lib/DataTables/media/css/dataTables.jqueryui.min.css">
    <link rel="stylesheet" type="text/css" href="${basePath }js/lib/DataTables/extensions/Buttons/css/buttons.dataTables.min.css">
    <script type="text/javascript" charset="UTF-8" src="${basePath }js/lib/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" charset="UTF-8" src="${basePath }js/lib/DataTables/media/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" charset="UTF-8" src="${basePath }js/lib/DataTables/extensions/Buttons/js/dataTables.buttons.min.js"></script>
    <script type="text/javascript" charset="UTF-8" src="${basePath }js/lib/DataTables/extensions/Buttons/js/buttons.colVis.min.js"></script>
    <script type="text/javascript" charset="UTF-8" src="${basePath }js/lib/DataTables/extensions/Buttons/js/buttons.flash.min.js"></script>
    <script type="text/javascript" charset="UTF-8" src="${basePath }js/lib/DataTables/extensions/jszip.min.js"></script>
    <script type="text/javascript" charset="UTF-8" src="${basePath }js/project/dt0.js"></script>
  </head>
  
  <body>
  ${basePath }
  
  <table id="dt0" class="display" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th>id</th>
                <th>First name</th>
                <th>Last name</th>
                <th>Position</th>
                <th>Office</th>
                <th>Start date</th>
                <th>Salary</th>
                <th>operate</th>
            </tr>
        </thead>
    </table>
  </body>
</html>