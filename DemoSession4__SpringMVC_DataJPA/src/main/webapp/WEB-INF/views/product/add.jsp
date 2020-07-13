<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<s:form method="post" modelAttribute="product" action="${pageContext.request.contextPath}/product/add">
		<table>
			<tr>
				<td>Name</td>
				<td><s:input path="name"/></td>
			</tr>
			
			<tr>
				<td>Price</td>
				<td><s:input path="price"/></td>
			</tr>
			<tr>
				<td>Quantity</td>
				<td><s:input path="quantity"/></td>
			</tr>
			<tr>
				<td>Status</td>
				<td><s:checkbox path="status"/></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><s:textarea path="description" cols="20" rows="5"/></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="save"/></td>
			</tr>
		</table>
	</s:form>
</body>
</html>