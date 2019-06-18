'use strict'

$(function(){
	console.log('welcome jquery i am vsked');
	$('#bt1_2').on('click',demo6.ck1);
});

var demo6=new Object({
      menuActive:function(menuItem){
        $.each($(menuItem).parent().parent().parent().parent().find('li'),function(index,el){
            $(el).removeClass('active'); 
        });
        $(menuItem).parent().attr('class','active');
        $(menuItem).parent().parent().parent().attr('class','active');  	 	
    },
    ck1:function(){
     
      $.each($(this).parent().parent().parent().parent().find('li'),function(index,el){
        $(el).removeClass('active'); 
      });
      
      $(this).parent().attr('class','active');
      //console.log($(this).parent().parent().parent());
      $(this).parent().parent().parent().attr('class','active');
      
    }
});