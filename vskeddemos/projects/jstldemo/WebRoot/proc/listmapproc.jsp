<%@page import="com.vsked.test.TestData"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
request.setAttribute("basePath", basePath);
TestData.listMapData(request);
request.getRequestDispatcher("/view/listmap.jsp").forward(request, response);
%>

