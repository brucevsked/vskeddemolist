$(function () {
  var c1=$('<div></div>');
  c1.attr('id','container');
	$(document.body).append(c1);
	
	$('#container').highcharts({
		credits:{enabled:false},
    chart: {type: 'pie',
    	      options3d: {
              enabled: true,
              alpha: 45,
              beta: 0
            } },
		title: {text: '主标题:浏览器占有市场比例' },
    tooltip: { pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>' },
    plotOptions: {
      pie: {
        allowPointSelect: true,
        cursor: 'pointer',
        depth: 35,
        dataLabels: {
          enabled: true,
          format: '{point.name}'
        }
      }
    },
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