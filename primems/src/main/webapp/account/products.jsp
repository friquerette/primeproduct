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
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<jsp:useBean id="products" scope="request" type="java.util.List" />
</head>
<body>
	<div class="container-fluid">
		<jsp:include page="../include/links.jsp" />
		<div class="page-header">
			<h2>My Products</h2>
		</div>
		<div class="row">
			<ul class="nav nav-tabs">
				<li role="presentation" class="active"><a href="#">My Products</a></li>
				<li role="presentation"><a href="../customer/edit">My profile</a></li>
			</ul>
		</div>
		<div class="row">
			<table class="table">
				<thead>
					<tr>
						<th>ID</th>
						<th>Category</th>
						<th>Title</th>
						<th>Price</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${products}" var="pro">
						<tr>
							<td>${pro.id}</td>
							<td>${pro.category.label}</td>
							<td>${pro.title}</td>
							<td>${pro.price}</td>
							<td><a href="<c:url value='./edit/${pro.id}' />" class="glyphicon glyphicon-edit"></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
