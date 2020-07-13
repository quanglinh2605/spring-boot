<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<div class="top-header" style="background: #fff; margin-top: -7px">
	<div class="logo">
		<a href="/"><img
			src="${pageContext.request.contextPath }/resources/images/logo.png"
			alt=""></a>
		<p>Movie Theater</p>
	</div>
	<hr>
	<div class="clearfix"></div>

</div>
<div class="containt">
	<div class="row">
		<div class="col-3 col-md-3 col-lg-3"></div>
		<div class="col-3 col-md-3 col-lg-3">
			<div>
				<h3>Please check your email</h3>
			</div>
			<a href="${pageContext.request.contextPath }/login">Back to Login</a>
		</div>
	</div>
</div>

