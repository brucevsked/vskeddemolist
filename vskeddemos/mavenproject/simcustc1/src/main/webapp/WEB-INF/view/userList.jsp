<%@ page language="java" pageEncoding="UTF-8" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
request.setAttribute("basePath", basePath);
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="${basePath }">
    
    <title>用户列表</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
  </head>
  
  <body>
  
  <div id="searchPanel" class="easyui-panel">
  <input id="suName" name="suName" class="easyui-textbox" label="用户名:" style="width: 18%">
  <button class="easyui-linkbutton" type="button" onclick="query()" id="queryBt">&nbsp;查 &nbsp;询&nbsp;</button> <br>
  <button class="easyui-linkbutton" type="button" onclick="edit()" id="editBt">&nbsp;编&nbsp;辑&nbsp;</button>
  <button class="easyui-linkbutton" type="button" onclick="userPass()" id="userPassBt">&nbsp;修&nbsp;改&nbsp;密&nbsp;码&nbsp;</button>
  <button class="easyui-linkbutton" type="button" onclick="userRole()" id="userRoleBt" >&nbsp;绑&nbsp;定&nbsp;角&nbsp;色&nbsp;</button>
  </div>
  
    <table id="mytb" toolbar="#searchPanel">
    <thead>
      <tr>
        <th field="SUNAME" >用户名</th>
        <th field="SUMOBILE" >手机号</th>
        <th field="SUNICK" >别名</th>
        <th field="SUQQ" > qq号</th>
      </tr>
    </thead>
    </table>
    
  <script type="text/javascript" charset="UTF-8" src="${basePath }static/js/project/userList.js"></script>
  
  </body>
</html>
