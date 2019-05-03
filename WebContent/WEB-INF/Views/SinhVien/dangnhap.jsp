<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="vendor/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="vendor/fontawesome-free-5.4.1-web/css/all.min.css">
    <link rel="stylesheet" href="./css/css1.css">   
    <title>Login</title>
</head>
<body>
        <div class="container"> 
                <div class="row vertical-center-row"> 
                 <div class="col-md-6 col-center-block login-widget"> 
                  <h1 class="text-center"><i class="fa fa-dot-circle-o"></i> Đăng nhập
                  </h1> 
                  <br/>
                   <div class="form-group">
                            <label class="radio-inline"><strong><a>Bạn Là:</a></strong></label>
                            <label class="radio-inline">          
                                <input name="actor" id="inlineCheckbox1" value="student" type="radio"> Sinh viên </label> 
                            <label class="radio-inline">          
                                <input name="actor" id="inlineCheckbox2" value="teacher1" type="radio"> Người ra đề  </label> 
                            <label class="radio-inline">          
                                <input name="actor" id="inlineCheckbox3" value="teacher2" type="radio"> Quản trị câu hỏi  </label> 
                            <label class="radio-inline">          
                                <input name="actor" id="inlineCheckbox4" value="admin" type="radio"> Người quản trị </label> 
                   </div>
                  <div> 
                   <div class="form-group"> 
                    <div class="input-group"> 
                     <div class="input-group-addon"><i class="fas fa-envelope fa-fw"></i>
                     </div> <input class="form-control" placeholder="Mã số sinh viên" type="text"> 
                    </div> 
                   </div> 
                   <div class="form-group"> 
                    <div class="input-group"> 
                     <div class="input-group-addon"><i class="fa fa-key fa-fw"></i>
                     </div> <input class="form-control" placeholder="Password" type="password"> 
                    </div> 
                   </div> 
                   <div class="form-group"> 
                    <div class="checkbox"> <label for="c1"><input id="c1" name="cc" type="checkbox">Nhớ thông tin</label> 
                    </div> 
                   </div>
                  
                   <div class="form-group">
						<a id="google-button" class="btn btn-danger btn-block py-2 px-2 ">
					 		 <i class="fab fa-google"></i> Đăng nhập bằng tài khoản Google
						</a>                   
					</div> 
                   
                   <div class="form-group"> 
                    <a href="trangchu.jsp" type="submit" class="btn btn-primary btn-block">Đăng nhập</a> 
                    <hr> 
                    <p class="text-center">Bạn có tài khoản không? <strong><a href="./dk.html" class="blue-text">Đăng ký</a></strong>
                    </p>
                    <div class="text-center"><strong><a href="./fgpass.html" class="blue-text">Quên Mật Khẩu?</a></strong></div> 
                   </div> 
                  </div> 
                 </div> 
                </div>
               </div>
               <script src="vendor/jquery-3.3.1.min.js"></script>
               <script src="vendor/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>