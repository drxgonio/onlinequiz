<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Web Thi Thử Trắc Nghiệm Online</title>

<!-- Meta tag Keywords -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<meta name="keywords"
	content="Eduversity Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
	Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript">
	
		addEventListener("load", function () {
			setTimeout(hideURLbar, 0);
		}, false);

		function hideURLbar() {
			window.scrollTo(0, 1);
		}
	
</script>
<!--// Meta tag Keywords -->

<!-- css files -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/def/css/bootstrap.css">
<!-- Bootstrap-Core-CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/def/css/style.css"
	type="text/css" media="all" />
<!-- Style-CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/def/css/fontawesome-all.css">
<!-- Font-Awesome-Icons-CSS -->
<!-- //css files -->

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/def/css/jquery.countdown.css" />

<!--web font-->


</head>

<body>


	<!-- header -->
	<header>
		<div class="container">
			<!-- top header -->

			<!-- nav -->
			<nav class="navbar navbar-expand-lg navbar-light py-sm-4 py-2">
				<!-- logo -->
				<h1>
					<a class="navbar-brand" href="${pageContext.request.contextPath}/Home"> <i
						class="fab fa-affiliatetheme"></i> Eduversity
					</a>
				</h1>
				<!-- //logo -->
				<button class="navbar-toggler ml-md-auto" type="button"
					data-toggle="collapse" data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<!-- main nav -->
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav ml-lg-auto text-center">
						<li class="nav-item active  mr-lg-3"><a class="nav-link"
							href="${pageContext.request.contextPath}/Home">Trang chủ <span class="sr-only">(current)</span>
						</a></li>
						
						<li class="nav-item mr-lg-3"><a class="nav-link"
							href="#">Môn học</a></li>
						<li class="dropdown nav-item mr-lg-3"><a href="#"
							data-toggle="dropdown" class="nav-link dropdown-toggle ">
								Đề thi <b class="caret"></b>
						</a>
							<ul class="dropdown-menu" role="menu">
								<li class="nav-item"><a href="#" class="nav-link">Đề Mạng 2016</a>
								</li>
								<li class="nav-item"><a href="#" class="nav-link">Đề CNPM 2017</a>
								</li>
							</ul></li>
						<li class="nav-item mr-3"><a class="nav-link"
							href="${pageContext.request.contextPath}/Login">Đăng nhập</a></li>
						<!-- search --->
						<div class="search-bar-agileits">
							<div class="cd-main-header">
								<ul class="cd-header-buttons">
									<li><a class="cd-search-trigger" href="#cd-search"> <span></span></a></li>
								</ul>
								<!-- cd-header-buttons -->
							</div>
							<div id="cd-search" class="cd-search">
								<form action="#" method="post">
									<input name="Search" type="search"
										placeholder="Click enter after typing...">
								</form>
							</div>
						</div>
						<!-- search --->
					</ul>
				</div>
				<!-- //main nav -->
			</nav>
			<!-- //nav -->
		</div>
	</header>
	<!-- //header -->

	<!-- banner -->
	<section class="banner layer" id="home">
		<div class="container">
			<div class="banner-text">
				<div class="slider-info mb-4">
					<div class="agileinfo-logo">
						<h3>Practice makes you better</h3>
					</div>
					<h3 class="txt-w3_agile mb-3">Its time to master your skills</h3>
					<a href="#" class="mr-2"><i
						class="fas fa-graduation-cap"></i> Our Courses</a> <a
						href="#"><i class="fas fa-book"></i> Read More</a>
				</div>
				<!-- To bottom button-->
				<div class="thim-click-to-bottom">
					<div class="rotate">
						<a href="#welcome" class="scroll"> <i
							class="fas fa-angle-double-down"></i>
						</a>
					</div>
				</div>
				<!-- //To bottom button-->

			</div>
		</div>
	</section>
	<!-- //banner -->

	<!-- welcome -->


	<!-- services -->
	<section class="services py-5">
		<div class="container py-sm-3">
			<h3 class="heading text-capitalize mb-lg-5 mb-4">
				Sách Chuyên Ngành - <span>What We Offer</span>
			</h3>
			<div class="row service-grids">
				<div class="col-lg-4 col-md-6">
					<div class="service-grid1">
						<i class="fas fa-globe"></i>
						<h5>1</h5>
						<h4 class="mb-3">Free Online Courses</h4>
						<p>Aenean tristique, duiid blandit elt ultricies, ligula elit
							interd ures turpis, a bibendum lib.</p>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 mt-md-0 mt-5">
					<div class="service-grid1">
						<i class="fas fa-book"></i>
						<h5>2</h5>
						<h4 class="mb-3">Digital Library</h4>
						<p>Aenean tristique, duiid blandit elt ultricies, ligula elit
							interd ures turpis, a bibendum lib.</p>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 mt-lg-0 mt-5">
					<div class="service-grid1">
						<i class="fab fa-digital-ocean"></i>
						<h5>3</h5>
						<h4 class="mb-3">Unlimited Courses</h4>
						<p>Aenean tristique, duiid blandit elt ultricies, ligula elit
							interd ures turpis, a bibendum lib.</p>
					</div>
				</div>
				<div class="ser-button mt-4">
					<a href="#">Explore all services</a>
				</div>
			</div>
		</div>
	</section>
	<!-- //services -->


	<!-- teachers -->
	<!-- team -->
	<div class="team py-5">
		<div class="container py-sm-3">
			<h3 class="heading text-capitalize mb-lg-5 mb-4">Danh sách các
				giáo viên</h3>
			<div class="row agile-team-grids">
				<div class="col-lg-3 col-sm-6 team-grid">
					<div class="team-img">
						<img src="${pageContext.request.contextPath}/def/images/t1.jpg"
							class="img-responsive" alt=" " />
						<div class="overlay">
							<h5>Khoa CNTT</h5>
							<p>Môn dạy: Mạng Máy Tính</p>
							<div class="w3l-social">
								<ul>
									<li><a href="#"><i class="fab fa-facebook-f"></i></a></li>
									<li><a href="#"><i class="fab fa-twitter"></i></a></li>
									<li><a href="#"><i class="fa fa-rss"></i></a></li>
								</ul>
							</div>
						</div>
					</div>
					<h4>Nguyễn Thị Thu Châu</h4>
					<span>Teacher</span>
				</div>
				<div class="col-lg-3 col-sm-6 mt-md-0 mt-5 team-grid">
					<div class="team-img">
						<img src="${pageContext.request.contextPath}/def/images/t3.jpg"
							class="img-responsive" alt=" " />
						<div class="overlay">
							<h5>Khoa CNNT</h5>
							<p>Môn dạy: Công nghệ phần mềm</p>
							<div class="w3l-social">
								<ul>
									<li><a href="#"><i class="fab fa-facebook-f"></i></a></li>
									<li><a href="#"><i class="fab fa-twitter"></i></a></li>
									<li><a href="#"><i class="fa fa-rss"></i></a></li>
								</ul>
							</div>
						</div>
					</div>
					<h4>Nguyễn Văn A</h4>
					<span>Teacher</span>
				</div>
				<div class="col-lg-3 col-sm-6 mt-lg-0 mt-5 team-grid">
					<div class="team-img">
						<img src="${pageContext.request.contextPath}/def/images/t2.jpg"
							class="img-responsive" alt=" " />
						<div class="overlay">
							<h5>voluptatem quia</h5>
							<p>sit aspernatur aut odit</p>
							<div class="w3l-social">
								<ul>
									<li><a href="#"><i class="fab fa-facebook-f"></i></a></li>
									<li><a href="#"><i class="fab fa-twitter"></i></a></li>
									<li><a href="#"><i class="fa fa-rss"></i></a></li>
								</ul>
							</div>
						</div>
					</div>
					<h4>Mike Arney</h4>
					<span>Teacher</span>
				</div>
				<div class="col-lg-3 col-sm-6 mt-lg-0 mt-5 team-grid">
					<div class="team-img">
						<img src="${pageContext.request.contextPath}/def/images/t4.jpg"
							class="img-responsive" alt=" " />
						<div class="overlay">
							<h5>voluptatem quia</h5>
							<p>sit aspernatur aut odit</p>
							<div class="w3l-social">
								<ul>
									<li><a href="#"><i class="fab fa-facebook-f"></i></a></li>
									<li><a href="#"><i class="fab fa-twitter"></i></a></li>
									<li><a href="#"><i class="fa fa-rss"></i></a></li>
								</ul>
							</div>
						</div>
					</div>
					<h4>Mary Jane</h4>
					<span>Teacher</span>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!-- //team -->

	<!-- //teachers -->

	<!-- footer -->
	<footer>
		<div class="container-fluid p-sm-5 py-5">
			<div class="row footer-gap">



			</div>
		</div>
		<div class="copyright pb-5 text-center">
			
			<p>
				© 2018 Eduversity. All Rights Reserved | Design by <a
					href="http://www.W3Layouts.com" target="_blank">Group 2</a>
			</p>
		</div>
	</footer>
	<!-- footer -->
	<!-- Login modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel1" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title text-uppercase" id="exampleModalLabel1">Login</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="#" method="post" class="p-3">
						<div class="form-group">
							<label for="recipient-name" class="col-form-label">User
								Name</label> <input type="email" class="form-control"
								placeholder="User Name" name="Name" id="recipient-name"
								required="">
						</div>
						<div class="form-group">
							<label for="recipient-name1" class="col-form-label">Password</label>
							<input type="password" class="form-control"
								placeholder="Password" name="Name" id="recipient-name1"
								required="">
						</div>
						<div class="right-w3l mt-4 mb-3">
							<input type="submit" class="form-control" value="Login">
						</div>
					</form>

				</div>
			</div>
		</div>
	</div>
	<!-- //Login modal -->

	<!-- Register modal -->
	<div class="modal fade" id="exampleModal1" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel1" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title text-uppercase" id="exampleModalLabel1">Register
						Here</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="#" method="post" class="p-3">
						<div class="form-group">
							<label for="recipient-name" class="col-form-label">First
								Name</label> <input type="text" class="form-control"
								placeholder="First Name" name="Name" id="recipient-name2"
								required="">
						</div>
						<div class="form-group">
							<label for="recipient-name" class="col-form-label">Last
								Name</label> <input type="text" class="form-control"
								placeholder="Last Name" name="Name" id="recipient-name3"
								required="">
						</div>
						<div class="form-group">
							<label for="recipient-name" class="col-form-label">Email
								id</label> <input type="email" class="form-control"
								placeholder="Email id" name="Name" id="recipient-name4"
								required="">
						</div>
						<div class="form-group">
							<label for="recipient-name" class="col-form-label">Mobile
								Number</label> <input type="text" class="form-control"
								placeholder="Mobile Number" name="Name" id="recipient-name5"
								required="">
						</div>
						<div class="form-group">
							<label for="recipient-name1" class="col-form-label">Password</label>
							<input type="password" class="form-control"
								placeholder="Password" name="Name" id="recipient-name6"
								required="">
						</div>
						<div class="right-w3l mt-4 mb-3">
							<input type="submit" class="form-control" value="Create account">
						</div>
					</form>

				</div>
			</div>
		</div>
	</div>
	<!-- //Register modal -->


	<!-- js -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/def/js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/def/js/bootstrap.js"></script>
	<!-- Necessary-JavaScript-File-For-Bootstrap -->
	<!-- //js -->

	<!-- search-bar -->
	<script src="${pageContext.request.contextPath}/def/js/main.js"></script>
	<!-- //search-bar -->

	<!-- Countdown-Timer-JavaScript -->
	<script
		src="${pageContext.request.contextPath}/def/js/simplyCountdown.js"></script>
	<!-- easy to customize -->
	<script>
		$('#simply-countdown-losange').simplyCountdown({
			year : 2020,
			month : 1,
			day : 06
		});
	</script>
	<!-- //Countdown-Timer-JavaScript -->

	<!-- start-smoth-scrolling -->
	<script
		src="${pageContext.request.contextPath}/def/js/SmoothScroll.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/def/js/move-top.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/def/js/easing.js"></script>
	<script type="text/javascript">
		jQuery(document).ready(function($) {
			$(".scroll").click(function(event) {
				event.preventDefault();
				$('html,body').animate({
					scrollTop : $(this.hash).offset().top
				}, 1000);
			});
		});
	</script>
	<!-- here stars scrolling icon -->
	<script type="text/javascript">
		$(document).ready(function() {
			/*
				var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
				};
			 */

			$().UItoTop({
				easingType : 'easeOutQuart'
			});

		});
	</script>
	<!-- //here ends scrolling icon -->
	<!-- start-smoth-scrolling -->

</body>
</html>