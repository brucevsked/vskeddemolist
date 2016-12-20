  var basePath=document.getElementsByTagName('base')[0].href;

  var myTbId='myt1';
  var myJqTbId='#'+myTbId;
  var myPageId='myp1';
  var myJqPageId='#'+myPageId;

$(function () {

  var t1=$('<table></table>');
  t1.attr('id',myTbId);
  $(document.body).append(t1);
  
  var p1=$('<div></div>');
  p1.attr('id',myPageId);
  
  p1.insertAfter(t1);
  
  
  $(myJqTbId).jqGrid({
      url: basePath+'demoproc/demo1proc.jsp',
      mtype: "GET",
      caption: "这是一个jqgrid例子",
      datatype: "json",
      page: 1,
      colNames: ['Order ID', 'Customer ID', 'Order Date', 'Freight', 'Ship Name','操作选项'],
      colModel: [
          { name: 'OrderID', index:'OrderID',key: true, sortable: false,hidedlg:true,hidden:true },
          { name: 'CustomerID',index:'CustomerID', sortable: false },
          { name: 'OrderDate' ,index:'OrderDate', sortable: false },
          { name: 'Freight' ,index:'Freight', sortable: false,formatter:freightFormat },
          { name: 'ShipName' ,index:'ShipName', sortable: false },
          { name: '_operate', sortable: false }
      ],
      //width: 750,
      height: 'auto',
      autowidth:true,
      shrinkToFit:true,
      autoScroll: false,
      rowNum: 10,
      rowList : [5,10,15,20,25,30],
      rownumbers: true,
      pager: myJqPageId,
      gridComplete:function (){
    	  var ids = jQuery(myJqTbId).jqGrid('getDataIDs');
    	  for (var i = 0; i < ids.length; i++) {
    	  var id = ids[i];
    	  var btn='';
    	  btn += '<button onclick=edit("'+id+'")>编辑</button>';
    	  btn +=  '<button onclick=del("'+id+'")>删除</button>';
    	  jQuery(myJqTbId).jqGrid('setRowData', ids[i], { _operate: btn });
    	  }
      }
  });
  
  //给查询条件焦点
  $('#customerId').focus();
  
});

function edit(rowIndex){
	var rowData = $(myJqTbId).jqGrid('getRowData',rowIndex);
	console.log(rowData);
	console.log(rowData.OrderID);
}

function del(rowIndex){
	var rowData = $(myJqTbId).jqGrid('getRowData',rowIndex);
	console.log(rowData);
	console.log(rowData.OrderID);
}

function search(){
	var customerId=$('#customerId').val();
	var freight=$('#freight').val();
	console.log(customerId+'|'+freight)
	
    $(myJqTbId).jqGrid('setGridParam',{ 
        url:basePath+'demoproc/demo1proc.jsp', 
        postData:{'customerId':customerId,'freight':freight}, //发送数据 
        page:1 
    }).trigger("reloadGrid"); //重新载入
}

function getSelectData(){
	var rowId = jQuery(myJqTbId).jqGrid("getGridParam", "selrow");
	if(rowId==null){
		console.log('没有选中行！')
	}else{
		console.log(rowId);
		var rowData = $(myJqTbId).jqGrid('getRowData',rowId);
		console.log(rowData);
		console.log(rowData.OrderID);
	}
	
}

function freightFormat(cellvalue, options, rowObject){
	cellvalue=cellvalue.replace('f','');
	cellvalue=cellvalue%2==1?'省':'国';
	return cellvalue;
}

