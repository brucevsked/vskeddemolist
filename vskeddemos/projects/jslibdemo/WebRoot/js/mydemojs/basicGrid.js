Ext.require([
    'Ext.direct.*',
    'Ext.data.*',
    'Ext.grid.*'
]);


var st = Ext.create('Ext.data.Store',{    
    fields:['userId','userName','userNick','userPass','userAge','regDate','lastLoginDate' ],
    autoLoad:true,
    proxy:{  
        type: 'ajax',  
        url:'UserServlet', 
        reader:{  
            type:'json',
        }  
    }  
}); 


Ext.onReady(function() {
    // create the Grid
    Ext.create('Ext.grid.Panel', {
        store: st ,
        columns: [
                  {
                	  dataIndex: 'userId',
                	  width: 50,
                	  text: 'a0'
                  },
                  {
                	  dataIndex: 'userName',
                	  width: 80,
                	  text: 'a1'
                  },
                  {
                	  dataIndex: 'userNick',
                	  width: 80,
                	  text: 'a2'
                  },
                  {
                	  dataIndex: 'userPass',
                	  width: 80,
                	  text: 'a3'
                  },
                  {
                	  dataIndex: 'userAge',
                	  width: 80,
                	  text: 'a4'
                  },
                  {
                	  dataIndex: 'regDate',
                	  width: 80,
                	  text: 'a5'
                  },
                  {
                	  dataIndex: 'lastLoginDate',
                	  width: 80,
                	  text: 'a6'
                  }
                  
                  ],
        
        autoHeight: true,
        width: 700,
        title: 'testGrid',
        renderTo: Ext.getBody()
    });
});