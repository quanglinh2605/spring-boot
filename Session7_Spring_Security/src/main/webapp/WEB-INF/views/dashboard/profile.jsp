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
	
	<h3>Profile</h3>
	${msg }
	<s:form method="post" modelAttribute="user" 
		action="${pageContext.request.contextPath }/dashboard/profile">
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
					<c:set var="checked" value="0"></c:set>
					<c:forEach var="userRole" items="${user.userRoles }">
						<c:if test="${role.id == userRole.id.roleid }">
							<c:set var="checked" value="1"></c:set>
						</c:if>
					</c:forEach>
					<input type="checkbox" name="roles" value="${role.id }" ${checked == 1 ? 'checked="checked"' : "" }> ${role.name }
				</li>
			</c:forEach>
		</ul>
		<input type="submit" value="Save">
		<s:hidden path="id"/>
	</s:form>
	
</body>
</html>