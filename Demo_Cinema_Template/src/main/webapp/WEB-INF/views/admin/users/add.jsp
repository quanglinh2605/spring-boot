<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<div class="col-md-6"
	style="margin-left: auto; margin-right: auto; padding-top: 50px;">
	<div class="card card-primary">
		<div class="card-header">
			<h3 class="card-title">Add User</h3>
		</div>
		<!-- /.card-header -->
		<!-- form start -->
		<s:form role="form" method="post" modelAttribute="user"
			action="${ pageContext.request.contextPath }/admin/users/add">
			<div class="card-body">
				<div class="form-group">
					<label for="username">Username</label>
					<s:input path="username" class="form-control" id="username"
						placeholder="username" required="required" />
					<s:errors style="color:red;" path="username"></s:errors>
				</div>
				<div class="form-group">
					<label for="email">Email</label>
					<s:input path="email" class="form-control" id="email"
						placeholder="email" required="required" />
					<s:errors style="color:red;" path="email"></s:errors>
				</div>
				<div class="form-group">
					<label for="password">Password</label>
					<s:password path="password" class="form-control" id="password"
						placeholder="password" required="required" />

				</div>
				<div class="form-group">
					<label for="role">Role</label>
					<s:select path="role" class="form-control select2">
						<s:option value="ROLE_ADMIN">ROLE_ADMIN</s:option>
						<s:option value="ROLE_USER">ROLE_USER</s:option>
					</s:select>
				</div>
				<div class="form-group">
					<label for="birhtday">Birthday:</label>
					<s:input path="birthday" id="birthday" />
				</div>
				<div class="form-group">
					<label for="gender">Gender</label>
					<s:select path="gender" class="form-control select2">
						<s:option value="female">Female</s:option>
						<s:option value="male">Male</s:option>
					</s:select>
				</div>
				<div class="form-group">
					<label for="phone">Phone</label>
					<s:input path="phone" class="form-control" id="phone" />
				</div>
				<!-- /.card-body -->

				<div class="card-footer">
					<button type="submit" class="btn btn-primary">Save</button>
				</div>
			</div>
		</s:form>
	</div>
</div>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {
		$("#birthday").datepicker({
			showButtonPanel: true,
			changeMonth : true,
			changeYear : true,
			showOtherMonths : true,
			selectOtherMonths : true,
			yearRange : '1950:2005'
		});
	});

	
</script>