$(function () {
  var c1=$('<div></div>');
  c1.attr('id','container');
	$(document.body).append(c1);
	
    $('#container').highcharts({
    	credits:{enabled:false},
        series: [{
            type: "treemap",
            layoutAlgorithm: 'stripes',
            alternateStartingDirection: true,
            levels: [{
                level: 1,
                layoutAlgorithm: 'sliceAndDice',
                dataLabels: {
                    enabled: true,
                    align: 'left',
                    verticalAlign: 'top',
                    style: {
                        fontSize: '15px',
                        fontWeight: 'bold'
                    }
                }
            }],
            data: [{
                id: 'A',
                name: '苹果',
                color: "#EC2500"
            }, {
                id: 'B',
                name: '香蕉',
                color: "#ECE100"
            }, {
                id: 'O',
                name: '橘子',
                color: '#EC9800'
            }, {
                name: '红富士',
                parent: 'A',
                value: 5
            }, {
                name: '一里香',
                parent: 'A',
                value: 3
            }, {
                name: '到口脆',
                parent: 'A',
                value: 4
            }, {
                name: '海南芝麻',
                parent: 'B',
                value: 4
            }, {
                name: '菲律宾之音',
                parent: 'B',
                value: 10
            }, {
                name: '宝岛忘他',
                parent: 'B',
                value: 1
            }, {
                name: '到口酸爽',
                parent: 'O',
                value: 1
            }, {
                name: '到口甜爽',
                parent: 'O',
                value: 3
            }, {
                name: '到口不爽',
                parent: 'O',
                value: 3
            }, {
                name: '其他水果',
                parent: 'Kiwi',
                value: 2,
                color: '#9EDE00'
            }]
        }],
        title: {
            text: '水果市场一级代理'
        }
    });
});