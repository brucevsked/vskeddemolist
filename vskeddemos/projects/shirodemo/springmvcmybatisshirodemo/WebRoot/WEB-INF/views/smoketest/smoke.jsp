<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<%@ page session="false"%>
<html>
<head>
<title>H57 Shiro Smoketest</title>
<link rel="icon" type="image/vnd.microsoft.icon" href="favicon.ico">
</head>
<body>
	<h1>Welcome to H57 Shiro!</h1>
	<shiro:guest>
		<h2>You are our guest!</h2>
	We would love to make you a more permanent part of the family. <br />
	How about <a href="identity/registration">Registering</a> ?
	</shiro:guest>


	<shiro:user>

		<shiro:authenticated>
			<h2>You are Authenticated!</h2>
			<p>It appears that you were authenticated successfully this
				session, not merely remembered!</p>
		</shiro:authenticated>
		<shiro:notAuthenticated>
			<h2>You are Unauthenticated!</h2>
			<p>
				Don't worry, it doesn't mean we don't remember you. We do!<br />
				But remembering you is subtly different from having you
				authenticated. Someone might have stolen your cookies!<br /> <a
					href="/identity/login">Login</a> and get all authenticated!
			</p>
		</shiro:notAuthenticated>

		<shiro:hasRole name="Test">
			<h2>Test Role</h2>
			<p>Whoot! You actually have a role, even if it is just a test
				role.</p>
		</shiro:hasRole>

		<shiro:hasPermission name="read">
			<h2>You Have Permission</h2>
			<p>To read this test!</p>
		</shiro:hasPermission>
		<c:choose>
			<c:when test='${identity != NULL}'>
				<strong>Identity ID:</strong> ${identity.id}      <br />
				<strong>User ID: </strong> [${identity.userid}]  <br />
			</c:when>
			<c:otherwise>
        It doesn't appear we found an identity. Is there one in the database? <br />
				<strong>Identity ID:</strong> ${identity.id}      <br />
				<strong>User ID: </strong> -${identity.userid}-  <br />
			</c:otherwise>
		</c:choose>
	</shiro:user>
</body>
</html>