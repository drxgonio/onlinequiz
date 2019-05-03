<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<t:WrapperAdmin>
	<div class="row">
		<div class="col-md-12">
			<div class="card">
				<div class="card-header">
					<div class="row">
						<div class="col-md-3">
							<h5 class="card-title">Danh sách Sinh viên</h5>
						</div>
						<div class="col-md-3">
							<a class="btn btn-success" href="./addStudent.jsp"> <i
								class="fa fa-plus"></i> Thêm đề thi
							</a>
						</div>
						<div class="navbar navbar-light">
							<a class="navbar-brand"> Navbar </a>
							<form class="form-inline">
								<input class="form-control " type="search"
									placeholder="Tìm kiếm .." aria-label="Search">
								<button class="btn btn-outline-success  py-2 my-sm-0"
									type="submit">
									<i class="fa fa-search"></i>
								</button>
							</form>
						</div>
					</div>
				</div>
				<div class="card-body">
					<div class="row justify-content-center">
						<div class="col-md-8">
							<select class="custom-select" id="inputGroupSelect01" onchange="location = this.value;">
								<option selected>Chọn lớp ...</option>
							
								<c:forEach items="${lsCourses}" var="item">
									<option value="${pageContext.request.contextPath}/ListCoursesExam?idCourse=${item.courseId}">${item.courseId}----${item.subjectIdObject.subjectName}-----${item.dateOfStarting}-----${item.dateOfWeek}</option>
								
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="table-responsive">
						<table class="table">
							<thead class=" text-primary">
								<tr>
									<th width="2%"><input type="checkbox"
										aria-label="Radio button for following text input"></th>
									<th width="8%">Mã Đề</th>
									<th width="20%">Tên Đề</th>

									<th width="10%">Thời gian bắt đầu</th>
									<th width="10%">Thời gian kết thúc</th>
									<th width="10%">Số câu hỏi</th>
									
									<th class="20%">Tùy chọn</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="item">

									<tr>
										<td><input type="checkbox"
											aria-label="Radio button for following text input"></td>
										<td>${item.id}</td>
										<td>${item.name}</td>
										<td>${item.timeStarting}</td>
										<td>${item.timeFinishing}</td>
										<td>${item.numQuestions}</td>
									
										<td>
											<button class="btn btn-success" data-toggle="modal"
												data-target="#modalStudent">
												<i class="fa fa-eye"></i>
											</button>
											<%-- <a
												href="${pageContext.request.contextPath}/DeleteStudentCourse?command=delete&student=${item.studentId}&idCourse=${param.idCourse}"
												class="btn btn-danger"> <i class="fa fa-trash"></i></a> --%>
												<a
												href="#"
												class="btn btn-danger"> <i class="fa fa-trash"></i></a>
										</td>
									</tr>

								</c:forEach>


							</tbody>
						</table>
						<nav aria-label="Page navigation example">
							<ul class="pagination justify-content-center">
								<li class="page-item disabled"><a class="page-link"
									href="#" tabindex="-1">Previous</a></li>
									<c:forEach var="i" begin="1" end="${numberPage}">
										<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/ListStudent?page=${i}">${i}</a></li>
									</c:forEach>
								<li class="page-item"><a class="page-link" href="#">Next</a>
								</li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</div>

	</div>
</t:WrapperAdmin>