<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<s:form method="post" modelAttribute="account"
		action="${pageContext.request.contextPath }/account/save">
		<table>
			<tr>
				<td>Username</td>
				<td><s:input path="username" required="required" /></td>
				<td><s:errors path="username"></s:errors></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><s:password path="password" /></td>
				<td><s:errors path="password"></s:errors></td>
			</tr>
			<tr>
				<td>Age</td>
				<td><s:input path="age" /></td>
				<td><s:errors path="age"></s:errors></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><s:input path="email" /></td>
				<td><s:errors path="email"></s:errors></td>
			</tr>
			<tr>
				<td>Website</td>
				<td><s:input path="website" /></td>
				<td><s:errors path="website"></s:errors></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="Save" /></td>
			</tr>
		</table>
	</s:form>

</body>
</html>