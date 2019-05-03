<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<t:WrapperAdmin>

	<!-- Modal Change Password-->
	<div class="modal fade" id="exampleModalCenter" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<form action="/WebThi/Profile" method="post">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalCenterTitle">Thay đổi
							mật khẩu</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">

						<div class="form-group row">
							<label for="inputEmail3" class="col-sm-3 col-form-label">Mật
								khẩu cũ</label>
							<div class="col-sm-9">
								<input type="password" class="form-control" id="passCu"
									placeholder="Mật khẩu cũ" name="passCu">
									<input type="hidden" name="pass" value="${ user.password}" id="pass">
									<p id="message1"></p>
							</div>
						</div>
						<div class="form-group row">
							<label for="inputPassword3" class="col-sm-3 col-form-label">Mật
								khẩu mới</label>
							<div class="col-sm-9">
								<input type="password" class="form-control" id="pass_reg"
									placeholder="Mật khẩu" name="passMoi" disabled>
							</div>
						</div>
						<div class="form-group row">
							<label for="inputPassword3" class="col-sm-3 col-form-label">Xác
								nhận mật khẩu</label>
							<div class="col-sm-9">
								<input type="password" class="form-control" id="pass_check"
									placeholder="Password" name="passXacNhan" disabled>
									<p id="message"></p>
							</div>

						</div>
						<div class="form-group row">
							
						</div>
						<input type="hidden" name="idUser" value="${user.userId}">



					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Hủy</button>
						<button type="submit" class="btn btn-primary " id="btn"
							onclick="alert('Đổi mật khẩu thành công')" disabled>Lưu thay đổi</button>
					</div>
				</form>
			</div>
		</div>
	</div>


	<form class="row" action="/WebThi/LoadInfoStudent" method="post">
		<div class="col-md-4">
			<div class="card card-user">
				<div class="image">
					<img
						src="${pageContext.request.contextPath}/assets/img/damir-bosnjak.jpg"
						alt="...">
				</div>
				<div class="card-body">
					<div class="author">
						<a href="#"> <img class="avatar border-gray"
							src="${pageContext.request.contextPath}/assets/img/mike.jpg"
							alt="...">
							<h5 class="title">${user.userName}</h5>
						</a>
						<p class="description">${user.email}</p>
					</div>
					<p class="description text-center">"Tôi là một người khá kín
						đáo và nghiêm túc trong công việc"</p>
				</div>
				<div class="card-footer">
					<hr>
					<div class="button-container">
						<div class="row">
							<div class="col-lg-3 col-md-6 col-6 ml-auto">
								<h5>
									12 <br> <small>Files</small>
								</h5>
							</div>
							<div class="col-lg-4 col-md-6 col-6 ml-auto mr-auto">
								<h5>
									26 <br> <small>Câu hỏi</small>
								</h5>
							</div>

						</div>
					</div>
				</div>
			</div>
			<div class="card">
				<div class="card-header">
					<h4 class="card-title">Thành viên nhóm</h4>
				</div>
				<div class="card-body">
					<ul class="list-unstyled team-members">
						<li>
							<div class="row">
								<div class="col-md-2 col-2">
									<div class="avatar">
										<img
											src="${pageContext.request.contextPath}/assets/img/faces/ayo-ogunseinde-2.jpg"
											alt="Circle Image"
											class="img-circle img-no-padding img-responsive">
									</div>
								</div>
								<div class="col-md-7 col-7">
									Trần Thành Đạt <br /> <span class="text-muted"> <small>Offline</small>
									</span>
								</div>
								<div class="col-md-3 col-3 text-right">
									<button
										class="btn btn-sm btn-outline-success btn-round btn-icon">
										<i class="fa fa-envelope"></i>
									</button>
								</div>
							</div>
						</li>
						<li>
							<div class="row">
								<div class="col-md-2 col-2">
									<div class="avatar">
										<img
											src="${pageContext.request.contextPath}/assets/img/faces/joe-gardner-2.jpg"
											alt="Circle Image"
											class="img-circle img-no-padding img-responsive">
									</div>
								</div>
								<div class="col-md-7 col-7">
									Hồ Ngọc Sơn Hà <br /> <span class="text-success"> <small>Available</small>
									</span>
								</div>
								<div class="col-md-3 col-3 text-right">
									<button
										class="btn btn-sm btn-outline-success btn-round btn-icon">
										<i class="fa fa-envelope"></i>
									</button>
								</div>
							</div>
						</li>
						<li>
							<div class="row">
								<div class="col-md-2 col-2">
									<div class="avatar">
										<img
											src="${pageContext.request.contextPath}/assets/img/faces/clem-onojeghuo-2.jpg"
											alt="Circle Image"
											class="img-circle img-no-padding img-responsive">
									</div>
								</div>
								<div class="col-ms-7 col-7">
									Phan Văn Trí <br /> <span class="text-danger"> <small>Busy</small>
									</span>
								</div>
								<div class="col-md-3 col-3 text-right">
									<button
										class="btn btn-sm btn-outline-success btn-round btn-icon">
										<i class="fa fa-envelope"></i>
									</button>
								</div>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="col-md-8">
			<div class="card card-user">
				<div class="card-header">
					<h5 class="card-title">Chỉnh sửa hồ sơ cá nhân</h5>
				</div>
				<div class="card-body">
					<form>
						<div class="row">
							<div class="col-md-5 pr-1">
								<div class="form-group">
									<label> Công ty </label> <input type="text"
										class="form-control" disabled="disabled" placeholder="Company"
										value="HCMUTE Inc.">
								</div>
							</div>

							<div class="col-md-3 px-1">
								<div class="form-group">
									<label>Tài khoản</label> <input type="text"
										class="form-control" placeholder="Username"
										value="${user.userName}">

								</div>
							</div>
							<div class="col-md-4 pl-1">
								<div class="form-group">
									<label for="exampleInputEmail1">Email</label> <input
										type="email" class="form-control" placeholder="Email"
										value="${user.email}">
								</div>
							</div>
						</div>
						<div class="row">

							<div class="col-md-6 pl-1">
								<div class="form-group">
									<label> Họ Tên</label> <input type="text" class="form-control"
										placeholder="Last Name" value="${student.name}">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label> Địa chỉ</label> <input type="text" class="form-control"
										placeholder="Home Address" value="${student.country}">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-4 pr-1">
								<div class="form-group">
									<label>Thành phố</label> <input type="text"
										class="form-control" placeholder="City"
										value="${student.address}">
								</div>
							</div>
							<div class="col-md-4 px-1">
								<div class="form-group">
									<label> Tôn giáo </label> <input type="text"
										class="form-control" placeholder="Tôn giáo"
										value="${student.religion}">
								</div>
							</div>

						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label> Giới thiệu chung</label>
									<textarea class="form-control textarea">Là một người đơn giản và rất đẹp trai.</textarea>
								</div>
							</div>
						</div>
						<div class="row">
							<!-- <div class="update ml-auto mr-auto">
								<button type="submit" class="btn btn-primary btn-round">
									Cập nhật hồ sơ</button>
							</div> -->
							<div class="update ml-auto mr-auto">
								<button type="button" class="btn btn-danger btn-round"
									data-toggle="modal" data-target="#exampleModalCenter">
									Thay đổi mật khẩu</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</form>
	<script>
