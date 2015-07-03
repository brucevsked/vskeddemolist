$(function() {
	
});

function getJsonData(reqUrl){
	chart = $('#container').highcharts();
	
	setInterval(function() {
			var seriest1 =chart.series[0];
			var seriest2 =chart.series[1];
		seriest1.addPoint([(new Date()).getTime(), Math.round(Math.random() * 100) ], true, true);
		seriest2.addPoint([(new Date()).getTime(), Math.round(Math.random() * 100) ], true, true);
		
	}, 1000);
}

function initMyChart(cid){

	$('#'+cid).highcharts('StockChart', {

	    title: {    text: 'test1'   },
	    navigator:{enabled:false},
	    scrollbar:{enabled:false},
	    rangeSelector: {buttons: [],
			inputEnabled:false
	    },
	    chart:{events :{load:function(){
	    	
			
				

	    }}},
	    series: [
	    {
	        name: 'AAPL Stock Price',
	        data:(function() {
			var data = [], time = (new Date()).getTime(), i;
			for( i = -90; i <= 0; i++) {		data.push([	time + i * 1000,	Math.round(Math.random() * 100)		]);		}
			return data;
		})(),
	        type: 'spline',
	        tooltip: {
	        	valueDecimals: 2
	        }
	    },
	    {
	        name: 'sst1',
	        data:(function() {
			var data = [], time = (new Date()).getTime(), i;
			for( i = -90; i <= 0; i++) {		data.push([	time + i * 1000,	Math.round(Math.random() * 100)		]);		}
			return data;
		})(),
	        type: 'spline',
	        tooltip: {
	        	valueDecimals: 2
	        }
	    }
	    ]
	});
}