<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>${ title }</title>
<link
	href="${pageContext.request.contextPath }/resources/css/bootstrap.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/resources/css/style.css"
	rel="stylesheet" type="text/css" media="all">
<script
	src="${pageContext.request.contextPath }/resources/js/jquery.min.js"></script>
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800"
	rel="stylesheet" type="text/css">
	<link rel="short icon" href="${ pageContext.request.contextPath }/resources/uploads/images/favicon.ico">	
	<link rel="apple-touch-icon" href="${ pageContext.request.contextPath }/resources/uploads/images/favicon.png">
	<link rel="icon" sizes="192x192" href="${ pageContext.request.contextPath }/resources/uploads/images/favicon.png">
</head>
<body>
	<div class="full">
		<div class="menu">
			<ul>
				<li><a class="active"
					href="${pageContext.request.contextPath }/home/index"><i
						class="home"></i></a></li>
				<li><a href="${pageContext.request.contextPath }/video"><div
							class="video">
							<i class="videos"></i><i class="videos1"></i>
						</div></a></li>
				<li><a
					href="${pageContext.request.contextPath }/${ sessionScope.currentUser != null ? 'account':'login' }"><div
							class="cat">
							<i class="watching"></i><i class="watching1"></i>
						</div></a></li>
				<li><a href="${pageContext.request.contextPath }/schedule/all"><div
							class="bk">
							<i class="booking"></i><i class="booking1"></i>
						</div></a></li>
				<li><a href="${pageContext.request.contextPath }/aboutus"><div
							class="cnt">
							<i class="contact"></i><i class="contact1"></i>
						</div></a></li>
			</ul>
		</div>
		<div class="main">
			<tiles:insertAttribute name="content"></tiles:insertAttribute>
			<div class="footer" style="margin-top: 250px;">
				<h6>Disclaimer :</h6>
				<p class="claim">This is a freebies and not an official website,
					I have no intention of disclose any movie, brand, news.My goal here
					is to train or excercise my skill and share this freebies.</p>
				<a href="example@mail.com">example@mail.com</a>
				<div class="copyright">
					<p>
						Template by <a href="http://w3layouts.com"> W3layouts</a>
					</p>
				</div>
			</div>
		</div>
	</div>


	<br>
	<br>


</body>
</html>