$(document).ready(function() {

    //check kí tự nhập vào của xác thực mật khẩu
    $("#pass_check").keyup(function(event) {
        var a = $("#pass_reg").val();
        var b = $("#pass_check").val();
        if (a == b) {
            $("#message").css("color", "GreenYellow");
            $('#message').text('Sẵn sàng');
            $("#btn"). removeAttr("disabled");
            $("#btn").arr('disabled', false);
        } else {
            $("#message").css("color", "red");
            $('#message').text('Mật khẩu xác nhận không đúng');
           
            $("#btn").attr('disabled', 'disabled');
         
        }
    });
    $("#passCu").keyup(function(event) {
        var a = $("#pass").val();
        var b = $("#passCu").val();
        if (a == b) {
            $("#message1").css("color", "GreenYellow");
            $('#message1').text('Sẵn sàng');
            $("#pass_check"). removeAttr("disabled");
            $("#pass_reg"). removeAttr("disabled");
            $("#pass_check").arr('disabled', false);
         
            $("#pass_reg").arr('disabled', false);
        } else {
            $("#message1").css("color", "red");
            $('#message1').text('Mật khẩu sai');
            $("#pass_check").attr('disabled', 'disabled');
            $("#pass_reg").attr('disabled', 'disabled');
          
        }
    });
    //ajax 
        $("#btnAddAccount").click(function(event) {
        	  var userName=$('[name="userName"]').val();
              var pass=$('[name="passWord"]').val();
        	  if(userName!=null&&pass!=null)
        	    {
        		  $.ajax({
                      url: '${pageContext.request.contextPath}/Profile',
                      type: 'POST',
                      data: { userName: userName,passWord:pass},
                      dataType:"html",
                      success:function(data){
                          $("#message").css("color","GreenYellow");
                          $("#message").text(data);
                          alert(data);
                      }
                  });
        	    }
        	  else
        	    {
        	        alert("Điền đầy đủ")
        	    }
        /* Act on the event */
      
            

    });
    
   
    

})
</script>

</t:WrapperAdmin>

