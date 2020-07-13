<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="col-md-6"
	style="margin-left: auto; margin-right: auto; padding-top: 50px;">
	<div class="card card-primary">
		<div class="card-header">
			<h3 class="card-title">Add Seat</h3>
		</div>
		<!-- /.card-header -->
		<!-- form start -->
		<s:form role="form" method="post" modelAttribute="seat"
			action="${ pageContext.request.contextPath }/admin/seat/add">
			<div class="card-body">
				<div class="form-group">
					<label>Cinema</label> <select id="comboboxCinemas"
						class="form-control select2">
						<option value="0" selected>Select one</option>
						<c:forEach items="${cinemas}" var="item">
							<option value="${ item.cinemaId }">${ item.cinemaName }</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group">
					<label>Room</label> <select class="form-control select2"
						style="width: 100%;" name="room.roomId" id="comboboxRooms">
						<option value="0">Select one</option>
					</select>
					<span style="color:red;"><s:errors path="room"></s:errors></span>
				</div>
				<div class="form-group">
					<label for="row">Seat Row</label>
					<s:input path="row" class="form-control" id="row" placeholder="row"
						required="required" />
				</div>
				<div class="form-group">
					<label for="number">Seat Number</label>
					<s:input path="number" class="form-control" id="number"
						placeholder="number" required="required" />
					<span style="color: red"><s:errors path="number"></s:errors></span>
				</div>
				<div class="form-group">
					<label for="seat_type">Seat Type</label>
					<s:select class="form-control select2" style="width: 100%;"
						path="seat_type">
						<s:option value="1">VIP</s:option>
						<s:option value="2">Normal</s:option>
					</s:select>
				</div>
				<s:hidden path="checked" value="false" />
			</div>
			<!-- /.card-body -->

			<div class="card-footer">
				<button type="submit" class="btn btn-primary">Save</button>
			</div>
		</s:form>
	</div>
</div>