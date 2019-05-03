<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Xem kết quả thi online</title>
  <meta name="description" content="Free Bootstrap Theme by BootstrapMade.com">
  <meta name="keywords" content="free website templates, free bootstrap themes, free template, free bootstrap, free website template">

  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Open+Sans|Candal|Alegreya+Sans">
  <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
  <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="css/imagehover.min.css">
  <link rel="stylesheet" type="text/css" href="css/style.css">

  <!-- =======================================================
    Theme Name: Mentor
    Theme URL: https://bootstrapmade.com/mentor-free-education-bootstrap-theme/
    Author: BootstrapMade.com
    Author URL: https://bootstrapmade.com
  ======================================================= -->
</head>

<body>
  <!--Navigation bar-->
  <!--Navigation bar-->
  <nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="index.html">Thi trắc nghiệm Online</a>
      </div>
      <div class="collapse navbar-collapse" id="myNavbar">
        <ul class="nav navbar-nav navbar-right">
          <li><a href="#feature">Đề thi</a></li>
          <li><a href="#organisations">Kiến thức</a></li>
          <li><a href="#courses">Thi thử</a></li>
          <li><a href="#pricing">Liên hệ</a></li>
          <li><a href="#" data-target="#login" data-toggle="modal">Đăng xuất</a></li>
          <li class="btn-trial"><a href="#footer">Free Trail</a></li>
        </ul>
      </div>
    </div>
  </nav>
  <!--/ Navigation bar-->
  <!--Modal box-->
  <div class="modal fade" id="login" role="dialog">
    <div class="modal-dialog modal-sm">

      <!-- Modal content no 1-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title text-center form-title">Login</h4>
        </div>
        <div class="modal-body padtrbl">

          <div class="login-box-body">
            <p class="login-box-msg">Sign in to start your session</p>
            <div class="form-group">
              <form name="" id="loginForm">
                <div class="form-group has-feedback">
                  <!----- username -------------->
                  <input class="form-control" placeholder="Username" id="loginid" type="text" autocomplete="off" />
                  <span style="display:none;font-weight:bold; position:absolute;color: red;position: absolute;padding:4px;font-size: 11px;background-color:rgba(128, 128, 128, 0.26);z-index: 17;  right: 27px; top: 5px;" id="span_loginid"></span>
                  <!---Alredy exists  ! -->
                  <span class="glyphicon glyphicon-user form-control-feedback"></span>
                </div>
                <div class="form-group has-feedback">
                  <!----- password -------------->
                  <input class="form-control" placeholder="Password" id="loginpsw" type="password" autocomplete="off" />
                  <span style="display:none;font-weight:bold; position:absolute;color: grey;position: absolute;padding:4px;font-size: 11px;background-color:rgba(128, 128, 128, 0.26);z-index: 17;  right: 27px; top: 5px;" id="span_loginpsw"></span>
                  <!---Alredy exists  ! -->
                  <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                </div>
                <div class="row">
                  <div class="col-xs-12">
                    <div class="checkbox icheck">
                      <label>
                                <input type="checkbox" id="loginrem" > Remember Me
                              </label>
                    </div>
                  </div>
                  <div class="col-xs-12">
                    <button type="button" class="btn btn-green btn-block btn-flat" onclick="userlogin()">Sign In</button>
                  </div>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>

    </div>
  </div>
  <!--/ Modal box-->
  <!--Modal box-->
  <div class="modal fade" id="login" role="dialog">
    <div class="modal-dialog modal-sm">

      <!-- Modal content no 1-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title text-center form-title">Login</h4>
        </div>
        <div class="modal-body padtrbl">

          <div class="login-box-body">
            <p class="login-box-msg">Sign in to start your session</p>
            <div class="form-group">
              <form name="" id="loginForm">
                <div class="form-group has-feedback">
                  <!----- username -------------->
                  <input class="form-control" placeholder="Username" id="loginid" type="text" autocomplete="off" />
                  <span style="display:none;font-weight:bold; position:absolute;color: red;position: absolute;padding:4px;font-size: 11px;background-color:rgba(128, 128, 128, 0.26);z-index: 17;  right: 27px; top: 5px;" id="span_loginid"></span>
                  <!---Alredy exists  ! -->
                  <span class="glyphicon glyphicon-user form-control-feedback"></span>
                </div>
                <div class="form-group has-feedback">
                  <!----- password -------------->
                  <input class="form-control" placeholder="Password" id="loginpsw" type="password" autocomplete="off" />
                  <span style="display:none;font-weight:bold; position:absolute;color: grey;position: absolute;padding:4px;font-size: 11px;background-color:rgba(128, 128, 128, 0.26);z-index: 17;  right: 27px; top: 5px;" id="span_loginpsw"></span>
                  <!---Alredy exists  ! -->
                  <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                </div>
                <div class="row">
                  <div class="col-xs-12">
                    <div class="checkbox icheck">
                      <label>
                                <input type="checkbox" id="loginrem" > Remember Me
                              </label>
                    </div>
                  </div>
                  <div class="col-xs-12">
                    <button type="button" class="btn btn-green btn-block btn-flat" onclick="userlogin()">Sign In</button>
                  </div>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>

    </div>
  </div>
  <!--/ Modal box-->
  <!--Banner-->
  <div class="banner">
    <div class="bg-color">
      <div class="container">
        <div class="row">
          <div class="banner-text text-center">
            <div class="text-border">
              <h2 class="text-dec">Ứng dụng thi trắc nghiệm</h2>
            </div>
            <div class="intro-para text-center quote">
              <p class="big-text">Đề tài: Ngôn ngữ công nghệ thông tin</p>
              <p class="small-text">Gồm có 20 câu hỏi và câu trả lời. Nếu bạn trả lời đúng thì bạn được 0.5đ.
              Nếu làm full sẽ được 10 điểm. Chọn một câu trả lời đúng.</p>
               <p class="big-text">Kết quả thi:7.5/10đ</p>
              <a href="#footer" class="btn get-quote">Xem kết quả</a>
            </div>
            <a href="#feature" class="mouse-hover">
              <div class="mouse"></div>
            </a>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!--/ Banner-->
  <!--Feature-->
  <section id="feature" class="section-padding">
    <div class="container">
     <div class="row">
        
         <div class="col-md-8">

            <!-- Default unchecked -->
              
                      <h3 class="heading text-capitalize mb-lg-5 mb-4">Câu 1. Thiết bị nào sau đây dùng để kết nối mạng?</span> </h3>
                      <div class="row welcome-grids">
                        <div class="card-body">
                                  <form>
                                  <ul class="nav flex-column" name="listAnswer">
                                    <li class="nav-item">
                                          <div class="input-group-text">
                                            <input type="radio" name="radAns" class="mr-2" aria-label="Radio button for following text input">
                                            <input type="text" class="form-control" aria-label="Text input with radio button" value=" Ram">
                                          </div>
                                    </li>
                                    <li class="nav-item">
                                        <div class="input-group-text">
                                          <input type="radio" checked="checked" name="radAns" class="mr-2" aria-label="Radio button for following text input">
                                          <input type="text" class="form-control" aria-label="Text input with radio button" value="Rom">
                                        </div>
                                  </li>
                                    <li class="nav-item">
                                        <div class="input-group-text">
                                          <input type="radio" name="radAns" class="mr-2" aria-label="Radio button for following text input">
                                          <input type="text" class="form-control" aria-label="Text input with radio button" value="Router">
                                        </div>
                                    </li>
                                    <li class="nav-item">
                                        <div class="input-group-text">
                                          <input type="radio"  name="radAns" class="mr-2" aria-label="Radio button for following text input">
                                          <input type="text" class="form-control" aria-label="Text input with radio button" value="CPU">
                                        </div>
                                  </li>
                                  </ul>
                                </form>

                              </div>
                        
                      </div>
                       <h3 class="heading text-capitalize mb-lg-5 mb-4">Câu 2. Hệ thống nhớ của máy tính bao gồm:</span> </h3>
                      <div class="row welcome-grids">
                        <div class="card-body">
                                  <form>
                                  <ul class="nav flex-column" name="listAnswer">
                                    <li class="nav-item">
                                          <div class="input-group-text">
                                            <input type="radio" name="radAns" class="mr-2" aria-label="Radio button for following text input">
                                            <input type="text" class="form-control" aria-label="Text input with radio button" value="Bộ nhớ trong, Bộ nhớ ngoài">
                                          </div>
                                    </li>
                                    <li class="nav-item">
                                        <div class="input-group-text">
                                          <input type="radio" checked="checked" name="radAns" class="mr-2" aria-label="Radio button for following text input">
                                          <input type="text" class="form-control" aria-label="Text input with radio button" value=" Cache, Bộ nhớ ngoài">
                                        </div>
                                  </li>
                                    <li class="nav-item">
                                        <div class="input-group-text">
                                          <input type="radio" name="radAns" class="mr-2" aria-label="Radio button for following text input">
                                          <input type="text" class="form-control" aria-label="Text input with radio button" value="Bộ nhớ ngoài, ROM">
                                        </div>
                                    </li>
                                    <li class="nav-item">
                                        <div class="input-group-text">
                                          <input type="radio"  name="radAns" class="mr-2" aria-label="Radio button for following text input">
                                          <input type="text" class="form-control" aria-label="Text input with radio button" value=" Đĩa quang, Bộ nhớ trong">
                                        </div>
                                  </li>
                                  </ul>
                                </form>

                              </div>
                        
                      </div>
                       <h3 class="heading text-capitalize mb-lg-5 mb-4">Câu 3. Trong mạng máy tính, thuật ngữ Share có ý nghĩa gì?</span> </h3>
                      <div class="row welcome-grids">
                        <div class="card-body">
                                  <form>
                                  <ul class="nav flex-column" name="listAnswer">
                                    <li class="nav-item">
                                          <div class="input-group-text">
                                            <input type="radio" name="radAns" class="mr-2" aria-label="Radio button for following text input">
                                            <input type="text" class="form-control" aria-label="Text input with radio button" value="Chia sẻ tài nguyên">
                                          </div>
                                    </li>
                                    <li class="nav-item">
                                        <div class="input-group-text">
                                          <input type="radio" checked="checked" name="radAns" class="mr-2" aria-label="Radio button for following text input">
                                          <input type="text" class="form-control" aria-label="Text input with radio button" value="Nhãn hiệu của một thiết bị kết nối mạng">
                                        </div>
                                  </li>
                                    <li class="nav-item">
                                        <div class="input-group-text">
                                          <input type="radio" name="radAns" class="mr-2" aria-label="Radio button for following text input">
                                          <input type="text" class="form-control" aria-label="Text input with radio button" value="Thực hiện lệnh in trong mạng cục bộ">
                                        </div>
                                    </li>
                                    <li class="nav-item">
                                        <div class="input-group-text">
                                          <input type="radio"  name="radAns" class="mr-2" aria-label="Radio button for following text input">
                                          <input type="text" class="form-control" aria-label="Text input with radio button" value="Một phần mềm hỗ trợ sử dụng mạng cục bộ">
                                        </div>
                                  </li>
                                  </ul>
                                </form>

                              </div>
                        
                      </div>
                       <h3 class="heading text-capitalize mb-lg-5 mb-4">Câu 4. Bộ nhớ RAM và ROM là bộ nhớ gì?</span> </h3>
                      <div class="row welcome-grids">
                        <div class="card-body">
                                  <form>
                                  <ul class="nav flex-column" name="listAnswer">
                                    <li class="nav-item">
                                          <div class="input-group-text">
                                            <input type="radio" name="radAns" class="mr-2" aria-label="Radio button for following text input">
                                            <input type="text" class="form-control" aria-label="Text input with radio button" value="Primary memory">
                                          </div>
                                    </li>
                                    <li class="nav-item">
                                        <div class="input-group-text">
                                          <input type="radio" checked="checked" name="radAns" class="mr-2" aria-label="Radio button for following text input">
                                          <input type="text" class="form-control" aria-label="Text input with radio button" value="Receive memory">
                                        </div>
                                  </li>
                                    <li class="nav-item">
                                        <div class="input-group-text">
                                          <input type="radio" name="radAns" class="mr-2" aria-label="Radio button for following text input">
                                          <input type="text" class="form-control" aria-label="Text input with radio button" value=" Secondary memory">
                                        </div>
                                    </li>
                                    <li class="nav-item">
                                        <div class="input-group-text">
                                          <input type="radio"  name="radAns" class="mr-2" aria-label="Radio button for following text input">
                                          <input type="text" class="form-control" aria-label="Text input with radio button" value="Random access memory.">
                                        </div>
                                  </li>
                                  </ul>
                                </form>

                              </div>
                              <nav aria-label="Page navigation example">
                      <ul class="pagination justify-content-center">
                        <li class="page-item disabled">
                          <a class="page-link" href="#" tabindex="-1">Previous</a>
                        </li>
                        <li class="page-item"><a class="page-link" href="#">1</a></li>
                        <li class="page-item"><a class="page-link" href="#">2</a></li>
                        <li class="page-item"><a class="page-link" href="#">3</a></li>
                        <li class="page-item">
                          <a class="page-link" href="#">Next</a>
                        </li>
                      </ul>
                    </nav>
                        
                      </div>
                    </div>
           

            <!-- Default unchecked -->
                 
        <div class="col-md-1">
        </div>      
       <div class="col-md-3">
           
        <div class="row">
           <div class="logo">
           <a href="http://www.creative-tim.com" class="simple-text logo-mini">
            <div class="logo-image-small">
              <img src="../assets/img/logo-small.png">
            </div>
           </a>
          <a href="http://www.creative-tim.com" class="simple-text logo-normal">
           <h4 style="color:blue;">Câu hỏi:</h4>
         </a>
        </div>

             
                   <button type="button" class="btn btn-primary" style="width: 50px">1</button>
                    <button type="button" class="btn btn-primary"style="width: 50px">2</button>
                    <button type="button" class="btn btn-primary"style="width: 50px">3</button>
                    <button type="button" class="btn btn-primary"style="width: 50px">4</button>
                    <button type="button" class="btn btn-primary"style="width: 50px">5</button>
                    <button type="button" class="btn btn-primary"style="width: 50px">6</button>
                    <button type="button" class="btn btn-primary"style="width: 50px">7</button>
                    <button type="button" class="btn btn-primary"style="width: 50px">8</button>
                    <button type="button" class="btn btn-primary"style="width: 50px">9</button>
                    <button type="button" class="btn btn-primary"style="width: 50px">11</button>
                    <button type="button" class="btn btn-primary"style="width: 50px">12</button>
                    <button type="button" class="btn btn-primary"style="width: 50px">13</button>
                    <button type="button" class="btn btn-primary"style="width: 50px">14</button>
                    <button type="button" class="btn btn-primary"style="width: 50px">15</button>
                    <button type="button" class="btn btn-primary"style="width: 50px">16</button>
                    <button type="button" class="btn btn-primary"style="width: 50px">17</button>
                    <button type="button" class="btn btn-primary"style="width: 50px">18</button>
                    <button type="button" class="btn btn-primary"style="width: 50px">19</button>
                    <button type="button" class="btn btn-primary"style="width: 50px">20</button> 
        </div>
        <div class="row">
            <a href="trangchu.jsp" style="color:blue">Return attempt..</a>
           <div class="kq">
            <button type="button" class="btn btn-danger"onclick="myFunction()">Xuất kết quả</button>
           </div>
         </a>
        </div> 
       </div>
       
     </div>
    </div>

  </section>
  <!--/ feature-->

  

  <!--Footer-->
  <footer id="footer" class="footer">
    <div class="container text-center">
      <!-- End newsletter-form -->
      <ul class="social-links">
        <li><a href="#link"><i class="fa fa-twitter fa-fw"></i></a></li>
        <li><a href="#link"><i class="fa fa-facebook fa-fw"></i></a></li>
        <li><a href="#link"><i class="fa fa-google-plus fa-fw"></i></a></li>
        <li><a href="#link"><i class="fa fa-dribbble fa-fw"></i></a></li>
        <li><a href="#link"><i class="fa fa-linkedin fa-fw"></i></a></li>
      </ul>
      ©2018. All rights reserved
      <div class="credits">
        <!--
          All the links in the footer should remain intact.
          You can delete the links only if you purchased the pro version.
          Licensing information: https://bootstrapmade.com/license/
          Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/buy/?theme=Mentor
        -->
        Designed by <a href="https://bootstrapmade.com/">Group 2 - Web</a>
      </div>
    </div>
  </footer>
  <!--/ Footer-->

  <script src="js/jquery.min.js"></script>
  <script src="js/jquery.easing.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/custom.js"></script>
  <script src="contactform/contactform.js"></script>
   <script src="js/myfunction.js"></script>
  <script>
// Set the date we're counting down to
var countDownDate = new Date("Jan 5, 2019 15:37:25").getTime();

// Update the count down every 1 second
var x = setInterval(function() {

    // Get todays date and time
    var now = new Date().getTime();
    
    // Find the distance between now and the count down date
    var distance = countDownDate - now;
    
    // Time calculations for days, hours, minutes and seconds
    var days = Math.floor(distance / (1000 * 60 * 60 * 24));
    var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
    var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
    var seconds = Math.floor((distance % (1000 * 60)) / 1000);
    
    // Output the result in an element with id="demo"
    document.getElementById("demo").innerHTML ="Thời gian còn lại: "+minutes + "m " + seconds + "s ";
    
    // If the count down is over, write some text 
    if (distance < 0) {
        clearInterval(x);
        document.getElementById("demo").innerHTML = "EXPIRED";
    }
}, 1000);
</script>


</body>

</html>
