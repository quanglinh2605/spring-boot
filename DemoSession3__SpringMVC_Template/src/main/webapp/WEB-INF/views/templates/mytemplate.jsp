<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<a href="${pageContext.request.contextPath }/home">Home</a> | 
	<a href="${pageContext.request.contextPath }/aboutus">About Us</a> | 
	<a href="${pageContext.request.contextPath }/news">News</a>
	<br><br>
	<tiles:insertAttribute name="content"></tiles:insertAttribute>
	<br><br>
	Copyright
	
</body>
</html>