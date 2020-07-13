<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<h3>Tag3</h3>
<table border="1">
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Price</th>
		<th>Quantity</th>
		<th>Status</th>
		<th>Description</th>
	</tr>
	<c:forEach var="item" items="${ products }">
		<tr>
			<td>${ item.id }</td>
			<td>${ item.name }</td>
			<td>${ item.price }</td>
			<td>${ item.quantity }</td>
			<td>${ item.status }</td>
			<td>${ item.description }</td>
		</tr>
	</c:forEach>
</table>