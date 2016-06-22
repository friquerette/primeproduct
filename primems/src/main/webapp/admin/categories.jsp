<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<jsp:include page="../include/header.jsp">
		<jsp:param name="title" value="Admin" />
	</jsp:include>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<jsp:useBean id="categories" scope="request" type="java.util.List" />
</head>
<body>
	<div class="container-fluid">
		<jsp:include page="../include/links.jsp" />
		<div class="page-header">
			<h2>Admin > Categories</h2>
			<a href="./edit/new">new category</a>
		</div>
		<div class="row">
			<ul class="nav nav-tabs">
				<li role="presentation" class="active"><a href="#">Categories</a></li>
				<li role="presentation"><a href="../products/all">Product</a></li>
				<li role="presentation"><a href="../customers/all">Customer</a></li>
			</ul>
		</div>
		<div class="row">
			<table class="table">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Description</th>
						<th>Parent</th>
						<th>Edit</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${categories}" var="cat">
						<tr>
							<td>${cat.id}</td>
							<td>${cat.name}</td>
							<td>${cat.description}</td>
							<td>${cat.parent.label}</td>
							<td><a href="<c:url value='./edit/${cat.id}' />" class="glyphicon glyphicon-edit"></a></td>
							<td><a href="<c:url value='./delete/${cat.id}' />" class="glyphicon glyphicon-trash"></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>