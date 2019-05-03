<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>!
    <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="vendor/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="vendor/fontawesome-free-5.4.1-web/css/all.min.css">
    <link rel="stylesheet" href="./css/css1.css">   
    <title>ForgotPassWord</title>
</head>
<body>
        <div class="container"> 
                <div class="row vertical-center-row"> 
                 <div class="col-md-4 col-center-block login-widget"> 
                  <h1 class="text-center"><i class="fa fa-dot-circle-o"></i> Quên mật khẩu
                  </h1>
                  <div> 
                    <div class="form-group">
                    <div class="input-group"> 
                    <div class="input-group-addon"><i class="fas fa-user"></i>
                        </div> 
                        <input class="form-control" placeholder="Tài khoản" type="text"> 
                    </div> 
                    </div>
                   <div class="form-group"> 
                    <div class="input-group"> 
                     <div class="input-group-addon"><i class="fas fa-envelope"></i>
                     </div> 
                     <input class="form-control" placeholder="Nhập email" type="email"> 
                    </div> 
                   </div>
                   <div class="form-group"> 
                        <a href="trangchu.jsp" type="submit" class="btn btn-primary btn-block"> Khôi phục tài khoản </a>
                        <hr>
                    </div>  
                  </div> 
                 </div> 
                </div>
               </div>
               <script src="vendor/jquery-3.3.1.min.js"></script>
               <script src="vendor/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>