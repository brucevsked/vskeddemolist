Ext.require([
    'Ext.direct.*',
    'Ext.data.*',
    'Ext.grid.*'
]);

Ext.onReady(function() {
	Ext.Ajax.request({
	    url: 'GenerateServlet',
	    success: function(response){
	        var rrt = response.responseText;
	        var j = Ext.JSON.decode(rrt);
	        var st = Ext.create('Ext.data.Store',{    
	            fields:j.fields,
	            data:j.dataStr  
	        }); 
	        Ext.create('Ext.grid.Panel', {
	            store: st ,
	            columns:j.fieldHeader,
	            autoHeight: true,
	            width: 700,
	            title: 'testGrid',
	            renderTo: 'tb1'
	        });  
	        
	    }
	});
    
});