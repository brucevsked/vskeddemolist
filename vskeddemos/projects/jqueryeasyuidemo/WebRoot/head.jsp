<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
request.setAttribute("basePath", basePath);
%>
    <link rel="stylesheet" href="${basePath }js/lib/jqueryeasyui/themes/default/easyui.css"/>
    <link rel="stylesheet" href="${basePath }js/lib/jqueryeasyui/themes/icon.css"/>
    
    <script src="${basePath }js/lib/jquery.min.js"></script>
    <script src="${basePath }js/lib/jqueryeasyui/jquery.easyui.min.js"></script>
 