Ext.onReady(function(){
	
	Ext.MessageBox.alert("this is title","this is content");
	
	//Ext.MessageBox.alert("this is title","this is content",function(){alert(1)});
	
	function reg(){
		alert('let me reg');
	}
	
	function login(){
		alert('let me login');
	}
	
	var loginForm = Ext.create("Ext.form.Panel", {  
        title: '用户登陆',  
        frame: true,  
        width: 320,  
        bodyPadding: 10,  
        defaultType: 'textfield',  
        defaults: {  
            anchor: '100%',  
            labelWidth: 50,  
            labelAlign: "right"  
        },  
        items: [  
            {  
                allowBlank: false,  
                fieldLabel: '用户名',  
                name: 'UserName',  
                emptyText: '用户名'  
            },  
            {  
                allowBlank: false,  
                fieldLabel: '密码',  
                name: 'Password',  
                emptyText: '密码',  
                inputType: 'password'  
            }
        ],  
        buttons: [  
            { 	text: '注册',
            	handler: reg
            },  
            {   text: '登陆',
            	handler: login
            }  
        ],  
        renderTo: "loginDiv"  
	});
});