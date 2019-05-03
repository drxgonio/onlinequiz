<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<t:WrapperAdmin>
	<form class="row" action="/WebThi/EditCourses" method="post">
		<div class="col-md-12">
			<div class="card">
				<div class="card-header">
					<h3 class="card-title">
						<b> Chỉnh sửa lớp học </b>
					</h3>
					<div class="card-body">
							<div class="form-group row">
							<input type="hidden" name="id" value=${course.getCourseId() }>
								<label for="inputId" class="col-sm-2 col-form-label"> <b>Tên
										môn học</b></label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputId"
										value="${subjectName}" placeholder="Tên môn học" name="Subject" readonly>
								</div>
							</div>
							<div class="form-group row">
								<label for="inputName" class="col-sm-2 col-form-label">
									<b>Ngày trong tuần</b>
								</label>
								<div class="col-sm-4">

									<select class="custom-select" name="DateOfWeek">
										<option selected >${course.getDateOfWeek()}</option>
										<option value="Thứ 2">Thứ 2</option>
										<option value="Thứ 3">Thứ 3</option>
										<option value="Thứ 4">Thứ 4</option>
										<option value="Thứ 5">Thứ 5</option>
										<option value="Thứ 6">Thứ 6</option>
										<option value="Thứ 7">Thứ 7</option>
									</select>
								</div>
								<label for="inputName" class="col-sm-1 col-form-label">
									<b>Từ tiết</b>
								</label>
								<div class="col-sm-2">
									<input type="number" class="form-control"
										value="${course.getPartOfStarting() }" name="PartOfStarting">
								</div>
								<label for="inputName" class="col-sm-1 col-form-label">
									<b>đến</b>
								</label>
								<div class="col-sm-2">
									<input type="number" class="form-control"
										value="${course.getPartOfEnding() }" name="PartOfEnding">
								</div>
							</div>
							<div class="form-group row">
								<label for="inputId" class="col-sm-2 col-form-label"> <b>
										Số lượng </b></label>
								<div class="col-sm-4">
									<input type="number" class="form-control" id="inputId"
										value="${course.getNumberOfStudent() }" name="NumofStudents">
								</div>
								<label for="inputId" class="col-sm-1 col-form-label"> <b>
										Phòng học </b></label>
								<div class="col-sm-5">
									<input type="text" class="form-control" id="inputId"
										placeholder="Phòng học" value="${course.getRoom() }" name="Room">
								</div>
							</div>
							<div class="form-group row">
								<label for="inputId" class="col-md-2 col-form-label"> <b>
										Ngày bắt đầu </b></label>
								<div class="col-md-4">
									<input type="date" class="form-control" id="inputId"
										value="${course.getDateOfStarting()}"  name="DateOfStarting"/>
								</div>
								<label for="inputId" class="col-md-1 col-form-label"> <b>
										Ngày kết thúc </b></label>
								<div class="col-md-5">
									<input type="date" class="form-control" id="inputId"
										value="${course.getDateOfEnding()}" name="DateOfEnding">
								</div>
							</div>
							<div class="form-group row">
								<label for="inputId" class="col-md-2 col-form-label"> <b>
										Teacher </b></label>
								<div class="col-md-4">
									<input type="text" class="form-control" id="inputId"
										value="${course.getTeacher()}" name="Teacher"/>
								</div>
								<label for="inputId" class="col-md-1 col-form-label"> <b>
										Tên Lớp </b></label>
								<div class="col-md-5">
									<input type="text" class="form-control" id="inputId"
										value="${course.getName()}" name="Name">
								</div>

							</div>

					</div>
				</div>
			</div>

			<div class="row justify-content-center">
				<button type="submit" class="btn btn-info col-3">
					<i class="fa fa-save"></i>Lưu thay đổi
				</button>
				 <a href="${pageContext.request.contextPath}/ListCourse" class="btn btn-danger col-3"> <i
					class="fa fa-times"></i> Hủy
				</a>
			</div>

		</div>
	</form>
</t:WrapperAdmin>