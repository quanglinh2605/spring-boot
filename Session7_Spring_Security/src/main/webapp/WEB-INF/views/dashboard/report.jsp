<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
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
	<a href="${pageContext.request.contextPath }/dashboard/logout">Logout</a>
	<sec:authorize access="hasRole('ROLE_SUPER_ADMIN')">
		<h3>Category Management</h3>
		<ul>
			<li><a href="#">Add</a></li>
			<li><a href="#">List</a></li>
		</ul>
	</sec:authorize>
	
	<sec:authorize access="hasRole('ROLE_SUPER_ADMIN') or hasRole('ROLE_ADMIN')">
		<h3>Product Management</h3>
		<ul>
			<li><a href="#">Add</a></li>
			<li><a href="#">List</a></li>
		</ul>
	</sec:authorize>
	
	<sec:authorize access="hasRole('ROLE_SUPER_ADMIN') or hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYEE')">
		<h3>Invoice Management</h3>
		<ul>
			<li><a href="#">Add</a></li>
			<li><a href="#">List</a></li>
		</ul>
	</sec:authorize>


</body>
</html>