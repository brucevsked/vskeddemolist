<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h1>Identity Registration</h1>

<form:form action="register" commandName="registration" method='post'
	accept-charset='UTF-8'>
	<table>
		<tr>
			<td>UserName:</td>
			<td><form:input path="username" /></td>
			<td><form:errors path="username" cssClass="error" /></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><form:input path="email" /></td>
			<td><form:errors path="email" cssClass="error" /></td>
		</tr>
		<tr>
			<td>Passphrase:</td>
			<td><form:input path="passphrase" /></td>
			<td><form:errors path="passphrase" cssClass="error" /></td>
		</tr>
		<tr>
			<td></td>
			<td><input type='submit' name='Submit' value='Submit' /></td>
		</tr>
	</table>

</form:form>

<style type="text/css">
body {
	background-color: #F8F8F8;
	text-align: left;
	margin: 0;
	padding: 0;
}

.error {
	background-color: #FFF;
	color: red;
	text-align: left;
}
</style>