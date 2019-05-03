<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:WrapperAdmin>
        <form class="row">
            <div class="col-md-12">
                <div class="card">
                  <div class="card-header">
                      <h3 class="card-title"><b> Sửa thông tin sinh viên - lớp học </b> </h3>
                      <div class="card-body">
                          <div>
                              <div class="form-group row">
                                  <label for="staticEmail" class="col-sm-2 col-form-label">Email</label>
                                  <div class="col-sm-10">
                                    <input type="text" readonly class="form-control-plaintext" id="staticEmail" value="fullsuper@gamil.com">
                                  </div>
                                </div>
                                <div class="form-group row">
                                    <label for="inputId" class="col-sm-2 col-form-label">Mã số sinh viên</label>
                                    <div class="col-sm-10">
                                      <input type="text" class="form-control" id="inputId" value="16110311" placeholder="Mã số sinh viên">
                                    </div>
                                  </div>
                                <div class="form-group row">
                                  <label for="inputName" class="col-sm-2 col-form-label"> Họ tên sinh viên</label>
                                  <div class="col-sm-10">
                                    <input type="text" class="form-control" id="inputName" value="Nguyễn Thành Đồng" placeholder="Nguyễn Văn A">
                                  </div>
                                </div>
                                  <div class="form-group row">
                                    
                                      <label for="inputName" class="col-sm-2 col-form-label"> Mã lớp </label>
                                      <div class="col-sm-10">
                                      <div class="input-group">
                                          <input type="text" class="form-control" placeholder="ID of Subject" value="WED1122_ST4" aria-label="Recipient's username" aria-describedby="basic-addon2">
                                          <div class="input-group-append">
                                            <button type="button" class="input-group-text px-2 bg-info" data-toggle="modal" data-target="#modalListSubject"> Chọn lớp </button>
                                          </div>
                                        </div>
                                      </div>
                                      <!-- <div class="col-sm-10">
                                         
                                      </div> -->
                                    </div>
                                    <div class="form-group row">
                                        <label for="inputName" class="col-sm-2 col-form-label"> Tên lớp </label>
                                        <div class="col-sm-10">
                                          <input type="text" class="form-control disab" id="inputName" value="Lập trình Web ST7 1-5 2018-2019" placeholder="Tên lớp">
                                        </div>
                                      </div>
                            </div>
                      </div>
                </div>
        </div>
      
        <div class="row justify-content-center">
          <a href="./listStudent.html" class="btn btn-info col-3"> <i class="fa fa-check"></i> Lưu thay đổi</a>
          <a href="./listStudent.html" class="btn btn-danger col-3"> <i class="fa fa-times"></i> Hủy </a>
        </div>
      
    </div>
  </form>
</t:WrapperAdmin>