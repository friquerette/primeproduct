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
	<jsp:useBean id="products" scope="request" type="java.util.List" />
</head>
<body>
	<div align="center" class="container-fluid">
		<jsp:include page="include/links.jsp" />
		<div class="page-header">
			<h2>Welcome</h2>
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
					<c:forEach items="${products}" var="product">
						<tr>
							<td>${product.id}</td>
							<td>${product.title}</td>
							<td>${product.price}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
