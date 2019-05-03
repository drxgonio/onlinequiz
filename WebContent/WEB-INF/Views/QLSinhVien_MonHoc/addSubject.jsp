<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<t:WrapperAdmin>
	<div class="row">
		<div class="col-md-12">
		<form action="/WebThi/AddSubject" method ="post">
			<div class="card">
				<div class="card-header">
					<h3 class="card-title">
						<b> Thêm lớp học </b>
					</h3>
					<div class="card-body">
						
							<div class="form-group row">
								<label for="inputId" class="col-sm-2 col-form-label my-1"> 
									<b>Tên môn học</b></label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="txtName" placeholder="Tên môn học">
								</div>
							</div>
							<div class="form-group row">
								<label for="inputName" class="col-sm-2 col-form-label my-1" >
									<b> Khoa</b>
								</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="txtFaculty"
										placeholder="Khoa giảng dạy">
								</div>					
							</div>
							
							<div class="form-group row">
								<label for="credit" class="col-sm-2 col-form-label my-1"> 
									<b> Số tín chỉ </b></label>
								<div class="col-sm-4">
									<input type="number" class="form-control" id="credit" name="txtCredit">

								</div>
								<label for="inputId" class="col-sm-2 col-form-label my-1"> 
									<b> Loại môn học </b>
								</label>
								<div class="col-sm-4">
									<select class="custom-select" name="txtType">
										<option value="Bắt buộc">Tự chọn</option>
										<option value="Tự chọn">Bắt buộc</option>
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
				<button type="submit" class="btn btn-info col-3"> 
				<i class="fa fa-check"></i>
					Lưu thay đổi
				</button> 
				 <a href="${pageContext.request.contextPath}/ListSubject" class="btn btn-danger col-3"> <i
					class="fa fa-times"></i> Hủy
				</a>
			</div>
		</form>
		</div>
	</div>
</t:WrapperAdmin>