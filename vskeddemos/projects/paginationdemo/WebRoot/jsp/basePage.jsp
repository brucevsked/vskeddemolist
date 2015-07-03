<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <table>
  <tr><td colspan="9">列表</td></tr>
  <tr>
      <td>testIds</td>
      <td>testNumberA</td>
      <td>testVarchar</td>
      <td>testVarchar2</td>
      <td>testNVarchar2</td>
      <td>testDate</td>
      <td>testTimeStamp</td>
      <td>testChar</td>
      <td>testNChar</td>
  </tr>
  <c:forEach items="${p.dataList==null?'':p.dataList}" var="tbDt" varStatus="status">
 <c:if test="${tbDt!=null}">
 <tr>
      <td>${tbDt.TESTIDS}</td>
      <td>${tbDt.TESTNUMBERA}</td>
      <td>${tbDt.TESTVARCHAR}</td>
      <td>${tbDt.TESTVARCHAR2}</td>
      <td>${tbDt.TESTNVARCHAR2}</td>
      <td>${tbDt.TESTDATE}</td>
      <td>${tbDt.TESTTIMESTAMP}</td>
      <td>${tbDt.TESTCHAR}</td>
      <td>${tbDt.TESTNCHAR}</td>
 </tr>
 </c:if>
 </c:forEach>
 </table>
 
 <script type="text/javascript" src="<%=basePath%>js/pageUtil.js" charset="utf-8"></script>
<form action="<%=basePath%>jsp/toBasePage.jsp" name="fmhd" id="fmhd" method="post" >
<a href="javascript:dosubmit(1)">首页</a>&nbsp;
 <c:if test="${p.currentPage>1}"><a href="javascript:dosubmit(${p.currentPage-1})">上一页</a>&nbsp;</c:if>
 <c:if test="${p.currentPage<p.numCount}"><a href="javascript:dosubmit(${p.currentPage+1})">下一页</a>&nbsp;</c:if>
 <a href="javascript:dosubmit(${p.numCount })">尾页</a>&nbsp;
 第${p.currentPage }页&nbsp;共${p.numCount }页&nbsp;
 <input type="hidden" id="currentPage" name="currentPage" value="${p.currentPage }">
 </form>
  </body>
</html>
