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
	<jsp:useBean id="products" scope="request" type="java.util.List" />
</head>
<body>
	<div class="container-fluid">
		<jsp:include page="../include/links.jsp" />
		<div class="page-header">
			<h2>Admin > Products</h2>
			<!-- <a href="./edit/new">new product</a> -->
		</div>
		<div class="row">
			<ul class="nav nav-tabs">
				<li role="presentation"><a href="../categories/all">Categories</a></li>
				<li role="presentation" class="active"><a href="#">Product</a></li>
				<li role="presentation"><a href="../customers/all">Customer</a></li>
			</ul>
		</div>
		<div class="row">
			<table class="table">
				<thead>
					<tr>
						<th>ID</th>
						<th>Title</th>
						<th>Price</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${products}" var="pro">
						<tr>
							<td>${pro.id}</td>
							<td>${pro.title}</td>
							<td>${pro.price}</td>
							<td><a href="<c:url value='./edit/${pro.id}' />" class="glyphicon glyphicon-edit"></a></td>
							<td><a href="<c:url value='./delete/${pro.id}' />" class="glyphicon glyphicon-trash"></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
