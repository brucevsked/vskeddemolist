<%@ page language="java" pageEncoding="UTF-8" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
request.setAttribute("basePath", basePath);
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="${basePath }">
    
    <title>字典列表</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
  </head>
  
  <body>
  
  <div id="searchPanel" class="easyui-panel">
  <input id="sdName" name="sdName" class="easyui-textbox" label="字典名称:" style="width: 18%">
  <input id="sdValue" name="sdValue" class="easyui-textbox" label="字典值:" style="width: 18%">
  <input id="sdtName" name="sdtName" class="easyui-textbox" label="字典类型:" style="width: 18%">
  <button class="easyui-linkbutton" type="button" onclick="query()">&nbsp;查 &nbsp;询&nbsp;</button> <br>
  <button class="easyui-linkbutton" type="button" onclick="edit()">&nbsp;编&nbsp;辑&nbsp;</button>
  </div>
  
    <table id="mytb" toolbar="#searchPanel">
    <thead>
      <tr>
        <th field="SDNAME" >名称</th>
        <th field="SDVALUE" >值</th>
        <th field="SDSORT" >排序</th>
        <th field="SDTNAME" >字典类型</th>
      </tr>
    </thead>
    </table>
    
  <script type="text/javascript" charset="UTF-8" src="${basePath }static/js/project/dictionaryList.js"></script>
  
  </body>
</html>
