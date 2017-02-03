<%@page import="com.vsked.service.UserSer"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
response.sendRedirect(new UserSer().login(request));
%>
