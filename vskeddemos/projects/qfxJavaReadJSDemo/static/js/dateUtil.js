var dateUtil = {
	// 获得当前日期,格式:yyyy-MM-dd
	getNow : function() {
		var date = new Date();
		var y = date.getFullYear();
		var m = addZero(date.getMonth() + 1);// 获取当前月份的日期
		var d = addZero(date.getDate());
		return y + "-" + m + "-" + d;
	},
	// 获得当前日期,格式:yyyy年MM月dd日
	getNowDate : function() {
		var date = new Date();
		var y = date.getFullYear();
		var m = addZero(date.getMonth() + 1);// 获取当前月份的日期
		var d = addZero(date.getDate());
		return y + "年" + m + "月" + d + '日';
	},
	// 获得当前日期前X天的日期,格式:yyyy-MM-dd
	getBeforeDate : function(dayCount){
		var date = new Date();
		date.setDate(date.getDate() - dayCount);//获取dayCount天前的日期
		var y = date.getFullYear();
		var m = addZero(date.getMonth() + 1);
		var d = addZero(date.getDate());
		return y + "-" + m + "-" + d;
	},
	// 获得当前日期后X天的日期,格式:yyyy-MM-dd
	getAfterDate : function(dayCount){
		var date = new Date();
		date.setDate(date.getDate() + dayCount);//获取dayCount天后的日期
		var y = date.getFullYear();
		var m = addZero(date.getMonth() + 1);
		var d = (date.getDate());
		return y + "-" + m + "-" + d;
	},
	// 获得当前月,格式:yyyy-MM
	getNowMonth : function() {
		var date = new Date();
		var y = date.getFullYear();
		var m = addZero(date.getMonth() + 1);// 获取当前月份的日期
		return y + "-" + m;
	},
	// 获得当前月前X月的年月,格式:yyyy-MM
	getBeforeMonth : function(monthCount){
		var date = new Date();
		date.setMonth(date.getMonth() + 1 - monthCount);//获取dayCount天前的月
		var y = date.getFullYear();
		var m = addZero(date.getMonth());
		return y + "-" + m;
	},
	// 获得当前月后X月的年月,格式:yyyy-MM
	getAfterMonth : function(monthCount){
		var date = new Date();
		date.setMonth(date.getMonth() + 1 - monthCount);//获取dayCount天后的日期
		var y = date.getFullYear();
		var m = addZero(date.getMonth());
		return y + "-" + m;
	}
};

function addZero(number){
	if (number < 10) {
		number = '0' + number;
	}
	return number;
}