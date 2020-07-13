<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-md-6" style="margin-left: auto;margin-right:auto; padding-top: 50px;">
<div class="card card-primary">
	<div class="card-header">
		<h3 class="card-title">Edit Room</h3>
	</div>
	<!-- /.card-header -->
	<!-- form start -->
	<s:form role="form" method="post" modelAttribute="room"
	action="${ pageContext.request.contextPath }/admin/room/edit">
		<div class="card-body">
			<div class="form-group">
				<label for="roomName">Room Name</label> <s:input
					path="roomName" class="form-control" id="roomName"
					placeholder="Name" required="required"/>
					<span style="color:red"><s:errors path="roomName"></s:errors></span>
			</div>
			<div class="form-group">
                  <label>Cinema</label>
                  <select class="form-control select2" style="width: 100%;" name="cinema.cinemaId">
                  	<c:forEach var="item" items="${ cinemas }">
                  		<option value="${ item.cinemaId }" ${ item.cinemaId ==  room.cinema.cinemaId ? "selected":"" }>${ item.cinemaName }</option>
                  	</c:forEach>
                  </select>
            </div>
		</div>
		<!-- /.card-body -->

		<div class="card-footer">
			<s:hidden path="roomId"/>
			<button type="submit" class="btn btn-primary">Save</button>
		</div>
	</s:form>
</div>
</div>