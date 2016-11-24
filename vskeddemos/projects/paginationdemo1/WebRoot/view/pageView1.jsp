<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
request.setAttribute("basePath", basePath);
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="${basePath }">

<title>index</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
</head>

<body>
	<form action="${basePath }proc/pageProc1.jsp" name="fm" id="fm" method="post">
	
	<table border="1" id="myTb">
	<tr> <td colspan="9" >用户列表</td></tr>
    <tr>
      <th>编号</th>
      <th>用户ID</th>
      <th>用户名</th>
      <th>密码</th>
      <th>类型</th>
      <th>手机</th>
      <th>别名</th>
      <th>qq</th>
      <th>邮箱</th>
  </tr>
  <c:forEach items="${p.dataList==null?'':p.dataList}" var="u" varStatus="status">
      <tr>
      <td>${(p.currentPage-1)*p.pageSize+status.count}</td>
      <td>${u.suId }</td>
      <td>${u.suName }</td>
      <td>${u.suPass }</td>
      <td>${u.suCredits }</td>
      <td>${u.suMobile }</td>
      <td>${u.suNick }</td>
      <td>${u.suQq }</td>
      <td>${u.suEmail }</td>
      </tr>
  </c:forEach>
  </table>
 <a href="javascript:void(0);" onclick="dosubmit('fm','1')" >首页</a>
 <c:if test="${p.currentPage>1}"><a href="javascript:void(0);" onclick="dosubmit('fm','${p.currentPage-1}')" >上一页</a></c:if>
    第<input type="text" id="currentPage" name="currentPage" value="${p.currentPage }" size="1">页
 <c:if test="${p.currentPage<p.numCount}"><a href="javascript:void(0);" onclick="dosubmit('fm','${p.currentPage+1}')">下一页</a>	</c:if>
 <a href="javascript:void(0);" onclick="dosubmit('fm','${p.numCount}')" >尾页</a>
 
    共${p.numCount }页&nbsp;
 
 每页显示
 <select id="pageSize" name="pageSize">
 <option value="5"  ${p.pageSize==5? "selected ":"" } >5</option>
 <option value="10" ${p.pageSize==10? "selected ":"" } >10</option>
 <option value="15" ${p.pageSize==15? "selected ":"" } >15</option>
 <option value="20" ${p.pageSize==20? "selected ":"" } >20</option>
 <option value="25" ${p.pageSize==25? "selected ":"" } >25</option>
 <option value="30" ${p.pageSize==30? "selected ":"" } >30</option>
 </select>条
 </form>

<script type="text/javascript" charset="UTF-8" src="${basePath }js/project/myOldPage.js"></script>

</body>
</html>
