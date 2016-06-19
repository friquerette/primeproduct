<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<jsp:include page="include/header.jsp">
		<jsp:param name="title" value="Registration failed" />
	</jsp:include>
</head>
<body>
	<div align="center" class="container-fluid">
		<jsp:include page="include/links.jsp" />
		<div class="bs-docs-header">
			<h2>${message}</h2>
		</div>
	</div>
</body>
</html>