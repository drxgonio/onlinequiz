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
							<h4 class="card-title">Danh sách Môn Học</h4>
						</div>	
						<div class="col-md-3">
							<a class="btn btn-success" href="AddSubject"> <i
								class="fa fa-plus"></i> Mở lớp
							</a>
						</div>
						<div class="navbar navbar-light">
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
								<th width="10px">Mã</th>

								<th >Môn học</th>
								<th width="10%">Khoa</th>

								<th width="10%">Số tín chỉ</th>
								<th width="10%">Loại môn</th>
								<th width="10%">Activate</th>
								<th width="15%" class="mr-0">Tùy chọn</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${list}" var="item">
								<tr>
									<td><input type="checkbox"
										aria-label="Radio button for following text input"></td>
									<td>${item.subjectID }</td>
									<td>${item.subjectName }</td>
									<td>${item.faculty}</td>
									<td>${item.credit }</td>
									<td>${item.type }</td>
									<td>${item.activate }</td>
									<td><a href="${pageContext.request.contextPath}/EditSubject?command=update&id=${item.subjectID}" class="btn btn-warning"><i
												class="fa fa-pencil"></i></a>
											 <a
												href="${pageContext.request.contextPath}/EditSubject?command=delete&id=${item.subjectID}"
												class="btn btn-danger"> <i class="fa fa-trash"></i></a>
												</td>
								</tr>
								</c:forEach>
								
							</tbody>
						</table>
						<nav aria-label="Page navigation example">
							<ul class="pagination justify-content-center">

								<c:forEach var="i" begin="1" end="${numberPage}">
									<li class="page-item"><a class="page-link"
										href="${pageContext.request.contextPath}/ListSubject?page=${i}">${i}</a></li>
								</c:forEach>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</div>

	</div>
</t:WrapperAdmin>