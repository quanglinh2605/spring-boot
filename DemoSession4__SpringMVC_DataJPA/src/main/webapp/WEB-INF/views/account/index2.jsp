<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>List Product</h3>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Username</th>
			<th>Fullname</th>
			<th>Birthday</th>
		</tr>
		<tr>
			<td>${ account.id }</td>
			<td>${ account.username }</td>
			<td>${ account.fullname }</td>
			<td>${ account.birthday }</td>
		</tr>
	</table>
	<a href="${ pageContext.request.contextPath }/account/index">Back</a>
</body>
</html>