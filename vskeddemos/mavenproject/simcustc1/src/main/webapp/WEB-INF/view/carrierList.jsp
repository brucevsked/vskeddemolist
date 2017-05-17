<%@ page language="java" pageEncoding="UTF-8" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
request.setAttribute("basePath", basePath);
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="${basePath }">
    
    <title>运营商列表</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
  </head>
  
  <body>
  
  <div id="searchPanel" class="easyui-panel">
  <input id="carrierName" name="carrierName" class="easyui-textbox" label="运营商名称:" style="width: 18%">
  <input id="carrierNick" name="carrierNick" class="easyui-textbox" label="别名:" style="width: 18%">
  <input id="carrierShortName" name="carrierShortName" class="easyui-textbox" label="简称:" style="width: 18%">
  <button class="easyui-linkbutton" type="button" onclick="query()">&nbsp;查 &nbsp;询&nbsp;</button> <br>
  <button class="easyui-linkbutton" type="button" onclick="edit()">&nbsp;编&nbsp;辑&nbsp;</button>
  </div>
  
    <table id="mytb" toolbar="#searchPanel">
    <thead>
      <tr>
        <th field="CARRIERNAME" >运营商名</th>
        <th field="CARRIERNICK" >别名</th>
        <th field="CARRIERSHORTNAME" >简称</th>
        <th field="OFFICIALWEBSITE" >官网</th>
        <th field="HOTLINE" >客服电话</th>
      </tr>
    </thead>
    </table>
    
  <script type="text/javascript" charset="UTF-8" src="${basePath }static/js/project/carrierList.js"></script>
  
  </body>
</html>
