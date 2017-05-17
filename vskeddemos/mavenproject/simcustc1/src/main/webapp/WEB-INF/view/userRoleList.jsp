<%@ page language="java" pageEncoding="UTF-8" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
request.setAttribute("basePath", basePath);
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="${basePath }">
    
    <title>用户角色分配</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
  </head>
  
  <body>
  <div id="userRoleDiv" title="为用户[${data.SUNICK }]分配角色" class="easyui-panel" style="width:100%;height:100%;">
<form id="fm" method="post" action="${basePath }userRoleProc">
<input type="hidden" id="suId" name="suId" value="${data.SUID }">
<table style="width:100%;height:85%;" border="0.5" cellspacing="0" bordercolor="#95B8E7">
<tr><td align="center">未拥有角色</td><td align="center">操作选项</td><td align="center">已拥有角色</td></tr>
<tr><td>
    <select multiple="multiple" id="noSysRoleList" name="noSysRoleList" size="15" style="width:100%;">
    </select>
</td>
<td width="50px">
<div style="margin-bottom:20px;" align="center">
        <button type="button" class="easyui-linkbutton" onclick="sourceToTargetSe('noSysRoleList','srIds',true);" >&nbsp;&nbsp;&gt;&nbsp;&nbsp;</button>
</div>
<div style="margin-bottom:20px;" align="center">
        <button type="button" class="easyui-linkbutton" onclick="sourceToTargetSe('srIds','noSysRoleList',true);" >&nbsp;&nbsp;&lt;&nbsp;&nbsp;</button>
</div>
<div style="margin-bottom:20px;" align="center">
        <button type="button" class="easyui-linkbutton" onclick="sourceToTargetSe('noSysRoleList','srIds',false);" >&nbsp;&gt;&nbsp;&gt;&nbsp;</button>
</div>
<div style="margin-bottom:20px;" align="center">
        <button type="button" class="easyui-linkbutton" onclick="sourceToTargetSe('srIds','noSysRoleList',false);" >&nbsp;&lt;&nbsp;&lt;&nbsp;</button>
</div>
</td>
<td>
    <select multiple="multiple" id="srIds" name="srIds" size="15" style="width:98%;" >
    </select>
</td>
</tr>
<tr>
<td colspan="3" align="center">
<br>
    <button type="button" class="easyui-linkbutton" onclick="submitForm();">保存</button> 
    <button type="reset" class="easyui-linkbutton">重置</button>
 </td>  
</table>
</form>
  </div>
  
  <script type="text/javascript" charset="UTF-8" src="${basePath }static/js/selectTool.js"></script>
  <script type="text/javascript" charset="UTF-8" src="${basePath }static/js/project/userRoleList.js"></script>
  
  </body>
</html>
