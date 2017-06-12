<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
request.setAttribute("basePath", basePath);
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="${basePath }">
    
    <title>功能添加</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
  </head>
  
  <body>
	<div class="easyui-panel" title="功能添加">
		<form id="fm" method="post" action="${basePath }functionAddProc">
		<br/>
<div style="margin-bottom:20px;margin-left:2%">
     <input class="easyui-textbox" type="text" name="sfValue" id="sfValue" label="功能地址:" data-options="required:true,missingMessage:'请输入功能地址'" style="width:30%" />
</div>
<div style="margin-bottom:20px;margin-left:2%">
     <input type="text" name="spId" id="spId" label="功能中文名:" style="width:30%"  />
</div>
<div style="margin-bottom:20px;margin-left:2%">
<label for="sfType1">拦截类型:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
<input type="radio" id="sfType1" name="sfType" value="anon" >不拦截 &nbsp;&nbsp;
<input type="radio" id="sfType2" name="sfType" value="cusperm" checked="checked" >按角色拦截
</div>
<div style="margin-bottom:20px;margin-left:15%">
    <button type="button" class="easyui-linkbutton" onclick="submitForm();" id="addBt">增加</button> 
    <button type="reset" class="easyui-linkbutton">重写</button> 
</div>
		</form>
	</div>
	
  <script type="text/javascript" charset="UTF-8" src="${basePath }static/js/project/functionAdd.js"></script>
  
  </body>
</html>
