<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<jsp:include page="include/header.jsp">
		<jsp:param name="title" value="Login" />
	</jsp:include>
</head>
  <body>
<body>
	<div align="center" class="container-fluid">
		<jsp:include page="include/links.jsp" />
        <form name="f" th:action="@{/login}" method="post">
                <h2>Please Login</h2>
                <!-- 
                <div th:if="${param.error}" class="alert alert-error">    
                    Invalid username and password.
                </div>
                <div th:if="${param.logout}" class="alert alert-success"> 
                    You have been logged out. 
                </div>
                -->
                <div>
	                <label for="username">Username</label>
	                <input type="text" id="username" name="username"/>
                </div> 
                <div>
                <label for="password">Password</label>
                <input type="password" id="password" name="password"/>
                </div>     
                <div class="form-actions">
                    <button type="submit" class="btn btn-default">Log in</button>
                </div>
        </form>
	</div>
  </body>
</html>
