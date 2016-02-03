$(function() {

  var columns = new Array();
  var cols = new Array();
  var basePath=document.getElementsByTagName('base')[0].href;
  $.post(basePath+'servlet/generateData.jsp',{d:2},function(rd){
	  console.log(rd.total+'|'+rd.pageInfo.pageSize);
	  
	  if(rd.columns.length>0){
		  $.each(rd.columns,function(){
			  var colData=new Object();
			  colData.field=this.field;
			  colData.title=this.title;
			  colData.width=this.width;	
			  cols.push(colData);
		  });
	  }//end if rd.columns.length>0
	  
	  columns.push(cols);
	  
	      $('#gridDiv').datagrid({
	          fit         : true,
	          loadMsg     : '数据加载中......',
	          url         : basePath+'servlet/generateData.jsp?d=2',//'servlet/generateData.jsp?d=2',
	          nowrap      : true,
	          border      : true, 
	          striped     : true,
	          pagination  : true,
	          rownumbers  :true,  //行号 
	          total       :rd.total,
	          pageSize    : rd.pageInfo.pageSize,
	          singleSelect: false,
	          columns     : columns,
	          fitColumns : true,
	          frozenColumns   :   [[ 
	              {field:'ck',checkbox:true} 
	          ]]
	      }).datagrid('loadData',{'total':rd.total,'rows':rd.rows,'pageSize':15});
  },'json');
  
});