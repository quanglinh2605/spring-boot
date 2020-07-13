<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="card">
	<div class="card-header">
		<h3 class="card-title">Rooms List</h3>
		<div class="card-tools">
			<form method="get"
				action="${ pageContext.request.contextPath }/admin/room/search/1">
				<div class="input-group input-group-sm" style="width: 150px;">
					<input type="text" name="keyword" class="form-control float-right"
						placeholder="Search" value="${ keyword }">

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
					<th>Cinema Name</th>
					<th>Room Name</th>
					<th>#Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${rooms.pageList}" varStatus="i">
					<tr>
						<td>${ i.index + 1 }</td>
						<td>${ item.cinema.cinemaName }</td>
						<td>${ item.roomName }</td>
						<td><a
							href="${ pageContext.request.contextPath}/admin/room/delete/${item.roomId}"
							onclick="return confirm('Are you sure')">Delete</a> | <a
							href="${ pageContext.request.contextPath}/admin/room/edit/${item.roomId}">Edit</a>
							| <a href="${ pageContext.request.contextPath }/admin/seat/findByRoom/${item.roomId}/1">Seat</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<!-- /.card-body -->
</div>
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