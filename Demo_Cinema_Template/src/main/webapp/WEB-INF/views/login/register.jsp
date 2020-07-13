<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<script>
	$(function() {
		$("#birthday").datepicker({
			showButtonPanel: true,
		    changeMonth: true,
		    changeYear: true,
		    showOtherMonths: true,
		    selectOtherMonths: true,
		    yearRange: '1950:2005'
			});
	});
</script>
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
		<div class="col-3 col-md-3 col-lg-3" style="margin-left: 10%; margin-right: 10%">
			<c:if test="${errLogin != null }">
				<div class="alert alert-danger" role="alert"> ${errLogin }</div>
			</c:if>
			<s:form method="post" modelAttribute="user"
				style="padding-top: 50px; padding-bottom:50px"
				enctype="multipart/form-data"
				action="${pageContext.request.contextPath }/login/register">

				<div class="form-group">
					<label for="formGroupExampleInput">Username:</label>
					<s:input class="form-control" path="username"
						placeholder="Username ..." required="required" /><br>
					<s:errors class="alert alert-danger" path="username"></s:errors>
				</div>
				<div class="form-group">
					<label for="formGroupExampleInput">Full name:</label>
					<s:input class="form-control" path="fullname"
						placeholder="Fullname ..." />
					<s:errors path="fullname"></s:errors>
				</div>
				<div class="form-group">
					<label for="formGroupExampleInput">Email:</label>
					<s:input class="form-control" path="email"
						placeholder="email ..." required="required" /><br>
					<s:errors  class="alert alert-danger"  path="email"></s:errors>
				</div>
				<div class="form-group">
					<label for="formGroupExampleInput">Birthday:</label>
					<s:input autocomplete="off" path="birthday" id="birthday" />
					<s:errors path="birthday"></s:errors>
				</div>
				<div class="form-group">
					<label for="formGroupExampleInput">Gender:</label><br>
					<s:radiobutton path="gender" value="male" /> Male<br>
					<s:radiobutton path="gender" value="female" /> Female<br>
					<s:errors class="alert alert-danger"  path="gender"></s:errors>
				</div>
				<div class="form-group">

					<label for="formGroupExampleInput">Phone:</label>
					<s:input class="form-control" path="phone"
						placeholder="username ..." required="required" /><br>
					<s:errors class="alert alert-danger"  path="phone"></s:errors>
				</div>
				<div class="form-group">

					<label for="formGroupExampleInput">City:</label>
					<s:input class="form-control" path="city"
						placeholder="City ..." required="required" /><br>
					<s:errors class="alert alert-danger"  path="city"></s:errors>
				</div>
				<div class="form-group">
					<label for="formGroupExampleInput">Avatar:</label>
					<input class="form-control" type="file" name="file"/><br>
					<s:errors class="alert alert-danger"  path="avatar"></s:errors>
				</div>
				<div class="form-group">
					<label for="formGroupExampleInput">Password:</label>
					<s:password class="form-control" path="password"
						placeholder="password ..." /><br>
					<s:errors class="alert alert-danger"  path="password"></s:errors>
				</div>
				 <div class="form-group">
					<label for="formGroupExampleInput">Password Confirmation:</label>
					<s:password class="form-control" path="confirmPassword"
						placeholder="Password confirmation..." /><br>
					<s:errors class="alert alert-danger"  path="confirmPassword"></s:errors>
				</div>
				
				<div class="form-group">
					&nbsp; <input class="btn btn-info" type="submit" value="Save">
				</div>
				<s:hidden path="id" />
			</s:form>
		</div>
	</div>
</div>

