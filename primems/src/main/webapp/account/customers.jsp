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
	<jsp:useBean id="customers" scope="request" type="java.util.List" />
</head>
<body>
	<jsp:include page="../include/links.jsp" />
	<div class="container-fluid">
		<div class="page-header">
			<h1>Purchase Requests</h1>
		</div>
		<a href="../../logout">logout</a>
		<div class="row">
			<ul class="nav nav-tabs">
				<li role="presentation" class="active"><a href="#">Saved</a></li>
				<li role="presentation"><a href="#">Submitted</a></li>
				<li role="presentation"><a href="#">Approved</a></li>
			</ul>
		</div>
		<div class="row">
			<table class="table">
				<thead>
					<tr>
						<th>ID</th>
						<th>First Name</th>
						<th>Last Name</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${customers}" var="customer">
						<tr>
							<td>${customer.id}</td>
							<td>${customer.firstName}</td>
							<td>${customer.lastName}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>


</body>
</html>
