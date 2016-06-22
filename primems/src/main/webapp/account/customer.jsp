<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<jsp:include page="../include/header.jsp">
		<jsp:param name="title" value="Account" />
	</jsp:include>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
</head>
<body>
	<div class="container-fluid">
		<jsp:include page="../include/links.jsp" />
		<div class="page-header">
			<h2>Edit Customer</h2>
		</div>
		<div class="row">
			<ul class="nav nav-tabs">
				<li role="presentation"><a href="../account/products">My Products</a></li>
				<li role="presentation" class="active"><a href="#">My profile</a></li>
			</ul>
		</div>
		<form:form method="post" commandName="customer">
			<table class="table">
				<tr>
					<td>FirstName:</td>
					<td><form:input path="firstName" required="required" class="form-control"/></td>
				</tr>
				<tr>
					<td>LastName:</td>
					<td><form:input path="lastName" required="required" class="form-control"/></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><form:input path="email" required="required" class="form-control"/></td>
				</tr>
				<tr>
					<td>UserName:</td>
					<td>${customer.userName}</td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:password path="password" class="form-control"/></td>
				</tr>
				<tr>
					<td>gender:</td>
					<td>
						<form:select path="gender" class="form-control">
							<form:options items="${genderMap}" />
						</form:select>
					</td>
				</tr>

				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="Save" class="btn btn-default"/>
						<form:hidden path="id"/>
					</td>
				</tr>
				
			</table>
		</form:form>
	</div>
</body>
</html>