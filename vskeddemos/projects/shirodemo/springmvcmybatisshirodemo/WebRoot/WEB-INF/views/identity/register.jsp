<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<h1>Identity Register</h1>
<p>Thanks for registering!</p>
<strong>Identity ID:</strong>
${identity.id}
<br />
<strong>UserID:</strong>
${identity.userid}
<br />
<strong>Salt:</strong>
${identity.salt}
<br />
<strong>Email:</strong>
${identity.email}
<br />
<strong>Created:</strong>
<fmt:formatDate type="both" dateStyle="long" timeStyle="long"
	value="${identity.created}" />
<br />
<br />
<a href="login">Login</a>
and get all authenticated!
</body>