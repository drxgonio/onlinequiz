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
						<div class="col-md-4">
							<h4 class="card-title">Danh sách Lớp Học</h4>
						</div>
						<div class="col-md-3">
							<a class="btn btn-success" href="${pageContext.request.contextPath}/AddCourse"> <i
								class="fa fa-plus"></i> Mở lớp
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

					<div class="table-responsive">
						<table class="table">
							<thead class=" text-primary">
								<tr>
									<th width="2px"><input type="checkbox"
										aria-label="Radio button for following text input"></th>
									<th width="4px">Mã</th>
									<th>Tên lớp</th>

									<th width="15%">Môn học</th>
									<th width="10%">Thời gian</th>

									<th width="10%">Bắt đầu</th>
									<th width="10%">Kết thúc</th>
									<th width="20%" class="mr-0">Tùy chọn</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="item">
									<tr>
										<td><input type="checkbox"
											aria-label="Radio button for following text input"></td>
										<td>${item.courseId}</td>
										<td>${item.name}</td>
										<td>${item.subjectIdObject.subjectName}</td>
										<td>  ${item.partOfStarting} - ${item.partOfEnding}</td>
										<td>${item.dateOfStarting}</td>
										<td>${item.dateOfEnding}</td>
										<td><a href="${pageContext.request.contextPath}/EditCourse?command=update&id=${item.courseId}&subjectName=${item.subjectIdObject.subjectName}" class="btn btn-warning"><i
												class="fa fa-pencil"></i></a>
											 <a
												href="${pageContext.request.contextPath}/EditCourse?command=delete&id=${item.courseId}"
												class="btn btn-danger"> <i class="fa fa-trash"></i></a></td>
									</tr>
								</c:forEach>



							</tbody>
						</table>
						<nav aria-label="Page navigation example">
							<ul class="pagination justify-content-center">

								<c:forEach var="i" begin="1" end="${numberPage}">
									<li class="page-item"><a class="page-link"
										href="${pageContext.request.contextPath}/ListCourse?page=${i}">${i}</a></li>
								</c:forEach>

							</ul>
						</nav>
					</div>
				</div>
			</div>
		</div>

	</div>
</t:WrapperAdmin>