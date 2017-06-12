<%@ page language="java" pageEncoding="UTF-8" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
request.setAttribute("basePath", basePath);
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="${basePath }">
    
    <title>组织列表</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
  </head>
  
  <body>
  
  <div id="searchPanel" class="easyui-panel">
  <input id="soName" name="soName" class="easyui-textbox" label="组织名称:" style="width: 18%">
  <input id="soCode" name="soCode" class="easyui-textbox" label="代码:" style="width: 18%">
  <input id="soName1" name="soName1" class="easyui-textbox" label="上级组织:" style="width: 18%">
  <button class="easyui-linkbutton" type="button" onclick="query()" id="queryBt">&nbsp;查 &nbsp;询&nbsp;</button> <br>
  <button class="easyui-linkbutton" type="button" onclick="edit()" id="editBt">&nbsp;编&nbsp;辑&nbsp;</button>
  </div>
  
    <table id="mytb" toolbar="#searchPanel">
    <thead>
      <tr>
        <th field="SONAME" >名称</th>
        <th field="SOCODE" >代码</th>
        <th field="SOSORT" >排序</th>
        <th field="SONAME1" >上级组织</th>
      </tr>
    </thead>
    </table>
    
  <script type="text/javascript" charset="UTF-8" src="${basePath }static/js/project/organizeList.js"></script>
  
  </body>
</html>
