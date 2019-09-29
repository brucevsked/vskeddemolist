$(function(){

	$('#myAddBt').on('click',demo8.add);
	
});

var demo8=new Object({
    add:function(){
      var rs='';
      rs+='<div>';
      rs+='<select><option value="1">1</option><option value="2">2</option><option value="3">3</option><option value="4">5</option></select>';
      rs+='<input type="text" name="heyC1">';
      rs+='<button type="button" onclick="demo8.del(this);">del</button>';
      rs+='</div>';
      rs=$(rs);
      $('#myRsDiv').append(rs);
    },
    del:function(obj){
      $(obj).parent().remove();
    }
});