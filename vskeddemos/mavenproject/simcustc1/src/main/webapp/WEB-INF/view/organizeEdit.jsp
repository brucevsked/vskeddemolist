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
    
    <title>组织信息修改</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
  </head>
  
  <body>
	<div class="easyui-panel" title="组织信息修改">
		<form id="fm" method="post" action="${basePath }organizeEditProc">
        <input type="hidden" name="soId" id="soId" value="${data.SOID }" />
        <input type="hidden" name="paremtSoIdOld" id="paremtSoIdOld" value="${data.PARENTSOID }" />
		<br/>
<div style="margin-bottom:20px;margin-left:2%">
     <input class="easyui-textbox" type="text" name="soName" id="soName" value="${data.SONAME }" label="组织名称:" data-options="required:true,missingMessage:'请输入组织名称'" style="width:30%" />
</div>
<div style="margin-bottom:20px;margin-left:2%">
     <input type="text" name="parentSoId" id="parentSoId" label="上级组织:"  style="width:30%" />
      <button type="button" class="easyui-linkbutton" onclick="emptyParentSoId();" >置空</button>
</div>
<div style="margin-bottom:20px;margin-left:2%">
     <input class="easyui-textbox" type="text" name="soCode" id="soCode" value="${data.SOCODE }"  label="代码:"  style="width:30%" />
</div>
<div style="margin-bottom:20px;margin-left:2%">
     <input class="easyui-textbox" type="text" name="soSort" id="soSort" value="${data.SOSORT }"  label="排序:"  style="width:30%" />
</div>
<div style="margin-bottom:20px;margin-left:15%">
    <button type="button" class="easyui-linkbutton" onclick="submitForm();" id="editBt">修改</button> 
    <button type="reset" class="easyui-linkbutton">重写</button> 
</div>
		</form>
	</div>
	
  <script type="text/javascript" charset="UTF-8" src="${basePath }static/js/project/organizeEdit.js"></script>
  
  </body>
</html>