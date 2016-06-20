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
		<a href="../">back</a>
		<div class="page-header">
			<h1>${product.title}</h1>
		</div>
		<div class="row">
			<div class="col-md-4">${product.id}</div>
		</div>
		<div class="row">
			<div class="col-md-6 col-md-offset-3" id="description">
				Description : <h3>${product.description}</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6 col-md-offset-3" id="description">
				Price : <h3>$ {product.price}</h3>
			</div>
		</div>
	</div>
</body>
</html>
