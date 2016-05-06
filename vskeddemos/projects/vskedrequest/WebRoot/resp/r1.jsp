<%@page import="com.vsked.response.MyResponse"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
out.clear();
out.write(MyResponse.postResponse(request));
%>
