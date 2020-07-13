<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h3
	style="color: red; font-size: 35px; text-align: center; padding: 10px;">Payment
	information</h3>
<c:if test="${ sessionScope.booking != null }">
	<div class="card-body table-responsive p-0">
		<table class="table table-hover"
			style="margin-left: 100px; margin-top: 100px;">
			<tr>
				<td>Customer's Name:</td>
				<td>${ sessionScope.booking.user.fullname }</td>
			</tr>
			<tr>
				<td>Cinema</td>
				<td>${ sessionScope.booking.seat.room.cinema.cinemaName },
					${sessionScope.booking.seat.room.roomName }, ${ sessionScope.booking.seat.row }-${ sessionScope.booking.seat.number }</td>
			</tr>
			<tr>
				<td>Schedule</td>
				<td>Movie name: ${ sessionScope.booking.schedule.movie.movieName }</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>Release: ${ sessionScope.booking.schedule.scheduleDate };<t/>
					Start Time: ${ sessionScope.booking.schedule.scheduleStart}; End
					Time: ${ sessionScope.booking.schedule.scheduleEnd}</td>
			</tr>
			<tr>
				<td>Total:</td>
				<td>Ticke price(${ sessionScope.booking.seat.seatType == 1 ? 4:5 }$)
					<c:forEach items="${ sessionScope.combos }" var="item">
						<c:if test="${ item.id != 0 }">
				+ ${ item.name }(${ item.price }$) x ${ item.id }
			</c:if>
					</c:forEach> : &nbsp; ${ sessionScope.booking.price }$
				</td>
			</tr>
		</table>
	</div>
</c:if>
<form method="post" action="${ paypalConfig.posturl }">
	<!-- Setting -->
	<input type="hidden" name="upload" value="1"> <input
		type="hidden" name="cmd" value="_cart"> <input type="hidden"
		name="business" value="${ paypalConfig.business }"> <input
		type="hidden" name="return" value="${ paypalConfig.returnurl }">
	<!-- Information -->
	<input type="submit" value="Checkout with Paypal"
		class="btn btn-primary" style="margin-left: 100px; margin-top: 10px;">
	<input type="hidden" name="item_number_1" value="1"> <input
		type="hidden" name="item_name_1" value="Ticket price"> <input
		type="hidden" name="amount_1"
		value="${ sessionScope.booking.seat.seatType == 1 ? 4:5 }">
	<c:forEach var="item" items="${ sessionScope.combos }" varStatus="i">
		<c:if test="${ item.id != 0 }">
			<input type="hidden" name="item_name_${ i.index+2 }"
				value="${ item.name }">
			<input type="hidden" name="amount_${ i.index+2 }"
				value="${ item.price }">
			<input type="hidden" name="quantity_${ i.index+2 }"
				value="${ item.id }">
		</c:if>
	</c:forEach>
</form>