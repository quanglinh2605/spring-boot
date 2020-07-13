<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath }/resources/css/style.css" 
	rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath }/resources/js/lib1.js" 
	type="text/javascript"></script>
</head>
<body>
	
	<a href="${pageContext.request.contextPath }/account/login">Login</a>
	<br>
	<form method="post" action="${pageContext.request.contextPath }/demo/save">
		Keyword <input type="text" name="keyword">
		<br>
		Price <input type="text" name="price">
		<br>
		Quantity 1 <input type="text" name="quantity">
		<br>
		Quantity 2 <input type="text" name="quantity">
		<br>
		Quantity 3 <input type="text" name="quantity">
		<br> 
		<input type="submit" value="Search">
	</form>
	<br>
	<a href="${pageContext.request.contextPath }/demo/index2">Link 1</a> | 
	<a href="${pageContext.request.contextPath }/demo/index3/p01">Link 2</a> |
	<a href="${pageContext.request.contextPath }/product/index">Product Details</a> | 
	<br>
	<span class="format">Hello World</span>
	<br>
	<img onclick="clickMe()" src="${pageContext.request.contextPath }/resources/images/thumb1.gif">
	
</body>
</html>