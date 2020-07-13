<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h3>Login Page</h3>
	${msg }
	<form method="post" action="${pageContext.request.contextPath }/dashboard/process-login">
		Username <input type="text" name="username">
		<br>
		Password <input type="password" name="password">
		<br>
		<input type="submit" value="Login">
		<br>
		<a href="${pageContext.request.contextPath }/dashboard/register">Register</a>
	</form>
	
</body>
</html>