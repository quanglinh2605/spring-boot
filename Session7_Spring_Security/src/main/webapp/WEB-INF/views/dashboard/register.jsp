<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h3>Register</h3>
	${msg }
	<s:form method="post" modelAttribute="user" 
		action="${pageContext.request.contextPath }/dashboard/register">
		Username <s:input path="username"/>
		<br>
		Password <s:password path="password"/>
		<br>
		Status <s:checkbox path="enabled"/>
		<br>
		<h4>Roles:</h4>
		<ul>
			<c:forEach var="role" items="${roles }">
				<li>
					<input type="checkbox" name="roles" value="${role.id }"> ${role.name }
				</li>
			</c:forEach>
		</ul>
		<input type="submit" value="Save">
	</s:form>
	
</body>
</html>