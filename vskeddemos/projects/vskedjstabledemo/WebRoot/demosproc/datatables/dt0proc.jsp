<%@page import="com.vsked.test.DataTables"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<% 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
request.setAttribute("basePath", basePath);

out.clear();
out.write(DataTables.getData(request));
%>
