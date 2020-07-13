<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<div class="contain">
	<div class="row">
		<div class="col-3 col-md-3 col-lg-3"></div>
		<div class="col-6 col-md-6 col-lg-6">
			<div class="contain" style="padding: 10px">
				<div class="row">
					<div class="col-5 col-md-5 col-lg-5" style="float: left;">
						<img src="${schedule.movie.moviePoster }"
							style="max-width: 100%; max-height: 100%; height: 50%; width: auto" />

					</div>
					<div class="col-7 col-md-7 col-lg-7">
						<table class="table" border="1"
							style="width: 100%; margin-top: 10px">
							<tr style="background-color: rgba(0, 0, 0, .075);">
								<th>Movie Name</th>
								<td><h3>${schedule.movie.movieName }</h3></td>
							</tr>
							<tr style="background-color: #b8daff;">
								<th>Start with</th>
								<td>${schedule.scheduleStart }</td>
							</tr>
							<tr style="background-color: #b8daff;">
								<th>Cinema Name</th>
								<td>${schedule.room.cinema.cinemaName }</td>
							</tr>
							<tr style="background-color: #b8daff;">
								<th>Room</th>
								<td>${schedule.room.roomName }</td>
							</tr>

						</table>

					</div>
				</div>
				<div class="row">
					<div class="col-12 col-md-12 col-lg-12" style="height: 90%">
						<div class="contain seat-contain">
							<div
								style="position: relative; margin-bottom: 50px; margin-left: 25%">
								<h4 style="background: #fff; width: 60%">SCREEN</h4>
							</div>
							<div style="text-align: center; height: 200px">
								<div
									style="position: relative; margin-bottom: 50px; float: left; margin-left: 20%">
									<table style="float: left; margin-right: 10px">

										<c:forEach items="${rowCol }" var="row">
											<tr style="height: 60px">
												<th>${row.row }</th>
											</tr>
										</c:forEach>

									</table>
								</div>

								<div
									style="position: relative; margin-bottom: 50px; float: left; width: 180px">
									<table border="1">

										<c:forEach items="${rowCol }" var="row">
											<tr>
												<c:forEach items="${row.cols }" var="column">
													<td>
														<div class="col" style="float: left; text-align: center">
															<c:choose>
																<c:when test="${column.imgChar == 'seat_icon.png' }">
																	<a style="text-align: center"
																		href="${pageContext.request.contextPath }/booking/book/${schedule.scheduleId}/${column.seatId}">
																		<img
																		src="${pageContext.request.contextPath }/resources/images/${column.imgChar}"
																		height="8%" width="auto" /><br>
																		${column.colNumber }
																	</a>
																	<br />
																</c:when>
																<c:otherwise>
																	<a style="text-align: center" href="#"> <img
																		src="${pageContext.request.contextPath }/resources/images/${column.imgChar}"
																		height="8%" width="auto" /><br>
																		${column.colNumber }
																	</a>
																	<br />
																</c:otherwise>
															</c:choose>
															<%-- <c:if test="${column.imgChar == 'seat_icon.png' }">
													<a style="text-align: center"
														href="${pageContext.request.contextPath }/booking/book/${schedule.scheduleId}/${column.seatId}">
														<img alt=""
														src="${pageContext.request.contextPath }/resources/images/${column.imgChar}"
														height="8%" width="auto" /><br> ${column.colNumber }
													</a>
													<br />
												</c:if>
												<c:if test="${column.imgChar == 'seat_checked.png' }">
													<a style="text-align: center"
														href="#">
														<img alt=""
														src="${pageContext.request.contextPath }/resources/images/${column.imgChar}"
														height="8%" width="auto" /><br> ${column.colNumber }
													</a>
													<br />
												</c:if> --%>

														</div>
													</td>
												</c:forEach>
											</tr>
										</c:forEach>
									</table>
								</div>

								<div style="float: right; position: relative;">
									<table>
										<tr>
											<td><img
												src="${pageContext.request.contextPath }/resources/images/seat_icon.png"
												height="8%" width="auto" />
												<p>Seat available</p></td>
										</tr>
										<tr>
											<td><img
												src="${pageContext.request.contextPath }/resources/images/seat_checked.png"
												height="8%" width="auto" />
												<p>Seat cheked</p></td>
										</tr>
									</table>
								</div>
							</div>


						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>