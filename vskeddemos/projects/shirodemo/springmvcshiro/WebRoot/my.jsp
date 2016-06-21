<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML>
<html>
  <head>
  </head>
  
  <body>
    
    <h2>myjsp</h2>
    <ul>
			<li>
				<h2>
					<a target="_self" href="user.html?notmyjsp">无权访问</a>
				</h2>
			</li>
			<li>
				<h2>
					<a target="_self" href="login.jsp">登录</a>
				</h2>
			</li>
			<li>
				<h2>
					<a target="_self" href="login.html?logout">注销</a>
				</h2>
			</li>
		</ul>
  </body>
</html>
