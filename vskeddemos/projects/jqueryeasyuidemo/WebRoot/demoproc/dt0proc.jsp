<%@page import="com.vsked.test.EasyUIGridData"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<% 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
request.setAttribute("basePath", basePath);

out.clear();
out.write(EasyUIGridData.getData(request));
%>
