Ext.require([
    'Ext.toolbar.Paging',
    'Ext.data.*',
    'Ext.selection.*',
    'Ext.tip.*',
    'Ext.grid.*'
]);

function initGrid(myPageSize){
	
	Ext.Ajax.request({
	    url: 'SortGridServlet',
	    params:{
	    	start:1,
	    	limit:myPageSize
	    },
	    success: function(response){	    	
	        var rrt = response.responseText;
	        var j = Ext.JSON.decode(rrt);
	        Ext.define('MVC.model.MVC', {
	        	extend: 'Ext.data.Model',
	        	fields: j.fields
	        	});
	        var st = Ext.create('Ext.data.Store',{
	        	storeId:'st',
	        	model:'MVC.model.MVC',
	        	autoLoad:true,
	            fields:j.fields,
	            pageSize: j.pageInfo.pageSize,
	            remoteSort: true,
	            data:j.dataStr,
	            proxy: Ext.create('Ext.data.proxy.Ajax', {
	                url: 'SortGridServlet',
	                actionMethods:{create: 'POST', read: 'POST', update: 'POST', destroy: 'POST'},
	                reader: Ext.create('Ext.data.reader.Json', {
	                	type:'json',
	                	root:'dataStr',
	                    totalProperty: 'totalCount'
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
	            forceFit: true,
	            width: '80%',
	            title: '<div >testgrid&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <button onclick=alert(1)> << </button>&nbsp;&nbsp;&nbsp;<button onclick=alert(2)> >> </button></div>',
	            renderTo: 'tb1',
	            listeners:{
	            	 'itemclick':function(view,record,item,index,e){
	            		 //var s=index+"|"+record.get('userId')+"|"+record.get('userName')+"|"+record.get('userNick')+"|"+record.get('userPass')+"|"+record.get('userAge');
	            		 //alert(s);
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
	
	initGrid(14);
    
});
