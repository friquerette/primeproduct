<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<jsp:include page="../include/header.jsp">
		<jsp:param name="title" value="Edit Customer" />
	</jsp:include>
</head>
<body>
	<div class="container-fluid">
		<jsp:include page="../include/links.jsp" />
		<form:form method="post" commandName="customer">
			<table class="table">
				<tr>
					<td><a href="../all" class="glyphicon glyphicon-arrow-left"> Back</a></td>
					<td></td>
				</tr>
				<tr>
					<th colspan="2">
					<h2>Edit Customer</h2>
					</th>
				</tr>
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
					<td><form:input path="userName" required="required" class="form-control"/></td>
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
					<td>Role:</td>
					<td>
						<form:select path="role" class="form-control">
							<form:options items="${roleMap}" />
						</form:select>
					</td>
				</tr>

				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="Save" class="btn btn-default"/>
					</td>
				</tr>
				
			</table>
		</form:form>
	</div>
</body>
</html>