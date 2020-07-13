<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Admin | ${ title }</title>
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/admin/plugins/fontawesome-free/css/all.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<!-- Tempusdominus Bbootstrap 4 -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/admin/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
<!-- iCheck -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/admin/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
<!-- JQVMap -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/admin/plugins/jqvmap/jqvmap.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/admin/dist/css/adminlte.min.css">
<!-- Pagination -->
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/resources/admin/css/pagination.css">
<!-- overlayScrollbars -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/admin/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
<!-- Daterange picker -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/admin/plugins/daterangepicker/daterangepicker.css">
<!-- summernote -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/admin/plugins/summernote/summernote-bs4.css">
<!-- Google Font: Source Sans Pro -->
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link rel="shorcut icon"
	href="${ pageContext.request.contextPath }/resources/uploads/images/admin.ico">
<link rel="apple-touch-icon"
	href="${ pageContext.request.contextPath }/resources/uploads/images/admin.png">
<link rel="icon" sizes="192x192"
	href="${ pageContext.request.contextPath }/resources/uploads/images/admin.png">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
	<div class="wrapper">
		<!-- Main Sidebar Container -->
		<aside class="main-sidebar sidebar-dark-primary elevation-4">
			<!-- Brand Logo -->
			<a href="${ pageContext.request.contextPath }/dashboard/welcome"
				class="brand-link"> <img
				src="${pageContext.request.contextPath}/resources/admin/dist/img/AdminLTELogo.png"
				alt="AdminLTE Logo" class="brand-image img-circle elevation-3"
				style="opacity: .8"> <span
				class="brand-text font-weight-light">Admin</span>
			</a>

			<!-- Sidebar -->
			<div class="sidebar">
				<!-- Sidebar Menu -->
				<nav class="mt-2">
					<ul class="nav nav-pills nav-sidebar flex-column"
						data-widget="treeview" role="menu" data-accordion="false">
						<!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
						<c:if test="${ sessionScope.user.role.equals('ROLE_ADMIN') }">
							<li
								class="nav-item has-treeview ${ title.contains('Cinema') ? 'menu-open' : '' }"><a
								href="#" class="nav-link"> <i class="nav-icon fas fa-table"></i>
									<p>
										Report <i class="fas fa-angle-left right"></i>
									</p>
							</a>
								<ul class="nav nav-treeview">
									<li class="nav-item"><a
										href="${ pageContext.request.contextPath }/admin/report/index"
										class="nav-link"> <i class="far fa-circle nav-icon"></i>
											<p>report</p>
									</a></li>
								</ul></li>
							<li
								class="nav-item has-treeview ${ title.contains('Cinema') ? 'menu-open' : '' }"><a
								href="#" class="nav-link"> <i class="nav-icon fas fa-table"></i>
									<p>
										Cinemas <i class="fas fa-angle-left right"></i>
									</p>
							</a>
								<ul class="nav nav-treeview">
									<li class="nav-item"><a
										href="${ pageContext.request.contextPath }/admin/cinema/add"
										class="nav-link"> <i class="far fa-circle nav-icon"></i>
											<p>Add</p>
									</a></li>
									<li class="nav-item"><a
										href="${ pageContext.request.contextPath }/admin/cinema/index"
										class="nav-link"> <i class="far fa-circle nav-icon"></i>
											<p>List</p>
									</a></li>
								</ul></li>
							<li
								class="nav-item has-treeview ${ title.contains('Room') ? 'menu-open' : '' }"><a
								href="#" class="nav-link"> <i class="nav-icon fas fa-table"></i>
									<p>
										Rooms <i class="fas fa-angle-left right"></i>
									</p>
							</a>
								<ul class="nav nav-treeview">
									<li class="nav-item"><a
										href="${ pageContext.request.contextPath }/admin/room/add"
										class="nav-link"> <i class="far fa-circle nav-icon"></i>
											<p>Add</p>
									</a></li>
									<li class="nav-item"><a
										href="${ pageContext.request.contextPath }/admin/room/index"
										class="nav-link"> <i class="far fa-circle nav-icon"></i>
											<p>List</p>
									</a></li>
								</ul></li>
							<li
								class="nav-item has-treeview ${ title.contains('Seat') ? 'menu-open' : '' }"><a
								href="#" class="nav-link"> <i class="nav-icon fas fa-table"></i>
									<p>
										Seat <i class="fas fa-angle-left right"></i>
									</p>
							</a>
								<ul class="nav nav-treeview">
									<li class="nav-item"><a
										href="${ pageContext.request.contextPath }/admin/seat/add"
										class="nav-link"> <i class="far fa-circle nav-icon"></i>
											<p>Add</p>
									</a></li>
									<li class="nav-item"><a
										href="${ pageContext.request.contextPath }/admin/seat/index"
										class="nav-link"> <i class="far fa-circle nav-icon"></i>
											<p>List</p>
									</a></li>
								</ul></li>
							<li
								class="nav-item has-treeview ${ title.contains('Movie') ? 'menu-open' : '' }"><a
								href="#" class="nav-link"> <i class="nav-icon fas fa-table"></i>
									<p>
										Movies <i class="fas fa-angle-left right"></i>
									</p>
							</a>
								<ul class="nav nav-treeview">
									<li class="nav-item"><a
										href="${ pageContext.request.contextPath }/admin/movie/add"
										class="nav-link"> <i class="far fa-circle nav-icon"></i>
											<p>Add</p>
									</a></li>
									<li class="nav-item"><a
										href="${ pageContext.request.contextPath }/admin/movie/index"
										class="nav-link"> <i class="far fa-circle nav-icon"></i>
											<p>List</p>
									</a></li>
								</ul></li>
							<li
								class="nav-item has-treeview ${ title.contains('Schedule') ? 'menu-open' : '' }"><a
								href="#" class="nav-link"> <i class="nav-icon fas fa-table"></i>
									<p>
										Schedules <i class="fas fa-angle-left right"></i>
									</p>
							</a>
								<ul class="nav nav-treeview">
									<li class="nav-item"><a
										href="${ pageContext.request.contextPath }/admin/schedule/add"
										class="nav-link"> <i class="far fa-circle nav-icon"></i>
											<p>Add</p>
									</a></li>
									<li class="nav-item"><a
										href="${ pageContext.request.contextPath }/admin/schedule/index"
										class="nav-link"> <i class="far fa-circle nav-icon"></i>
											<p>List</p>
									</a></li>
								</ul></li>
						</c:if>
						<li
							class="nav-item has-treeview ${ title.contains('User') ? 'menu-open' : '' }"><a
							href="#" class="nav-link"> <i class="nav-icon fas fa-table"></i>
								<p>
									Users <i class="fas fa-angle-left right"></i>
								</p>
						</a>
							<ul class="nav nav-treeview">
								<c:if test="${ sessionScope.user.role.equals('ROLE_ADMIN') }">
									<li class="nav-item"><a
										href="${ pageContext.request.contextPath }/admin/users/index"
										class="nav-link"> <i class="far fa-circle nav-icon"></i>
											<p>List</p>
									</a></li>
									<li class="nav-item"><a
										href="${ pageContext.request.contextPath }/admin/users/add"
										class="nav-link"> <i class="far fa-circle nav-icon"></i>
											<p>New User</p>
									</a></li>
								</c:if>
								<li class="nav-item"><a
									href="${ pageContext.request.contextPath }/user/users/edit"
									class="nav-link"> <i class="far fa-circle nav-icon"></i>
										<p>Update</p>
								</a></li>
								<li class="nav-item"><a
									href="${ pageContext.request.contextPath }/user/users/details"
									class="nav-link"> <i class="far fa-circle nav-icon"></i>
										<p>Details</p>
								</a></li>
							</ul></li>
						<li
							class="nav-item has-treeview ${ title.contains('Booking') ? 'menu-open' : '' }"><a
							href="#" class="nav-link"> <i class="nav-icon fas fa-table"></i>
								<p>
									Bookings <i class="fas fa-angle-left right"></i>
								</p>
						</a>
							<ul class="nav nav-treeview">

								<li class="nav-item"><a
									href="${ pageContext.request.contextPath }/user/booking/index"
									class="nav-link"> <i class="far fa-circle nav-icon"></i>
										<p>List</p>
								</a></li>
							</ul></li>
					</ul>
				</nav>
				<!-- /.sidebar-menu -->
			</div>
			<!-- /.sidebar -->
		</aside>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<c:if test="${ sessionScope.message != null }">
				<div id="AlertBox" class="alert ${ sessionScope.type } hide">
					${ sessionScope.message }</div>
			</c:if>
			<tiles:insertAttribute name="content"></tiles:insertAttribute>
		</div>
		<!-- Content Header (Page header) -->
		<!-- /.content-wrapper -->


		<!-- Control Sidebar -->
		<aside class="control-sidebar control-sidebar-dark">
			<!-- Control sidebar content goes here -->
		</aside>
		<!-- /.control-sidebar -->
	</div>
	<!-- ./wrapper -->

	<!-- jQuery -->
	<script
		src="${pageContext.request.contextPath}/resources/admin/plugins/jquery/jquery.min.js"></script>

	<!-- jQuery UI 1.11.4 -->
	<script
		src="${pageContext.request.contextPath}/resources/admin/plugins/jquery-ui/jquery-ui.min.js"></script>
	<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
	<script>
		$.widget.bridge('uibutton', $.ui.button)
	</script>
	<!-- Bootstrap 4 -->
	<script
		src="${pageContext.request.contextPath}/resources/admin/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	${ script }
	<!-- mainJS -->
	<script
		src="${ pageContext.request.contextPath }/resources/admin/js/main.js"></script>
	<!-- ChartJS -->
	<script
		src="${pageContext.request.contextPath}/resources/admin/plugins/chart.js/Chart.min.js"></script>
	<!-- Sparkline -->
	<script
		src="${pageContext.request.contextPath}/resources/admin/plugins/sparklines/sparkline.js"></script>
	<!-- JQVMap -->
	<script
		src="${pageContext.request.contextPath}/resources/admin/plugins/jqvmap/jquery.vmap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/admin/plugins/jqvmap/maps/jquery.vmap.usa.js"></script>
	<!-- jQuery Knob Chart -->
	<script
		src="${pageContext.request.contextPath}/resources/admin/plugins/jquery-knob/jquery.knob.min.js"></script>
	<!-- daterangepicker -->
	<script
		src="${pageContext.request.contextPath}/resources/admin/plugins/moment/moment.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/admin/plugins/daterangepicker/daterangepicker.js"></script>
	<!-- Tempusdominus Bootstrap 4 -->
	<script
		src="${pageContext.request.contextPath}/resources/admin/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
	<!-- Summernote -->
	<script
		src="${pageContext.request.contextPath}/resources/admin/plugins/summernote/summernote-bs4.min.js"></script>
	<!-- overlayScrollbars -->
	<script
		src="${pageContext.request.contextPath}/resources/admin/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
	<!-- AdminLTE App -->
	<script
		src="${pageContext.request.contextPath}/resources/admin/dist/js/adminlte.js"></script>
	<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
	<script
		src="${pageContext.request.contextPath}/resources/admin/dist/js/pages/dashboard.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script
		src="${pageContext.request.contextPath}/resources/admin/dist/js/demo.js"></script>
</body>
</html>
