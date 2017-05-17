<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
request.setAttribute("basePath", basePath);
%>
<!DOCTYPE html>
<html>
<head>
    <base href="${basePath }">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <link rel="stylesheet" href="${basePath }static/js/lib/jquery-easyui/themes/default/easyui.css"/>
    <link rel="stylesheet" href="${basePath }static/js/lib/jquery-easyui/themes/icon.css"/>
    <link rel="stylesheet" href="${basePath }static/js/lib/toastr/toastr.min.css"/>
    <link rel="stylesheet" href="${basePath }static/css/global.css"/>

</head>
<body>
    <div id="cc" class="easyui-layout" style="width:100%;height:100%;">
        <div data-options="region:'north',title:'[${user.SUNAME }]的菜单,用户别名为[${user.SUNICK }]',split:true" style="height:65px;" id="menuDiv" >
        <!-- menu start -->

         <!-- menu end -->
        </div>
        <div data-options="region:'center'" id="mainDiv"></div>
    </div>

  <script type="text/javascript" charset="UTF-8" src="${basePath }static/js/jquery.min.js"></script>
  <script type="text/javascript" charset="UTF-8" src="${basePath }static/js/lib/jquery-easyui/jquery.easyui.min.js"></script>
  <script type="text/javascript" charset="UTF-8" src="${basePath }static/js/lib/toastr/toastr.min.js"></script>
  <script type="text/javascript" charset="UTF-8" src="${basePath }static/js/project/index.js"></script>
</body>
</html>