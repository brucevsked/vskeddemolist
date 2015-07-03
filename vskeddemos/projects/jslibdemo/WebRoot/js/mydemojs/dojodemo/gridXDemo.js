require([
    'dojo/request',
    'dojox/data/QueryReadStore',
    'gridx/Grid',
    'gridx/allModules',
    'gridx/core/model/cache/Async',
    'dojo/domReady!'
], function(request, QueryReadStore, Grid,mods, Cache){
	reqUrl='servlet/generateData.jsp?d=4';
    request(reqUrl, {
    	query:{
    		ak:"2",
    		bk:"3"
    	},
        handleAs: "json"
    }).then(function (response) {
        	
    var ds = new QueryReadStore({
	    fetch:function(request){
	    	request.query={aak:1,bbc:'okgogogo'};
	          return this.inherited("fetch", arguments);
	    },
    	url:reqUrl 
    	});
    
    var tmpColArray=new Array(response.columns.length);
    var hideColArray=new Array();
    for(var i=0;i<response.columns.length;i++){
        tmpColArray[i]=new Object();
        tmpColArray[i].id=''+response.columns[i].id;
        tmpColArray[i].field=response.columns[i].field;
        tmpColArray[i].name=response.columns[i].name;
        tmpColArray[i].width=response.columns[i].width;
        if(response.columns[i].sortable!=undefined)
        tmpColArray[i].sortable=eval(response.columns[i].sortable);
        if(response.columns[i].url!=undefined){
        tmpColArray[i].decorator=function(cellData, rowId, rowIndex,setCell){
        	return  '<a href=\"javascript:alert('+rowId+'|'+response.columns[i].url+');\">|'+cellData+'|'+'</a>';
        };
        }
        if(response.columns[i].isHidden=='true'){
        	hideColArray.push((''+response.columns[i].id));
        }
     }
    var grid = new Grid({
    	id:'myGrid1',
    	title:'this is myGrid1',
		autoWidth: true,
		autoHeight: true,
		cacheClass: Cache,
        store: ds,
        structure: tmpColArray,
       //columnWidthAutoResize: true,
       //vScrollerLazy: true,
        bodyRowHoverEffect: true,
        selectRowTriggerOnCell: true,
		modules: [
		          mods.HiddenColumns,
		          mods.Pagination,
		          {
		        	  moduleClass:mods.PaginationBar,
		        	  sizes: [11,21],
		        	  visibleSteppers: 2,
		        	  gotoButton: true
		          },
		          //mods.VirtualVScroller,
		          mods.NestedSort,
		          mods.ColumnResizer,
		          //mods.RowHeader,
		          //{		        	 
		        	  //moduleClass: mods.IndirectSelect,
		        	  //all:true
		          //},
		          {
		        	  moduleClass:mods.SelectRow,
		        	  multiple: true
		          },
		          mods.ExtendedSelectRow,
		          mods.MoveColumn	          
				]
		
    }); 
    
    getRowInfo=function(rowId){
    	//all hide columns id array
    	var tmpArr=grid.hiddenColumns.get();
    	//set column display
    	for(var i=0;i<tmpArr.length;i++) grid.hiddenColumns.remove(tmpArr[i]+'');
    	
    	var d1=grid.cell(rowId,'0').data();
    	console.log(d1)
    	var d2=grid.cell(rowId,'1').data();
    	console.log(d2)
    	var d3=grid.cell(rowId,'2').data();
    	console.log(d3)
    	
    	//columns Array
    	for(var i=0;i<grid.structure.length;i++){
    		console.log(grid.structure[i].id)
    	}
    	//set column hidden
    	for(var i=0;i<tmpArr.length;i++) grid.hiddenColumns.add(tmpArr[i]+'');
    	
    };
    
    grid.placeAt('gridDiv');
    
    for(var i=0;i<hideColArray.length;i++){
    	grid.hiddenColumns.add(hideColArray[i]);
    	console.log('----------'+hideColArray[i])
    }
    
    grid.startup();
    
    });
    
});