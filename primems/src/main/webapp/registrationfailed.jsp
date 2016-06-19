<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
</head>
<body>
    <div align="center">
        <form:form action="register" method="post" commandName="customer">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Register with success</h2></td>
                </tr>
                <tr>
                    <td>First Name:</td>
                    <td>${customer.firstName}</td>
                </tr>
                <tr>
                    <td>Last Name:</td>
                    <td>${customer.lastName}</td>
                </tr>
                <tr>
                    <td>UserName:</td>
                    <td>${customer.username}</td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td>${customer.password}</td>
                </tr>
                <tr>
                    <td>E-mail:</td>
                    <td>${customer.email}</td>
                </tr>
                <tr>
                    <td>Birthdate (mm/dd/yyyy):</td>
                    <td>${customer.birthdate}</td>
                </tr>

                <tr>
                    <td colspan="2" align="center">
                    	<a href="./">back to home</a>
                   	</td>
                </tr>
            </table>
        </form:form>
    </div>
</body>
</html>