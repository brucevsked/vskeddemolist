﻿$(function () {
  var c1=$('<div></div>');
  c1.attr('id','container');
	$(document.body).append(c1);
	 var chart = new Highcharts.Chart({
		credits:{enabled:false},
    chart: {renderTo: 'container',
    	type: 'column',
    	options3d: {
    		enabled: true,
        alpha: 15,
        beta: 15,
        depth: 50,
        viewDistance: 25} 
    },
    plotOptions: {
            column: {
                depth: 25
            }
   },
		title: {text: '主标题:全球气温变化表' },
    subtitle: {text: '副标题:山东省济南市气温变化表' },
    xAxis: {categories: ['1', '2', '3', '4', '5', '6','7', '8', '9', '10', '11', '12'] },
    yAxis: {title: {text: '温度' } },
    tooltip: {valueSuffix: '摄氏度' },
    series: [
      {name: '市中区',data: [10.0, 60, 20, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6] },
      {name: '历下区',data: [20.0, 50, 25, 25, 28.2, 36.5, 69.2, 52.5, 98.3, 81.3, 50.9, 19.6] },
      {name: '槐阴区',data: [30.0, 40, 21, 30, 13.2, 10.5, 96.2, 30.5, 9.33, 25.3, 53.9, 29.6] }
    ]
  });  
  function showValues() {
  	$('#alpha-value').html(chart.options.chart.options3d.alpha);
    $('#beta-value').html(chart.options.chart.options3d.beta);
    $('#depth-value').html(chart.options.chart.options3d.depth);
  }
  // Activate the sliders
  $('#sliders input').on('input change', function () {
    chart.options.chart.options3d[this.id] = this.value;
    showValues();
    chart.redraw(false);
  });
  showValues();  
});