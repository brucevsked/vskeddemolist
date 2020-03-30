<%@page import="com.vsked.util.BasicServlet"%>
<%@page import="com.vsked.util.Page"%>
<%@page import="com.vsked.util.ConnectOracle"%>
<%@page import="com.vsked.service.BasicDaoImpl"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String inTbName="testTableInfo";
BasicDaoImpl bd=new BasicDaoImpl();
bd.setConn(TestConnectOracle.getConnection());
Map<String, String> m=BasicServlet.getMapInParameter(request);
Page p=BasicServlet.getPage(request);

request.setAttribute("param", m);
request.setAttribute("p", bd.getList(inTbName, p, m));

String fpage="basePage.jsp";
%>
<jsp:forward page="<%=fpage %>" />