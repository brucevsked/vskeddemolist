<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
request.setAttribute("basePath", basePath);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="${basePath }">
    <title>用户列表</title>
    <script type="text/javascript" src="static/js/jquery-2.0.3.min.js"></script>
</head>
<body>
<h1>${message }</h1>

<h1>用户列表<shiro:hasPermission name="user:add">--<a href="${basePath }user">添加用户</a></shiro:hasPermission>---
<a href="${basePath }logout">退出登录</a></h1>

<button type="button" onclick="add()">add</button>
<button type="button" onclick="query()">query</button>
<button type="button" onclick="edit()">edit</button>
<button type="button" onclick="del()">del</button>
<button type="button" onclick="patch()">patch</button>

<br>权限结果
<div id="permissionResult"></div>

<h2>权限列表</h2>
<shiro:authenticated>用户已经登录显示此内容</shiro:authenticated><br/>
<shiro:hasRole name="manager">manager角色登录显示此内容</shiro:hasRole><br/>
<shiro:hasRole name="admin">admin角色登录显示此内容</shiro:hasRole><br/>
<shiro:hasRole name="normal">normal角色登录显示此内容</shiro:hasRole><br/>
<shiro:hasRole name="user"><p style="color: red;">测试专用！！</p></shiro:hasRole>
<shiro:hasAnyRoles name="manager,admin">**manager or admin 角色用户登录显示此内容**</shiro:hasAnyRoles><br/>

<p>============================我是邪恶的分割线==========================</p>

<shiro:principal/>-显示当前登录用户名<br/>
<shiro:hasPermission name="user:add">user:add权限用户显示此内容</shiro:hasPermission><br/>
<shiro:hasPermission name="user:del">user:del权限用户显示此内容</shiro:hasPermission><br/>
<shiro:hasPermission name="user:update">user:update权限用户显示此内容</shiro:hasPermission><br/>
<shiro:hasPermission name="user:query">user:query权限用户显示此内容</shiro:hasPermission><br/>
<shiro:lacksPermission name="user:add">不具有user:add权限用户显示此内容</shiro:lacksPermission><br/>
<shiro:lacksPermission name="user:del">不具有user:del权限用户显示此内容</shiro:lacksPermission><br/>
<shiro:lacksPermission name="user:update">不具有user:update权限用户显示此内容</shiro:lacksPermission><br/>
<shiro:lacksPermission name="user:query">不具有user:query权限用户显示此内容</shiro:lacksPermission><br/>

<shiro:hasPermission name="user:query">所有用户列表<br/></shiro:hasPermission>
<ul>
    <c:forEach items="${userList }" var="user">
        <li><shiro:hasPermission name="user:query">用户名：${user.username }</shiro:hasPermission>
            <shiro:hasPermission name="user:query">----密码：${user.password }</shiro:hasPermission>
            <shiro:hasPermission name="user:update">----<a href="${basePath }user/edit?id=${user.id}">修改用户</a></shiro:hasPermission>
            <shiro:hasPermission name="user:del">----<a href="javascript:void(0);" class="del" ref="${user.id }">删除用户</a></shiro:hasPermission>
        </li>
    </c:forEach>
</ul>
<script type="text/javascript">
var basePath=document.getElementsByTagName('base')[0].href;
    $(function () {
        $(".del").click(function () {
            var id = $(this).attr("ref");
            $.ajax({
                type: "GET",
                url: "/user/del?id="+id,
                success: function (e) {
                    alert("删除成功(不是真删除，测试而已)");
                },
                error: function(json){
                    alert("删除失败");
                }
            });
        });
    });
    
    function add(){
		$.ajax({
    		type:'post',
    		url :basePath+'user',
    		data:{ suId: 1 },
    		success:function (dt){
    			console.log(dt)
    			$('#permissionResult').html(dt);
    	    },
    	    error:function (XMLHttpRequest, textStatus, errorThrown){
    	    	if(XMLHttpRequest.status=405){
        	    	console.log('无权限操作该资源');
        	    	$('#permissionResult').html('无权限操作该资源');
    	    	}

    	    },
    	    dataType: 'html'
    	});
    }
    
    function query(){
		$.ajax({
    		type:'get',
    		url :basePath+'user',
    		data:{ suId: 1 },
    		success:function (dt){
    			console.log(dt)
    			$('#permissionResult').html(dt);
    	    },
    	    error:function (rs){
    	    	if(XMLHttpRequest.status=405){
        	    	console.log('无权限操作该资源');
        	    	$('#permissionResult').html('无权限操作该资源');
    	    	}
    	    },
    	    dataType: 'html'
    	});
    }
    
    function edit(){
		$.ajax({
    		type:'put',
    		url :basePath+'user',
    		data:{ suId: 1 },
    		success:function (dt){
    			console.log(dt)
    			$('#permissionResult').html(dt);
    	    },
    	    error:function (rs){
    	    	if(XMLHttpRequest.status=405){
        	    	console.log('无权限操作该资源');
        	    	$('#permissionResult').html('无权限操作该资源');
    	    	}
    	    },
    	    dataType: 'html'
    	});
    }
    
    function del(){
		$.ajax({
    		type:'delete',
    		url :basePath+'user',
    		data:{ suId: 1 },
    		success:function (dt){
    			console.log(dt)
    			$('#permissionResult').html(dt);
    	    },
    	    error:function (rs){
    	    	if(XMLHttpRequest.status=405){
        	    	console.log('无权限操作该资源');
        	    	$('#permissionResult').html('无权限操作该资源');
    	    	}
    	    },
    	    dataType: 'html'
    	});
    }
    
    function patch(){
		$.ajax({
    		type:'PATCH',
    		url :basePath+'user',
    		data:{ suId: 1 },
    		success:function (dt){
    			console.log(dt)
    			$('#permissionResult').html(dt);
    	    },
    	    error:function (rs){
    	    	if(XMLHttpRequest.status=405){
        	    	console.log('无权限操作该资源');
        	    	$('#permissionResult').html('无权限操作该资源');
    	    	}
    	    },
    	    dataType: 'html'
    	});
    }
</script>
</body>
</html>