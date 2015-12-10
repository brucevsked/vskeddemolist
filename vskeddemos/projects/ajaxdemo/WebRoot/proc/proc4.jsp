<%@page import="com.vsked.controller.BaseController"%>
<%@page import="com.vsked.util.LogUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

LogUtil.outPutBasicMap(BaseController.getMaps(request));

out.clear();
out.write("fff3this is proced data for you?,.{}-=!@#$%^&*()/\\");

%>