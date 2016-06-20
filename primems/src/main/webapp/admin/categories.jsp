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
</head>
<body>
	<div class="container-fluid">
		<jsp:include page="../include/links.jsp" />
		<div class="page-header">
			<h2>Admin</h2>
		</div>
		<div class="row">
			<ul class="nav nav-tabs">
				<li role="presentation" class="active"><a href="#">Categories</a></li>
				<li role="presentation"><a href="products">Product</a></li>
				<li role="presentation"><a href="../customers/all">Customer</a></li>
			</ul>
		</div>
	</div>
</body>
</html>
