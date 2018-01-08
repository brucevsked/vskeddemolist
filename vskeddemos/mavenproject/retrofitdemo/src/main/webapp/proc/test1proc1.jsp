<%@page import="com.vsked.service.Test1Service"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
out.clear();
out.write(Test1Service.proc1(request));
%>
