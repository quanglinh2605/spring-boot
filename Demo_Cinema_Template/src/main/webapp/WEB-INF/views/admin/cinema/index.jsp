<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="card">
	<div class="card-header">
		<h3 class="card-title">Cinemas List</h3>
		<div class="card-tools">
			<form method="get"
				action="${ pageContext.request.contextPath }/admin/cinema/search/1">
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
	<c:if test="${ cinemas.pageList != null }">
		<!-- /.card-header -->
		<div class="card-body table-responsive p-0">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>STT</th>
						<th>Name</th>
						<th>Address</th>
						<th>#Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${cinemas.pageList}" varStatus="i">
						<tr>
							<td>${ i.index + 1 }</td>
							<td>${ item.cinemaName }</td>
							<td>${ item.cinemaAddress }</td>
							<td><a
								href="${ pageContext.request.contextPath}/admin/cinema/delete/${item.cinemaId}"
								onclick="return confirm('Are you sure')">Delete</a> | <a
								href="${ pageContext.request.contextPath}/admin/cinema/edit/${item.cinemaId}">Edit</a> |
								<a href="${ pageContext.request.contextPath }/admin/room/listByCinema/${ item.cinemaId }/1">Room</a>								
							</td>
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
		href="${baseUrl}1${addUrl}">First</a>
	</li>
	<li class="${currentIndex == 1 ? 'page-item disabled': 'page-item' }">
		<a class="page-link" aria-label="Previous"
		href="${baseUrl}${currentIndex - 1}${addUrl}" title='Go to previous page'><span
			aria-hidden="true">�</span> <span class="sr-only">Previous</span></a>
	</li>
	<c:forEach var="item" begin="${ beginIndex }" end="${endIndex}" step="1">
		<li class="${item == currentIndex ? 'page-item active' :'page-item' }">
			<a class="page-link" href="${baseUrl}${item}${addUrl}"> <span>${item}</span>
		</a>
		</li>
	</c:forEach>
	
	<li
		class="${currentIndex == totalPageCount ? 'page-item disabled': 'page-item'}">
		<a class="page-link" aria-label="Next"
		href="${baseUrl}${currentIndex + 1}${addUrl}" title='Go to next page'><span
			aria-hidden="true">�</span> <span class="sr-only">Next</span></a>
	</li>
	<li
		class="${currentIndex == totalPageCount ? 'page-item disabled':'page-item'}">
		<a class="page-link" href="${baseUrl}${totalPageCount}${addUrl}">Last</a>
	</li>
</ul>