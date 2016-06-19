<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<jsp:include page="include/header.jsp">
		<jsp:param name="title" value="Registration success" />
	</jsp:include>
</head>
<body>
	<jsp:include page="include/links.jsp" />
	<div align="center">
		<form:form action="register" method="post" commandName="customer">
			<table border="0">
				<tr>
					<td colspan="2" align="center"><h2>Register with success</h2></td>
				</tr>
				<tr>
					<td>First Name:</td>
					<td>${customer.firstName}</td>
				</tr>
				<tr>
					<td>Last Name:</td>
					<td>${customer.lastName}</td>
				</tr>
				<tr>
					<td>UserName:</td>
					<td>${customer.userName}</td>
				</tr>
				<tr>
					<td>E-mail:</td>
					<td>${customer.email}</td>
				</tr>
				<!-- 
				<tr>
					<td>Birthdate (mm/dd/yyyy):</td>
					<td>${customer.birthdate}</td>
				</tr>
 				-->
			</table>
		</form:form>
	</div>
</body>
</html>