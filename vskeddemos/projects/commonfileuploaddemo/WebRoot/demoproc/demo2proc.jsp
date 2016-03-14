<%@page import="com.vsked.util.FilePathUtil"%>
<%@page import="com.vsked.util.BaseService"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
BaseService bs=new BaseService();
bs.uploadFile(request, FilePathUtil.uploadFileSavePath);
request.getRequestDispatcher("/demo/demo2.jsp").forward(request, response);
%>