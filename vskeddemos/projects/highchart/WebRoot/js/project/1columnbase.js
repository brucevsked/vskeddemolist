$(function () {
	
	var basePath=document.getElementsByTagName('base')[0].href;
	
	var c1=$('<div></div>');
	c1.attr('id','myLineBaseContent');
	$(document.body).append(c1);
	
	myBasePath=basePath+'proc/1columnbaseproc.jsp';
	$.post(myBasePath,{ myName: 'vsked' },function (dt){
		$('#myLineBaseContent').highcharts({
			credits:{enabled:dt.credits.enabled},
			chart: {type: 'column' },
	        title  :{text:dt.title.text},
	       // subtitle:{text: dt.subtitle.text},
	        xAxis: {
	            categories: dt.xAxis.categories
	        },
	        yAxis: {
	            title: { text: dt.yAxis.title.text  }
	        },
	        tooltip: {
	            valueSuffix: dt.tooltip.valueSuffix
	        },
	        series: dt.series
	    });
	},"json");
});