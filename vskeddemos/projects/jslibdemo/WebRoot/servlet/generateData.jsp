<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.vsked.util.BasicServlet"%>
<%@page import="com.vsked.data.GenerateDGridData"%>
<%@page import="com.vsked.data.GenerateEasyUIData"%>
<%@page import="com.vsked.data.GenerateGridXData"%>
<%@page import="com.vsked.data.GenerateDataGridData"%>
<%
out.clear();
if("1".equals(request.getParameter("d"))) GenerateDGridData.getInstance().proc(request, response, out);
if("2".equals(request.getParameter("d"))) GenerateEasyUIData.getInstance().proc(request, response, out);
if("3".equals(request.getParameter("d"))) GenerateDataGridData.getInstance().proc(request, response, out);
if("4".equals(request.getParameter("d"))) GenerateGridXData.getInstance().proc(request, response, out);

%>

