$(function () {
  var c1=$('<div></div>');
  c1.attr('id','container');
	$(document.body).append(c1);
	
	$('#container').highcharts({
		credits:{enabled:false},
    chart: {type: 'pie' },
		title: {text: '主标题:浏览器占有市场比例' },
    tooltip: { pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>' },
    series: [
    { name: 'Brands', 
    	colorByPoint: true,
    	data: [
    	{ name: 'Microsoft Internet Explorer', y: 56.33 }, 
      { name: 'Chrome', y: 24.03, sliced: true, selected: true }, 
      { name: 'Firefox',y: 10.38 }, 
      { name: 'Safari', y: 4.77 ,sliced: true}, 
      { name: 'Opera',  y: 0.91  }, 
      { name: 'Proprietary or Undetectable', y: 0.2}
      ]
    }]
  });
  
});