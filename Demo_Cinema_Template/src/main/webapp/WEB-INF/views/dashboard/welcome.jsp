<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Welcome ${pageContext.request.userPrincipal.name }</h3>
		<a class="btn btn-success" href="${ pageContext.request.contextPath }/dashboard/logout">Logout</a>
</body>
</html>