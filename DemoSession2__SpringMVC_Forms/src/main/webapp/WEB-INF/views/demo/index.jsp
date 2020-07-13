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
	age: ${sessionScope.age }
	<br>
	username: ${sessionScope.username }
	<br>
	<a href="${pageContext.request.contextPath }/demo/remove">Remove Session</a>


</body>
</html>