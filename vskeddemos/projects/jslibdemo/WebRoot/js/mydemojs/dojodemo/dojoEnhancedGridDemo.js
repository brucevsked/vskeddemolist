require([
			"dojox/grid/EnhancedGrid",
			"dojox/data/QueryReadStore",
			"dojo/request",
			"dojox/grid/enhanced/plugins/Pagination",
			"dojo/domReady!"
], function (EnhancedGrid,QueryReadStore, request,Pagination) {
	
	reqUrl="servlet/generateData.jsp?d=3";
    request(reqUrl, {
		query:{
			ak:'a41',
			b8:2,
			cdi:'b89'
		},
        handleAs: "json"
    }).then(function (response) {
    	
        var renderToDiv='gridDiv';
        ds = new QueryReadStore({
    	    fetch:function(request){
    	    	request.query={aak:1,bbc:'okgogogo'};
    	          return this.inherited("fetch", arguments);
    	    },
        	url:reqUrl 
        	});
        
        var tmpColArray=new Array(response.columns.length);
        for(var i=0;i<response.columns.length;i++){
            tmpColArray[i]=new Object();
            tmpColArray[i].id=""+i;
            tmpColArray[i].field=response.columns[i].field;
            tmpColArray[i].name=response.columns[i].name;
            tmpColArray[i].width=response.columns[i].width;
         }
        var grid=new EnhancedGrid({
        	id:'myGrida',
        	store:ds,
        	autoWidth:true,
        	autoHeight:true,
        	plugins: {
        		pagination: {
        			defaultPageSize:10,
        			position: 'bottom',
        			pageSizes: ['10', '15', '20', 'All'], 
        			maxPageStep: 5, //在右边最多显示几页
        			itemTitle: 'items', //默认把每一行称作一个item，当然可以改成别的
        			descTemplate: '${2} - ${3} of ${1} ${0}' , //这个比较复杂，${0}就是刚才的itemTitle，${1}是总行数，${2}和${3}分别是起止行。
        			description: true,  //如果设置成False，就没有最左边的描述信息了
        			sizeSwitch: true,   //如果设置成False，中间的行数切换就没了
        			gotoButton: true,
        			pageStepper: true   //如果设置成False，右边的页面切换也省了
        			}
            },
        	structure:tmpColArray
        },renderToDiv);
        grid.startup();
    });
});
 