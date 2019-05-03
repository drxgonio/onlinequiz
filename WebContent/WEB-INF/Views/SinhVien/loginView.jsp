<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assetquiz/css/login.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assetquiz/css/reset.css">
<title>Đăng Nhập</title>
</head>
<body>   
      <div class="limiter">
		<div class="container-login">
			<div class="wrap-login">
				<form class="login-form" method="POST" action="Login">
					<span class="title-login-form">Login Online Quiz</span>
					<input type="hidden" name="redirectId" value="${param.redirectId}" />
					<div class="icon-login-form"><img src="https://ss-images.catscdn.vn/2018/06/10/2968571/34689401_2147325555551794_7654281988110548992_n.jpg"></div>
					
					<div class="wrap-input" data-validate="Valid email is: a@b.c">
						<input type="text" placeholder="Tên Đăng Nhập" name="userName">
					</div>
					<div class="wrap-input" data-validate="Xin nhập mật khẩu">
						<input type="password" placeholder="Mật Khẩu" name="passWord">
					</div>
					<div class="input-btn"><button type="submit">Đăng Nhập</button></div>
					<p style="color: red;">${errorString}</p>
					<div class="input-option">
					<div class="ck"><input type="checkbox" name="">Nhớ mật khẩu</div>
					<div class="forget"><a href="#">Quên mật khẩu</a></div>
					</div>
					<div class="footer-login">
					
				</form>	
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>