$(function() {

  var columns = new Array();
  var cols = new Array();

  $.post('servlet/generateData.jsp',{d:2},function(rd){
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
	          url         : null,//'servlet/generateData.jsp?d=2',
	          nowrap      : true,
	          border      : true, 
	          striped     : true,
	          pagination: true,
	          total       :rd.total,
	          pageSize    : rd.pageInfo.pageSize,
	          singleSelect: false,
	          columns     : columns,
	          fit:true,
	          fitColumns : true,
	          queryParams : {},
	          frozenColumns   :   [[ 
	              {field:'ck',checkbox:true} 
	          ]]
	      }).datagrid('loadData',{'total':rd.total,'rows':rd.rows,'pageSize':15});
	      //$('#gridDiv').datagrid('loadData',{'total' : rd.total,'rows' : rd.rows}); 
	      
	        
	  /*
      //动态生成表头开始
      if(data.xxxx != null){
          $.each(data.xxxx,function(){
              colData = new Object();
              colData.field = this.resCode;
              colData.title = this.resName;
              colData.width = 100;//也可以配置在数据库，这样整个页面的生成全部是配置的
              colData.formatter =  function(value,row,index){                   

                  //这两句是嵌套对象属性绑定，insideObject 为嵌套的对象，field 为对象的属性
                  //datagrid 的field不能重复，注意在绑定field 时不能全部用 insideObject，需要使用  insideObject 的属性绑定

                  var field = this.field;
                  return row.insideObject[field];                  

              };
              cols.push(colData);
          });
      };

      columns.push(cols);
      //动态生成表头结束      

      var gridCfg = {
          fit         : true,
          loadMsg     : '数据加载中......',
          url         : opts.resDataQueryUrl,
          nowrap      : true,
          border      : false, 
          striped     : true,
          pagination  : true,
          pageSize    : opts.pageSize,
          rownumbers  : true,
          singleSelect: false,
          columns     : columns,
          fitColumns : false,
          queryParams : {},
          frozenColumns   :   [[ 
              {field:'ck',checkbox:true} 
          ]],
          onLoadSuccess:function(data){
          }
      };
      $('#gridDiv').datagrid(gridCfg);  
      */
  },'json');
  
});