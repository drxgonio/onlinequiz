<%@ tag language="java" pageEncoding="UTF-8"%>
<div class="sidebar" data-color="blue" data-active-color="danger">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<div class="logo">
		<a href="http://www.creative-tim.com" class="simple-text logo-mini">
			<div class="logo-image-small">
				<img
					src="${pageContext.request.contextPath}/assets/img/logo-small.png">
			</div>
		</a> <a href="http://www.creative-tim.com" class="simple-text logo-normal">
			Group 2 </a>
	</div>
	<div class="sidebar-wrapper">
		<ul class="nav">
			<li><a href="${pageContext.request.contextPath}/HomeQuizController"> <i class="nc-icon nc-bank"></i> Trang chủ
			</a></li>

			<li><a href="#"> <i
					class="nc-icon nc-bell-55"></i> Thông báo
			</a></li>
			<li><a href="${pageContext.request.contextPath}/Profile"> <i class="nc-icon nc-single-02"></i>
					Hồ sơ
			</a></li>
<!-- Quản lý người tạo câu hỏi -->
			<c:if test="${loginedUser.roleObject.roleName eq 'asma' }">
				<li><a href="${pageContext.request.contextPath}/ListQuestion">
						<i class="nc-icon nc-tile-56"></i> Câu hỏi
				</a></li>
			</c:if>

<!-- phân quyền người quản lý đề thi -->
			<c:if test="${loginedUser.roleObject.roleName eq 'exma' }">
				<li><a href="${pageContext.request.contextPath}/ListExam">
						<i class="nc-icon nc-pin-3"></i> Quản Lý Đề Thi
				</a></li>
			</c:if>
			<!--End Đề thi-->
			<!--Sinh viên-->
<!-- phân quyền người quản lý sinh viên và lớp học -->
			<c:if test="${loginedUser.roleObject.roleName eq 'stuma' }">
				<li><a href="${pageContext.request.contextPath}/ListAllStudent">
						<i class="nc-icon nc-tile-56"></i> Sinh viên
				</a></li>
				<li><a href="${pageContext.request.contextPath}/ListStudent">
						<i class="nc-icon nc-tile-56"></i>Sinh Viên Của Lớp Học
				</a></li>
				<li><a href="${pageContext.request.contextPath}/ListCourses">
						<i class="nc-icon nc-briefcase-24"></i> Lớp Học
				</a></li>
				<li><a href="${pageContext.request.contextPath}/ListCoursesExam">
						<i class="nc-icon nc-briefcase-24"></i> Đề thi lớp học
				</a></li>
			</c:if>
<!-- 	phân quyền admin -->
			<c:if test="${loginedUser.roleObject.roleName eq 'ad' }">
				<li><a href="${pageContext.request.contextPath}/ListQuestion">
						<i class="nc-icon nc-tile-56"></i> Câu hỏi
				</a></li>
				<li><a href="${pageContext.request.contextPath}/ListExam">
						<i class="nc-icon nc-pin-3"></i> Quản Lý Đề Thi
				</a></li>
				<li><a href="${pageContext.request.contextPath}/ListAllStudent">
						<i class="nc-icon nc-tile-56"></i> Sinh viên
				</a></li>
				<li><a href="${pageContext.request.contextPath}/ListStudent">
						<i class="nc-icon nc-tile-56"></i>Sinh Viên Của Lớp Học
				</a></li>
				<li><a href="${pageContext.request.contextPath}/ListCourses">
						<i class="nc-icon nc-briefcase-24"></i> Lớp Học
				</a></li>
				<li><a href="${pageContext.request.contextPath}/ListCoursesExam">
						<i class="nc-icon nc-briefcase-24"></i> Đề thi lớp học
				</a></li>
			</c:if>
			<li><a href="${pageContext.request.contextPath}/Logout"> <i
					class="nc-icon nc-pin-3"></i> Đăng Xuất
			</a></li>

		</ul>
	</div>
</div>