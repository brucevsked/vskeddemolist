require([
    "dojo/_base/declare",
    "dojo/request",
    "dojo/store/Memory",
    "dgrid/OnDemandGrid",
    "dgrid/Grid",
    "dgrid/extensions/Pagination",
	"dgrid/Selection",
	"dojox/data/QueryReadStore",
	"dgrid/Keyboard"
], function (declare,request, Memory, OnDemandGrid,Grid,Pagination, Selection,QueryReadStore, Keyboard) {
	reqUrl='servlet/generateData.jsp?d=1';
    request(reqUrl, {
    	query:{
    		ak:"2",
    		bk:"3"
    	},
        handleAs: "json"
    }).then(function (response) {
    	
        var st = new Memory({ 
        	data: response.data
        	});
        //TODO will see again here
        var queryReadStore = new QueryReadStore({
    		_filterResponse: function(data){
    			data.items.length=data.pageInfo.total;
    			return data;
    		},
    	    fetch:function(request){
    	    	request.query={aak:1,bbc:'okgogogo'};
    	          return this.inherited("fetch", arguments);
    	    },
        	url:reqUrl 
        	});
        var grid ;
        var renderToDiv='gridDiv';
        if(!response.pageInfo.isPage){
        grid= new OnDemandGrid({className: "dgrid-autoheight", store: st }, renderToDiv);
        }else{
        grid=new (declare([Grid, Pagination]))({
        	className: "dgrid-autoheight",
        	store:st,
        	rowsPerPage: 15,
        	pagingTextBox: true,
        	firstLastArrows: true,
        	pagingLinks: true,
        	pageSizeOptions: [10, 15, 25]
        },renderToDiv);
        }//end else ispage
        
        
        var tmpColArray=new Array(response.columns.length);
        for(var i=0;i<response.columns.length;i++){
        tmpColArray[i]=new Object();
        tmpColArray[i].id=""+i;
        tmpColArray[i].field=response.columns[i].field;
        tmpColArray[i].label=response.columns[i].label;
        }
        grid.set("columns",tmpColArray);
        grid.startup();
    });
});
 