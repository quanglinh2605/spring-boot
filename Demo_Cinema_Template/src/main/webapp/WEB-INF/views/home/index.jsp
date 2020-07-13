<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<div class="header">
	<div class="top-header" style="background: #fff; margin-top: -7px">
		<div class="logo">
			<a href="/"><img
				src="${pageContext.request.contextPath }/resources/images/logo.png"
				alt=""></a>
			<p>Movie Theater</p>
		</div>


		<div class="search" >
			<form method="post" action="${pageContext.request.contextPath }/home/search">
				<input id="Movie_name" type="text" name="movieName" value="Search.." onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = 'Search..';}">
				<input type="submit" value="">
			</form>
		</div>
		<script type="text/javascript">
			$(document).ready(function(){
				$("#Movie_name").autocomplete({
						source: "${pageContext.request.contextPath }/home/movieNameAutocomplete",
						minLength: 1
					});
					
				});
		</script>
		<hr>
		<div class="clearfix"></div>

	</div>

	<div class="header-backgrount">

		<a href="#"><img src="${movie.moviePoster}"
			style="max-width: 100%; max-height: 100%" /></a>
	</div>

	<div class="header-info">
		<h1>${movie.movieName}</h1>
		<p class="age">
			<a href="#">${movie.movieCens }</a>
		</p>
		<p class="review">Rating
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: &nbsp;&nbsp; 8,5/10</p>
		<p class="review reviewgo">Genre
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; : &nbsp;&nbsp;
			${movie.movieFormat }</p>
		<p class="review">Release &nbsp;&nbsp;&nbsp;&nbsp;: &nbsp;&nbsp; 7
			November 2014</p>
		<p class="special">${movie.movieDescription }</p>
		<a class="video"
			href="https://www.youtube.com/watch?v=${movie.movieTrailer }"><i
			class="video1"></i>WATCH TRAILER</a> <a class="book"
			href="${pageContext.request.contextPath }/schedule/movie/${movie.movieId}/0"><i
			class="book1"></i>BOOK TICKET</a>
	</div>
</div>
<div class="review-slider">
	
			<ul id="flexiselDemo1">

				<c:forEach items="${movies }" var="m">
					<li><a href="${pageContext.request.contextPath }/schedule/movie/${m.movieId}/0">
							<img src="${m.moviePoster }" alt="${m.movieName }" width="80%" height="30%" >
					</a></li>
				</c:forEach>

			</ul>
			<div class="nbs-flexisel-nav-left" style="top: 58px;"></div>
			<div class="nbs-flexisel-nav-right" style="top: 58px;"></div>
		
	<script type="text/javascript">
		$(window).load(function() {

			$("#flexiselDemo1").flexisel({
				visibleItems : 6,
				animationSpeed : 1000,
				autoPlay : true,
				autoPlaySpeed : 3000,
				pauseOnHover : false,
				enableResponsiveBreakpoints : true,
				responsiveBreakpoints : {
					portrait : {
						changePoint : 480,
						visibleItems : 2
					},
					landscape : {
						changePoint : 640,
						visibleItems : 3
					},
					tablet : {
						changePoint : 768,
						visibleItems : 4
					}
				}
			});
		});
	</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/resources/js/jquery.flexisel.js"></script>
</div>
<div class="video">
	<iframe src="https://www.youtube.com/embed/${movie.movieTrailer }" frameborder="0"
		allowfullscreen=""></iframe>
</div>
<div class="news">
	<div class="col-md-6 news-left-grid">
		<h3>Don’t be late,</h3>
		<h2>Book your ticket now!</h2>
		<h4>Easy, simple &amp; fast.</h4>
		<a href="${pageContext.request.contextPath }/schedule/movie/${movie.movieId}"><i class="book"></i>BOOK TICKET</a>
		<p>
			Get Discount up to <strong>10%</strong> if you are a member!
		</p>
	</div>
	<div class="col-md-6 news-right-grid">
		<h3>News</h3>
		<div class="news-grid">
			<h5>Lorem Ipsum Dolor Sit Amet</h5>
			<label>Nov 11 2014</label>
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed
				do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
				enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi
				ut aliquip ex ea commodo.</p>
		</div>
		<div class="news-grid">
			<h5>Lorem Ipsum Dolor Sit Amet</h5>
			<label>Nov 11 2014</label>
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed
				do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
				enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi
				ut aliquip ex ea commodo.</p>
		</div>
		<a class="more" href="#">MORE</a>
	</div>
	<div class="clearfix"></div>
</div>
<div class="more-reviews">
	<div class="nbs-flexisel-container">
		<div class="nbs-flexisel-inner">
			<ul id="flexiselDemo2" class="nbs-flexisel-ul"
				style="left: -83px; display: block;">

				<c:forEach items="${movies }" var="m">
					<li class="nbs-flexisel-item" style="width: 83px;">
						<a href="${pageContext.request.contextPath }/schedule/movie/${m.movieId}/0">
							<img src="${m.moviePoster }" alt="${m.movieName }" width="80%" height="30%" >
						</a>
					</li>
				</c:forEach>


				<%-- <li class="nbs-flexisel-item" style="width: 83px;"><img
					src="${pageContext.request.contextPath }/resources/images/m1.jpg"
					alt=""></li>
				<li class="nbs-flexisel-item" style="width: 83px;"><img
					src="${pageContext.request.contextPath }/resources/images/m2.jpg"
					alt=""></li>
				<li class="nbs-flexisel-item" style="width: 83px;"><img
					src="${pageContext.request.contextPath }/resources/images/m3.jpg"
					alt=""></li>
				<li class="nbs-flexisel-item" style="width: 83px;"><img
					src="${pageContext.request.contextPath }/resources/images/m4.jpg"
					alt=""></li>
				<li class="nbs-flexisel-item" style="width: 83px;"><img
					src="${pageContext.request.contextPath }/resources/images/m1.jpg"
					alt=""></li>
				<li class="nbs-flexisel-item" style="width: 83px;"><img
					src="${pageContext.request.contextPath }/resources/images/m2.jpg"
					alt=""></li>
				<li class="nbs-flexisel-item" style="width: 83px;"><img
					src="${pageContext.request.contextPath }/resources/images/m3.jpg"
					alt=""></li>
				<li class="nbs-flexisel-item" style="width: 83px;"><img
					src="${pageContext.request.contextPath }/resources/images/m4.jpg"
					alt=""></li> --%>
			</ul>
			<div class="nbs-flexisel-nav-left" style="top: 55px;"></div>
			<div class="nbs-flexisel-nav-right" style="top: 55px;"></div>
		</div>
	</div>
	<script type="text/javascript">
		$(window).load(function() {

			$("#flexiselDemo2").flexisel({
				visibleItems : 4,
				animationSpeed : 1000,
				autoPlay : true,
				autoPlaySpeed : 3000,
				pauseOnHover : false,
				enableResponsiveBreakpoints : true,
				responsiveBreakpoints : {
					portrait : {
						changePoint : 480,
						visibleItems : 2
					},
					landscape : {
						changePoint : 640,
						visibleItems : 3
					},
					tablet : {
						changePoint : 768,
						visibleItems : 3
					}
				}
			});
		});
	</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/resources/js/jquery.flexisel.js"></script>
</div>