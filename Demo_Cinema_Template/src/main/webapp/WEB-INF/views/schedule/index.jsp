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
<c:forEach items="${allSchedule }" var="allSchedule">
	<div class="contain-fluid" style="margin: 10px; background: #f7e9ce;">
		<div class="row">
			<div class="col-4 col-md-4 col-lg-4">
				<div class="row">
					<div class="col-4 col-md-4 col-lg-4">
						<!-- Movie trailer -->
						<div class="trailer-schedule" style="margin-left: 20%">
							<img src="${allSchedule.movie.moviePoster}"
			style="max-width: 100%; max-height: 100%; padding-top: 10px" />
						</div>
					</div>
					<div class="col-8 col-md-8 col-lg-8">
						<!-- Movie inf -->
						<div class="movie-schedule"
							style="margin-right: 10%; margin-left: 10%">
							<ul style="list-style: none">
								<li><h1>${allSchedule.movie.movieName }</h1></li>
								<li><b>Lenght:</b> ${allSchedule.movie.movieLength }</li>
								<li><b>Description:</b> ${allSchedule.movie.movieDescription }</li>
							</ul>
						</div>
					</div>
				</div>
			</div>

			<div class="col-6 col-md-6 col-lg-6">
				<div class="contain">
					<div class="row">
						<div class="col-12 col-md-12 col-lg-12 schedule">

							<ul style="list-style: none;">

								<c:forEach items="${allSchedule.schedules }" var="sche">
									<div class="movie-schedule-li">
										<li><h3>${sche.nameCinema }</h3></li>
										<li>${sche.room }</li>

										<li style="height: 100px">
											<ul style="list-style: none; margin: 15px">
												<c:forEach items="${sche.timeschedule }" var="time">
													<li
														style="border: 1px solid #cbcabe; margin: 5px; text-align: center; float: left">
														<a style="font-size: 16px"
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
			</div>
		</div>
	</div>
</c:forEach>