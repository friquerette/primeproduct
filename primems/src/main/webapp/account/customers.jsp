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
	<jsp:useBean id="customers" scope="request" type="java.util.List" />
</head>
<body>
	<div class="container-fluid">
		<jsp:include page="../include/links.jsp" />
		<div class="page-header">
			<h2>Purchase Requests</h2>
		</div>
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
