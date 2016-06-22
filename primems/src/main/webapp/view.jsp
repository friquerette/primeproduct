<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<jsp:include page="include/header.jsp">
	<jsp:param name="title" value="Home" />
</jsp:include>
</head>
<body>
	<div align="center" class="container-fluid">
		<jsp:include page="include/links.jsp" />

		<table class="table">
			<tr>
				<td><a href="../" class="glyphicon glyphicon-arrow-left">
						Back</a></td>
				<td></td>
			</tr>
			<tr>
				<td>Title:</td>
				<td><h3>${product.title}</h3></td>
			</tr>
			<tr>
				<td>Category:</td>
				<td>${product.categoryLabel}</td>
			</tr>
			<tr>
				<td>Description:</td>
				<td>${product.description}</td>
			</tr>
			<tr>
				<td>Price:</td>
				<td>${product.price}</td>
			</tr>
			<tr>
				<td>Currency:</td>
				<td>${product.currency}</td>
			</tr>
		</table>
	</div>
</body>
</html>
