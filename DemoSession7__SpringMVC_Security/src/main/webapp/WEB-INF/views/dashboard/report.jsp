<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Report Page</h3>
	<sec:authorize access="hasRole('ROLE_SUPER_ADMIN')">
		<h3>Category Management</h3>
		<ul>
			<li><a href="#">Menu 1</a>
			<li><a href="#">Menu 2</a>
			<li><a href="#">Menu 3</a>
		</ul>
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_SUPER_ADMIN') or hasRole('ROLE_ADMIN')">
		<h3>Product Management</h3>
		<ul>
			<li><a href="#">Menu 1</a>
			<li><a href="#">Menu 2</a>
			<li><a href="#">Menu 3</a>
		</ul>
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_SUPER_ADMIN') or hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYEE')">
		<h3>Invoice Management</h3>
		<ul>
			<li><a href="#">Menu 1</a>
			<li><a href="#">Menu 2</a>
			<li><a href="#">Menu 3</a>
		</ul>
	</sec:authorize>
	<a href="${ pageContext.request.contextPath }/dashboard/logout">Logout</a>
</body>
</html>