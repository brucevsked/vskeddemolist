
/**
 * 项目路径配合base标签使用
 */
var basePath=document.getElementsByTagName('base')[0].href;

/**
 * toastr提示消息全局设置
 */
toastr.options = {
		closeButton : true,
		progressBar : true,
		showMethod : 'slideDown',
		positionClass : "toast-bottom-right",
		timeOut : 5000
};

/**
 * 系统登录成功后运行函数
 */
$(function(){
	userMenu();
	console.log('welcome to simcustc1 system')
});

/**
 * 转换为easyui树格式需要id,name,parentId请提前在数据库或代码端处理好
 * @param rows
 * @returns {Array}
 */
function convertEasyUITreeData(rows){
    var nodes = [];  
    // get the top level nodes  
    for (var i = 0; i < rows.length; i++) {  
        var row = rows[i];  
        if (!existsChildNode(rows, row.parentId)) {  
            nodes.push({  
                id: row.id,  
                text: row.name  
            });  
        }  
    } 
    var toDo = [];  
    for (var i = 0; i < nodes.length; i++) {  
        toDo.push(nodes[i]);  
    }  
    while (toDo.length) {  
        var node = toDo.shift();    // the parent node  
        // get the children nodes  
        for (var i = 0; i < rows.length; i++) {  
            var row = rows[i];  
            if (row.parentId == node.id) {  
                var child = { id: row.id, text: row.name };  
                if (node.children) {  
                    node.children.push(child);  
                } else {  
                    node.children = [child];  
                }  
                toDo.push(child);  
            }  
        }  
    }  
    return nodes;  
}

/**
 * 是否存在子节点
 * @param rows
 * @param parentId
 * @returns {Boolean}
 */
function existsChildNode(rows, parentId) {
    for (var i = 0; i < rows.length; i++) {  
        if (rows[i].id === parentId) return true;  
    }  
    return false;  
} 

/**
 * 将指定页面载入mainDiv
 * @param pageUrl 页面地址不包括项目地址只写controller那层就可以 只有本参数时会用get方法载入
 * @param data 要传的数据 注意使用本参数时会用post方法载入后台controller需要用post接收
 * @param callback 回调函数
 */
function loadPage(pageUrl,data,callback){
	$('#mainDiv').load(basePath+pageUrl,data,callback);
}

/**
 * 是否存在某种权限如果没有移除元素
 * @param permission 权限表达式
 * @param elId 元素id
 */
function isExistPermission(permission,elId){
	var myBasePath=basePath+'isExistPermission';
	$.post(myBasePath,{myPermission:permission},function (dt){
		if(dt!='true'){
			var el=document.getElementById(elId);
			removeElement(el);
		}
	 }
	);
}

/**
 * 移除元素
 * @param _element
 */
function removeElement(_element){
    var _parentElement = _element.parentNode;
    if(_parentElement){
           _parentElement.removeChild(_element);
    }
}

/**
 * 载入当前用户菜单
 */
function userMenu(){
	$('#menuDiv').html('');//清空原有菜单
	var myBasePath=basePath+'userMenu';
	$.post(myBasePath,{},function (dt){
		dt=JSON.parse(dt);
		var menuList='';
		level1List=getMenuLevel1(dt);
		$.each(level1List,function (index,el){			
			$('#menuDiv').append('<a'+getMenuHref(el)+getMenuClass(el)+getMenuClick(el)+getDataOptions(el,dt)+'>'+el.SMNAME+'</a>');
		});
	    $.parser.parse();//重新加载样式
		    	}
	);

}

/**
 * 获取顶级菜单
 * @param dt 菜单列表
 * @returns {Array} 最顶级菜单列表
 */
function getMenuLevel1(dt){
	var menuList=[];
	$.each(dt,function (index,el){
		if(el.PARENTSMID==undefined){
			menuList.push(el);
		}
	});
	
	return menuList;
}

/**
 * 获取子菜单
 * @param curMenu 当前菜单对象
 * @param dt 菜单列表
 * @returns {Array} 当前菜单子菜单列表
 */
