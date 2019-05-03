<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="vendor/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="./css/dk.css" />
    <title>Register</title>
</head>
<body>
        <div class="container"> 
                <h1 class="text-center">ĐĂNG KÍ TÀI KHOẢN</h1> 
                <div class="row"> 
                 <div class="col-xs-12 col-sm-12 col-md-4 well well-sm col-md-offset-4"> 
                  <legend><a><i class="glyphicon glyphicon-globe"></i></a> Đăng ký thành viên!
                  </legend> 
                  <form method="post" class="form" role="form"> 
                   <div class="row"> 
                    <div class="col-xs-6 col-md-6"> <input class="form-control" name="firstname" placeholder="Họ" required="" autofocus="" type="text"> 
                    </div> 
                    <div class="col-xs-6 col-md-6"> <input class="form-control" name="lastname" placeholder="Tên" required="" type="text"> 
                    </div> 
                </div>
                    <input class="form-control" name="mssv" placeholder="Mã Số Sinh Viên" type="text">     
                    <input class="form-control" name="youremail" placeholder="Email" type="email"> 
                   <input class="form-control" name="password" placeholder="Mật khẩu" type="password"> 
                   <input class="form-control" name="retypepassword" placeholder="Nhập lại mật khẩu" type="password"> 
                   <label for="">Ngày sinh</label> 
                   <div class="row"> 
                    <div class="col-xs-4 col-md-4"> 
                        <select class="form-control">              
                            <option value="Day" >Ngày</option>            
                        </select> 
                    </div> 
                    <div class="col-xs-4 col-md-4"> <select class="form-control">              <option value="Month">Tháng</option>            </select> 
                    </div> 
                    <div class="col-xs-4 col-md-4"> <select class="form-control">              <option value="Year">Năm</option>            </select> 
                    </div> 
                   </div> 
                   <label class="radio-inline">          
                       <input name="sex" id="inlineCheckbox1" value="male" type="radio">   Nam </label> 
                   <label class="radio-inline">          
                       <input name="sex" id="inlineCheckbox2" value="female" type="radio"> Nữ </label> 
                   <br> 
                   <br> 
                   <a href="trangchu.jsp" class="btn btn-lg btn-primary btn-block" type="submit"> Đăng ký</a> 
                  </form> 
                 </div> 
                </div>
               </div>
        <script src="vendor/jquery-3.3.1.min.js"></script>
        <script src="vendor/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>