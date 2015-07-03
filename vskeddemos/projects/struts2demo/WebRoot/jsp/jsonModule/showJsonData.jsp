<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("basePath", basePath);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="${basePath }">
    
    <title>index</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="">
	<meta http-equiv="description" content="">
	<script src="<%=basePath%>js/jquery-1.11.0.js" type="text/javascript" charset="utf-8"></script>

  </head>
  
  <body>
  <script type="text/javascript">
  $(document).ready(function() { 
		
	  $.post('${basePath }testJsonModule/getJsonData',{vt:1},function(rd){
		  rd=$.parseJSON(rd.jsonDataVs1)
		  for(i=0;i<rd.tableHead.length;i++){
			  document.write(rd.tableHead[i][0].tbName+"<br>")
			  for(tmpIndex=0;tmpIndex<rd.tableHead[i][0].columns.length;tmpIndex++){
				  document.write(rd.tableHead[i][0].columns[tmpIndex][0]+"|"+rd.tableHead[i][0].columns[tmpIndex][1]+"|"+rd.tableHead[i][0].columns[tmpIndex][2]+"|")
		      }
			  document.write("<br>");
		  }
	  },'json');

	  });
  </script>
  </body>
</html>
