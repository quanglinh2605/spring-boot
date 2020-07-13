<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<div class="col-md-6" style="margin-left: auto;margin-right:auto; padding-top: 50px;">
<div class="card card-primary">
	<div class="card-header">
		<h3 class="card-title">Add Cinema</h3>
	</div>
	<!-- /.card-header -->
	<!-- form start -->
	<s:form role="form" method="post" modelAttribute="cinema"
	action="${ pageContext.request.contextPath }/admin/cinema/add">
		<div class="card-body">
			<div class="form-group">
				<label for="cinemaName">Cinema Name</label> <s:input
					path="cinemaName" class="form-control" id="cinemaName"
					placeholder="Name" required="required"/>
			</div>
			<div class="form-group">
				<label for="cinemaAddress">Cinema address</label> <s:input
					path="cinemaAddress" class="form-control" id="cinemaAddress"
					placeholder="Address" required="required"/>
			</div>
		</div>
		<!-- /.card-body -->

		<div class="card-footer">
			<button type="submit" class="btn btn-primary">Save</button>
		</div>
	</s:form>
</div>
</div>