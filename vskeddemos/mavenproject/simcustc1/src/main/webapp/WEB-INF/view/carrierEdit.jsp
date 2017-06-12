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
    
    <title>运营商信息修改</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
  </head>
  
  <body>
	<div class="easyui-panel" title="运营商信息修改">
		<form id="fm" method="post" action="${basePath }carrierEditProc">
        <input type="hidden" name="carrierId" id="carrierId" value="${data.CARRIERID }" />
		<br/>
			<div style="margin-bottom:20px;margin-left:2%">
     <input class="easyui-textbox" type="text" name="carrierName" id="carrierName" value="${data.CARRIERNAME }" label="运营商名:" data-options="required:true,missingMessage:'请输入运营商名'" style="width:30%" />
			</div>
			<div style="margin-bottom:20px;margin-left:2%">
     <input class="easyui-textbox" type="text" name="carrierNick" id="carrierNick" value="${data.CARRIERNICK }" label="别名:" style="width:30%" />
			</div>
			<div style="margin-bottom:20px;margin-left:2%">
     <input class="easyui-textbox" type="text" name="carrierShortName" id="carrierShortName" value="${data.CARRIERSHORTNAME }" label="简称:" style="width:30%" />
			</div>
			<div style="margin-bottom:20px;margin-left:2%">
     <input class="easyui-textbox" type="text" name="officialWebSite" id="officialWebSite" value="${data.OFFICIALWEBSITE }" label="官网:" style="width:30%" />
			</div>
			<div style="margin-bottom:20px;margin-left:2%">
     <input class="easyui-textbox" type="text" name="hotline" id="hotline" value="${data.HOTLINE }" label="客服热线:"  style="width:30%" />
			</div>
<div style="margin-bottom:20px;margin-left:15%">
    <button type="button" class="easyui-linkbutton" onclick="submitForm();" id="editBt">修改</button> 
    <button type="reset" class="easyui-linkbutton">重写</button> 
</div>
		</form>
	</div>
	
  <script type="text/javascript" charset="UTF-8" src="${basePath }static/js/project/carrierEdit.js"></script>
  
  </body>
</html>