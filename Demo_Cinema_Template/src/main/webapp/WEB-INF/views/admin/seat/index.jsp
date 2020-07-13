<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<div class="card">
	<div class="card-header">
		<h3 class="card-title">Seats List</h3>
		<div class="card-tools">
			<form method="get"
				action="${ pageContext.request.contextPath }/admin/seat/search/1">
				<div class="input-group input-group-sm" style="width: 450px;">
					<select id="comboboxCinemas" class="form-control">
						<option value="0" selected>Select one</option>
						<c:forEach items="${cinemas}" var="item">
							<option value="${ item.cinemaId }"
								${ item.cinemaId == cinemaId ? 'selected':'' }>${ item.cinemaName }</option>
						</c:forEach>
					</select> <select class="form-control" name="roomId" id="comboboxRooms">
						<option value="0">Select one</option>
						<c:if test="${ rooms != null }">
							<c:forEach items="${rooms}" var="item">
								<option value="${ item.roomId }"
									${ item.roomId == roomId ? 'selected':'' }>${ item.roomName }</option>
							</c:forEach>
						</c:if>
					</select> <input type="text" name="row" class="form-control float-right"
						placeholder="Row" value="${ row }"> <input type="number"
						name="number" min="0" class="form-control float-right"
						value="${ number != null? number:0}">

					<div class="input-group-append">
						<button type="submit" class="btn btn-default">
							<i class="fas fa-search"></i>
						</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<!-- /.card-header -->
	<div class="card-body table-responsive p-0">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>STT</th>
					<th>Cinema</th>
					<th>Room</th>
					<th>Seat</th>
					<th>Style</th>
					<th>#Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${seats.pageList}" varStatus="i">
					<tr>
						<td>${ i.index + 1 }</td>
						<td>${ item.room.cinema.cinemaName }</td>
						<td>${ item.room.roomName }</td>
						<td>${ item.row }-${ item.number }</td>
						<td>${ item.seat_type == 1 ? 'VIP':'Normal' }</td>
						<td><a
							href="${ pageContext.request.contextPath}/admin/seat/delete/${item.seat_id}"
							onclick="return confirm('Are you sure')">Delete</a> | <a
							href="${ pageContext.request.contextPath}/admin/seat/edit/${item.seat_id}">Edit</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<!-- /.card-body -->
</div>

<div class="modal" id="myModal">
	<div class="modal-dialog">
		<div class="modal-content">
			<s:form role="form" method="post" modelAttribute="seat"
				action="${ pageContext.request.contextPath }/admin/seat/create">
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Add Seat</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->

				<div class="modal-body">
					<div class="form-group">
						<label>Cinema</label> <select id="comboboxCinemas1"
							class="form-control select2">
							<option value="0" selected>Select one</option>
							<c:forEach items="${cinemas}" var="item">
								<option value="${ item.cinemaId }"
									${ item.cinemaId == cinemaId ? 'selected':'' }>${ item.cinemaName }</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label>Room</label> <select class="form-control select2"
							style="width: 100%;" name="room.roomId" id="comboboxRooms1">
							<option value="0">Select one</option>
							<c:if test="${ rooms != null }">
								<c:forEach items="${rooms}" var="item">
									<option value="${ item.roomId }"
										${ item.roomId == roomId ? 'selected':'' }>${ item.roomName }</option>
								</c:forEach>
							</c:if>
						</select> <span style="color: red;"><s:errors path="room"></s:errors></span>
					</div>
					<div class="form-group">
						<label for="row">Seat Row</label>
						<s:input path="row" class="form-control" id="row"
							placeholder="row" required="required" />
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
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary">Save</button>
					<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
				</div>
			</s:form>
		</div>
	</div>
</div>
<button type="button" class="btn btn-success" style="margin-left: 20px;" data-toggle="modal"
	data-target="#myModal">Add</button>
<input type="hidden" value="${ check }" id="add" />
<ul class="pagination">
	<li class="${currentIndex == 1 ? 'page-item disabled' : 'page-item'}">
		<a class="page-link" href="${baseUrl}1${addUrl}">First</a>
	</li>
	<li class="${currentIndex == 1 ? 'page-item disabled': 'page-item' }">
		<a class="page-link" aria-label="Previous"
		href="${baseUrl}${currentIndex - 1}${addUrl}"
		title='Go to previous page'><span aria-hidden="true">«</span> <span
			class="sr-only">Previous</span></a>
	</li>
	<c:forEach var="item" begin="${ beginIndex }" end="${endIndex}"
		step="1">
		<li class="${item == currentIndex ? 'page-item active' :'page-item' }">
			<a class="page-link" href="${baseUrl}${item}${addUrl}"> <span>${item}</span>
		</a>
		</li>
	</c:forEach>

	<li
		class="${currentIndex == totalPageCount ? 'page-item disabled': 'page-item'}">
		<a class="page-link" aria-label="Next"
		href="${baseUrl}${currentIndex + 1}${addUrl}" title='Go to next page'><span
			aria-hidden="true">»</span> <span class="sr-only">Next</span></a>
	</li>
	<li
		class="${currentIndex == totalPageCount ? 'page-item disabled':'page-item'}">
		<a class="page-link" href="${baseUrl}${totalPageCount}${addUrl}">Last</a>
	</li>
</ul>