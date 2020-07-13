<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<br>
<br>
<br>
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
		<div class="col-6 col-md-6 col-lg-6" style="float: left;">
			<table border="1" class="table table-striped"
				style="margin-top: 10px">
				<tr>
					<th>Movie:&nbsp;</th>
					<td>${schedule.movie.movieName }</td>
				</tr>
				<tr>
					<th>Time start:&nbsp;</th>
					<td>${schedule.scheduleStart }</td>
				</tr>
				<tr>
					<th>Cinema:&nbsp;</th>
					<td>${schedule.room.cinema.cinemaName  }</td>
				</tr>
				<tr>
					<th>Room:&nbsp;</th>
					<td>${seat.row }-${seat.number}</td>
				</tr>
			</table>
			<div class="bg-success">
				Price :<span data-price="${price}" id="price"> ${price }<span>$</span></span>
			</div>
			<f:form method="post" modelAttribute="booking"
				action="${pageContext.request.contextPath }/booking/book/${schedule.scheduleId}/${seat.seatId}">
				
				Combo water:
				<table class="table table-borderless" border="1"
					style="margin-top: 10px">
					<c:forEach items="${combos }" var="combo">

						<tr>
							<td><img
								src="${pageContext.request.contextPath }/resources/images/combo_water1.jpg"
								width="50px" height="auto" /><br>${combo.name }:
								${combo.id}</td>
							<td><input class="inp-combo-price"
								data-combo-price="${combo.price }" type="number"
								name="${ combo.name }" value="0" min="0" /> <%-- <f:checkbox path="comboWater" value="${combo.name }" id="${combo.name }"/> --%>
								<p>${combo.price }$</p></td>
						</tr>
					</c:forEach>
				</table>
				<script type="text/javascript">
					let allCombo = document
							.querySelectorAll("input.inp-combo-price");
					let originPrice = $("#price");

					allCombo
							.forEach(function(eachCombo) {
								$(eachCombo)
										.on(
												'change',
												function(e) {
													var comboPrice = 0;
													let allCombo = document
															.querySelectorAll("input.inp-combo-price");

													allCombo
															.forEach(function(
																	eachOne) {
																console
																		.log($(
																				eachOne)
																				.val());
																comboPrice += parseInt($(
																		eachOne)
																		.val())
																		* parseInt($(
																				eachOne)
																				.data(
																						'combo-price'));
															});

													comboPrice += parseInt(originPrice
															.data('price'));
													originPrice.text(comboPrice
															+ "$");
												});
							});
				</script>
				<f:hidden path="seatStatus" value="1" />
				<input type="submit" value="Buy" class="btn btn-inf">
				<%-- <a role="button" class="btn btn-primary" href="${pageContext.request.contextPath }/booking/save/${schedule.scheduleId}/${seat.seatId}">Buy</a> --%>
			</f:form>

		</div>
		<div class="col-3 col-md-3 col-lg-3"></div>

	</div>
</div>
