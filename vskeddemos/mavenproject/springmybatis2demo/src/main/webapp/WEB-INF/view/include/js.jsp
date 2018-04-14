<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
request.setAttribute("basePath", basePath);
out.clear();
%>

<script src="${basePath}js/lib/jquery.min.js"></script>
<script src="${basePath}js/project/common.js"></script>
<script src="https://res.wx.qq.com/open/js/jweixin-1.2.2.js"></script>
