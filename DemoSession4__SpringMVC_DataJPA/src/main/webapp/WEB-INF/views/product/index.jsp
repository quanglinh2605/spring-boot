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
	<a href="${ pageContext.request.contextPath }/product/add">Add</a>
	<form method="get" action="${ pageContext.request.contextPath }/product/Search">
		Keyword <input type="text" name="keyword" value="${ keyword}">
		<input type="submit" value="Search"/>
	</form>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Status</th>
			<th>Description</th>
			<th>Action</th>
		</tr>
		<c:forEach var="item" items="${products}">
			<tr>
				<td>${ item.id }</td>
				<td>${ item.name }</td>
				<td>${ item.price }</td>
				<td>${ item.quantity }</td>
				<td>${ item.status }</td>
				<td>${ item.description }</td>
				<td>
					<a href="${ pageContext.request.contextPath}/product/delete/${item.id}">Delete</a>|
					<a href="${ pageContext.request.contextPath}/product/edit/${item.id}">Edit</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>