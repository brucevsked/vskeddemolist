$(function () {
  var c1=$('<div></div>');
  c1.attr('id','container');
	$(document.body).append(c1);
	
	$('#container').highcharts({
		credits:{enabled:false},
		//chart: {type: 'line' },
		title: {text: '主标题:全球气温变化表' },
    subtitle: {text: '副标题:山东省济南市气温变化表' },
    xAxis: {categories: ['1', '2', '3', '4', '5', '6','7', '8', '9', '10', '11', '12'] },
    yAxis: {title: {text: '温度' } },
    tooltip: {valueSuffix: '摄氏度' },
    series: [{name: '市中区',data: [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6] },
      {name: '历下区',data: [5.0, 3.9, 1.5, 77.5, 28.2, 36.5, 69.2, 52.5, 98.3, 81.3, 50.9, 19.6] },
      {name: '长清区',data: [99.0, 100.9, 101.5, 102.5, 103.2, 104.5, 105.2, 90.5, 80.3, 70.3, 60.9, 29.6] },
      {name: '槐阴区',data: [1.0, 1.9, 3.5, 25.5, 3.2, 10.5, 96.2, 30.5, 0.33, 25.3, 53.9, 29.6] }
    ]
  });
  
});