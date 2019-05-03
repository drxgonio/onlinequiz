<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:WrapperAdmin>
        <div class="row">
            <div class="col-md-12">
         
              <form action="${pageContext.request.contextPath}/AddStudent" method="post">
            
                <div class="card">
                  <div class="card-header">
                      <h3 class="card-title"><b> Thêm sinh viên vào lớp học </b> </h3>
                      <div class="card-body">
                         <c:if test = "${ message != null }">
                      			<i><p style="color:red">${message}</p></i>
                      </c:if>
								 <div class="form-group row">
                                  <label for="account" class="col-sm-2 col-form-label"> Tài khoản</label>
                                  <div class="col-sm-10">
                                    <input type="text" class="form-control" id="account" placeholder="Tài khoản" name="username">
                                  </div>
                                </div>
                                 <div class="form-group row">
                                  <label for="email" class="col-sm-2 col-form-label"> Email</label>
                                  <div class="col-sm-10">
                                    <input type="email" class="form-control" id="email" placeholder="Email" name="email">
                                  </div>
                                </div>
                                 <div class="form-group row">
	                                  <label for="password" class="col-sm-2 col-form-label"> Mật khẩu</label>
	                                  <div class="col-sm-10">
	                                    <input type="password" class="form-control" id="password" placeholder="Mật khẩu" name="password">
	                                  </div>
                                </div>
                                 <div class="form-group row">
	                                  <label for="confirm" class="col-sm-2 col-form-label"> Mật khẩu xác nhận</label>
	                                  <div class="col-sm-10">
	                                    <input type="password" class="form-control" id="confirm" placeholder="Xác nhận mật khẩu" name="confirm">
	                                  </div>
                                </div>
                                
                                <div class="form-group row">
                                  <label for="fullname" class="col-sm-2 col-form-label"> Họ tên sinh viên</label>
                                  <div class="col-sm-10">
                                    <input type="text" class="form-control" id=""fullname"" placeholder="Họ tên sinh viên" name="fullname">
                                  </div>
                                </div>
                                  <div class="form-group row">
                                      <label for="inputCMND" class="col-sm-2 col-form-label" > CMND </label>
                                      <div class="col-sm-4">
	                                          <input type="text" class="form-control" placeholder="Số chứng minh nhân dân" id="inputCMND" name="cmnd">
	                                      </div>
                                   
                                     <label for="inputBirth" class="col-sm-2 col-form-label"> Ngày sinh </label>
                                      <div class="col-sm-4">
	                                          <input type="date" class="form-control" id="inputBirth" name="birthday">
	                                      </div>
	                              </div>
	                                      
                                    <div class="form-group row">
                                       	<label for="inputName" class="col-sm-2 col-form-label"> Giới tính </label>
                                       	<div class="col-sm-4" >
                                        	<select class="form-control" name="gender">
                                        		<option value="Nam">  Nam </option>
                                        		<option value="Nữ"> Nữ </option>
                                        		<option value="Khác"> Khác </option>
                                        	</select>
                                       	</div>
                                           <label for="inputPhone" class="col-sm-2 col-form-label"> Số điện thoại </label>
                                        <div class="col-sm-4">
	                                     		<input type="text" class="form-control" placeholder="Điện thoại" name="phone" id="inputPhone">
	                                    </div>
                                    </div>
                                    <div class="form-group row">
                                       	<label for="inputAddress" class="col-sm-2 col-form-label"> Địa chỉ </label>
                                       	<div class="col-sm-4">
                                        	<input type="text" class="form-control" placeholder="Địa chỉ" id="inputAddress" name="address">

                                       	</div>
                                           <label for="inputCountry" class="col-sm-2 col-form-label"> Quê quán </label>
                                        <div class="col-sm-4">
	                                     	<input type="text" class="form-control" placeholder="Quê quán" id="inputCountry" name="country">
	                                    </div>
                                    </div>
                                    <div class="form-group row">
                                       	<label for="inputAdmission" class="col-sm-2 col-form-label"> Thời gian tốt nghiệp dự kiến </label>
                                       	<div class="col-sm-5">
                                        	<input type="text" class="form-control" placeholder="Năm nhập học" id="inputAdmission" name="admission">

                                       	</div>
                                        <div class="col-sm-5">
	                                     	<input type="text" class="form-control" placeholder="Năm tốt nghiệp" id="inputGraduation" name="graduation">
	                                    </div>
                                    </div>
                      </div>
                </div>
        </div>
      
        <div class="row justify-content-center">
          <button type="submit" class="btn btn-info col-3"> <i class="fa fa-check"></i> Lưu thay đổi</button>
          <a href="${pageContext.request.contextPath}/ListAllStudent" class="btn btn-danger col-3"> <i class="fa fa-times"></i> Hủy </a>
        </div>
        </form>
      
    </div>
  </div>
  </t:WrapperAdmin>