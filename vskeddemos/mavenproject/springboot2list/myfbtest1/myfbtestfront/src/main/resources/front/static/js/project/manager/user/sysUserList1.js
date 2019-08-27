'use strict'

$(function(){
	sysUserList.list();
});

var sysUserList=new Object({
	list: function(){
		$('#dt0body tr').remove();//先清空原数据
		
  axios.post('http://localhost:9010//apia/v1/user/list', {
　　//params: { id:1,name:'vsked',age:18 }
  }).then(function (dt) {
        console.log(dt.data);
				var dataList=JSON.parse(JSON.stringify(dt.data));
				var rowData="";
				$.each(dataList,function(index,el){
					rowData+='<tr>';
					rowData+='<td>'+el.sysuserid+'</td>';
					rowData+='<td>'+el.sysusername+'</td>';
					rowData+='<td>'+el.sysuseraddtime+'</td>';
					rowData+='</tr>';
				});

				$('#dt0body').append(rowData);
  }).catch(function (error) {
　　alert(error);
  });

	}
});