function getSubMenus(curMenu,dt){
	var subMenuList=[];
	$.each(dt,function (index,el){
		if(el.PARENTSMID==curMenu.SMID){
			subMenuList.push(el);
		}
	});
	
	return subMenuList;
}

/**
 * 解析href属性
 * @param dt
 * @returns
 */
function getMenuHref(dt){
	if(dt.SMHREF==undefined){
		return ' href="javascript:void(0);" ';
	}else if(dt.SMHREF.indexOf('void(0)')>=0){
		return ' href="'+dt.SMHREF+'" '
	}else{
		return ' href="'+basePath+dt.SMHREF+'" ';
	}
}

/**
 * 解析click属性
 * @param dt
 * @returns
 */
function getMenuClick(dt){
	return dt.SMCLICK==undefined?'  ':' onclick="'+dt.SMCLICK+'" ';
}

/**
 * 解析class属性
 * @param dt
 * @returns
 */
function getMenuClass(dt){
	return dt.SMCLASS==undefined?'  ':' class="'+dt.SMCLASS+'" ';
}

/**
 * 解析data-options属性
 * @param dt
 * @param menuList
 */
function getDataOptions(dt,menuList){
	if(dt.SMDATAOPTIONS==undefined){
		return ' ';
	}else{
		if(dt.SMDATAOPTIONS.indexOf('menu')>=0){
			//有子菜单时
			var s1=dt.SMDATAOPTIONS;
			var menuTmpId='';
			s1=s1.substring(s1.indexOf('menu'));
			var tmpArry=s1.split(',');
			if(tmpArry[0]!=''){
				var tmpStr=tmpArry[0];
				tmpStr=tmpStr.substring(tmpStr.indexOf('#')+1,tmpStr.lastIndexOf('\''));
				menuTmpId=tmpStr;
			}
            var subMenuList=getSubMenus(dt,menuList);
            var subMenuStr='';
            var tmpSubMenu=document.getElementById(menuTmpId);
            if(tmpSubMenu!=null){
            	removeElement(tmpSubMenu);
            }
            subMenuStr=('<div id="'+menuTmpId+'" >');
			$.each(subMenuList,function (index,el){
				subMenuStr+=('<div '+getMenuClick(el)+' >'+el.SMNAME+'</div>');
			});
			subMenuStr+=('</div>');
			$('#menuDiv').append(subMenuStr);
		}
		//无子菜单时
		return ' data-options="'+dt.SMDATAOPTIONS+'" ';
		
	}
}

/**
 * 载入用户列表页
 */
function userListPage(){
	loadPage('userListPage');
}

/**
 * 载入用户添加页
 */
function userAddPage(){
	loadPage('userAddPage');
}

/**
 * 载入角色列表页
 */
function roleListPage(){
	loadPage('roleListPage');
}

/**
 * 载入角色添加页
 */
function roleAddPage(){
	loadPage('roleAddPage');
}

/**
 * 载入权限列表页
 */
function permissionListPage(){
	loadPage('permissionListPage');
}

/**
 * 载入权限添加页
 */
function permissionAddPage(){
	loadPage('permissionAddPage');
}

/**
 * 载入功能列表页
 */
function functionListPage(){
	loadPage('functionListPage');
}

/**
 * 载入功能添加页
 */
function functionAddPage(){
	loadPage('functionAddPage');
}

/**
 * 载入菜单列表页
 */
function menuListPage(){
	loadPage('menuListPage');
}

/**
 * 载入菜单添加页
 */
function menuAddPage(){
	loadPage('menuAddPage');
}

/**
 * 修改我的密码外部按钮
 */
function myPassPage(){
	loadPage('userPassPage?suId=');
}

/**
 * 运营商列表页
 */
function carrierListPage(){
	loadPage('carrierListPage');
}

/**
 * 运营商添加页
 */
function carrierAddPage(){
	loadPage('carrierAddPage');
}

/**
 * 组织列表页
 */
function organizeListPage(){
	loadPage('organizeListPage');
}

/**
 * 组织添加页
 */
function organizeAddPage(){
	loadPage('organizeAddPage');
}

