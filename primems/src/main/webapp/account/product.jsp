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
		<form:form method="post" commandName="product">
			<table class="table">
				<tr>
					<th colspan="2">
					<h2>User - Edit Product</h2>
					</th>
				</tr>
				<tr>
					<td>Title:</td>
					<td><form:input path="title" required="required" class="form-control"/></td>
				</tr>
				<tr>
					<td>Description:</td>
					<td><form:input path="description" class="form-control"/></td>
				</tr>
				<tr>
					<td>Price:</td>
					<td><form:input path="price" class="form-control"/></td>
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