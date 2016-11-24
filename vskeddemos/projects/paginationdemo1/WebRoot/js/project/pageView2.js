

$(function(){
	
	var basePath=document.getElementsByTagName('base')[0].href;
	var myPageSize=10;
	//好像很实用的样子，后端的同学再也不用写分页逻辑了。
	laypage({
	  cont: 'page1',//容器。值支持id名、原生dom对象，jquery对象,
	  pages: myPageSize, //可以叫服务端把总页数放在某一个隐藏域，再获取。假设我们获取到的是10
	  skin: 'molv', //皮肤
	  skip: true , //是否开启跳页
	  groups: 3 , //连续显示分页数
	  prev: '<' , //若不显示，设置false即可
	  next: '>' ,//若不显示，设置false即可
	  first:'|<',
	  last: '>|',
	  curr: function(){ //通过url获取当前页，也可以同上（pages）方式获取
	    var page = location.search.match(/currentPage=(\d+)/);
	    return page ? page[1] : 1;
	  }(), 
	  jump: function(e, first){ //触发分页后的回调
	    if(!first){ //一定要加此判断，否则初始时会无限刷新
	      location.href = basePath+'proc/pageProc2.jsp?currentPage='+e.curr+'&pageSize='+myPageSize;
	    }
	  }
	});
	
});

