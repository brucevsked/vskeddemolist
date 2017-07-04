<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
request.setAttribute("basePath", basePath);
%>

<!DOCTYPE html>
<html>
<head>
    <base href="${basePath }">
<title>Testing websockets</title>
    <link rel="stylesheet" href="${basePath }css/client.css"/>
</head>
<body>
<div>this is client 1</div>
<table>
<tr><td>发送方</td><td>接收方</td></tr>
<tr>
<td>
client1<input type="radio" name="sourceClient" checked> <br> 
client2<input type="radio" name="sourceClient" > <br> </td>
<td>
client1<input type="radio" name="targetClient"  > <br> 
client2<input type="radio" name="targetClient" checked > <br>
</td>
</tr>
<tr>
<td colspan="2">
<textarea id="myMsg" cols="180"></textarea>
</td>
</tr>
<tr>
<td colspan="2">
<button type="button" id="sendMsgBt">send</button>
</td>
</tr>
</table>
  <div id="messages"></div>
    <script type="text/javascript" charset="UTF-8" src="${basePath }js/lib/jquery.js" ></script>
    <script type="text/javascript" charset="UTF-8" src="${basePath }js/client1.js" ></script>
</body>
</html>
