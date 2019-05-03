<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:WrapperAdmin>
	<div class="row">
		<div class="col-md-12">
			<form class="col-md-12" action="/WebThi/AddCourse" method="post">
		
			<div class="card">
				<div class="card-header">
					<h3 class="card-title">
						<b> Thêm lớp học </b>
					</h3>
					<div class="card-body">
							<div class="form-group row">
								<label for="inputId" class="col-sm-2 col-form-label my-1"> <b>Tên
										lớp học</b></label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputId" name="name"
										placeholder="Tên môn học">
								</div>
							</div>
							<div class="form-group row">
								<label for="inputDay" class="col-sm-2 col-form-label my-1" for="inputDay">
									<b>Ngày trong tuần</b>
								</label>
								<div class="col-sm-4">
									<select class="custom-select" name="dayOfWeek" id="inputDay">
										<option selected value="Thứ 2">Thứ 2</option>
										<option value="Thứ 3">Thứ 3</option>
										<option value="Thứ 4">Thứ 4</option>
										<option value="Thứ 5">Thứ 5</option>
										<option value="Thứ 6">Thứ 6</option>
										<option value="Thứ 7">Thứ 7</option>
									</select>
								</div>
								<label  class="col-sm-2 col-form-label my-1" for="fromPart">
									<b>Từ tiết</b>
								</label>
								<div class="col-sm-1">
									<input type="number" class="form-control" id="fromPart" name="startPart">
								</div>
								<label class="col-sm-2 col-form-label my-1" for="endPart">
									<b>đến tiết</b>
								</label>
								<div class="col-sm-1">
									<input type="number" class="form-control" id="endPart" name="endPart">
								</div>
							</div>
							<div class="form-group row">
								<label for="num" class="col-sm-2 col-form-label my-1" > <b>
										Số sinh viên </b></label>
								<div class="col-sm-4">
									<input type="number" class="form-control" id="num" name="amount">
								</div>
								<label for="room" class="col-sm-2 col-form-label my-1"> <b>
										Phòng </b></label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="room" name="room"
										placeholder="Phòng học">
								</div>
							</div>
							<div class="form-group row">
								<label for="fromDate" class="col-md-2 col-form-label my-1"> <b>
										Ngày bắt đầu </b></label>
								<div class="col-md-4">
									<input type="date" class="form-control" id="fromDate" name="fromDate">
								</div>
								<label for="endDate" class="col-md-2 col-form-label my-1"> <b>
										kết thúc </b></label>
								<div class="col-md-4">
									<input type="date" class="form-control" id="endDate" name="endDate">
								</div>
							</div>
							<div class="form-group row">
								<label for="subject" class="col-sm-2 col-form-label my-1">
									<b>Môn học </b></label>
								<div class="col-sm-10">
									<select class="custom-select" name="sltSubject" id="subject">
									<c:forEach items="${ lstSubject }" var="item"> 
									   <option value="${item.getSubjectID()}"> ${item.getSubjectName() }</option>
									</c:forEach>
									</select>
								</div>
							</div>
							<div class=" row justify-content-center">
								<div class="col-8 my-1">
							      <div class="custom-control custom-checkbox mr-sm-2">
							        <input type="checkbox" class="custom-control-input" id="ckbActivate" name="ckbActivate" value="check">
							        <label class="custom-control-label py-1" for="ckbActivate"><b>Kích hoạt </b></label>
							      </div>
						    	</div>
							</div>
					</div>
				</div>
			</div>

			<div class="row justify-content-center">
				<button type="submit" class="btn btn-info col-3"> <i
					class="fa fa-check"></i> Lưu thay đổi
				</button> <a href="${pageContext.request.contextPath}/ListCourse" class="btn btn-danger col-3"> <i
					class="fa fa-times"></i> Hủy
				</a>
			</div>
		</form>

		</div>
	</div>
</t:WrapperAdmin>