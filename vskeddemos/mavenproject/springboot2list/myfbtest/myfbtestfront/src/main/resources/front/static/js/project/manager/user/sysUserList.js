'use strict'

$(function(){
	sysUserList.list();
});

var sysUserList=new Object({
	list: function(){
		$('#dt0body tr').remove();//先清空原数据

		$.ajax({
			url:'http://localhost:9010//apia/v1/user/list',
			type:'post',
			dataType:'json',
			success:function(dt){
				var dataList=dt;
				var rowData="";
				$.each(dataList,function(index,el){
					rowData+='<tr>';
					rowData+='<td>'+el.sysuserid+'</td>';
					rowData+='<td>'+el.sysusername+'</td>';
					rowData+='<td>'+el.sysuseraddtime+'</td>';
					rowData+='</tr>';
				});

				$('#dt0body').append(rowData);
			},
			error:function(erdt){
				console.log('error:'+erdt);
			}

		});
	}
});