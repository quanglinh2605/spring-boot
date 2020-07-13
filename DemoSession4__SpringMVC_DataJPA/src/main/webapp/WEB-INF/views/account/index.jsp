<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>List Product</h3>
	<form method="post" action="${ pageContext.request.contextPath}/account/search">
		Username: <input type="text" name="keyword">
		<input type = "submit" value="Search">
	</form>
	<br></br>
	<form method="post" action="${ pageContext.request.contextPath}/account/listbymonth">
		Month: <input type="text" name="month">
		<input type = "submit" value="Search">
	</form>
	<br></br>
	<form method="post" action="${ pageContext.request.contextPath}/account/login">
			Username: <input type="text" name="username">
		<br>Password: <input type="password" name="password">
		<br>
		<input type = "submit" value="Login">
		<br>${msg}
	</form>
	<br>
	<a href="${ pageContext.request.contextPath }/account/listbyAge">User elder 25 years old</a>
	<br></br>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Username</th>
			<th>Fullname</th>
			<th>Birthday</th>			
		</tr>
		<c:forEach var="item" items="${accounts}">
			<tr>
				<td>${ item.id }</td>
				<td>${ item.username }</td>
				<td>${ item.fullname }</td>
				<td>${ item.birthday }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>