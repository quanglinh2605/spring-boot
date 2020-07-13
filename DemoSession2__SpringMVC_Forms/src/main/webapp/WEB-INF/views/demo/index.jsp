<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Demo</h3>
	Age: ${sessionScope.age};
	<br>
	Username: ${sessionScope.username}
	<a href="${pageContext.request.contextPath}/demo/remove">Remove</a>
</body>
</html>