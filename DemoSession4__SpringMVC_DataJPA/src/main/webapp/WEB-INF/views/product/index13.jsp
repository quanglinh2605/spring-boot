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
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Price</th>
			<th>Description</th>
		</tr>
		<c:forEach var="item" items="${products}">
			<tr>
				<td>${ item.id }</td>
				<td>${ item.name }</td>
				<td>${ item.price }</td>
				<td>${ item.description }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>