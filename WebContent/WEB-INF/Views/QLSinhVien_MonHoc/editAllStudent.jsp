<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:WrapperAdmin>
	<form class="row" action="/WebThi/EditAllStudent" method="post">
		<div class="col-md-12">
			<div class="card">
				<div class="card-header">
					<h3 class="card-title">
						<b> Sửa thông tin sinh viên </b>
					</h3>
					<div class="card-body">
						<div>
							<div class="form-group row">
								<label for="staticEmail" class="col-sm-2 col-form-label">Email</label>
								<div class="col-sm-10">
									<input type="text" class="form-control-plaintext"
										id="staticEmail" value="${user.getEmail()}" name="email">
								</div>
							</div>
							<div class="form-group row">
								<label for="inputId" class="col-sm-2 col-form-label">IdentityCardNumber</label>
								<div class="col-sm-10">

									<input type="hidden" name="id"
										value="${profilestudent.getStudentId()}"> <input
										type="text" class="form-control" id="inputId"
										value="${profilestudent.getIdentityCardNumber()}"
										placeholder="Mã số sinh viên" name="IdentityCardNumber">
								</div>
							</div>
							<div class="form-group row">
								<label for="inputName" class="col-sm-2 col-form-label">
									Name</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputName"
										value="${profilestudent.getName()}" placeholder="Name"
										name="Name">
								</div>
							</div>
							<div class="form-group row">
								<label for="inputName" class="col-sm-2 col-form-label">
									PhoneNumber</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputName"
										value="${profilestudent.getPhoneNumber()}"
										placeholder="PhoneNumber" name="PhoneNumber">
								</div>
							</div>
							<div class="form-group row">

								<label for="inputName" class="col-sm-2 col-form-label">
									Ngày sinh </label>
								<div class="col-sm-10">
									<div class="input-group">
										<input type="date" name="DateOfBirth"
											value="${profilestudent.getDateOfBirth()}">
									</div>
								</div>
								<label for="inputGender" class="col-sm-2 col-form-label">
									Gender </label>
								<div class="col-sm-10">
									<c:if test="${ profilestudent.getGender() eq 'Nữ' }">
										<!-- Material unchecked -->
										<div class="form-check">
											<input type="radio" class="form-check-input"
												id="materialUnchecked" name="GenDer" value="Nam"> <label
												class="form-check-label" for="materialUnchecked">Nam</label>
										</div>
										<div class="form-check">
											<input type="radio" class="form-check-input"
												id="materialChecked" name="GenDer" checked value="Nữ"> <label
												class="form-check-label" for="materialChecked">Nữ</label>
										</div>
									</c:if>
									<c:if test="${ profilestudent.getGender() eq 'Nam' }">
										<!-- Material unchecked -->
										<div class="form-check">
											<input type="radio" class="form-check-input"
												id="materialUnchecked" name="GenDer" checked value="Nam"> <label
												class="form-check-label" for="materialUnchecked">Nam</label>
										</div>
										<div class="form-check">
											<input type="radio" class="form-check-input"
												id="materialChecked" name="GenDer" value="Nữ"> <label
												class="form-check-label" for="materialChecked">Nữ</label>
										</div>
									</c:if>

								</div>

							</div>
							<div class="form-group row">
								<label for="inputCountry" class="col-sm-2 col-form-label">
									Country</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputCountry"
										value="${profilestudent.getCountry()}" placeholder="Country"
										name="Country">
								</div>

							</div>
							<div class="form-group row">
								<label for="inputAddress" class="col-sm-2 col-form-label">
									Address</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputAddress"
										value="${profilestudent.getAddress()}"
										placeholder="inputAddress" name="Adress">
								</div>
							</div>
							<div class="form-group row">
								<label for="inputReligon" class="col-sm-2 col-form-label">
									Religon</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputReligon"
										value="${profilestudent.getReligion()}"
										placeholder="inputReligon" name="Religion">
								</div>
							</div>
							<div class="form-group row">
								<label for="inputStartYear" class="col-sm-2 col-form-label">
									YearOfAdmission</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputStartYear"
										value="${profilestudent.getYearOfAdmission()}"
										placeholder="inputStartYear" name="YearOfAdmission">
								</div>
							</div>
							<div class="form-group row">
								<label for="inputStartFinish" class="col-sm-2 col-form-label">
									YearOfGraduation</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputStartFinish"
										value="${profilestudent.getYearOfGraduation()}"
										placeholder="inputStartFinish" name="YearOfGraduation">
								</div>
							</div>
							<div class="form-group row">
								<label for="userStudent" class="col-sm-2 col-form-label">
									UserProfile</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="userprofile"
										value="${user.getUserName()}" placeholder="userprofile"
										name="userprofile">
								</div>
								<label for="userStudent" class="col-sm-2 col-form-label">
									Password</label>
								<div class="col-sm-10">
									<input type="password" class="form-control" id="passwordUser"
										placeholder="passwordUser"
										name="passwordUser">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="row justify-content-center">
				<button type="submit" class="btn btn-info col-3">
					<i class="fa fa-save"></i>Lưu thay đổi
				</button>
				<a href="${pageContext.request.contextPath}/ListAllStudent" class="btn btn-danger col-3"> <i
					class="fa fa-times"></i> Hủy
				</a>
			</div>

		</div>
	</form>
</t:WrapperAdmin>