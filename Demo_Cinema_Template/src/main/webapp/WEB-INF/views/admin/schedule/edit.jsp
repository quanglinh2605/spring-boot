<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-md-6"
	style="margin-left: auto; margin-right: auto; padding-top: 50px;">
	<div class="card card-primary">
		<div class="card-header">
			<h3 class="card-title">Update Schedule</h3>
		</div>
		<!-- /.card-header -->
		<!-- form start -->
		<s:form role="form" method="post" modelAttribute="schedule"
			action="${ pageContext.request.contextPath }/admin/schedule/edit">
			<div class="card-body">
				<div class="form-group">
					<label>Cinema</label> <select class="form-control select2"
						style="width: 100%;" id="comboboxCinemas">
						<option value="0">Select one</option>
						<c:forEach var="item" items="${ cinemas }">
							<option value="${ item.cinemaId }" ${ item.cinemaId == check.room.cinema.cinemaId ? 'selected' : '' }>${ item.cinemaName }</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group">
					<label>Room</label> <select class="form-control select2"
						style="width: 100%;" name="room.roomId" id="comboboxRooms">
						<option value="0">Select one</option>
						<c:forEach var="item" items="${ rooms }">
							<option value="${ item.roomId }" ${ item.roomId == check.room.roomId ? 'selected' : '' }>${ item.roomName }</option>
						</c:forEach>
					</select>
					<span style="color: red;"><s:errors path="room"></s:errors></span>
				</div>
				<div class="form-group">
					<label>Movie</label> <select class="form-control select2"
						style="width: 100%;" name="movie.movieId">
						<option value="0">Select one</option>
						<c:forEach var="item" items="${ movies }">
							<option value="${ item.movieId }" ${ item.movieId == check.movie.movieId ? 'selected' : '' }>${ item.movieName }</option>
						</c:forEach>
					</select>
					<span style="color: red;"><s:errors path="movie"></s:errors></span>
				</div>
				<div class="form-group">
					<label>Schedule Date</label>
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i
								class="far fa-calendar-alt"></i></span>
						</div>
						<input type="date" name="scheduleDate" value="${ schedule.scheduleDate }" required="required" />
					</div>
					<span style="color: red;"><s:errors path="scheduleDate"></s:errors></span>
					<!-- /.input group -->
				</div>
				<div class="bootstrap-timepicker">
					<div class="form-group">
						<label>Time start:</label>
						<div class="input-group">
							<input class="clocklet-scroll-into-view" data-clocklet
								maxlength="5" value="${ schedule.scheduleStart }" name="scheduleStart" required="required">
						</div>
						<span style="color: red;"><s:errors path="scheduleStart"></s:errors></span>
						<!-- /.input group -->
					</div>
					<!-- /.form group -->
				</div>
				<div class="bootstrap-timepicker">
					<div class="form-group">
						<label>Time end:</label>
						<div class="input-group">
							<input class="clocklet-scroll-into-view" data-clocklet
								maxlength="5" value="${ schedule.scheduleEnd }" name="scheduleEnd" required="required">
						</div>
						<span style="color: red;"><s:errors path="scheduleEnd"></s:errors></span>
						<!-- /.input group -->
					</div>
					<!-- /.form group -->
				</div>
			</div>
			<!-- /.card-body -->

			<div class="card-footer">
			<s:hidden path="scheduleId"/>
				<button type="submit" class="btn btn-primary">Save</button>
			</div>
		</s:form>
	</div>
</div>
<link rel=stylesheet href="${ pageContext.request.contextPath }/resources/admin/css/clocklet.min.css">
<script src="${ pageContext.request.contextPath }/resources/admin/js/clocklet.min.js\"></script>