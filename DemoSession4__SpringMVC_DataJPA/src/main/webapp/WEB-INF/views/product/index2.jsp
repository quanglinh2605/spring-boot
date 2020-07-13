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
			<th>Name</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Status</th>
			<th>Description</th>
		</tr>
		<tr>
			<td>${ product.id }</td>
			<td>${ product.name }</td>
			<td>${ product.price }</td>
			<td>${ product.quantity }</td>
			<td>${ product.status }</td>
			<td>${ product.description }</td>
		</tr>

	</table>
</body>
</html>