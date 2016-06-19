<!DOCTYPE html>
<html lang="en">
<head>
<title>Purchase Requests</title>
<meta name="viewport" content="initial-scale=1, maximum-scale=1">
<link rel='stylesheet'
	href='/primems/webjars/bootstrap/3.3.6/css/bootstrap.min.css'>
<script type="text/javascript" src="/primems/webjars/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript"
	src="/primems/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="customers" scope="request" type="java.util.List" />
</head>
<body>
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
