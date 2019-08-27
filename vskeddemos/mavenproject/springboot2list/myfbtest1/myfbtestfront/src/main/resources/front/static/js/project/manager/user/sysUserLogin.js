'use strict'

$(function(){
	$('#loginBt').on('click',sysUserLogin.login);
});

var sysUserLogin=new Object({
	login: function(){
	  var sysusername=	$('#sysusername').val();
	  var sysuserpwd=	$('#sysuserpwd').val();
axios({
  url: 'http://localhost:9010/apia/v1/user/login',
  method: 'post',
  data: {
    sysusername: sysusername,
    sysuserpwd: sysuserpwd
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
  //console.log(dt.data);
  if(dt.data.code=='000000'){
    $('#token').val(dt.data.data.token);
    $('#loginDiv').remove();
    $('#tmpMain').load('http://localhost:8080/front/templates/SysUserList1.html');
  }else{
    alert('登录失败');
  }
  }).catch(function (er){
    alert(er);
    });

	}
});