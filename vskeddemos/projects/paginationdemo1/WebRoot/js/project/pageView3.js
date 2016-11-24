
var basePath=document.getElementsByTagName('base')[0].href;

var pageElementId='page1';

$(function(){
	
	var isInited = $("#page").pagination();
	if(!isInited){
	var myPageSize=10;
	
    $('#'+pageElementId).pagination({
        pageIndex: pageIndexV, //起始页
        pageSize: pageSizeV, //页大小
        total: totalV, //总记录数
        debug: true,
        showInfo: true,
        showJump: true,
        showPageSizes: true,
        pageElementSort: ['$page', '$size', '$jump', '$info']
    });
	}
	
});

$('#'+pageElementId).on("pageClicked", function (event, data) {
    //console.log('currentPage='+data.pageIndex+'|pageSize='+data.pageSize);
   location.href = basePath+'proc/pageProc3.jsp?currentPage='+(data.pageIndex+1)+'&pageSize='+data.pageSize;
}).on('jumpClicked', function (event, data) {
	location.href = basePath+'proc/pageProc3.jsp?currentPage='+(data.pageIndex+1)+'&pageSize='+data.pageSize;
}).on('pageSizeChanged', function (event, data) {
	location.href = basePath+'proc/pageProc3.jsp?currentPage='+(data.pageIndex+1)+'&pageSize='+data.pageSize;
});