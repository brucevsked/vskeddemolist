
jQuery.validator.addMethod("mobileVali", function(value, element) { 
	var length = value.length;
	var mobile = /^1[3|4|5|7|8]\d{9}$/
	return this.optional(element) || (length == 11 && mobile.test(value));
	}, "手机号码格式错误");

jQuery.validator.addMethod("ipVali", function(value, element) {
	var ip = /^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$/;
	return this.optional(element) || (ip.test(value) && (RegExp.$1 < 256 && RegExp.$2 < 256 && RegExp.$3 < 256 && RegExp.$4 < 256));
	}, "Ip地址格式错误");