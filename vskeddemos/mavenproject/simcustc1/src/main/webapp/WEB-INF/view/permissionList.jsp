<%@ page language="java" pageEncoding="UTF-8" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
request.setAttribute("basePath", basePath);
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="${basePath }">
    
    <title>权限列表</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
  </head>
  
  <body>
  
  <div id="searchPanel" class="easyui-panel">
  <input id="spName" name="spName" class="easyui-textbox" label="权限表达式:" style="width: 18%">
  <input id="spNick" name="spNick" class="easyui-textbox" label="权限中文名:" style="width: 18%">
  <button class="easyui-linkbutton" type="button" onclick="query()">&nbsp;查 &nbsp;询&nbsp;</button> <br>
  <button class="easyui-linkbutton" type="button" onclick="edit()">&nbsp;编&nbsp;辑&nbsp;</button>
  <button class="easyui-linkbutton" type="button" onclick="rolePermission()">&nbsp;绑&nbsp;定&nbsp;角&nbsp;色&nbsp;</button>
  </div>
  
    <table id="mytb" toolbar="#searchPanel">
    <thead>
      <tr>
        <th field="SPNAME" >权限表达式</th>
        <th field="SPNICK" >权限名</th>
      </tr>
    </thead>
    </table>
    
  <script type="text/javascript" charset="UTF-8" src="${basePath }static/js/project/permissionList.js"></script>
  
  </body>
</html>
