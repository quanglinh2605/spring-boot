<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#birthday" ).datepicker();
  } );
  </script>

</head>
<body>
	<h3>Register</h3>
	<s:form method="post" modelAttribute="account" enctype="multipart/form-data" action="${pageContext.request.contextPath}/account/save">
		<table>
			<tr>
				<td>Username</td>
				<td>
					<s:input path="username"/>
				</td>
			</tr>
			<tr>
				<td>Password</td>
				<td>
					<s:password path="password"/>
				</td>
			</tr>
			<tr>
				<td>Description</td>
				<td>
					<s:textarea cols="20" rows="5" path="description"/>
				</td>
			</tr>
			<tr>
				<td>Gender</td>
				<td>
					<s:radiobutton path="gender" value="m"/>Male
					<br><s:radiobutton path="gender" value="f"/>Female
				</td>
			</tr>
			<tr>
				<td>Certificate</td>
				<td><s:checkboxes items="${certificates}" path="certificate" itemLabel="name" itemValue="id"></s:checkboxes></td>	
			</tr>
			<tr>
				<td>Status</td>
				<td>
					<s:checkbox path="status"/>
				</td>
			</tr>
			<tr>
				<td>Roles</td>
				<td><s:checkboxes items="${roles}" path="roles" itemLabel="name" itemValue="id"></s:checkboxes></td>	
			</tr>
			<tr>
				<td>Department</td>
				<td><s:select path="department" items="${departments}" itemLabel="name" itemValue="id"></s:select></td>	
			</tr>
			<tr>
				<td>BirthDay</td>
				<td><s:input id="birthday" path="birthday"/></td>	
			</tr>
			<tr>
				<td>Photo</td>
				<td><input type="file" name="file"></td>	
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>
					<input type="submit" value="save">
				</td>
			</tr>
		</table>
		<s:hidden path="id"/>
	</s:form>
</body>
</html>