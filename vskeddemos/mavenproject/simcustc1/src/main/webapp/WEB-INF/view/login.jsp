<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
request.setAttribute("basePath", basePath);
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="${basePath }">
    
    <title>欢迎到来</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
    <link rel="stylesheet" href="${basePath }static/js/lib/jquery-easyui/themes/default/easyui.css"/>
    <link rel="stylesheet" href="${basePath }static/js/lib/jquery-easyui/themes/icon.css"/>

  </head>
  
  <body>   
  
<div id="loginWin" class="easyui-window" title="欢迎您使用" style="width:350px;height:188px;padding:5px;"
   minimizable="false" maximizable="false" resizable="false" collapsible="false" closable="false" > 
    <div class="easyui-layout" fit="true">
       <div region="center" border="false" style="padding:5px;background:#fff;border:1px solid #ccc;">
        <form id="loginForm" method="post" action="${basePath }login" >
            <div style="padding:5px 0;">
                <label for="login">帐号:</label>
                <input type="text" id="suName" name="suName" value="admin" style="width:260px;" class="easyui-validatebox"  />
            </div>
            <div style="padding:5px 0;">
                <label for="password">密码:</label>
                <input type="text" id="suPass" name="suPass" value="000000" style="width:260px;" class="easyui-validatebox"  />
            </div>
             <div style="padding:5px 0;text-align: center;color: red;" id="showMsg"> 
             <c:if test="${!empty backMsg}"> <c:out value="${backMsg}"/>  </c:if></div>
            <div region="south" border="false" style="text-align:right;padding:5px 0;">
                <input type="button" value="登录" onclick="toLogin()" />
                <input type="reset"  value="重置" />
            </div>
          </form>
        </div>
    </div>
</div>

  <script type="text/javascript" charset="UTF-8" src="${basePath }static/js/jquery.min.js"></script>
  <script type="text/javascript" charset="UTF-8" src="${basePath }static/js/lib/jquery-easyui/jquery.easyui.min.js"></script>

  <script type="text/javascript" charset="UTF-8" src="${basePath }static/js/project/login.js" ></script>
    
  </body>
</html>