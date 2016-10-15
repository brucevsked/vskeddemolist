<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>用户列表</title>
    <script type="text/javascript" src="static/js/jquery-2.0.3.min.js"></script>
</head>
<body>
<h1>${message }</h1>

<h1>用户列表<shiro:hasPermission name="user:add">--<a href="/user/add.html">添加用户</a></shiro:hasPermission>---<a href="/logout.html">退出登录</a></h1>

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
            <shiro:hasPermission name="user:update">----<a href="/user/edit.html?id=${user.id}">修改用户</a></shiro:hasPermission>
            <shiro:hasPermission name="user:del">----<a href="javascript:void(0);" class="del" ref="${user.id }">删除用户</a></shiro:hasPermission>
        </li>
    </c:forEach>
</ul>
<script type="text/javascript">
    $(function () {
        $(".del").click(function () {
            var id = $(this).attr("ref");
            $.ajax({
                type: "GET",
                url: "/user/del.html?id="+id,
                success: function (e) {
                    alert("删除成功(不是真删除，测试而已)");
                },
                error: function(json){
                    alert("删除失败");
                }
            });
        });
    });
</script>
</body>
</html>