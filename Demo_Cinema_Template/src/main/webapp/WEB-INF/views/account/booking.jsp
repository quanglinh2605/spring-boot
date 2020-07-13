<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<br><br>
<div class="top-header" style="background: #fff; margin-top: -7px">
	<div class="logo">
		<a href="/"><img
			src="${pageContext.request.contextPath }/resources/images/logo.png"
			alt=""></a>
		<p>Movie Theater</p>
	</div>
	<hr>
	<div class="clearfix"></div>

</div><br>
<div class="container">
	<div class="card">
		<div class="card-header">
			<h3 class="card-title">Bookings List</h3>
		</div>
		<br><br>
		<c:if test="${ bookings.pageList != null }">
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
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${bookings.pageList}" varStatus="i">
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
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<!-- /.card-body -->
		</c:if>
	</div>
	<ul class="pagination">
		<li class="${currentIndex == 1 ? 'page-item disabled' : 'page-item'}">
			<a class="page-link"
			href="${ pageContext.request.contextPath }/admin/booking/index">First</a>
		</li>
		<li class="${currentIndex == 1 ? 'page-item disabled': 'page-item' }">
			<a class="page-link" aria-label="Previous"
			href="${baseUrl}${currentIndex - 1}${addUrl}"
			title='Go to previous page'><span aria-hidden="true">«</span> <span
				class="sr-only">Previous</span></a>
		</li>
		<c:forEach var="item" begin="${ beginIndex }" end="${endIndex}"
			step="1">
			<li
				class="${item == currentIndex ? 'page-item active' :'page-item' }">
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
</div>