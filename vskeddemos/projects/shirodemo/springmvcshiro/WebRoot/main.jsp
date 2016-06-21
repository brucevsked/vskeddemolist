<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE HTML >
<html>
	<head>

		<title>My JSP 'main.jsp' starting page</title>
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>
		<ul>
			<li>
				<h2>
					<a target="_self" href="user.html?myjsp">myjsp</a>
				</h2>
			</li>
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
