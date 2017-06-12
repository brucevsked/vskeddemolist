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
    
    <title>菜单添加</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
  </head>
  
  <body>
	<div class="easyui-panel" title="菜单添加">
		<form id="fm" method="post" action="${basePath }menuAddProc">
		<br/>
<div style="margin-bottom:20px;margin-left:2%">
     <input class="easyui-textbox" type="text" name="smName" id="smName" label="菜单名称:" data-options="required:true,missingMessage:'请输入菜单名称'" style="width:30%" />
</div>
<div style="margin-bottom:20px;margin-left:2%">
     <input type="text" name="parentSmId" id="parentSmId" label="上级菜单:"  style="width:30%" />
</div>
<div style="margin-bottom:20px;margin-left:2%">
     <input class="easyui-textbox" type="text" name="smHref" id="smHref" label="链接:"  style="width:30%" />
</div>
<div style="margin-bottom:20px;margin-left:2%">
     <input class="easyui-textbox" type="text" name="smClick" id="smClick" label="单击:"  style="width:30%" />
</div>
<div style="margin-bottom:20px;margin-left:2%">
     <input class="easyui-textbox" type="text" name="smClass" id="smClass" label="样式:"  style="width:30%" />
</div>
<div style="margin-bottom:20px;margin-left:2%">
     <input class="easyui-textbox" type="text" name="smDataOptions" id="smDataOptions" label="扩展:"  style="width:30%" />
</div>
<div style="margin-bottom:20px;margin-left:15%">
    <button type="button" class="easyui-linkbutton" onclick="submitForm();" id="addBt">增加</button> 
    <button type="reset" class="easyui-linkbutton">重写</button> 
</div>
		</form>
	</div>
	
  <script type="text/javascript" charset="UTF-8" src="${basePath }static/js/project/menuAdd.js"></script>
  
  </body>
</html>
