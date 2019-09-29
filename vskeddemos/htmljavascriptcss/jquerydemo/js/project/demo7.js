$(function(){
	console.log('welcome jquery i am vsked');
	$('#showBt').on('click',demo7.show);
	$('#hideBt').on('click',demo7.hide);
	$('#show1Bt').on('click',demo7.show1);
	$('#hide1Bt').on('click',demo7.hide1);
	$('#showhideBt').on('click',demo7.toggle);
});

var demo7=new Object({
    show:function(){
      $('#testDiv').show();
    },
    hide:function(){
      $('#testDiv').hide();  
    },
    show1:function(){
      $('#testDiv').show(2000);
    },
    hide1:function(){
      $('#testDiv').hide(2000);  
    },
    toggle:function(){
      $('#testDiv').toggle();  
    }
});