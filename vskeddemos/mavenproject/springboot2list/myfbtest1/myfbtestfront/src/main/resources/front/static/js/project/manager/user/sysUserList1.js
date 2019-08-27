'use strict'

$(function(){
	
	$('#testGetToken').on('click',sysUserList.getToken);
	sysUserList.list();
});

var sysUserList=new Object({
	list: function(){
		$('#dt0body tr').remove();//先清空原数据
		
axios({
  url: 'http://localhost:9010//apia/v1/user/list',
  method: 'post',
  data: {
    token: $('#token').val()
  },
  transformRequest: [function (data) {
    var ret = ''
    for (var it in data) {
      ret += encodeURIComponent(it) + '=' + encodeURIComponent(data[it]) + '&'
    }
    return ret
  }],
  headers: {
    'Content-Type': 'application/x-www-form-urlencoded'
  }
}).then(function(dt){
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
  }).catch(function (er){
    alert(er);
    });

	},
	getToken:function(){
	  alert($('#token').val());
	}
});