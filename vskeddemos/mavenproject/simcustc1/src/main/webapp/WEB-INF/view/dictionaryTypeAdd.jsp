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
    
    <title>字典类型添加</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
  </head>
  
  <body>
	<div class="easyui-panel" title="字典类型添加">
		<form id="fm" method="post" action="${basePath }dictionaryTypeAddProc">
		<br/>
<div style="margin-bottom:20px;margin-left:2%">
     <input class="easyui-textbox" type="text" name="sdtName" id="sdtName" label="字典类型名:" data-options="required:true,missingMessage:'请输入字典类型名'" style="width:30%" />
</div>
<div style="margin-bottom:20px;margin-left:15%">
    <button type="button" class="easyui-linkbutton" onclick="submitForm();" id="addBt">增加</button> 
    <button type="reset" class="easyui-linkbutton">重写</button> 
</div>
		</form>
	</div>
	
  <script type="text/javascript" charset="UTF-8" src="${basePath }static/js/project/dictionaryTypeAdd.js"></script>
  
  </body>
</html>
