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
      datatype: "json",
      page: 1,
      colNames: ['Order ID', 'Customer ID', 'Order Date', 'Freight', 'Ship Name','编辑','删除'],
      colModel: [
          { name: 'OrderID', key: true, sortable: false,hidedlg:true,hidden:true },
          { name: 'CustomerID',index:'CustomerID', sortable: false },
          { name: 'OrderDate' ,index:'OrderDate', sortable: false },
          { name: 'Freight' ,index:'Freight', sortable: false },
          { name: 'ShipName' ,index:'ShipName', sortable: false },
          { name: 'edit', sortable: false },
          { name: 'del', sortable: false }
      ],
      //width: 750,
      height: 'auto',
      //autowidth:true,
      shrinkToFit:false,
      autoScroll: false,
      rowNum: 10,
      rowList : [5,10,15,20,25,30],
      rownumbers: true,
      pager: myJqPageId,
      gridComplete:function (){
    	  var ids = jQuery(myJqTbId).jqGrid('getDataIDs');
    	  for (var i = 0; i < ids.length; i++) {
    	  var id = ids[i];
    	  var editBtn = '<button onclick="edit('+ids[i]+')">编辑</button>';
    	  var delBtn = '<button onclick="del('+ids[i]+')">删除</button>';
    	  jQuery(myJqTbId).jqGrid('setRowData', ids[i], { edit: editBtn, del: delBtn });
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