<%@page import="com.vsked.highstock.GenerateJson"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";

GenerateJson.getInstance(out,request);

%>