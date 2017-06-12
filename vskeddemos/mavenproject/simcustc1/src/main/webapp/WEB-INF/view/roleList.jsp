<%@ page language="java" pageEncoding="UTF-8" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
request.setAttribute("basePath", basePath);
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="${basePath }">
    
    <title>角色列表</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
  </head>
  
  <body>
  
  <div id="searchPanel" class="easyui-panel">
  <input id="srName" name="srName" class="easyui-textbox" label="角色名:" style="width: 18%">
  <button class="easyui-linkbutton" type="button" onclick="query()" id="queryBt">&nbsp;查 &nbsp;询&nbsp;</button> <br>
  <button class="easyui-linkbutton" type="button" onclick="edit()" id="editBt">&nbsp;编&nbsp;辑&nbsp;</button>
  </div>
  
    <table id="mytb" toolbar="#searchPanel">
    <thead>
      <tr>
        <th field="SRNAME" >角色名</th>
      </tr>
    </thead>
    </table>
    
  <script type="text/javascript" charset="UTF-8" src="${basePath }static/js/project/roleList.js"></script>
  
  </body>
</html>
