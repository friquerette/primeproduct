<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
<meta name="viewport" content="initial-scale=1, maximum-scale=1">
<link rel='stylesheet'
	href='/primems/webjars/bootstrap/3.3.6/css/bootstrap.min.css'>
<script type="text/javascript"
	src="/primems/webjars/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript"
	src="/primems/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
	<div align="center">
		<form:form method="post" commandName="customer">
			<table border="0">
				<tr>
					<td colspan="2" align="center"><h2>Registration form</h2></td>
				</tr>
				<tr>
					<td>First Name:</td>
					<td><form:input path="firstName" required="required" /></td>
				</tr>
				<tr>
					<td>Last Name:</td>
					<td><form:input path="lastName" required="required" /></td>
				</tr>
				<tr>
					<td>UserName:</td>
					<td><form:input path="userName" required="required" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:password path="password" required="required" /></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><form:input path="email" required="required" /></td>
				</tr>
				<tr>
					<td>Gender:</td>
					<td>
						<form:select path="gender">
							<form:options items="${genderList}" />
						</form:select>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Register" />
						<form:hidden path="role" />
						<form:hidden path="enabled" />
					</td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>