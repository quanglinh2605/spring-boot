<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<div class="right-content">
	<div class="right-content-heading">
		<div class="right-content-heading-left">
			<h3 class="head">Videos trailer</h3>
		</div>
	</div>
	<!-- pop-up-box -->
	<link href="css/popuo-box.css" rel="stylesheet" type="text/css"
		media="all">
	<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
	<script>
		$(document).ready(function() {
			$('.popup-with-zoom-anim').magnificPopup({
				type : 'inline',
				fixedContentPos : false,
				fixedBgPos : true,
				overflowY : 'auto',
				closeBtnInside : true,
				preloader : false,
				midClick : true,
				removalDelay : 300,
				mainClass : 'my-mfp-zoom-in'
			});

			
			    $('#play').click(function() {
			        this.paused ? this.play() : this.pause();
			    });
			
		});
	</script>

	<!--//pop-up-box -->

	<div class="content-grids">

		<c:forEach items="${movies }" var="video">

 			<div class="content-grid">
				<iframe width="90%" src="https://youtube.com/embed/${video.movieTrailer }"> </iframe>		
				<h4 class="btn btn-info"><b>${video.movieName }.</b></h4>
			</div>

			</c:forEach>




		<div class="clearfix"></div>
		<!---start-pagenation----->
		
		<div class="clearfix"></div>
		<!---End-pagenation----->
	</div>
</div>