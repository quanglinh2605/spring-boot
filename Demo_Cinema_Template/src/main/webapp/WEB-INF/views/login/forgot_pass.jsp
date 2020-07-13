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
			<form method="post"
				style="padding-top: 50px; padding-bottom:10px"
				action="${pageContext.request.contextPath }/login/f_pass">

				<div class="form-group">

					<label for="formGroupExampleInput">Enter email to get password:</label>
					<input class="form-control" type="text" name="mail"
						placeholder="email ..." required="required" />
					<span style="color: red"><s:errors path="username"></s:errors>
					</span>
				</div>
				
				<div class="form-group">
					&nbsp; <input class="btn btn-info" type="submit" value="Submit">
				</div>
				
			</form>
			
		</div>
	</div>
</div>

