Ext.require([
    'Ext.toolbar.Paging',
    'Ext.data.*',
    'Ext.selection.*',
    'Ext.tip.*',
    'Ext.grid.*'
]);

function initGrid(pageSize){
	
	Ext.Ajax.request({
	    url: 'SortGridServlet',
	    params:{
	    	start:1,
	    	isArray:true,
	    	limit:15
	    },
	    success: function(response){	    	
	        var rrt = response.responseText;
	        var j = Ext.JSON.decode(rrt);
	        var st = Ext.create('Ext.data.ArrayStore',{
	        	storeId:'st',
	        	autoLoad:false,
	            fields:j.fields,
	            data:j.dataStr ,
	            pageSize: j.pageInfo.pageSize,
	            remoteSort: true,
	            proxy: Ext.create('Ext.data.proxy.Ajax', {
	                url: 'SortGridServlet',
	                extraParams:{isArray:true},
	                reader: Ext.create('Ext.data.reader.Array', {
	                	root:'dataStr',
	                	totalProperty: 'totalCount',
	                	type: 'array'
	                })
	            })
	        }); 
	        
            var grid=Ext.create('Ext.grid.Panel', {
	        	id:j.pageInfo.gridId,
	        	selModel:j.pageInfo.isMutiSelect?Ext.create('Ext.selection.CheckboxModel'):{},
	        	stripeRows:true,
	            store: st ,
	            columns:j.fieldHeader,
	            columnLines:j.pageInfo.columnLines ,
	            autoHeight: true,
	            width: 700,
	            title: '<div >testgrid&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <button onclick=alert(1)> << </button>&nbsp;&nbsp;&nbsp;<button onclick=alert(2)> >> </button></div>',
	            renderTo: 'tb1',
	            listeners:{
	            	 'itemclick':function(view,record,item,index,e){
	            		 var s=index+"|"+record.get('userId')+"|"+record.get('userName')+"|"+record.get('userNick')+"|"+record.get('userPass')+"|"+record.get('userAge');
	            		 alert(s);
	            		 }
	            },
	            viewConfig:{
	            	getRowClass:function(record, index, rowParams, store){
	            		//return record.get('userId')%3==0?"row-s":"row-f";
	            		if(index==3) return "row-f";
	            		if(index==6) return "row-s";
	            		return "";
	            	}
	            },
	            bbar: j.pageInfo.isPage?Ext.create('Ext.PagingToolbar', {
	                store: st,
	                displayInfo: true,
	                displayMsg: 'Displaying topics {0} - {1} of {2}',
	                emptyMsg: "No topics to display"
	            }):{}

	        }); 
	        
	        st.loadPage(1);
	        
	    }
	});

}

Ext.onReady(function() {
	
	initGrid(10);
    
});
