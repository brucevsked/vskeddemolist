/**
 * 将一个下拉列表框选中数据移动到另一个下拉列表框
 * @param sourceId 源下拉列表框id
 * @param targetId 目标下拉列表框id
 * @param isSelected
 */
function sourceToTargetSe(sourceId,targetId,isSelected){
	$('#'+sourceId+' option'+(isSelected?':selected':'')).each(function(){
 	$('#'+targetId).append('<option value="'+$(this).val()+'">'+$(this).html()+'</option>');
 	$(this).remove();
 	});
}

/**
 * 选中所有,在提交表单前使用
 * @param selId
 */
function selectAll(selId){
	$('#'+selId+' option').each(function(){
 	$(this).attr('selected','selected');
 	});
}

/**
 * 获取select中所有值用,分隔
 * @param sourceId select的id
 * @returns {String} 1,2,3
 */
function getSelectValues(sourceId){
	var result='';
	$('#'+sourceId+' option').each(function(){
		result+=$(this).val()+',';
 	});
	result=result.substring(0,result.length-1);
	return result;
}