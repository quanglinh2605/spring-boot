<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<br><br>
<div class="container">
	<div class="card">
		<div class="card-header">
			<h3 class="card-title">Booking Number</h3>
			<div class="card-tools">
				<select id="comboboxMonth" class="form-control">
						<option value="1" ${ month == 1 ? 'selected':'' }>January</option>
						<option value="2" ${ month == 2 ? 'selected':'' }>February</option>
						<option value="3" ${ month == 3 ? 'selected':'' }>March</option>
						<option value="4" ${ month == 4 ? 'selected':'' }>April</option>
						<option value="5" ${ month == 5 ? 'selected':'' }>May</option>
						<option value="6" ${ month == 6 ? 'selected':'' }>June</option>
						<option value="7" ${ month == 7 ? 'selected':'' }>July</option>
						<option value="8" ${ month == 8 ? 'selected':'' }>August</option>
						<option value="9" ${ month == 9 ? 'selected':'' }>September</option>
						<option value="10" ${ month == 10 ? 'selected':'' }>October</option>
						<option value="11" ${ month == 11 ? 'selected':'' }>November</option>
						<option value="12" ${ month == 12 ? 'selected':'' }>December</option>						
					</select>
			</div>
		</div>
		<c:if test="${ cinemas != null }">
			<!-- /.card-header -->
			<div class="card-body table-responsive p-0">
				<table class="table table-hover" id="bookingNumber">
					<thead>
						<tr>
							<th>STT</th>
							<th>Cinema Name</th>
							<th>Booking Number</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${cinemas}" varStatus="i">
							<tr>
								<td>${ i.index + 1 }</td>
								<td>${ item.cinema }</td>
								<td>${ item.bookingNumber }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<!-- /.card-body -->
		</c:if>
	</div>

	<p style="font-size: 20px; color: red; margin-left: 50px;" id="total">Month's
		Revenue: ${total}$</p>

	<div class="card">
		<div class="card-header">
			<h3 class="card-title">Bookings List Today</h3>			
		</div>
		<c:if test="${ bookings != null }">
			<!-- /.card-header -->
			<div class="card-body table-responsive p-0">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>STT</th>
							<th>Movie</th>
							<th>Room</th>
							<th>Seat Number</th>
							<th>Book Date</th>
							<th>Price</th>
							<th>Users</th>
							<th>Combo</th>
							<c:if test="${ sessionScope.user.role.equals('ROLE_ADMIN') }">
								<th>#Action</th>
							</c:if>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${bookings}" varStatus="i">
							<tr>
								<td>${ i.index + 1 }</td>
								<td>${ item.schedule.movie.movieName }</td>
								<td>${ item.schedule.room.roomName }</td>
								<td>${ item.seat.row}-${ item.seat.number }</td>
								<td>${ item.bookingDate }</td>
								<td><fmt:formatNumber value="${ item.price }"
										type="currency"></fmt:formatNumber></td>
								<td>${ item.user.fullname }</td>
								<td>${ item.combo_water }</td>
								<c:if test="${ sessionScope.user.role.equals('ROLE_ADMIN') }">
									<td><a
										href="${ pageContext.request.contextPath}/admin/booking/delete/${item.bookingId}"
										onclick="return confirm('Are you sure')">Delete</a></td>
								</c:if>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<!-- /.card-body -->
		</c:if>
	</div>
</div>