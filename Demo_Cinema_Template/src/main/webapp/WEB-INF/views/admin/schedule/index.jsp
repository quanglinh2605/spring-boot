<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="card">
	<div class="card-header">
		<h3 class="card-title">Schedules List</h3>
		<div class="card-tools">
			<form method="get"
				action="${ pageContext.request.contextPath }/admin/schedule/search/1">
				<div class="input-group input-group-sm" style="width: 150px;">
					<input type="text" name="keyword" class="form-control float-right"
						placeholder="keyword" value="${ keyword }"> 					
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
		<table class="table table-hover" id="scheduleTable">
			<thead>
				<tr>
					<th>STT</th>
					<th>Cinema</th>
					<th>Room</th>
					<th>Movie</th>
					<th>Release date</th>
					<th>Start Time</th>
					<th>End Time</th>
					<th>#Action</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${ schedules != null }">
					<c:forEach var="item" items="${schedules.pageList}" varStatus="i">
						<tr>
							<td>${ i.index + 1 }</td>
							<td>${ item.room.cinema.cinemaName }</td>
							<td>${ item.room.roomName }</td>
							<td>${ item.movie.movieName }</td>
							<td>${ item.scheduleDate }</td>
							<td>${ item.scheduleStart }</td>
							<td>${ item.scheduleEnd }</td>
							<td><a
								href="${ pageContext.request.contextPath}/admin/schedule/delete/${item.scheduleId}"
								onclick="return confirm('Are you sure')">Delete</a> | <a
								href="${ pageContext.request.contextPath}/admin/schedule/edit/${item.scheduleId}">Edit</a>
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>
	<!-- /.card-body -->
</div>

<ul class="pagination">
	<li class="${currentIndex == 1 ? 'page-item disabled' : 'page-item'}">
		<a class="page-link"
		href="${baseUrl}1${addUrl}">First</a>
	</li>
	<li class="${currentIndex == 1 ? 'page-item disabled': 'page-item' }">
		<a class="page-link" aria-label="Previous"
		href="${baseUrl}${currentIndex - 1}${addUrl}" title='Go to previous page'><span
			aria-hidden="true">«</span> <span class="sr-only">Previous</span></a>
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
