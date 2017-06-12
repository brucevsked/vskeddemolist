<%@ page language="java" pageEncoding="UTF-8" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
request.setAttribute("basePath", basePath);
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="${basePath }">
    
    <title>菜单列表</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
  </head>
  
  <body>
  
  <div id="searchPanel" class="easyui-panel">
  <input id="smName" name="smName" class="easyui-textbox" label="菜单名称:" style="width: 18%">
  <input id="smHref" name="smHref" class="easyui-textbox" label="链接:" style="width: 18%">
  <input id="smClick" name="smClick" class="easyui-textbox" label="单击:" style="width: 18%"> <br>
  <input id="smName1" name="smName1" class="easyui-textbox" label="上级菜单:" style="width: 18%">
  <button class="easyui-linkbutton" type="button" onclick="query()" id="queryBt">&nbsp;查 &nbsp;询&nbsp;</button> <br>
  <button class="easyui-linkbutton" type="button" onclick="edit()" id="editBt">&nbsp;编&nbsp;辑&nbsp;</button>
  <button class="easyui-linkbutton" type="button" onclick="roleMenu()" id="roleMenuBt">&nbsp;绑&nbsp;定&nbsp;角&nbsp;色&nbsp;</button>
  </div>
  
    <table id="mytb" toolbar="#searchPanel">
    <thead>
      <tr>
        <th field="SMNAME" >名称</th>
        <th field="SMHREF" >链接</th>
        <th field="SMCLICK" >单击</th>
        <th field="SMCLASS" >样式</th>
        <th field="SMDATAOPTIONS" >扩展</th>
        <th field="SMNAME1" >上级菜单</th>
      </tr>
    </thead>
    </table>
    
  <script type="text/javascript" charset="UTF-8" src="${basePath }static/js/project/menuList.js"></script>
  
  </body>
</html>
