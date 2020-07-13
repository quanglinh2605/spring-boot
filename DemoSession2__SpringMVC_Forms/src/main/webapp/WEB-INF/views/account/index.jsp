<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {
		$("#birthday").datepicker();
	});
</script>

</head>
<body>
	
	<a href="${pageContext.request.contextPath }/demo">Session</a>
	<h3>Register</h3>
	<s:form method="post" modelAttribute="account" enctype="multipart/form-data" 
		action="${pageContext.request.contextPath }/account/save">
		<table>
			<tr>
				<td>Username</td>
				<td><s:input path="username" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><s:password path="password" /></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><s:textarea path="description" cols="20" rows="5" /></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><s:radiobutton path="gender" value="m" /> Male <br> <s:radiobutton
						path="gender" value="f" /> Female</td>
			</tr>
			<tr>
				<td>Certificates</td>
				<td><s:radiobuttons path="certificate" items="${certificates }"
						itemLabel="name" itemValue="id" /></td>
			</tr>
			<tr>
				<td>Status</td>
				<td><s:checkbox path="status" /></td>
			</tr>
			<tr>
				<td>Roles</td>
				<td><s:checkboxes items="${roles }" itemLabel="name"
						itemValue="id" path="roles" /></td>
			</tr>
			<tr>
				<td>Department</td>
				<td><s:select path="department" items="${departments }"
						itemLabel="name" itemValue="id"></s:select></td>
			</tr>
			<tr>
				<td>Birthday</td>
				<td><s:input path="birthday" id="birthday"/></td>
			</tr>
			<tr>
				<td>Photo</td>
				<td><input type="file" name="file"/></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="Save"></td>
			</tr>
		</table>
		<s:hidden path="id" />
	</s:form>

</body>
</html>