<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8" />
<link rel="apple-touch-icon"
	href="${pageContext.request.contextPath}/assets/img/apple-icon.png">
<link rel="icon" type="image/png"
	href="${pageContext.request.contextPath}/assets/img/favicon.png">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>Trang quản lý</title>
<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no'
	name='viewport' />
<!--     Fonts and icons     -->
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200"
	rel="stylesheet" />
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css"
	rel="stylesheet">
<!-- CSS Files -->
<link
	href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/assets/css/paper-dashboard.css?v=2.0.0"
	rel="stylesheet" />
<script
	src="${pageContext.request.contextPath}/assets/js/core/jquery-3.3.1.min.js"></script>
<!-- CSS Just for demo purpose, don't include it in your project -->
<link href="${pageContext.request.contextPath}/assets/demo/demo.css"
	rel="stylesheet" />
</head>

<body class="">
	<div class="wrapper">

		<t:SideMenuAdmin></t:SideMenuAdmin>

		<div class="main-panel">


			<t:Navbar></t:Navbar>
			<!-- End Navbar -->

			<div class="content">
				<jsp:doBody></jsp:doBody>
				<t:Footer></t:Footer>
			</div>


			<!--   Core JS Files   -->

			<script
				src="${pageContext.request.contextPath}/assets/js/core/popper.min.js"></script>
			<script
				src="${pageContext.request.contextPath}/assets/js/core/bootstrap.min.js"></script>
			<script
				src="${pageContext.request.contextPath}/assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
			<!--  Google Maps Plugin    -->
			<script
				src="${pageContext.request.contextPath}/assets/js/plugins/chartjs.min.js"></script>
			<!--  Notifications Plugin    -->
			<script
				src="${pageContext.request.contextPath}/assets/js/plugins/bootstrap-notify.js"></script>
			<!-- Control Center for Now Ui Dashboard: parallax effects, scripts for the example pages etc -->
			<script
				src="${pageContext.request.contextPath}/assets/js/paper-dashboard.min.js?v=2.0.0"
				type="text/javascript"></script>
			<!-- Paper Dashboard DEMO methods, don't include it in your project! -->
			<script src="${pageContext.request.contextPath}/assets/demo/demo.js"></script>
		</div>
	</div>
</body>
</html>