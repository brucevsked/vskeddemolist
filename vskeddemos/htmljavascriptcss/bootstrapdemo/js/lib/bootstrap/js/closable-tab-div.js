//子页面不用iframe，用div展示
var closableTab = {
  tabList:[],
	
    //添加tab
	addTab:function(tabItem){ //tabItem = {id,name,url,closable}

		var id = "tab_seed_" + tabItem.id;
		var container ="tab_container_" + tabItem.id;

		$("li[id^=tab_seed_]").removeClass("active");
		$("div[id^=tab_container_]").removeClass("active");

		if(!$('#'+id)[0]){
			var li_tab = '<li class="nav-item" id="'+id+'"><a class="nav-link" data-toggle="tab" href="#'+container+'" >'+tabItem.name;
			if(tabItem.closable){
				li_tab = li_tab + '<i class="glyphicon glyphicon-remove small" id="x'+id+'" tabclose="'+id+'" style="position: relative;right:-6px;top: -6px;"  onclick="closableTab.closeTab(this)">×</i></a></li> ';
				closableTab.tabList.push('x'+id);
			}else{
				li_tab = li_tab + '</a></li>';
			}
		
		 	var tabpanel = '<div role="tabpanel" class="container tab-pane" id="'+container+'" style="width: 100%;">'+
	    					  '正在加载...'+
	    				   '</div>';


			$('.nav-tabs').append(li_tab);
			$('.tab-content').append(tabpanel);
			$('#'+container).load(tabItem.url,function(response,status,xhr){
				if(status=='error'){//status的值为success和error，如果error则显示一个错误页面
					$(this).html(response);
				}
			});
		}
		$("#"+id).addClass("active");
		$("#"+container).addClass("active");
	},

	//关闭tab
	closeTab:function(item){
		var val = $(item).attr('tabclose');
		var containerId = "tab_container_"+val.substring(9);
   	    
   	    if($('#'+containerId).hasClass('active')){
   	    	$('#'+val).prev().addClass('active');
   	    	console.log(val)
   	    	console.log(containerId)
   	    	$('#'+containerId).prev().addClass('active');
   	    }


		$("#"+val).remove();
		$("#"+containerId).remove();

		closableTab.tabList.splice(closableTab.tabList.indexOf('x'+val),1);


	},
	closeAllTab:function(){
    var i=0;
		for(i=closableTab.tabList.length-1;i>=0;i--){
		  closableTab.closeTab(document.getElementById(''+closableTab.tabList[i]));
		}
	},
	slide:function(flag){
	  var curTabHead=$('.nav-link.active');
	  var curTabBody=$('.tab-pane.active');
	  if(flag==1){
	    var leftTabHead=curTabHead.parent().prev().find('.nav-link');
	    var leftTabBody=curTabBody.prev();
	    if(leftTabHead.length>0){
	       curTabHead.removeClass('active');
	       leftTabHead.addClass('active');
	       leftTabHead.addClass('show');
	       curTabBody.removeClass('active');
	       leftTabBody.addClass('active');
	       leftTabBody.addClass('show');
	    }
	  }else{
	    var rightTabHead=curTabHead.parent().next().find('.nav-link');
	    var rightTabBody=curTabBody.next();
	    if(rightTabHead.length>0){
	       curTabHead.removeClass('active');
	       rightTabHead.addClass('active');
	       rightTabHead.addClass('active');
	       curTabBody.removeClass('active');
	       rightTabBody.addClass('active');
	       rightTabBody.addClass('show');
	    }
	  }
	},
	slideLeft:function(){
	  closableTab.slide(1);
	},
	slideRight:function(){
	  closableTab.slide(2);
	}
}