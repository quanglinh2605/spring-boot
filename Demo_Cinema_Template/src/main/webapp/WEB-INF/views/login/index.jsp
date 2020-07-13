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
			<c:if test="${errLogin != null }">
				<div class="alert alert-danger" role="alert"> ${errLogin }</div>
			</c:if>
			<s:form method="post" modelAttribute="user"
				style="padding-top: 50px; padding-bottom:10px"
				enctype="multipart/form-data"
				action="${pageContext.request.contextPath }/login/sigin">

				<div class="form-group">

					<label for="formGroupExampleInput">Username:</label>
					<s:input class="form-control" path="username"
						placeholder="username ..." required="required" />
					<span style="color: red"><s:errors path="username"></s:errors>
					</span>
				</div>
				<div class="form-group">
					<label for="formGroupExampleInput">Password:</label>
					<s:password class="form-control" path="password"
						placeholder="password ..." />
					<span style="color: red"><s:errors path="password"></s:errors>
					</span>
				</div>
				<div class="form-check">
					<input type="checkbox" class="form-check-input" id="exampleCheck1">
					<label class="form-check-label" for="exampleCheck1">Remember
						me</label>
				</div>
				<div class="form-group">
					&nbsp; <input class="btn btn-info" type="submit" value="Login">
				</div>
				<s:hidden path="id" />
			</s:form>
			<div style="color: red; margin-bottom: 20px">
			<a  href="${pageContext.request.contextPath }/login/index3">For got password</a><br>
			<a  href="${pageContext.request.contextPath }/login/index2">If you don't have a account, register here.</a>
			</div>
		</div>
	</div>
</div>

