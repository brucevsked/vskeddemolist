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
    
    <title>菜单信息修改</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
  </head>
  
  <body>
	<div class="easyui-panel" title="菜单信息修改">
		<form id="fm" method="post" action="${basePath }menuEditProc">
        <input type="hidden" name="smId" id="smId" value="${data.SMID }" />
        <input type="hidden" name="paremtSmIdOld" id="paremtSmIdOld" value="${data.PARENTSMID }" />
		<br/>
<div style="margin-bottom:20px;margin-left:2%">
     <input class="easyui-textbox" type="text" name="smName" id="smName" value="${data.SMNAME }" label="菜单名称:" data-options="required:true,missingMessage:'请输入菜单名称'" style="width:30%" />
</div>
<div style="margin-bottom:20px;margin-left:2%">
     <input type="text" name="parentSmId" id="parentSmId" label="上级菜单:"  style="width:30%" />
</div>
<div style="margin-bottom:20px;margin-left:2%">
     <input class="easyui-textbox" type="text" name="smHref" id="smHref" value="${data.SMHREF }"  label="链接:"  style="width:30%" />
</div>
<div style="margin-bottom:20px;margin-left:2%">
     <input class="easyui-textbox" type="text" name="smClick" id="smClick" value="${data.SMCLICK }"  label="单击:"  style="width:30%" />
</div>
<div style="margin-bottom:20px;margin-left:2%">
     <input class="easyui-textbox" type="text" name="smClass" id="smClass" value="${data.SMCLASS }"  label="样式:"  style="width:30%" />
</div>
<div style="margin-bottom:20px;margin-left:2%">
     <input class="easyui-textbox" type="text" name="smDataOptions" id="smDataOptions" value="${data.SMDATAOPTIONS }"  label="扩展:"  style="width:30%" />
</div>
<div style="margin-bottom:20px;margin-left:15%">
    <button type="button" class="easyui-linkbutton" onclick="submitForm();" id="editBt">修改</button> 
    <button type="reset" class="easyui-linkbutton">重写</button> 
</div>
		</form>
	</div>
	
  <script type="text/javascript" charset="UTF-8" src="${basePath }static/js/project/menuEdit.js"></script>
  
  </body>
</html>