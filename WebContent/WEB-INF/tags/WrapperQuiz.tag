<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Danh sách các đề thi</title>
<meta name="description"
	content="Free Bootstrap Theme by BootstrapMade.com">
<meta name="keywords"
	content="free website templates, free bootstrap themes, free template, free bootstrap, free website template">

<link rel="stylesheet" type="text/css"
	href="https://fonts.googleapis.com/css?family=Open+Sans|Candal|Alegreya+Sans">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/assetquiz/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/assetquiz/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/assetquiz/css/imagehover.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/assetquiz/css/style3.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assetquiz/css/datepickk.min.css">
<script
	src="${pageContext.request.contextPath}/assetquiz/js/datepickk.min.js"></script>


<script
	src="${pageContext.request.contextPath}/assetquiz/js/jquery-3.3.1.min.js"></script>
<!-- =======================================================
    Theme Name: Mentor
    Theme URL: https://bootstrapmade.com/mentor-free-education-bootstrap-theme/

    Author: BootstrapMade.com
    Author URL: https://bootstrapmade.com
  ======================================================= -->
<script>
	addEventListener("load", function() {
		setTimeout(hideURLbar, 0);
	}, false);

	function hideURLbar() {
		window.scrollTo(0, 1);
	}
</script>
<!-- //Meta-Tags -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/assetquiz/css/style1.css" />
<!-- calendar css -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/assetquiz/css/pignose.calendar.min.css" />
<!-- online fonts -->
<link
	href="//fonts.googleapis.com/css?family=Fira+Sans:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">
</head>

<body>
<!-- Subiz -->
	<script>
	(function(s, u, b, i, z){
	  u[i]=u[i]||function(){
	    u[i].t=+new Date();
	    (u[i].q=u[i].q||[]).push(arguments);
	  };
	  z=s.createElement('script');
	  var zz=s.getElementsByTagName('script')[0];
	  z.async=1; z.src=b; z.id='subiz-script';
	  zz.parentNode.insertBefore(z,zz);
	})(document, window, 'https://widgetv4.subiz.com/static/js/app.js', 'subiz');
	subiz('setAccount', 'acqewmptbqzepqdsalsd');
	</script>


<!-- End Subiz -->
	<!--Navigation bar-->
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.html">Thi trắc nghiệm Online</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#feature">Đề thi</a></li>
					<li><a href="#organisations">Kiến thức</a></li>
					<li><a href="#courses">Thi thử</a></li>
					<li><a href="about.jsp">Liên hệ</a></li>
					<c:if test="${not empty loginedUser}">
						<li><a href="${pageContext.request.contextPath}/HistoryExam">Lịch
								Sử Thi</a></li>
						<c:if test="${loginedUser.roleObject.roleName eq 'stu' }">
							<li><a href="${pageContext.request.contextPath}/Logout">Đăng
									xuất</a></li>
						</c:if>

						<c:if test="${loginedUser.roleObject.roleName eq 'asma' }">
							<li><a
								href="${pageContext.request.contextPath}/ListQuestion">Quản
									Lý Câu Hỏi</a></li>
							<li><a href="${pageContext.request.contextPath}/Logout">Đăng
									xuất</a></li>
						</c:if>

						<c:if test="${loginedUser.roleObject.roleName eq 'stuma' }">
							<li><a
								href="${pageContext.request.contextPath}/ListAllStudent">Quản
									Lý Học Sinh</a></li>
							<li><a href="${pageContext.request.contextPath}/Logout">Đăng
									xuất</a></li>
						</c:if>

						<c:if test="${loginedUser.roleObject.roleName eq 'exma' }">
							<li><a href="${pageContext.request.contextPath}/ListExam">Quản
									Lý Đề Thi</a></li>
							<li><a href="${pageContext.request.contextPath}/Logout">Đăng
									xuất</a></li>
						</c:if>


						<c:if test="${loginedUser.roleObject.roleName eq 'ad' }">
							<li><a
								href="${pageContext.request.contextPath}/ListQuestion">Quản
									Lý</a></li>
							<li><a href="${pageContext.request.contextPath}/Logout">Đăng
									xuất</a></li>
						</c:if>
						<span style="color: #2da32c;font-weight: bold; border: solid 1px; border-radius:5px;">${loginedUser.userName}</span>


					</c:if>
					<c:if test="${empty loginedUser}">
						<li><a href="${pageContext.request.contextPath}/Login">Đăng
								nhập</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</nav>
	<!--/ Navigation bar-->

	<!--Modal box-->

	<!--/ Modal box-->
	<!--Banner-->
	<!--   <div class="banner">
    <div class="bg-color">
      <div class="container">
        <div class="row">
          <div class="banner-text text-center">
            <div class="text-border">
              <h2 class="text-dec">Ứng dụng thi trắc nghiệm</h2>
            </div>
            <div class="intro-para text-center quote">
              <p class="big-text">Đề tài: Ngôn ngữ công nghệ thông tin</p>
              <p class="small-text">Gồm có 20 câu hỏi và câu trả lời. Nếu bạn trả lời đúng thì bạn được 0.5đ.
              Nếu làm full sẽ được 10 điểm. Chọn một câu trả lời đúng.</p>
               <p class="big-text">Danh sách đề thi</p>
              <a href="#footer" class="btn get-quote">Bắt đầu</a>
            </div>
            <a href="#feature" class="mouse-hover">
              <div class="mouse"></div>
            </a>
          </div>
        </div>
      </div>
    </div>
  </div> -->

	<jsp:doBody></jsp:doBody>

	<t:FooterQuiz></t:FooterQuiz>
</body>
</html>

