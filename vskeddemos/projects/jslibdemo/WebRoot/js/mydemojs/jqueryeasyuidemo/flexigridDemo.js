
$(document).ready(function() { 
	
$.post('jqueryeasyuidemo/getJsonData.jsp',{vt:1},function(rd){
	var columnHead=rd;
$('#flexme4').flexigrid({
	url : 'jqueryeasyuidemo/getJsonData.jsp?vt=2',
	dataType : 'json',
	colModel : columnHead,
	sortname : 'iso',
	sortorder : 'asc',
	usepager : true,
	title : 'Employees',
	useRp : true,
	rp : 15,
	showTableToggleBtn : true,
	width : 750,
	height : 200
});
},'json');

});