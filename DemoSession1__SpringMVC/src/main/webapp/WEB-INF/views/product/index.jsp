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
	
	<h3>Product List</h3>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Photo</th>
			<th>Price</th>
		</tr>
		<c:forEach var="p" items="${products }">
			<tr>
				<td>${p.id }</td>
				<td>${p.name }</td>
				<td>
					<img src="${pageContext.request.contextPath }/resources/images/${p.photo}" 
					width="120" height="100">
				</td>
				<td>${p.price }</td>
			</tr>
		</c:forEach>
	</table>
	
	<h3>Product Info</h3>
	<table border="1">
		<tr>
			<td>Id</td>
			<td>${product.id }</td>
		</tr>
		<tr>
			<td>Name</td>
			<td>${product.name }</td>
		</tr>
		<tr>
			<td>Price</td>
			<td>${product.price }</td>
		</tr>
		<tr>
			<td>Photo</td>
			<td>
				<img src="${pageContext.request.contextPath }/resources/images/${product.photo}" 
					width="120" height="100">
			</td>
		</tr>
	</table>
	
</body>
</html>