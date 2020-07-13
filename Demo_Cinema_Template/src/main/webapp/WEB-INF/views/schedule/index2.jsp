<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<div class="top-header" style="background: #fff; margin-top: -7px">
	<div class="logo">
		<a href="/"><img
			src="${pageContext.request.contextPath }/resources/images/logo.png"
			alt=""></a>
		<p>Movie Theater</p>
	</div>
	<hr>
	<div class="clearfix"></div>

</div>
<c:if test="${err != null }">
	<div class="alert alert-warning">
		<strong>${err }</strong>
	</div>
</c:if>
<br><br>
<div class="contain-fluid">
	<div class="row">
		<div class="col-4 col-md-4 col-lg-4">
			<!-- Movie trailer -->
			<div class="trailer-schedule" style="margin-left: 20%">
				<iframe width="80%" height="30%"
					src="https://youtube.com/embed/${movie.movieTrailer }"> </iframe>
			</div>
		</div>
		<div class="col-8 col-md-8 col-lg-8">
			<!-- Movie inf -->
			<div class="movie-schedule"
				style="margin-right: 10%; margin-left: 10%">
				<table class="table table-bordered table-striped">
					<tr>
						<th colspan="2"><h1>${movie.movieName }</h1></th>
					</tr>
					<tr>
						<th>Genre</th>
						<td>${movie.movieFormat }</td>
					</tr>
					<tr>
						<th>Lenght</th>
						<td>${movie.movieLength }</td>
					</tr>
					<tr>
						<th>Description</th>
						<td>${movie.movieDescription }</td>
					</tr>
				</table>
				<%-- <h1>${movie.movieName }</h1>
				<p>Genre &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; : &nbsp;&nbsp;
					${movie.movieFormat }</p>
				<p>Release &nbsp;&nbsp;&nbsp;&nbsp;: &nbsp;&nbsp; 7 November
					2014</p>
				<p>${movie.movieDescription }</p> --%>
			</div>
		</div>
	</div>
</div>


<!-- Movie Schedule -->
<div class="contain">
	<div class="row">


		<div class="col-6 col-md-6 col-lg-6 schedule"
			style="background: #999; text-align: center">

			<ul class="nav" style="margin-left: 10%">
				<li class="nav-item" style="float: left; font-size: 18px"><a
					href="${pageContext.request.contextPath }/schedule/movie/${movie.movieId}/0">${date }
						|</a></li>
				<li class="nav-item" style="float: left; font-size: 18px"><a
					href="${pageContext.request.contextPath }/schedule/movie/${movie.movieId}/1">${date1 }
						|</a></li>
				<li class="nav-item" style="float: left; font-size: 18px"><a
					href="${pageContext.request.contextPath }/schedule/movie/${movie.movieId}/2">${date2 }</a>
				</li>
			</ul>

		</div>
		<div class="col-3 col-md-3 col-lg-3 schedule"></div>
	</div>
	<div class="row">
		<div class="col-12 col-md-12 col-lg-12 schedule">
			<ul style="list-style: none;">

				<c:forEach items="${schedules }" var="sche">
					<div class="movie-schedule-li">
						<li><h3>${sche.nameCinema }</h3></li>
						<li>${sche.room }</li>

						<li style="height: 100px">
							<ul style="list-style: none; margin: 15px">
								<c:forEach items="${sche.timeschedule }" var="time">
									<li
										style="border: 1px solid #cbcabe; margin: 5px; text-align: center; float: left">
										<a
										href="${pageContext.request.contextPath }/schedule/book/${time.id}">Time
											start: ${time.scheduleTime }<br> Seat Available:
											${time.seatAvailable }
									</a>
									</li>
								</c:forEach>
							</ul>
						</li>


					</div>
				</c:forEach>

			</ul>
			<hr>
		</div>
	</div>
</div>